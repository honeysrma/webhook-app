package com.webhook.service.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.webhook.common.service.UtilityService;
import com.webhook.dto.OutBoundRequestDto;
import com.webhook.service.OutboundIntegrationService;

@Service("CallTriggerService")
public class CallTriggerServiceImpl implements OutboundIntegrationService {

	private static final Logger logger = LoggerFactory.getLogger(CallTriggerServiceImpl.class);

	private final RestTemplate restTemplate;

	public CallTriggerServiceImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	public ResponseEntity<Object> callPost(OutBoundRequestDto reqDto, Map<String, String> headers, String apiUrl) {
		logger.info("apiUrl--> {}", apiUrl);
		logger.info("headers--> {}", headers);
		logger.info("RequestDto--> {}", reqDto);
		HttpEntity<OutBoundRequestDto> requestEntity = new HttpEntity<>(reqDto,
				UtilityService.convertMapToHttpHeaders(headers));
		ResponseEntity<Object> responseEntity = restTemplate.postForEntity(apiUrl, requestEntity, Object.class);
		return responseEntity;
	}

}
