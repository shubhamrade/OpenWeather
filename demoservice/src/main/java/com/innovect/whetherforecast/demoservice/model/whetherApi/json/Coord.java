package com.innovect.whetherforecast.demoservice.model.whetherApi.json;

public class Coord {

	private Double lat;

	private Double lon;

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

	@Override
	public String toString() {
		return "Coord [lat=" + lat + ", lon=" + lon + "]";
	}

}
