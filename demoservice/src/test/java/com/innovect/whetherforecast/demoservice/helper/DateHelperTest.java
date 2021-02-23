package com.innovect.whetherforecast.demoservice.helper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.jupiter.api.Test;

public class DateHelperTest {

	@Test
	public void addNumberOfDays() throws ParseException {

		String date = "2021-02-23";
		int day = 1;
		String expectedDate = "2021-02-24";

		assertNotNull(date);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateFormat.parse(date));

		cal.add(Calendar.DATE, day);
		String convertedDate = dateFormat.format(cal.getTime());

		assertEquals(expectedDate, convertedDate);

	}

}
