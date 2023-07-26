package com.webhook.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webhook.constants.UtilConstant;

@RestController
@RequestMapping("/")
public class AppController {
	
	@GetMapping
	public String checkApp() {
		return UtilConstant.SUCCESS;
	}
	
}
