package com.webhook.common.service;

import java.util.Date;

public interface DateUtility {

	static Date getSystemCurrentDateTime() {
		return new Date();
	}
}
