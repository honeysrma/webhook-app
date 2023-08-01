package com.webhook.dto;

public class CallTriggerOutBoundRequestDto implements OutBoundRequestDto {

	private static final long serialVersionUID = -2151630067370734938L;

	private String AgentNo;
	private String CustomerNo;
	private String CampId;
	private String CustRefNo;
	private String Callsec;
	private String CallSchType;
	private String CallTime;

	public String getAgentNo() {
		return AgentNo;
	}

	public void setAgentNo(String agentNo) {
		AgentNo = agentNo;
	}

	public String getCustomerNo() {
		return CustomerNo;
	}

	public void setCustomerNo(String customerNo) {
		CustomerNo = customerNo;
	}

	public String getCampId() {
		return CampId;
	}

	public void setCampId(String campId) {
		CampId = campId;
	}

	public String getCustRefNo() {
		return CustRefNo;
	}

	public void setCustRefNo(String custRefNo) {
		CustRefNo = custRefNo;
	}

	public String getCallsec() {
		return Callsec;
	}

	public void setCallsec(String callsec) {
		Callsec = callsec;
	}

	public String getCallSchType() {
		return CallSchType;
	}

	public void setCallSchType(String callSchType) {
		CallSchType = callSchType;
	}

	public String getCallTime() {
		return CallTime;
	}

	public void setCallTime(String callTime) {
		this.CallTime = callTime;
	}

	public CallTriggerOutBoundRequestDto(String agentNo, String customerNo, String campId, String custRefNo,
			String callsec, String callSchType, String callTime) {
		super();
		AgentNo = agentNo;
		CustomerNo = customerNo;
		CampId = campId;
		CustRefNo = custRefNo;
		Callsec = callsec;
		CallSchType = callSchType;
		this.CallTime = callTime;
	}

	public CallTriggerOutBoundRequestDto() {
		super();
	}

	@Override
	public String toString() {
		return "CallTriggerOutBoundRequestDto [AgentNo=" + AgentNo + ", CustomerNo=" + CustomerNo + ", CampId=" + CampId
				+ ", CustRefNo=" + CustRefNo + ", Callsec=" + Callsec + ", CallSchType=" + CallSchType + ", callTime="
				+ CallTime + "]";
	}

}
