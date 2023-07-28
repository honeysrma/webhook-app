package com.webhook.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;

@Entity
@Table(name = "ivr_payload")
public class IVRPayloadEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "TRANSID")
    @Min(value = 1, message = "TRANSID greater than 0")
    private int transId;

    @Column(name = "CID")
    private int cid;

    @Column(name = "CLI")
    private int cli;

    @Column(name = "AgentNo" , length = 12)
    private String agentNo;
    
    @Column(name = "AgentCallStatus")
    private String agentCallStatus;
    
    @Column(name = "AgentCallStartTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date agentCallStartTime;
    
    @Column(name = "AgentCallEndTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date agentCallEndTime;
    
    @Column(name = "CustomerNo", length = 12)
    private String customerNo;
    
    @Column(name = "CustomerCallStatus")
    private String customerCallStatus;
    
    @Column(name = "CustomerCallStartTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date customerCallStartTime;
    
    @Column(name = "CustomerCallEndTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date customerCallEndTime;
    
    @Column(name = "CallRecordURL")
    private String callRecordURL;
    
    @Column(name = "raw_dataset")
    @Lob
    private String rawDataSet;
    
    @Column(name = "createdDate", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    
    @Column(name = "updatedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTransId() {
		return transId;
	}

	public void setTransId(int transId) {
		this.transId = transId;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getCli() {
		return cli;
	}

	public void setCli(int cli) {
		this.cli = cli;
	}

	public String getAgentNo() {
		return agentNo;
	}

	public void setAgentNo(String agentNo) {
		this.agentNo = agentNo;
	}

	public String getAgentCallStatus() {
		return agentCallStatus;
	}

	public void setAgentCallStatus(String agentCallStatus) {
		this.agentCallStatus = agentCallStatus;
	}

	public Date getAgentCallStartTime() {
		return agentCallStartTime;
	}

	public void setAgentCallStartTime(Date agentCallStartTime) {
		this.agentCallStartTime = agentCallStartTime;
	}

	public Date getAgentCallEndTime() {
		return agentCallEndTime;
	}

	public void setAgentCallEndTime(Date agentCallEndTime) {
		this.agentCallEndTime = agentCallEndTime;
	}

	public String getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}

	public String getCustomerCallStatus() {
		return customerCallStatus;
	}

	public void setCustomerCallStatus(String customerCallStatus) {
		this.customerCallStatus = customerCallStatus;
	}

	public Date getCustomerCallStartTime() {
		return customerCallStartTime;
	}

	public void setCustomerCallStartTime(Date customerCallStartTime) {
		this.customerCallStartTime = customerCallStartTime;
	}

	public Date getCustomerCallEndTime() {
		return customerCallEndTime;
	}

	public void setCustomerCallEndTime(Date customerCallEndTime) {
		this.customerCallEndTime = customerCallEndTime;
	}

	public String getCallRecordURL() {
		return callRecordURL;
	}

	public void setCallRecordURL(String callRecordURL) {
		this.callRecordURL = callRecordURL;
	}

	public String getRawDataSet() {
		return rawDataSet;
	}

	public void setRawDataSet(String rawDataSet) {
		this.rawDataSet = rawDataSet;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
        
}
