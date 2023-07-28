package com.webhook.common.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.webhook.common.service.UtilityService;
import com.webhook.dto.APIResponseDto;
import com.webhook.dto.APIResponseDto.APIResponseBuilder;

@Service
public class UtilityServiceImpl implements UtilityService {

	private final ObjectMapper objectMapper = new ObjectMapper();
	
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
	
}
