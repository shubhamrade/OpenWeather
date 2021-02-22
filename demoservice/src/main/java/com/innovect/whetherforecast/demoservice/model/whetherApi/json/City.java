package com.innovect.whetherforecast.demoservice.model.whetherApi.json;

public class City {

	private long id;
	private String name;
	private Coord coord;
	private String country;
	private long population;
	private long timezone;
	private long sunrise;
	private long sunset;

	public long getID() {
		return id;
	}

	public void setID(long value) {
		this.id = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String value) {
		this.name = value;
	}

	public Coord getCoord() {
		return coord;
	}

	public void setCoord(Coord value) {
		this.coord = value;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String value) {
		this.country = value;
	}

	public long getPopulation() {
		return population;
	}

	public void setPopulation(long value) {
		this.population = value;
	}

	public long getTimezone() {
		return timezone;
	}

	public void setTimezone(long value) {
		this.timezone = value;
	}

	public long getSunrise() {
		return sunrise;
	}

	public void setSunrise(long value) {
		this.sunrise = value;
	}

	public long getSunset() {
		return sunset;
	}

	public void setSunset(long value) {
		this.sunset = value;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + ", coord=" + coord + ", country=" + country + ", population="
				+ population + ", timezone=" + timezone + ", sunrise=" + sunrise + ", sunset=" + sunset + "]";
	}

}
