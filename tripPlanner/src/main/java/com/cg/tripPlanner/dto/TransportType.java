package com.cg.tripPlanner.dto;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection="transportType")
public class TransportType {
	@Id
private Integer transportId;
private String destinationName;
private String transportName;
private Double transportAmount;
private String transportationMode;
public TransportType() {
	super();
	// TODO Auto-generated constructor stub
}



public TransportType(Integer transportId, String destinationName,String transportName, Double transportAmount,
		String transportationMode) {
	super();
	this.transportId = transportId;
	this.destinationName=destinationName;
	this.transportName = transportName;
	this.transportAmount = transportAmount;
	this.transportationMode = transportationMode;
}


@Override
public String toString() {
	return "TransportType [transportId=" + transportId + ", destinationName=" + destinationName + ", transportName="
			+ transportName + ", transportAmount=" + transportAmount + ", transportationMode=" + transportationMode
			+ "]";
}



public String getDestinationName() {
	return destinationName;
}



public void setDestinationName(String destinationName) {
	this.destinationName = destinationName;
}



public Integer getTransportId() {
	return transportId;
}
public void setTransportId(Integer transportId) {
	this.transportId = transportId;
}
public String getTransportName() {
	return transportName;
}
public void setTransportName(String transportName) {
	this.transportName = transportName;
}
public Double getTransportAmount() {
	return transportAmount;
}
public void setTransportAmount(Double transportAmount) {
	this.transportAmount = transportAmount;
}
public String getTransportationMode() {
	return transportationMode;
}
public void setTransportationMode(String transportationMode) {
	this.transportationMode = transportationMode;
}

}
