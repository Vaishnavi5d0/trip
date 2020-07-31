package com.cg.tripPlanner.dto;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection="hotel")
public class Hotel {
	@Id
private Integer hotelId;
private String destinationName;
private String hotelName;
private String address;
private Double hotelBill;
public Hotel() {
	super();
	// TODO Auto-generated constructor stub
}
public Hotel(Integer hotelId, String destinationName,String hotelName, String address, Double hotelBill) {
	super();
	this.hotelId = hotelId;
	this.destinationName=destinationName;
	this.hotelName = hotelName;
	this.address = address;
	this.hotelBill = hotelBill;
	
}
public Integer getHotelId() {
	return hotelId;
}
public void setHotelId(Integer hotelId) {
	this.hotelId = hotelId;
}
public String getHotelName() {
	return hotelName;
}
public void setHotelName(String hotelName) {
	this.hotelName = hotelName;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public Double getHotelBill() {
	return hotelBill;
}
public void setHotelBill(Double hotelBill) {
	this.hotelBill = hotelBill;
}
public String getDestinationName() {
	return destinationName;
}
public void setDestinationName(String destinationName) {
	this.destinationName = destinationName;
}
@Override
public String toString() {
	return "Hotel [hotelId=" + hotelId + ", destinationName=" + destinationName + ", hotelName=" + hotelName
			+ ", address=" + address + ", hotelBill=" + hotelBill + "]";
}


}
