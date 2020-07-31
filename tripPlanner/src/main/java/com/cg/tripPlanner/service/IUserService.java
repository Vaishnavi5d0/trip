package com.cg.tripPlanner.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.tripPlanner.dto.BookingDetails;
import com.cg.tripPlanner.dto.Destination;

import com.cg.tripPlanner.dto.Hotel;
import com.cg.tripPlanner.dto.TransportType;
import com.cg.tripPlanner.dto.User;
import com.cg.tripPlanner.exception.TripPlannerException;

public interface IUserService {
	public List<Destination> displayDestinationsByCountry(String country);
	public List<TransportType> display_TransportTypesBy_Destinationname(String destinationName);
	public List<Hotel> display_HotelsBy_Destinationname(String destinationName);
	public User addingUser(User user);
	public Integer bookingTransport(BookingDetails bookingDetails) throws TripPlannerException;
	public BookingDetails viewBookingDetails(Integer ticketNumber);
	public String validateUser(String userName,String password)throws TripPlannerException;
	public String validateUserCredentials(User user) throws TripPlannerException;
	
}
