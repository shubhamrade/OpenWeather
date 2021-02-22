package com.innovect.whetherforecast.demoservice.service;

import com.innovect.whetherforecast.demoservice.response.WeatherResponse;;

public interface WeatherService {

	WeatherResponse callWeatherApi(String zipcode, String countrycode);

}