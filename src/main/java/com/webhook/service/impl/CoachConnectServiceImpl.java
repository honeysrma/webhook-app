package com.webhook.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.webhook.common.service.DateUtility;
import com.webhook.common.service.UtilityService;
import com.webhook.constants.AppConstants;
import com.webhook.constants.UtilConstant;
import com.webhook.dto.APIResponseDto;
import com.webhook.dto.APIResponseDto.APIResponseBuilder;
import com.webhook.dto.CallTriggerOutBoundRequestDto;
import com.webhook.dto.CallTriggerResponseDto;
import com.webhook.dto.CoachConnectDTO;
import com.webhook.entity.CoachConnectEntity;
import com.webhook.entity.LogCtcAdvanceCallApiEntity;
import com.webhook.enums.ConnectType;
import com.webhook.mapper.CoachConnectMapper;
import com.webhook.repositories.CoachConnectRepository;
import com.webhook.repositories.LogCtcAdvanceCallApiRepository;
import com.webhook.security.service.AuthTokenService;
import com.webhook.service.CoachConnectService;
import com.webhook.service.OutboundIntegrationService;

@Service
public class CoachConnectServiceImpl implements CoachConnectService {

	private static final Logger logger = LoggerFactory.getLogger(CoachConnectServiceImpl.class);

	@Autowired
	private CoachConnectRepository coachConnectRepository;

	@Autowired
	private CoachConnectMapper coachConnectMapper;

	@Autowired
	private OutboundIntegrationService outboundIntegrationService;
	
	@Autowired
	private Environment environment;

	@Autowired
	private AuthTokenService authTokenService;
	
	@Autowired
	private DateUtility dateUtility;
	
	@Autowired
	private LogCtcAdvanceCallApiRepository logCallApiRepo;
	
	@Autowired
	private UtilityService utilityService;
	
	@Override
	public APIResponseDto findAllByCoachId(Integer userId) { // id_mst_coach
		APIResponseBuilder responseBuilder = new APIResponseDto.APIResponseBuilder();
		try {
			List<CoachConnectEntity> le = coachConnectRepository.findAllByCoachIdAndIsActive(userId, UtilConstant.ACTIVE);
			if (!CollectionUtils.isEmpty(le)) {
				List<CoachConnectDTO> dl = le.stream().map(e -> {
					try {
						CoachConnectDTO dto = coachConnectMapper.EntityToDto(e);
						return dto;
					} catch (Exception e2) {
					}
					return null;
				}).filter(e -> e != null).collect(Collectors.toList());
				responseBuilder.withMessage(UtilConstant.SUCCESS).withStatusCode(HttpStatus.OK.value()).withData(dl);
			} else {
				responseBuilder.withMessage(UtilConstant.DATA_NOT_FOUND).withStatusCode(HttpStatus.OK.value())
						.withData(new ArrayList<>());
			}
		} catch (Exception e) {
			logger.error("Exception {}-{}", userId, e.getMessage());
			logger.error(e.getMessage(), e);
			responseBuilder.withMessage(UtilConstant.FAILED + ": " + e.getMessage())
					.withStatusCode(HttpStatus.BAD_REQUEST.value());
		}
		return responseBuilder.build();
	}

