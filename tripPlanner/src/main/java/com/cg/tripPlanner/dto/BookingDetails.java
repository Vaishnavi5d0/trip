package com.cg.tripPlanner.dto;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection="bookingDetails")
public class BookingDetails {
	@Id
    private Integer bookingId;
	private Integer transportTiketNumber;
	private String destinationName;
	private Integer userId;
	private Integer transportId;
	private Date date_of_journey;
	private Date date_of_land;
	private Integer hotelId;
	private Date check_in_date;
	private Date check_out_date;
	private Double totalBill;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public BookingDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Integer getTransportTiketNumber() {
		return transportTiketNumber;
	}
	public void setTransportTiketNumber(Integer transportTiketNumber) {
		this.transportTiketNumber = transportTiketNumber;
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
	public Date getDate_of_journey() {
		return date_of_journey;
	}
	public void setDate_of_journey(Date date_of_journey) {
		this.date_of_journey = date_of_journey;
	}
	public Date getDate_of_land() {
		return date_of_land;
	}
	public void setDate_of_land(Date date_of_land) {
		this.date_of_land = date_of_land;
	}
	public Integer getHotelId() {
		return hotelId;
	}
	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}
	
	public Date getCheck_in_date() {
		return check_in_date;
	}
	public void setCheck_in_date(Date check_in_date) {
		this.check_in_date = check_in_date;
	}
	public Integer getBookingId() {
		return bookingId;
	}
	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}
	public Date getCheck_out_date() {
		return check_out_date;
	}
	public void setCheck_out_date(Date check_out_date) {
		this.check_out_date = check_out_date;
	}
	public Double getTotalBill() {
		return totalBill;
	}
	public void setTotalBill(Double totalBill) {
		this.totalBill = totalBill;
	}
	@Override
	public String toString() {
		return "BookingDetails [bookingId=" + bookingId + ", transportTiketNumber=" + transportTiketNumber
				+ ", destinationName=" + destinationName + ", userId=" + userId + ", transportId=" + transportId
				+ ", date_of_journey=" + date_of_journey + ", date_of_land=" + date_of_land + ", hotelId=" + hotelId
				 + ", check_in_date=" + check_in_date + ", check_out_date="
				+ check_out_date + ", totalBill=" + totalBill + "]";
	}
	public BookingDetails(Integer bookingId, Integer transportTiketNumber, String destinationName, Integer userId,
			Integer transportId, Date date_of_journey, Date date_of_land, Integer hotelId, 
			Date check_in_date, Date check_out_date, Double totalBill) {
		super();
		this.bookingId = bookingId;
		this.transportTiketNumber = transportTiketNumber;
		this.destinationName = destinationName;
		this.userId = userId;
		this.transportId = transportId;
		this.date_of_journey = date_of_journey;
		this.date_of_land = date_of_land;
		this.hotelId = hotelId;
		this.check_in_date = check_in_date;
		this.check_out_date = check_out_date;
		this.totalBill = totalBill;
	}
	
		}
