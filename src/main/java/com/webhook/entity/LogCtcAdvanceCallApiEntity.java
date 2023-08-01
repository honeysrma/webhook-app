package com.webhook.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.webhook.enums.ConnectType;

@Entity
@Table(name = "log_ctc_advance_call_api")
public class LogCtcAdvanceCallApiEntity {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Lob
	private String rawRequestPayload;
	
	@Lob
	private String rawResponseText;
	
	@Column(name = "validation_response", length = 100)
	private String validationMessageText;
	
	@Column(name = "id_trns_coach_connect")
	private Long bookingId;
	
	@Column(name = "scheduled_connect_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date acutalScheduledTime;
	
	@Column(name = "mobile_number_coach", length = 12)
	private Long mobileNumberCoach;
	
	@Column(name = "mobile_number_customer", length = 12)
	private Long customerMobileNumber;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "connect_type", columnDefinition = "ENUM('CALL','CHAT','VIDEO')")
	private ConnectType connectType;
	
	@Column(name = "trigger_scheduled_time", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date triggerScheduledTime;
	
	@Column(name = "trans_id")
	private Long transId;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "message")
	private String message;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRawRequestPayload() {
		return rawRequestPayload;
	}

	public void setRawRequestPayload(String rawRequestPayload) {
		this.rawRequestPayload = rawRequestPayload;
	}

	public String getRawResponseText() {
		return rawResponseText;
	}

	public void setRawResponseText(String rawResponseText) {
		this.rawResponseText = rawResponseText;
	}

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public Date getAcutalScheduledTime() {
		return acutalScheduledTime;
	}

	public void setAcutalScheduledTime(Date acutalScheduledTime) {
		this.acutalScheduledTime = acutalScheduledTime;
	}

	public Long getMobileNumberCoach() {
		return mobileNumberCoach;
	}

	public void setMobileNumberCoach(Long mobileNumberCoach) {
		this.mobileNumberCoach = mobileNumberCoach;
	}

	public Long getCustomerMobileNumber() {
		return customerMobileNumber;
	}

	public void setCustomerMobileNumber(Long customerMobileNumber) {
		this.customerMobileNumber = customerMobileNumber;
	}

	public ConnectType getConnectType() {
		return connectType;
	}

	public void setConnectType(ConnectType connectType) {
		this.connectType = connectType;
	}

	public Date getTriggerScheduledTime() {
		return triggerScheduledTime;
	}

	public void setTriggerScheduledTime(Date triggerScheduledTime) {
		this.triggerScheduledTime = triggerScheduledTime;
	}

	public Long getTransId() {
		return transId;
	}

	public void setTransId(Long transId) {
		this.transId = transId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getValidationMessageText() {
		return validationMessageText;
	}

	public void setValidationMessageText(String validationMessageText) {
		this.validationMessageText = validationMessageText;
	}
	
}
