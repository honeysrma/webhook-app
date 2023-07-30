package com.webhook.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAlias;

public class CallTriggerResponseDto implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@JsonAlias("Status")
	private String status;
	
	@JsonAlias("TransId")
	private String transId;
	
	@JsonAlias("Message")
	private String message;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTransId() {
		return transId;
	}

	public void setTransId(String transId) {
		this.transId = transId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "CallTriggerResponseDto [status=" + status + ", transId=" + transId + ", message=" + message + "]";
	}
	
}