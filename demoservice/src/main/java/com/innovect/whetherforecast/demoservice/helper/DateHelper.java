package com.innovect.whetherforecast.demoservice.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.innovect.whetherforecast.demoservice.service.impl.WeatherServiceImpl;

public class DateHelper {

	static Logger logger = LoggerFactory.getLogger(WeatherServiceImpl.class);

	public static String addNumberOfDays(String date, int day) {

		if (!StringHelper.isNullOrEmpty(date)) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cal = Calendar.getInstance();
			try {
				cal.setTime(dateFormat.parse(date));
			} catch (ParseException e) {
				logger.info("Exception occured in addNumberOfDays funtion :{}", e);
			}
			cal.add(Calendar.DATE, day);
			String convertedDate = dateFormat.format(cal.getTime());
			return convertedDate;
		} else {
			return null;
		}
	}

}
