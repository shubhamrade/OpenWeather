package com.innovect.whetherforecast.demoservice.model.whetherApi.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherList {
	private long dt;
	@JsonProperty("main")
	private MainClass main;
	@JsonProperty("weather")
	private List<Weather> weather;
	private Clouds clouds;
	private Wind wind;
	private long visibility;
	private long pop;
	private Sys sys;

	@JsonIgnore
	private Object rain;
	@JsonIgnore
	private Object snow;
	@JsonProperty("dt_txt")
	private String dtTxt;

	public long getDt() {
		return dt;
	}

	public void setDt(long value) {
		this.dt = value;
	}

	public MainClass getMain() {
		return main;
	}

	public void setMain(MainClass value) {
		this.main = value;
	}

	public List<Weather> getWeather() {
		return weather;
	}

	public void setWeather(List<Weather> value) {
		this.weather = value;
	}

	public Clouds getClouds() {
		return clouds;
	}

	public void setClouds(Clouds value) {
		this.clouds = value;
	}

	public Wind getWind() {
		return wind;
	}

	public void setWind(Wind value) {
		this.wind = value;
	}

	public long getVisibility() {
		return visibility;
	}

	public void setVisibility(long value) {
		this.visibility = value;
	}

	public long getPop() {
		return pop;
	}

	public void setPop(long value) {
		this.pop = value;
	}

	public Sys getSys() {
		return sys;
	}

	public void setSys(Sys value) {
		this.sys = value;
	}

	public String getDtTxt() {
		return dtTxt;
	}

	public void setDtTxt(String value) {
		this.dtTxt = value;
	}

	public Object getRain() {
		return rain;
	}

	public void setRain(Object rain) {
		this.rain = rain;
	}

	public Object getSnow() {
		return snow;
	}

	public void setSnow(Object snow) {
		this.snow = snow;
	}

	@Override
	public String toString() {
		return "WeatherList [dt=" + dt + ", main=" + main + ", weather=" + weather + ", clouds=" + clouds + ", wind="
				+ wind + ", visibility=" + visibility + ", pop=" + pop + ", sys=" + sys + ", dtTxt=" + dtTxt + "]";
	}

}
