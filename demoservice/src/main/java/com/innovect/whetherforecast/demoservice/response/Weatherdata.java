package com.innovect.whetherforecast.demoservice.response;

import java.util.List;

public class Weatherdata {

	String date;

	Double minTemp;
	Double maxTemp;
	Double temp;
	List<WeatherStatus> weatherStatus;
	Double cloudiness;
	Double windSpeed;
	Double windDirection;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Double getMinTemp() {
		return minTemp;
	}

	public void setMinTemp(Double minTemp) {
		this.minTemp = minTemp;
	}

	public Double getMaxTemp() {
		return maxTemp;
	}

	public void setMaxTemp(Double maxTemp) {
		this.maxTemp = maxTemp;
	}

	public Double getTemp() {
		return temp;
	}

	public void setTemp(Double temp) {
		this.temp = temp;
	}

	public Double getCloudiness() {
		return cloudiness;
	}

	public void setCloudiness(Double cloudiness) {
		this.cloudiness = cloudiness;
	}

	public Double getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(Double windSpeed) {
		this.windSpeed = windSpeed;
	}

	public Double getWindDirection() {
		return windDirection;
	}

	public void setWindDirection(Double windDirection) {
		this.windDirection = windDirection;
	}

	public List<WeatherStatus> getWeatherStatus() {
		return weatherStatus;
	}

	public void setWeatherStatus(List<WeatherStatus> weatherStatus) {
		this.weatherStatus = weatherStatus;
	}

}
