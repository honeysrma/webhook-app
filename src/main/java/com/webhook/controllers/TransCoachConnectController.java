package com.webhook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webhook.dto.APIResponseDto;
import com.webhook.service.CoachConnectService;

@Controller
@RequestMapping("/rest/trans-coach-connect")
public class TransCoachConnectController {

	@Autowired
	private CoachConnectService coachConnectService;

	@GetMapping(value = "/list/{coachId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<APIResponseDto> listById(@PathVariable(name = "coachId", required = true) Integer coachId){
		return ResponseEntity.ok(coachConnectService.findAllByCoachId(coachId));
	}


}
