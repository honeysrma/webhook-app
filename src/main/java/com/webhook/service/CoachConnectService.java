package com.webhook.service;

import org.modelmapper.ModelMapper;

import com.webhook.dto.APIResponseDto;

public interface CoachConnectService {

	APIResponseDto findAllByCoachId(Integer userId);

	APIResponseDto callTriggerOutboundIntegration(Long bookingId, String status);
	
	static ModelMapper getModelMapper() {
		return new ModelMapper();
	}

}
