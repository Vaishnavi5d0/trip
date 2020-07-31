package com.cg.tripPlanner.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.cg.tripPlanner.dto.BookingDetails;
import com.cg.tripPlanner.dto.Destination;
import com.cg.tripPlanner.dto.Hotel;
import com.cg.tripPlanner.dto.TransportType;
import com.cg.tripPlanner.dto.User;
import com.cg.tripPlanner.dto.UserBooking;
import com.cg.tripPlanner.exception.TripPlannerException;

@Repository
public class AdminDao implements IAdminDao{
	@Autowired
	MongoTemplate mongoTemplate;


		@Override
	public List<UserBooking> viewUsers() throws TripPlannerException{
		// TODO Auto-generated method stub
	List<UserBooking> bookingDetails=mongoTemplate.findAll(UserBooking.class);
	return bookingDetails;
	}

	

	@Override
	public Destination addDestination(Destination destination) {
		// TODO Auto-generated method stub
		return mongoTemplate.insert(destination);
	}

	@Override
	public TransportType addTransportation(TransportType transportType) {
		// TODO Auto-generated method stub
		return mongoTemplate.insert(transportType);
	}

	@Override
	public Hotel addHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		return mongoTemplate.insert(hotel);
	}

	@Override
	public String validateAdmin(String adminName, String admin_pwd) throws TripPlannerException{
		// TODO Auto-generated method stub
		if(adminName.equals("siva")) {
			System.out.println("in dao siva");
			if(admin_pwd.equals("siva@123"))
			{
				System.out.println("in dao pswd");
			return adminName;	
			}
		}
		System.out.println("null");
			return null;
	}

	@Override
	public List<Destination> getAllDestinations() {
		// TODO Auto-generated method stub
		return mongoTemplate.findAll(Destination.class);
	}

	@Override
	public List<TransportType> getAllTrasportations() {
		// TODO Auto-generated method stub
		return mongoTemplate.findAll(TransportType.class);
	}

	@Override
	public List<Hotel> getAllHotels() {
		// TODO Auto-generated method stub
		return mongoTemplate.findAll(Hotel.class);
	}

	@Override
	public Boolean deleteTransportation_byId(Integer transportId) {
		// TODO Auto-generated method stub
		System.out.println("transId "+transportId);
		TransportType transportType=mongoTemplate.findOne(Query.query(Criteria.where("transportId").is(transportId)), TransportType.class);
		if(transportType!=null) {
			System.out.println(transportType);
			mongoTemplate.remove(transportType);
			return true;
		}
		System.out.println("this is not transId");
		return false;
	}

	@Override
	public Boolean deleteHotel_byId(Integer hotelId) {
		// TODO Auto-generated method stub
		Hotel hotel=mongoTemplate.findOne(Query.query(Criteria.where("hotelId").is(hotelId)), Hotel.class);
		if(hotel!=null) {
			mongoTemplate.remove(hotel);
			return true;
		}
		return false;
	}

	

}
