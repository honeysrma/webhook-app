package com.webhook.service;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.webhook.dto.APIResponseDto;

public interface UtilityService {

	ObjectMapper getObjectMapper();

	ResponseEntity<APIResponseDto> returnErrorMessages(BindingResult result);


}
