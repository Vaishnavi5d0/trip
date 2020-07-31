package com.cg.tripPlanner.dao;

import java.util.ArrayList;
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
public class UserDao implements IUserDao {
	@Autowired
private MongoTemplate mongoTemplate;
	

	@Override
	public List<Destination> displayDestinationsByCountry(String country) {
		// TODO Auto-generated method stub
		
		List<Destination> destinations=mongoTemplate.findAll(Destination.class);
		List<Destination> requiredDestinations=new ArrayList<Destination>();
		for (Destination destination : destinations) {
			if(destination.getCountry().equalsIgnoreCase(country)) {
				requiredDestinations.add(destination);
			}
		}
		return requiredDestinations;
	}

	@Override
	public List<TransportType> display_TransportTypesBy_Destinationname(String destinationName) {
		// TODO Auto-generated method stub
		List<TransportType> transportTypes=mongoTemplate.findAll(TransportType.class);
		List<TransportType> reqTransportTypes=new ArrayList<TransportType>();
		for (TransportType transportType : transportTypes) {
			if(transportType.getDestinationName().equalsIgnoreCase(destinationName)) {
				reqTransportTypes.add(transportType);
			}
		}
		
		return reqTransportTypes;
	}

	@Override
	public List<Hotel> display_HotelsBy_Destinationname(String destinationName) {
		// TODO Auto-generated method stub
	List<Hotel> hotels=mongoTemplate.findAll(Hotel.class);
	List<Hotel> reqHotels=new ArrayList<Hotel>();
	
	for (Hotel hotel : hotels) {
		if(hotel.getDestinationName().equalsIgnoreCase(destinationName)) {
			reqHotels.add(hotel);
		}
	 }
	 return reqHotels;
	}

	@Override
	public User addingUser(User user) {
		// TODO Auto-generated method stub
		System.out.println("in dao :"+user);
				
	    User newUser=new User();
	    Integer newuserId=(int) (Math.random()*60);
	    System.out.println("new user Id :"+newuserId);
	    
	    UserBooking userBooking=new UserBooking();
		userBooking.setUserId(newuserId);
	    mongoTemplate.save(userBooking);
		System.out.println("in user adding");

	    
	    newUser.setPhoneNumber(user.getPhoneNumber());
	    newUser.setUserName(user.getUserName());
	    newUser.setPassword(user.getPassword());
	    newUser.setUserId(newuserId);
	    mongoTemplate.insert(newUser);
		System.out.println("after adding user");
		
	
		return newUser;
	}

	@Override
	public Integer bookingTransport(BookingDetails bookingDetails) throws TripPlannerException{
		// TODO Auto-generated method stub
		
		User user=mongoTemplate.findOne(Query.query(Criteria.where("userId").is(bookingDetails.getUserId())), User.class);
		
		if(user==null)
		return null;
			
		mongoTemplate.insert(bookingDetails);
		
		System.out.println("booking details booked"+bookingDetails);
		Integer ticketNumber=(int) (Math.random()*30);
		System.out.println("ticketNumber:"+ticketNumber);
		addBill(ticketNumber,bookingDetails.getBookingId(),bookingDetails.getDestinationName(),bookingDetails.getUserId());
		return ticketNumber;
	}

	private void addBill(Integer ticketNumber,Integer bookingId,String destinationName,Integer userId) {
		// TODO Auto-generated method stub
		BookingDetails booking=mongoTemplate.findOne(Query.query(Criteria.where("bookingId").is(bookingId)), BookingDetails.class);
	   System.out.println("booking:"+booking);
		Integer transportId=booking.getTransportId();
	  System.out.println("transporId"+transportId);
	  
	  TransportType transportbooked=new TransportType();
	  List<TransportType> transports=mongoTemplate.findAll(TransportType.class);
	  for (TransportType transportType : transports) {
		if(transportType.getTransportId().equals(transportId)) {
			transportbooked=transportType;
			break;
		}
		 
	}
	  System.out.println("transport:"+transportbooked);
	 
	  Double transportAmount=transportbooked.getTransportAmount();
	  System.out.println("transport amount"+transportAmount);
	  
	  
	  Integer hotelId=booking.getHotelId();
	 
	 Hotel hotelbooked=new Hotel();
	  List<Hotel> hotels=mongoTemplate.findAll(Hotel.class);
	 for (Hotel hotel : hotels) {
		if(hotel.getHotelId().equals(hotelId))
		{
			hotelbooked=hotel;
			break;

		}
				}
	  
	
	  
	  System.out.println("hotel:"+hotelbooked);
	  Double hotelBill=hotelbooked.getHotelBill();
	  System.out.println("hotelBill"+hotelBill);
	  Double totalBill=transportAmount+hotelBill;
	  booking.setTransportTiketNumber(ticketNumber);
	  booking.setTotalBill(totalBill);
	  mongoTemplate.save(booking);
	  
	  UserBooking userbooking=mongoTemplate.findOne(Query.query(Criteria.where("userId").is(userId)), UserBooking.class);
	  List<BookingDetails> bookingList=new ArrayList<BookingDetails>();
		
	  List<BookingDetails> bookings=userbooking.getBookingDetails();
		 if(bookings!=null) {
			 
			bookings.add(booking);
			bookingList=bookings;
		 }
		 else
		 {
			 bookingList.add(booking);
			
		 }
		 userbooking.setBookingDetails(bookingList);
		 mongoTemplate.save(userbooking);
	


	}

	@Override
	public BookingDetails viewBookingDetails(Integer ticketNumber) {
		// TODO Auto-generated method stub
		BookingDetails bookingdetails=mongoTemplate.findOne(Query.query(Criteria.where("transportTiketNumber").is(ticketNumber)), BookingDetails.class);
		 
		return bookingdetails;
	}

	@Override
	public String validateUser(String userName, String password) throws TripPlannerException {
		// TODO Auto-generated method stub
		System.out.println("userid :"+userName+" pswd :"+password);
		List<User> users=mongoTemplate.findAll(User.class);
		System.out.println("users"+users);
		for(User user:users) {
			if(user.getUserName().equals(userName)) {
				if(user.getPassword().equals(password)) {
					return user.getUserName();
				}
			}
		}
		System.out.println("null");
		return null;
			}
	
	

}
