package com.webhook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webhook.common.service.UtilityService;
import com.webhook.dto.APIResponseDto;
import com.webhook.service.CoachConnectService;

@Controller
@RequestMapping("/rest/call-trigger")
public class CallTriggerController {

	@Autowired
	private CoachConnectService coachConnectService;

	@PostMapping(value = "/trigger", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<APIResponseDto> insertIVRPayload(
			@RequestParam(name = "bookindId", required = true) Long bookindId){
		return ResponseEntity.ok(coachConnectService.callTriggerOutboundIntegration(bookindId));
	}
	
}
