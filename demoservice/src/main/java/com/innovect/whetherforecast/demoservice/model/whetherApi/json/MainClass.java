package com.innovect.whetherforecast.demoservice.model.whetherApi.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MainClass {

	@JsonProperty("temp")
	private double temp;
	@JsonProperty("feels_like")
	private double feelsLike;
	@JsonProperty("temp_min")
	private double tempMin;
	@JsonProperty("temp_max")
	private double tempMax;
	@JsonProperty("pressure")
	private long pressure;
	@JsonProperty("sea_level")
	private long seaLevel;
	@JsonProperty("grnd_level")
	private long grndLevel;
	@JsonProperty("humidity")
	private long humidity;
	@JsonProperty("temp_kf")
	private double tempKf;

	public double getTemp() {
		return temp;
	}

	public void setTemp(double value) {
		this.temp = value;
	}

	public double getFeelsLike() {
		return feelsLike;
	}

	public void setFeelsLike(double value) {
		this.feelsLike = value;
	}

	public double getTempMin() {
		return tempMin;
	}

	public void setTempMin(double value) {
		this.tempMin = value;
	}

	public double getTempMax() {
		return tempMax;
	}

	public void setTempMax(double value) {
		this.tempMax = value;
	}

	public long getPressure() {
		return pressure;
	}

	public void setPressure(long value) {
		this.pressure = value;
	}

	public long getSeaLevel() {
		return seaLevel;
	}

	public void setSeaLevel(long value) {
		this.seaLevel = value;
	}

	public long getGrndLevel() {
		return grndLevel;
	}

	public void setGrndLevel(long value) {
		this.grndLevel = value;
	}

	public long getHumidity() {
		return humidity;
	}

	public void setHumidity(long value) {
		this.humidity = value;
	}

	public double getTempKf() {
		return tempKf;
	}

	public void setTempKf(double value) {
		this.tempKf = value;
	}

	@Override
	public String toString() {
		return "MainClass [temp=" + temp + ", feelsLike=" + feelsLike + ", tempMin=" + tempMin + ", tempMax=" + tempMax
				+ ", pressure=" + pressure + ", seaLevel=" + seaLevel + ", grndLevel=" + grndLevel + ", humidity="
				+ humidity + ", tempKf=" + tempKf + "]";
	}

}
