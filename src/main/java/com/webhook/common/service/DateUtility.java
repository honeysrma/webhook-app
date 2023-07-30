package com.webhook.common.service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public interface DateUtility {

	String FORMAT_CALL_TRIGGER = "dd/MM/yyyy HH:mm";
	String FORMAT_DB = "yyyy-MM-dd HH:mm:ss";

	static String dateToString(Date date, String format) {
		// Parse the input date to LocalDateTime
		LocalDateTime dateTime = dateToLocalDateTime(date);
		// Format LocalDateTime to the desired output format
		return dateTime.format(DateTimeFormatter.ofPattern(format));
	}

	static LocalDateTime dateToLocalDateTime(Date date) {
		// Convert Date to Instant
		Instant instant = date.toInstant();
		// Convert Instant to LocalDateTime using the default system time zone
		LocalDateTime localDateTime = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
		return localDateTime;
	}

	static Date getSystemCurrentDateTime() {
		return new Date();
	}
}
