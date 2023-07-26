package com.webhook.service.impl;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.webhook.constants.UtilConstant;
import com.webhook.dto.APIResponseDto;
import com.webhook.dto.APIResponseDto.APIResponseBuilder;
import com.webhook.dto.IVRPayloadRequestDto;
import com.webhook.entity.IVRPayloadEntity;
import com.webhook.mapper.IVRPayloadMapper;
import com.webhook.repositories.IVRPayloadRepository;
import com.webhook.service.IVRService;
import com.webhook.service.UtilityService;

@Service
public class IVRServiceImpl implements IVRService {
	
	private static final Logger logger = LoggerFactory.getLogger(IVRServiceImpl.class);

	@Autowired
	private IVRPayloadMapper ivrPayloadMapper;

	@Autowired
	private UtilityService utilityService;
	
	@Autowired
	private IVRPayloadRepository ivrPayloadRepository;
	
	@Override
	public APIResponseDto insertIVRPayload(String reqPayload) {
		IVRPayloadRequestDto reqDto = null;
		APIResponseBuilder  responseBuilder = new APIResponseDto.APIResponseBuilder();
		try {
			logger.info("insertIVRPayload {}", reqPayload);
			reqDto = utilityService.getObjectMapper().readValue(reqPayload, IVRPayloadRequestDto.class);
			reqDto.setRawDataSet(reqPayload);
			
			IVRPayloadEntity entityPayloadEntity = ivrPayloadMapper.dtoToEntity(reqDto);
			entityPayloadEntity = ivrPayloadRepository.save(entityPayloadEntity);
			if(Objects.nonNull(entityPayloadEntity) && entityPayloadEntity.getId()>0) {
				return responseBuilder.withMessage(UtilConstant.SUCCESS)
						.withStatusCode(HttpStatus.OK.value()).build();
			}
		} catch (JsonMappingException e) {
			logger.error("JsonMappingException", e);
			responseBuilder.withMessage(UtilConstant.FAILED+ ": "+e.getMessage())
			.withStatusCode(HttpStatus.BAD_REQUEST.value());
		} catch (JsonProcessingException e) {
			logger.error("JsonProcessingException", e);
			responseBuilder.withMessage(UtilConstant.FAILED+ ": "+e.getMessage())
			.withStatusCode(HttpStatus.BAD_REQUEST.value());
		} catch (Exception e) {
			logger.error("Exception {}", reqDto.getTransId(), e.getMessage());
			logger.error(e.getMessage(), e);
			responseBuilder.withMessage(UtilConstant.FAILED+ ": "+e.getMessage())
			.withStatusCode(HttpStatus.BAD_REQUEST.value());
		}
		return responseBuilder.build();
	}

}
