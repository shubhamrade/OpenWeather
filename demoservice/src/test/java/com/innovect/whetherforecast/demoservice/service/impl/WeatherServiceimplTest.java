package com.innovect.whetherforecast.demoservice.service.impl;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.innovect.whetherforecast.demoservice.model.whetherApi.json.WeatherModeljson;

public class WeatherServiceimplTest {
//

	private static Stream<Arguments> provideParameters() {
		return Stream.of(Arguments.of("20020", "Us"));
	}
	
	private static Stream<Arguments> provideInvalidParameters() {
		return Stream.of(Arguments.of("2002", "Us"));
	}


	@ParameterizedTest
	@MethodSource("provideParameters")
	public void testcallWeatherApi_Success(String zipCode, String countryCode) throws IOException {

		WeatherModeljson model = new WeatherModeljson();
		int responseCode = 200;
		URL url = null;
		String baseurl = "http://api.openweathermap.org/data/2.5/forecast?units=metric&";
		String zipParam = "zip=";
		String questionChar = "&";
		String passkeyParam = "appid=";

		assertNotNull(zipCode);
		assertNotNull(countryCode);

		url = new URL("http://api.openweathermap.org/data/2.5/forecast?units=metric&" + zipParam + zipCode + ","
				+ countryCode + questionChar + passkeyParam + "debdf6dddb389e3ac291e4f3fd48db6c");

		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.connect();

		assertEquals(responseCode, conn.getResponseCode());

		InputStream in = conn.getInputStream();
		ObjectMapper mapper = new ObjectMapper();
		model = mapper.readValue(in, WeatherModeljson.class);

		assertNotNull(model);
		assertNotNull(model.getCity());
		assertNotNull(model.getList());
		assertFalse(model.getList().isEmpty());

	}

	@ParameterizedTest
	@MethodSource("provideParameters")
	public void testcallWeatherApi_ApiKEyInValid(String zipCode, String countryCode) throws IOException {

		WeatherModeljson model = new WeatherModeljson();
		int responseCode = 401; /// response code for invalid api key
		URL url = null;
		String baseurl = "http://api.openweathermap.org/data/2.5/forecast?units=metric&";
		String zipParam = "zip=";
		String questionChar = "&";
		String passkeyParam = "appid=";

		assertNotNull(zipCode);
		assertNotNull(countryCode);

		url = new URL("http://api.openweathermap.org/data/2.5/forecast?units=metric&" + zipParam + zipCode + ","
				+ countryCode + questionChar + passkeyParam + "debdf6dddb389e3ac291e4f3fd48db6");

		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.connect();

		assertEquals(responseCode, conn.getResponseCode());

	}
	
	
	@ParameterizedTest
	@MethodSource("provideInvalidParameters")
	public void testcallWeatherApi_invalidCity(String zipCode, String countryCode) throws IOException {

		WeatherModeljson model = new WeatherModeljson();
		int responseCode = 404; /// response code for Invalid city
		URL url = null;
		String baseurl = "http://api.openweathermap.org/data/2.5/forecast?units=metric&";
		String zipParam = "zip=";
		String questionChar = "&";
		String passkeyParam = "appid=";

		assertNotNull(zipCode);
		assertNotNull(countryCode);

		url = new URL("http://api.openweathermap.org/data/2.5/forecast?units=metric&" + zipParam + zipCode + ","
				+ countryCode + questionChar + passkeyParam + "debdf6dddb389e3ac291e4f3fd48db6c");

		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.connect();

		assertEquals(responseCode, conn.getResponseCode());

	}
}