	@Override
	public APIResponseDto callTriggerOutboundIntegration(Long bookingId, String status) { // id_mst_coach
		logger.info("callTriggerOutboundIntegration BookingId- {} status- {}", bookingId, status);
		APIResponseBuilder responseBuilder = new APIResponseDto.APIResponseBuilder();
		
		List<String> allowedCallTypeList= utilityService.getAllowedCallTypes();
		if(!allowedCallTypeList.contains(status)){
			return responseBuilder.withMessage(UtilConstant.INVALID_CALL_TYPE)
					.withStatusCode(HttpStatus.BAD_REQUEST.value()).build();
		}
		
		LogCtcAdvanceCallApiEntity logApi = new LogCtcAdvanceCallApiEntity();
		logApi.setBookingId(bookingId);
		logApi.setTriggerScheduledTime(DateUtility.getSystemCurrentDateTime());
		try {
			
			Optional<CoachConnectEntity> oe = coachConnectRepository.findById(bookingId);
			if(oe.isPresent()) {
				CoachConnectDTO ccDto = coachConnectMapper.EntityToDto(oe.get());
				Date scheduleDT = ccDto.getScheduledConnectTime();
				logApi.setAcutalScheduledTime(ccDto.getScheduledConnectTime());
				logApi.setMobileNumberCoach(ccDto.getMobileNumberCoach());
				logApi.setCustomerMobileNumber(ccDto.getMobileNumberCustomer());
				
				boolean callTrigger = false;
				
				CallTriggerOutBoundRequestDto reqDto = new CallTriggerOutBoundRequestDto();
				reqDto.setAgentNo(ccDto.getMobileNumberCoach().toString());
				reqDto.setCustomerNo(ccDto.getMobileNumberCustomer().toString());
				reqDto.setCampId(environment.getProperty(AppConstants.CALL_TRIGGER_API_CAMPID));
				//reqDto.setCustRefNo(environment.getProperty(AppConstants.CALL_TRIGGER_API_CUSTREFNO));// bookingId
				reqDto.setCustRefNo(String.valueOf(bookingId));// bookingId
				logApi.setConnectType(ccDto.getConnectType());
				reqDto.setCallsec(String.valueOf(ccDto.getMaxAllowedTime()*60));
				reqDto.setCallTime(DateUtility.dateToString(ccDto.getScheduledConnectTime(), DateUtility.FORMAT_CALL_TRIGGER));
				
				switch (status) {
				case (UtilConstant.CONNECT_TYPE_CURRENT): {
					reqDto.setCallSchType(ConnectType.SCHEDULE.name());
					// setup calltime now()
					reqDto.setCallTime(DateUtility.dateToString(
							dateUtility
							.addSecsToNewDate(DateUtility.getSystemCurrentDateTime(), 
									environment.getProperty(AppConstants.CALL_TRIGGER_API_CURRENT_TIME_GRACE, Integer.class)), 
							DateUtility.FORMAT_CALL_TRIGGER));
					callTrigger = true;
				}
					break;
				case (UtilConstant.CONNECT_TYPE_SCHEDULE): {
					Date graceDate = dateUtility.addHourToNewDate(scheduleDT, Integer.parseInt(environment
							.getProperty(AppConstants.CALL_TRIGGER_API_GRACE_HOUR, UtilConstant.INT_ONE_STRING)));
					if (graceDate.before(DateUtility.getSystemCurrentDateTime())) {
						logApi.setValidationMessageText(UtilConstant.TIME_LASPED_MSG);
						return responseBuilder.withMessage(UtilConstant.TIME_LASPED_MSG)
								.withStatusCode(HttpStatus.OK.value()).build();
					}
					reqDto.setCallSchType(ConnectType.SCHEDULE.name());
					callTrigger = true;
				}
					break;
				default:
					logApi.setValidationMessageText(UtilConstant.INVALID_CALL_TYPE);
					responseBuilder.withMessage(UtilConstant.INVALID_CALL_TYPE)
							.withStatusCode(HttpStatus.BAD_REQUEST.value());
					break;
				}
				
				logApi.setRawRequestPayload(utilityService.getObjectMapper().writeValueAsString(reqDto));
				
				if(callTrigger) {
					Map<String, String> headers = new HashMap<>();
					String apiUrl = environment.getProperty(AppConstants.CALL_TRIGGER_API_URL);
					String headersProp = environment.getProperty(AppConstants.CALL_TRIGGER_API_HEADERS);
					Map<String, String> apiHeaders = UtilityService.convertStringToMap(headersProp);
					headers.putAll(apiHeaders);
					ResponseEntity<Object> responseEntity = outboundIntegrationService.callPost(reqDto, headers, apiUrl);
					logApi.setRawResponseText(utilityService.getObjectMapper().writeValueAsString(responseEntity));
					
					 if (responseEntity.getStatusCode().is2xxSuccessful()) {
						 Object response = responseEntity.getBody();
						 logger.info("response--> {}", response);
					        // Convert the response object to JSON string
					        String jsonString = OutboundIntegrationService.getObjectMapper().writeValueAsString(response);

					        // Deserialize JSON to MyResponseDto
					        CallTriggerResponseDto callTriggerResponseDto = OutboundIntegrationService.getObjectMapper()
					        		.readValue(jsonString, CallTriggerResponseDto.class);
					        logApi.setStatus(callTriggerResponseDto.getStatus());
					        logApi.setTransId(callTriggerResponseDto.getTransId());
					        logApi.setMessage(callTriggerResponseDto.getMessage());
					        logger.info("callTriggerResponseDto--> {}", callTriggerResponseDto);
					        responseBuilder.withData(responseEntity);
				        } else {
				        	responseBuilder.withMessage(UtilConstant.DATA_NOT_FOUND)
							.withStatusCode(HttpStatus.BAD_REQUEST.value()).withData(responseEntity);
				        }
					responseBuilder.withMessage(UtilConstant.SUCCESS);
					responseBuilder.withStatusCode(HttpStatus.OK.value());
				}
				
			} else {
				responseBuilder.withMessage(UtilConstant.DATA_NOT_FOUND)
				.withStatusCode(HttpStatus.OK.value()).withData(new ArrayList<>());
			}
		} catch (Exception e) {
			logApi.setValidationMessageText(e.getMessage());
			logger.error("Exception {}-{}", bookingId, e.getMessage());
			logger.error(e.getMessage(), e);
			responseBuilder.withMessage(UtilConstant.FAILED+ ": "+e.getMessage())
			.withStatusCode(HttpStatus.BAD_REQUEST.value());
		} finally {
			logCallApiRepo.save(logApi);
		}
		return responseBuilder.build();
	}

}
