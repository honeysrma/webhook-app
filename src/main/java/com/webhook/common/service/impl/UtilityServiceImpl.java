package com.webhook.common.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.webhook.common.service.UtilityService;
import com.webhook.constants.AppConstants;
import com.webhook.constants.UtilConstant;
import com.webhook.dto.APIResponseDto;
import com.webhook.dto.APIResponseDto.APIResponseBuilder;

@Service
public class UtilityServiceImpl implements UtilityService {

	private static final Logger logger = LoggerFactory.getLogger(UtilityServiceImpl.class);
	
	private final ObjectMapper objectMapper = new ObjectMapper();
	
	
	private Environment environment;
	
	public UtilityServiceImpl(Environment environment) {
		this.environment = environment;
	}
	
	@Override
	public ObjectMapper getObjectMapper() {
		return objectMapper;
	}
	
	@Override
 	public ResponseEntity<APIResponseDto> returnErrorMessages(BindingResult result){
		APIResponseBuilder  responseBuilder = new APIResponseDto.APIResponseBuilder();
 		 Map<String, String> errors = new HashMap<>();
            for (FieldError error : result.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            responseBuilder.withStatusCode(HttpStatus.BAD_REQUEST.value())
            .withMessage("Validation Errors")
            .withData(errors);
            return ResponseEntity.badRequest().body(responseBuilder.build());
 	}
	
	@Override
	public String convertDtoToJson(APIResponseDto apiResponseDto) {
        try {
            return objectMapper.writeValueAsString(apiResponseDto);
        } catch (JsonProcessingException e) {
        	logger.error(e.getMessage(), e);
            return null;
        }
    }
	
	@Override
	public List<String> getSkipAPIList(){
		return UtilityService.convertStringToList(environment.getProperty(AppConstants.SKIP_APP_API_URL, UtilConstant.EMPTY));
	}
	
	@Override
	public List<String> getAllowedCallTypes(){
		 String value = environment.getProperty(AppConstants.CALL_TRIGGER_API_ALLOWTYPE);
		 return Arrays.asList(value.split(","));
		
	}
	
}
