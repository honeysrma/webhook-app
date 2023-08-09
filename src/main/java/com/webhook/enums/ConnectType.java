package com.webhook.enums;

public enum ConnectType {
	CALL("CALL"), CHAT("CHAT"), VIDEO("VIDEO"), CURRENT("CURRENT"), SCHEDULE("SCHEDULE");
	
	private String name;
	
	ConnectType(String name){
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}