package com.cg.tripPlanner.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Destination")
public class Destination {
	@Id
	private Integer destinationId;
	private String destinationName;
	private String country;
	private String state;
	private String city;
	public Destination() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Destination(Integer destinationId, String destinationName, String country, String state, String city) {
		super();
		this.destinationId = destinationId;
		this.destinationName = destinationName;
		this.country = country;
		this.state = state;
		this.city = city;
	}
	public Integer getDestinationId() {
		return destinationId;
	}
	public void setDestinationId(Integer destinationId) {
		this.destinationId = destinationId;
	}
	public String getDestinationName() {
		return destinationName;
	}
	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Destination [destinationId=" + destinationId + ", destinationName=" + destinationName + ", country="
				+ country + ", state=" + state + ", city=" + city + "]";
	}
  
}
