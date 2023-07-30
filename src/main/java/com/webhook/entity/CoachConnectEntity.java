package com.webhook.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Immutable;

import com.webhook.enums.ConnectType;

@Entity
@Table(name = "trns_coach_connect")
@Immutable

public class CoachConnectEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_trns_coach_connect")
	private Long id;

	@Column(name = "connect_initiation_time", nullable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date connectInitiationTime;

	@Enumerated(EnumType.STRING)
	@Column(name = "connect_type", nullable = false, columnDefinition = "ENUM('CALL','CHAT','VIDEO')")
	private ConnectType connectType;

	@Column(name = "transaction_rate", nullable = false)
	private Integer transactionRate;

	@Column(name = "id_mst_coach", nullable = false)
	private Integer idMstCoach;

	@Column(name = "mobile_number_coach", nullable = false)
	private Long mobileNumberCoach;

	@Column(name = "id_mst_users", nullable = false)
	private Integer idMstUsers;

	@Column(name = "mobile_number_customer", nullable = false)
	private Long customerMobileNumber;

	@Column(name = "scheduled_connect_time", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date scheduledConnectTime;

	@Column(name = "max_allowed_time", nullable = false)
	private Integer maxAllowedTime;

	@Column(name = "is_active", nullable = false)
	private int isActive;

	@Column(name = "cancelled_on")
	@Temporal(TemporalType.TIMESTAMP)
	private Date cancelledOn;

	@Column(name = "cancelled_by")
	private Integer cancelledBy;

	@Column(name = "disposition_remark", length = 1050)
	private String dispositionRemark;

	@Column(name = "case_remark", length = 1050)
	private String caseRemark;

	@Column(name = "user_note", length = 1050)
	private String userNote;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getConnectInitiationTime() {
		return connectInitiationTime;
	}

	public void setConnectInitiationTime(Date connectInitiationTime) {
		this.connectInitiationTime = connectInitiationTime;
	}

	public ConnectType getConnectType() {
		return connectType;
	}

	public void setConnectType(ConnectType connectType) {
		this.connectType = connectType;
	}

	public Integer getTransactionRate() {
		return transactionRate;
	}

	public void setTransactionRate(Integer transactionRate) {
		this.transactionRate = transactionRate;
	}

	public Long getCustomerMobileNumber() {
		return customerMobileNumber;
	}

	public void setCustomerMobileNumber(Long customerMobileNumber) {
		this.customerMobileNumber = customerMobileNumber;
	}

	public Date getScheduledConnectTime() {
		return scheduledConnectTime;
	}

	public void setScheduledConnectTime(Date scheduledConnectTime) {
		this.scheduledConnectTime = scheduledConnectTime;
	}

	public Integer getMaxAllowedTime() {
		return maxAllowedTime;
	}

	public void setMaxAllowedTime(Integer maxAllowedTime) {
		this.maxAllowedTime = maxAllowedTime;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public Date getCancelledOn() {
		return cancelledOn;
	}

	public void setCancelledOn(Date cancelledOn) {
		this.cancelledOn = cancelledOn;
	}

	public Integer getCancelledBy() {
		return cancelledBy;
	}

	public void setCancelledBy(Integer cancelledBy) {
		this.cancelledBy = cancelledBy;
	}

	public String getDispositionRemark() {
		return dispositionRemark;
	}

	public void setDispositionRemark(String dispositionRemark) {
		this.dispositionRemark = dispositionRemark;
	}

	public String getCaseRemark() {
		return caseRemark;
	}

	public void setCaseRemark(String caseRemark) {
		this.caseRemark = caseRemark;
	}

	public String getUserNote() {
		return userNote;
	}

	public void setUserNote(String userNote) {
		this.userNote = userNote;
	}

	public Integer getIdMstCoach() {
		return idMstCoach;
	}

	public void setIdMstCoach(Integer idMstCoach) {
		this.idMstCoach = idMstCoach;
	}

	public Long getMobileNumberCoach() {
		return mobileNumberCoach;
	}

	public void setMobileNumberCoach(Long mobileNumberCoach) {
		this.mobileNumberCoach = mobileNumberCoach;
	}

	public Integer getIdMstUsers() {
		return idMstUsers;
	}

	public void setIdMstUsers(Integer idMstUsers) {
		this.idMstUsers = idMstUsers;
	}
}
