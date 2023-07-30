package com.webhook.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.webhook.converters.CustomDateSerializer;
import com.webhook.enums.ConnectType;

public class CoachConnectDTO implements Serializable {

	private static final long serialVersionUID = 1360875188026485918L;

	private Long id;
	private ConnectType connectType;
	private int transactionRate;

	@JsonIgnore
	private Long idMstCoach;

	@JsonIgnore
	private Long mobileNumberCoach;

	@JsonIgnore
	private Long idMstUsers;

	private Long mobileNumberCustomer;

	@JsonSerialize(using = CustomDateSerializer.class)
	private Date scheduledConnectTime;

	private int maxAllowedTime;

	public ConnectType getConnectType() {
		return connectType;
	}

	public void setConnectType(ConnectType connectType) {
		this.connectType = connectType;
	}

	public int getTransactionRate() {
		return transactionRate;
	}

	public void setTransactionRate(int transactionRate) {
		this.transactionRate = transactionRate;
	}

	public Long getMobileNumberCustomer() {
		return mobileNumberCustomer;
	}

	public void setMobileNumberCustomer(Long mobileNumberCustomer) {
		this.mobileNumberCustomer = mobileNumberCustomer;
	}

	public Date getScheduledConnectTime() {
		return scheduledConnectTime;
	}

	public void setScheduledConnectTime(Date scheduledConnectTime) {
		this.scheduledConnectTime = scheduledConnectTime;
	}

	public int getMaxAllowedTime() {
		return maxAllowedTime;
	}

	public void setMaxAllowedTime(int maxAllowedTime) {
		this.maxAllowedTime = maxAllowedTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdMstCoach() {
		return idMstCoach;
	}

	public void setIdMstCoach(Long idMstCoach) {
		this.idMstCoach = idMstCoach;
	}

	public Long getMobileNumberCoach() {
		return mobileNumberCoach;
	}

	public void setMobileNumberCoach(Long mobileNumberCoach) {
		this.mobileNumberCoach = mobileNumberCoach;
	}

	public Long getIdMstUsers() {
		return idMstUsers;
	}

	public void setIdMstUsers(Long idMstUsers) {
		this.idMstUsers = idMstUsers;
	}

}
