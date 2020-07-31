package com.cg.tripPlanner.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cg.tripPlanner.dto.BookingDetails;
import com.cg.tripPlanner.dto.Destination;

import com.cg.tripPlanner.dto.Hotel;
import com.cg.tripPlanner.dto.TransportType;
import com.cg.tripPlanner.dto.User;
import com.cg.tripPlanner.dto.UserBooking;
import com.cg.tripPlanner.exception.TripPlannerException;
import com.cg.tripPlanner.service.AdminService;
@RestController
@RequestMapping("/admin")
public class AdminController {
@Autowired
private	AdminService adminService;
Logger logger=LoggerFactory.getLogger(AdminController.class);

@PostMapping("/addDestination")
public ResponseEntity<String> addDestination(@RequestBody Destination destination) {
	
	Destination addedDestination=adminService.addDestination(destination);
	logger.info("adding HolidayDestinations");
	if(addedDestination!=null)
	{
		 return new ResponseEntity<>("Added "+addedDestination.getDestinationName()+" Successfully",HttpStatus.OK);
		}
		else
			return new ResponseEntity<>("Destination is not added ",HttpStatus.BAD_REQUEST);

}
@PostMapping("/addTransportation")
public ResponseEntity<String> addTransportation(@RequestBody TransportType transportType) {
	
	TransportType transportation=adminService.addTransportation(transportType);
	logger.info("adding HolidayDestinations");
	if(transportation!=null)
	{
		 return new ResponseEntity<>("Added "+transportation.getTransportName()+" Successfully",HttpStatus.OK);
		}
		else
			return new ResponseEntity<>("transportation is not added ",HttpStatus.BAD_REQUEST);

}

@PostMapping("/addHotel")
public ResponseEntity<String> addHotel(@RequestBody Hotel hotel) {
	
	Hotel hotelAdded=adminService.addHotel(hotel);
	logger.info("adding HolidayDestinations");
	if(hotelAdded!=null)
	{
		 return new ResponseEntity<>("Added "+hotelAdded.getHotelName()+" successfully",HttpStatus.OK);
		}
		else
			return new ResponseEntity<>("Hotel is not added ",HttpStatus.BAD_REQUEST);

}

@GetMapping("/validateAdmin")
public ResponseEntity<String> validateAdmin(@RequestParam String adminName,@RequestParam String admin_pwd) throws TripPlannerException{
	String admin=adminService.validateAdmin(adminName,admin_pwd);
	if(admin==null)
		return new ResponseEntity<>("You are not admin",HttpStatus.BAD_REQUEST);
	else
		return new ResponseEntity<>("welcome admin "+admin,HttpStatus.OK);
	

}

@GetMapping("/viewUsersBooking")
public List<UserBooking> viewUsers() throws TripPlannerException {
	List<UserBooking> bookingDetails=adminService.viewUsers();
	return bookingDetails;
}

@GetMapping("/getAllDestinations")
public List<Destination> getAllDestinations(){
	return adminService.getAllDestinations();
}
@GetMapping("/getAllTrasportations")
public List<TransportType> getAllTrasportations(){
	return adminService.getAllTrasportations();
}
@GetMapping("/getAllHotels")
public List<Hotel> getAllHotels(){
	return adminService.getAllHotels();
}

@DeleteMapping("/deleteHotel_byId")
public ResponseEntity<String> deleteHotel_byId(@RequestParam Integer hotelId) {
	System.out.println("hotelid in cont "+hotelId);
 Boolean deleted=adminService.deleteHotel_byId(hotelId);
 if(deleted==true) {
	 System.out.println("in if  --");
	 return new ResponseEntity<>("deleted hotel with hotelId: "+hotelId+" successfully",HttpStatus.OK);
	}
	else
		return new ResponseEntity<>("Not deleted , given invalid id",HttpStatus.BAD_REQUEST);

}
@DeleteMapping("/deletetransportation_byId")
public ResponseEntity<String> deleteTransportation_byId(@RequestParam Integer transportId) {
	System.out.println("trasnportid in cont "+transportId);
 Boolean deleted=adminService.deleteTransportation_byId(transportId);
 if(deleted==true) {
	 System.out.println("in if  --");
	 return new ResponseEntity<>("deleted transportation with tranportId: "+transportId+" successfully",HttpStatus.OK);
	}
	else
		return new ResponseEntity<>("Not deleted , given invalid id",HttpStatus.BAD_REQUEST);

}

}
