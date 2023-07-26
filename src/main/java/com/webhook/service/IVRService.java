package com.webhook.service;

import com.webhook.dto.APIResponseDto;

public interface IVRService {

	APIResponseDto insertIVRPayload(String reqPayload);

}
