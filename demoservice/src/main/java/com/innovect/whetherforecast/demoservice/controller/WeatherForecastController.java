package com.innovect.whetherforecast.demoservice.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.innovect.whetherforecast.demoservice.helper.StringHelper;
import com.innovect.whetherforecast.demoservice.response.ErrorEntity;
import com.innovect.whetherforecast.demoservice.response.WeatherResponse;
import com.innovect.whetherforecast.demoservice.service.WeatherService;

@CrossOrigin
@RestController
public class WeatherForecastController {

	@Autowired
	WeatherService weatherService;

	@GetMapping(value = "/getweatherdata")
	public WeatherResponse getData(@RequestParam(defaultValue = "null") String zipcode,
			@RequestParam(defaultValue = "null") String countrycode) {

		WeatherResponse response = new WeatherResponse();
		if (!StringHelper.isNullOrEmpty(countrycode) && !StringHelper.isNullOrEmpty(countrycode)) {
			response = weatherService.callWeatherApi(zipcode, countrycode);
		} else {
			ErrorEntity entity = StringHelper.getErrorEntityFromCode(1);
			response.setHasErrors(true);
			response.setErrors(entity.getErrorMessage());
		}
		return response;
	}

}
