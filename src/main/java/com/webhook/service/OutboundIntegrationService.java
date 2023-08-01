package com.webhook.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.webhook.dto.OutBoundRequestDto;

public interface OutboundIntegrationService {

	ResponseEntity<Object> callPost(OutBoundRequestDto reqDto, Map<String, String> headers, String apiUrl);
	
	static ObjectMapper getObjectMapper() {
		return new ObjectMapper();
	}

}
