package com.cg.tripPlanner.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.tripPlanner.dto.BookingDetails;
import com.cg.tripPlanner.dto.Destination;
import com.cg.tripPlanner.dto.Hotel;
import com.cg.tripPlanner.dto.TransportType;
import com.cg.tripPlanner.dto.User;
import com.cg.tripPlanner.dto.UserBooking;
import com.cg.tripPlanner.exception.TripPlannerException;

public interface IAdminService{
	public List<UserBooking> viewUsers() throws TripPlannerException;
	public Destination addDestination(Destination destination);
	public TransportType addTransportation(TransportType transportType);
	public Hotel addHotel(Hotel hotel);
	public String validateAdmin(String adminName,String admin_pwd) throws TripPlannerException;
	
	public List<Destination> getAllDestinations();
	public List<TransportType> getAllTrasportations();
	public List<Hotel> getAllHotels();
	public Boolean deleteTransportation_byId(Integer transportId);
	public Boolean deleteHotel_byId(Integer hotelId);

}
