package com.innovect.whetherforecast.demoservice.service.impl;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.innovect.whetherforecast.demoservice.helper.DateHelper;
import com.innovect.whetherforecast.demoservice.helper.StringHelper;
import com.innovect.whetherforecast.demoservice.model.whetherApi.json.Weather;
import com.innovect.whetherforecast.demoservice.model.whetherApi.json.WeatherList;
import com.innovect.whetherforecast.demoservice.model.whetherApi.json.WeatherModeljson;
import com.innovect.whetherforecast.demoservice.response.ErrorEntity;
import com.innovect.whetherforecast.demoservice.response.WeatherResponse;
import com.innovect.whetherforecast.demoservice.response.WeatherStatus;
import com.innovect.whetherforecast.demoservice.response.Weatherdata;
import com.innovect.whetherforecast.demoservice.service.WeatherService;

@Service
public class WeatherServiceImpl implements WeatherService {

	@Value("${Pass.key}")
	String passkey;
	Logger logger = LoggerFactory.getLogger(WeatherServiceImpl.class);

	@Override
	public WeatherResponse callWeatherApi(String zipcode, String countrycode) {

		WeatherResponse response = new WeatherResponse();
		WeatherModeljson model = new WeatherModeljson();

		model = getDataFromWeatherApi(zipcode, countrycode, response);

		if (!response.isHasErrors()) {
			logger.info(model.toString());
			this.prepareResponseData(response, model,
					DateHelper.addNumberOfDays(new Timestamp(new Date().getTime()).toString(), 1));
		}

		return response;

	}

	private void prepareResponseData(WeatherResponse response, WeatherModeljson model, String date) {

		response.setCity(model.getCity().getName());
		response.setLat(model.getCity().getCoord().getLat());
		response.setLon(model.getCity().getCoord().getLon());
		response.setCountryCode(model.getCity().getCountry());

		List<Weatherdata> dataList = new ArrayList<Weatherdata>();
		for (WeatherList weatherObj : model.getList()) {
			if (DateHelper.addNumberOfDays(weatherObj.getDtTxt(), 0).equals(date)) {

				Weatherdata weatherdata = new Weatherdata();
				weatherdata.setDate(weatherObj.getDtTxt());
				weatherdata.setCloudiness(weatherObj.getClouds().getAll().doubleValue());
				weatherdata.setMaxTemp(weatherObj.getMain().getTempMax());
				weatherdata.setMinTemp(weatherObj.getMain().getTempMin());
				weatherdata.setTemp(weatherObj.getMain().getTemp());
				List<WeatherStatus> StatusList = new ArrayList<WeatherStatus>();
				for (Weather weather : weatherObj.getWeather()) {
					WeatherStatus status = new WeatherStatus();
					status.setWeatherParam(weather.getMain());
					status.setWeatherDesc(weather.getDescription());
					StatusList.add(status);

				}

				weatherdata.setWeatherStatus(StatusList);
				weatherdata.setWindSpeed(weatherObj.getWind().getSpeed());
				weatherdata.setWindDirection(weatherObj.getWind().getDeg());
				dataList.add(weatherdata);
			}
			response.setWeatherdata(dataList);
		}

	}

	public WeatherModeljson getDataFromWeatherApi(String zipcode, String countrycode, WeatherResponse response) {
		WeatherModeljson model = new WeatherModeljson();
		URL url = null;
		String baseurl = "http://api.openweathermap.org/data/2.5/forecast?units=metric&";
		String zipParam = "zip=";
		String questionChar = "&";
		String passkeyParam = "appid=";
//		String passkey = "debdf6dddb389e3ac291e4f3fd48db6c";
		ErrorEntity entity = new ErrorEntity();

		try {
			url = new URL(baseurl + zipParam + zipcode + "," + countrycode + questionChar + passkeyParam + passkey);
			logger.info("url =" + url);

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();

			if (conn.getResponseCode() != 200) {
				entity = StringHelper.getErrorEntityFromCode(conn.getResponseCode());
				response.setHasErrors(true);
				response.setErrors(entity.getErrorMessage());

			}
			InputStream in = conn.getInputStream();
			ObjectMapper mapper = new ObjectMapper();
			model = mapper.readValue(in, WeatherModeljson.class);
		} catch (

		Exception e) {

			logger.info("Exception:{}", e.getMessage());
		}

		return model;

	}

}
