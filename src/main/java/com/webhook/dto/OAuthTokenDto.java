package com.webhook.dto;

import java.io.Serializable;
import java.util.Date;

public class OAuthTokenDto implements Serializable {

	private static final long serialVersionUID = 8887956659649425855L;
	private Long id;
	private String token;
	private Long clientId;
	private String clientIp;
	private Long userId;
	private Date expiryTime;
	private Date createdAt;
	private Date updatedAt;
	private String fullToken;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public String getClientIp() {
		return clientIp;
	}

	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Date getExpiryTime() {
		return expiryTime;
	}

	public void setExpiryTime(Date expiryTime) {
		this.expiryTime = expiryTime;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public String getFullToken() {
		return fullToken;
	}

	public void setFullToken(String fullToken) {
		this.fullToken = fullToken;
	}

}
