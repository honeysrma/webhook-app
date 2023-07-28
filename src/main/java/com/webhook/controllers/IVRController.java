package com.webhook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webhook.common.service.UtilityService;
import com.webhook.dto.APIResponseDto;
import com.webhook.service.IVRService;

@RestController
@RequestMapping("/ivrpayload")
public class IVRController {

	@Autowired
	private IVRService ivrService;

	@Autowired
	private UtilityService utility;

	@PostMapping(value = "/insert", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<APIResponseDto> insertIVRPayload(@RequestBody String requestPayload, BindingResult result) {
		if (result.hasErrors()) {
			return utility.returnErrorMessages(result);
		}
		return ResponseEntity.ok(ivrService.insertIVRPayload(requestPayload));
	}

}
