package com.cg.tripPlanner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.tripPlanner.dao.UserDao;
import com.cg.tripPlanner.dto.BookingDetails;
import com.cg.tripPlanner.dto.Destination;
import com.cg.tripPlanner.dto.Hotel;
import com.cg.tripPlanner.dto.TransportType;
import com.cg.tripPlanner.dto.User;
import com.cg.tripPlanner.exception.TripPlannerException;

@Service
public class UserService implements IUserService{
    @Autowired
	private UserDao userDao;

	@Override
	public List<Destination> displayDestinationsByCountry(String country) {
		// TODO Auto-generated method stub
		return userDao.displayDestinationsByCountry(country);
	}

	@Override
	public List<TransportType> display_TransportTypesBy_Destinationname(String destinationName) {
		// TODO Auto-generated method stub
		return userDao.display_TransportTypesBy_Destinationname(destinationName);
	}

	@Override
	public List<Hotel> display_HotelsBy_Destinationname(String destinationName) {
		// TODO Auto-generated method stub
		return userDao.display_HotelsBy_Destinationname(destinationName);
	}

	@Override
	public User addingUser(User user) {
		// TODO Auto-generated method stub
		System.out.println("in service :"+user);
		return userDao.addingUser(user);
		
	}
		
		@Override
	public String validateUserCredentials(User user) throws TripPlannerException{
		// TODO Auto-generated method stub
		if(!(isValidName(user.getUserName()))) {
			return  "Name Should Be In Alphabets and minimum 3 characters long";
			
		}
		if(!(isValidPhoneNumber(user.getPhoneNumber()))){
			return "Phone Number Should be in 10 digit and start with 6-9";
		}
		if(!(isValidPassword(user.getPassword()))){
		return "enter valid password, eg:joy@123";
     	}
			return null;
			}


	public boolean isValidName(String userName){
		Pattern namePattern=Pattern.compile("^[A-Za-z]{3,}$");
		Matcher nameMatcher=namePattern.matcher(userName);
		return nameMatcher.matches();
	}
	
	public boolean isValidPhoneNumber(String phoneNumber){
		Pattern phonePattern=Pattern.compile("^[6-9]{1}[0-9]{9}$");
		Matcher phoneMatcher=phonePattern.matcher(phoneNumber);
		return phoneMatcher.matches();

	}

	public boolean isValidPassword(String password){
		Pattern namePattern=Pattern.compile("[a-z][a-zA-Z0-9]{3,}[0-9@]{3,}$");
		Matcher nameMatcher=namePattern.matcher(password);
		return nameMatcher.matches();
	}
	@Override
	public Integer bookingTransport(BookingDetails bookingDetails) throws TripPlannerException{
		// TODO Auto-generated method stub
		return userDao.bookingTransport(bookingDetails);
	}

	@Override
	public BookingDetails viewBookingDetails(Integer ticketNumber) {
		// TODO Auto-generated method stub
		return userDao.viewBookingDetails(ticketNumber);
	}

	@Override
	public String validateUser(String userName, String password) throws TripPlannerException {
		// TODO Auto-generated method stub
		
		return userDao.validateUser(userName, password);
	}

	


    
	
	

}
