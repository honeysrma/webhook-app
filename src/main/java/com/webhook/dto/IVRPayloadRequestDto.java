package com.webhook.dto;

import java.util.Date;

import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;


public class IVRPayloadRequestDto {

    private int id;

    @Min(value = 1, message = "TRANSID greater than 0")
    @JsonProperty("TRANSID")
    private int transId;

    @JsonProperty("CID")
    private int cid;

    @JsonProperty("CLI")
    private int cli;

    @JsonProperty("AgentNo")
    private String agentNo;
    
    @JsonProperty("AgentCallStatus")
    private String agentCallStatus;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone = "IST")
    @JsonProperty("AgentCallStartTime")
    private Date agentCallStartTime;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone = "IST")
    @JsonProperty("AgentCallEndTime")
    private Date agentCallEndTime;
    
    @JsonProperty("CustomerNo")
    private String customerNo;
    
    @JsonProperty("CustomerCallStatus")
    private String customerCallStatus;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone = "IST")
    @JsonProperty("CustomerCallStartTime")
    private Date customerCallStartTime;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone = "IST")
    @JsonProperty("CustomerCallEndTime")
    private Date customerCallEndTime;
    
    @JsonProperty("CallRecordURL")
    private String callRecordURL;
    
    private String rawDataSet;

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

	@Override
	public String toString() {
		return "IVRPayloadRequestDto [id=" + id + ", transId=" + transId + ", cid=" + cid + ", cli=" + cli
				+ ", agentNo=" + agentNo + ", agentCallStatus=" + agentCallStatus + ", agentCallStartTime="
				+ agentCallStartTime + ", agentCallEndTime=" + agentCallEndTime + ", customerNo=" + customerNo
				+ ", customerCallStatus=" + customerCallStatus + ", customerCallStartTime=" + customerCallStartTime
				+ ", customerCallEndTime=" + customerCallEndTime + ", callRecordURL=" + callRecordURL + ", rawDataSet="
				+ rawDataSet + "]";
	}

}
