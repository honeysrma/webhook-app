package com.webhook.dto;

import java.io.Serializable;

public class APIResponseDto implements Serializable {
	private static final long serialVersionUID = -1722209598517066997L;

	private int statusCode;
	private String message;
	private Object data;

	// Private constructor to prevent direct instantiation
	private APIResponseDto() {
	}

	// Builder class for APIResponseDto
	public static class APIResponseBuilder implements IResponseDtoBuilder {
		private APIResponseDto instance = new APIResponseDto();

		public APIResponseBuilder withMessage(String message) {
			instance.message = message;
			return this;
		}

		public APIResponseBuilder withStatusCode(int statusCode) {
			instance.statusCode = statusCode;
			return this;
		}

		public APIResponseBuilder withData(Object data) {
			instance.data = data;
			return this;
		}

		// Implement build method from the IResponseDtoBuilder interface
		@Override
		public APIResponseDto build() {
			// Optionally, you can add validation logic here before returning the instance.
			return instance;
		}
	}

	// Getters for ConcreteResponseDto properties (omitted for brevity)
	public String getMessage() {
		return message;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public Object getData() {
		return data;
	}

}
