package com.cg.tripPlanner.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.tripPlanner.dto.BookingDetails;
import com.cg.tripPlanner.dto.Destination;

import com.cg.tripPlanner.dto.Hotel;
import com.cg.tripPlanner.dto.TransportType;
import com.cg.tripPlanner.dto.User;
import com.cg.tripPlanner.exception.TripPlannerException;
import com.cg.tripPlanner.service.UserService;
@RestController
@RequestMapping("/user")

public class UserController {
@Autowired
private UserService userService;

@PostMapping("/addUser")
public ResponseEntity<String> addingUser(@RequestBody User user) throws TripPlannerException {
	System.out.println("in controller :"+user);
	String msg=userService.validateUserCredentials(user);
	if(msg==null) {
	User useradded=userService.addingUser(user);	
	 if(useradded!= null) {
	 return new ResponseEntity<>("welcome to trip planner website "+useradded.getUserName()+" your userId is:"+useradded.getUserId(),HttpStatus.OK);
	}
	else
		return new ResponseEntity<>("You are not added ",HttpStatus.BAD_REQUEST);
	}
	else
		return new ResponseEntity<>("error: "+msg,HttpStatus.BAD_REQUEST);
	
}
@GetMapping("/validateUser")
public ResponseEntity<String> validateUser(@RequestParam String userName,@RequestParam String password) throws TripPlannerException
{
	String user=userService.validateUser(userName,password);
	if(user!=null)
		return new ResponseEntity<>("welcome "+user,HttpStatus.OK);
	else
		return new ResponseEntity<>("You have not registered, please register",HttpStatus.BAD_REQUEST);
	

}


@GetMapping("/displayDestinationsByCountry")
public List<Destination> displayDestinationsByCountry(@RequestParam String country){
	return userService.displayDestinationsByCountry(country);
	
}	

@GetMapping("/display_TransportTypesBy_Destinationname")
public List<TransportType> display_TransportTypesBy_Destinationname(@RequestParam String destinationName){
	return userService.display_TransportTypesBy_Destinationname(destinationName);
	
}	
@GetMapping("/display_HotelsBy_Destinationname")
public List<Hotel> display_HotelsBy_Destinationname(@RequestParam String destinationName){
	return userService.display_HotelsBy_Destinationname(destinationName);
	
}	
@PostMapping("/bookingTransport")
public ResponseEntity<String> bookingTransport(@RequestBody BookingDetails bookingDetails) throws TripPlannerException {

Integer ticket=userService.bookingTransport(bookingDetails);
if(ticket!=null)
{
	 return new ResponseEntity<>("booked successfully and the ticket number is:"+ticket,HttpStatus.OK);
	}
	else
		return new ResponseEntity<>("enter valid user Id to book",HttpStatus.BAD_REQUEST);
	
}
@GetMapping("/displayDetails_by_TicketNumber")
public ResponseEntity<BookingDetails> viewBookingDetails(@RequestParam Integer ticketNumber){
	
	BookingDetails details=userService.viewBookingDetails(ticketNumber);
	if(details!=null)
	{
		 return new ResponseEntity<>(details,HttpStatus.OK);
		}
		else
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);

}

}
