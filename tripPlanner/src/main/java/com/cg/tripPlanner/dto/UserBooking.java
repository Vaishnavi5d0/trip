package com.cg.tripPlanner.dto;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection="userBooking")
public class UserBooking {
	@Id
private Integer userId;
private List<BookingDetails> bookingDetails;
public UserBooking() {
	super();
	// TODO Auto-generated constructor stub
}
public UserBooking(Integer userId, List<BookingDetails> bookingDetails) {
	super();
	this.userId = userId;
	this.bookingDetails = bookingDetails;
}
@Override
public String toString() {
	return "UserBooking [userId=" + userId + ", bookingDetails=" + bookingDetails + "]";
}
public Integer getUserId() {
	return userId;
}
public void setUserId(Integer userId) {
	this.userId = userId;
}
public List<BookingDetails> getBookingDetails() {
	return bookingDetails;
}
public void setBookingDetails(List<BookingDetails> bookingDetails) {
	this.bookingDetails = bookingDetails;
}

}
