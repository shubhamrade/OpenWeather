package com.innovect.whetherforecast.demoservice.model.whetherApi.json;

public class WeatherModeljson {

	private String cod;
	private long message;
	private long cnt;
	private java.util.List<WeatherList> list;
	private City city;

	public String getCod() {
		return cod;
	}

	public void setCod(String value) {
		this.cod = value;
	}

	public long getMessage() {
		return message;
	}

	public void setMessage(long value) {
		this.message = value;
	}

	public long getCnt() {
		return cnt;
	}

	public void setCnt(long value) {
		this.cnt = value;
	}

	public java.util.List<WeatherList> getList() {
		return list;
	}

	public void setList(java.util.List<WeatherList> list) {
		this.list = list;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City value) {
		this.city = value;
	}

	@Override
	public String toString() {
		return "WeatherModeljson [cod=" + cod + ", message=" + message + ", cnt=" + cnt + ", list=" + list + ", city="
				+ city + "]";
	}

}