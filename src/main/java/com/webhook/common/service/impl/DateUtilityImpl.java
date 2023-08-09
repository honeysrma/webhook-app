package com.webhook.common.service.impl;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.webhook.common.service.DateUtility;

@Service
public class DateUtilityImpl implements DateUtility {

	private static final Logger logger = LoggerFactory.getLogger(DateUtilityImpl.class);

	@Override
	public Date addHourToDate(Date date, int hour) {
		LocalDateTime localDateTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		LocalDateTime updatedLocalDateTime = localDateTime.plusHours(hour);
		Date updatedDate = Date.from(updatedLocalDateTime.atZone(ZoneId.systemDefault()).toInstant());
		logger.info("Original Date: " + date);
		logger.info("Updated Date (after adding " + hour + " hour): " + updatedDate);
		return updatedDate;
	}
	
	@Override
	 public Date addHourToNewDate(Date originalDate, int hour) {
		 	logger.info("originalDate Date: " + originalDate);
	        Date clonedDate = Date.from(originalDate.toInstant());
	        LocalDateTime localDateTime = clonedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
			LocalDateTime updatedLocalDateTime = localDateTime.plusHours(hour);
			Date updatedDate = Date.from(updatedLocalDateTime.atZone(ZoneId.systemDefault()).toInstant());
			logger.info("clonedDate Date: " + clonedDate);
			logger.info("Updated Date (after adding " + hour + " hour): " + updatedDate);
			return updatedDate;
	    }
	
	@Override
	 public Date addMinsToNewDate(Date originalDate, int mins) {
		 	logger.info("originalDate Date: " + originalDate);
	        Date clonedDate = Date.from(originalDate.toInstant());
	        LocalDateTime localDateTime = clonedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
			LocalDateTime updatedLocalDateTime = localDateTime.plusMinutes(mins);
			Date updatedDate = Date.from(updatedLocalDateTime.atZone(ZoneId.systemDefault()).toInstant());
			logger.info("clonedDate Date: " + clonedDate);
			logger.info("Updated Date (after adding " + mins + " mins): " + updatedDate);
			return updatedDate;
	    }
	
	@Override
	 public Date addSecsToNewDate(Date originalDate, int secs) {
		 	logger.info("originalDate Date: " + originalDate);
	        Date clonedDate = Date.from(originalDate.toInstant());
	        LocalDateTime localDateTime = clonedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
			LocalDateTime updatedLocalDateTime = localDateTime.plusSeconds(secs);
			Date updatedDate = Date.from(updatedLocalDateTime.atZone(ZoneId.systemDefault()).toInstant());
			logger.info("clonedDate Date: " + clonedDate);
			logger.info("Updated Date (after adding " + secs + " secs): " + updatedDate);
			return updatedDate;
	    }

}
