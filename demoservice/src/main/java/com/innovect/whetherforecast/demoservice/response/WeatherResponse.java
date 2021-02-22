package com.innovect.whetherforecast.demoservice.response;

import java.util.List;

public class WeatherResponse extends BaseResponse {

	String city;
	String countryCode;
	private Double lat;
	private Double lon;
	List<Weatherdata> weatherdata;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLon() {
		return lon;
	}

	public void setLon(Double lon) {
		this.lon = lon;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public List<Weatherdata> getWeatherdata() {
		return weatherdata;
	}

	public void setWeatherdata(List<Weatherdata> weatherdata) {
		this.weatherdata = weatherdata;
	}

}
