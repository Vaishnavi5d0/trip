package com.cg.tripPlanner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.tripPlanner.dao.AdminDao;
import com.cg.tripPlanner.dto.BookingDetails;
import com.cg.tripPlanner.dto.Destination;

import com.cg.tripPlanner.dto.Hotel;
import com.cg.tripPlanner.dto.TransportType;
import com.cg.tripPlanner.dto.User;
import com.cg.tripPlanner.dto.UserBooking;
import com.cg.tripPlanner.exception.TripPlannerException;
@Service
public class AdminService implements IAdminService{
@Autowired	
private AdminDao adminDao;
	
	@Override
	public List<UserBooking> viewUsers() throws TripPlannerException {
		// TODO Auto-generated method stub
		return adminDao.viewUsers();
	}

	

	@Override
	public Destination addDestination(Destination destination) {
		// TODO Auto-generated method stub
		return adminDao.addDestination(destination);
	}

	@Override
	public TransportType addTransportation(TransportType transportType) {
		// TODO Auto-generated method stub
		return adminDao.addTransportation(transportType);
	}

	@Override
	public Hotel addHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		return adminDao.addHotel(hotel);
	}

	@Override
	public String validateAdmin(String adminName, String admin_pwd)throws TripPlannerException{
		// TODO Auto-generated method stub
		return adminDao.validateAdmin(adminName, admin_pwd);
	}

	@Override
	public List<Destination> getAllDestinations() {
		// TODO Auto-generated method stub
		return adminDao.getAllDestinations();
	}

	@Override
	public List<TransportType> getAllTrasportations() {
		// TODO Auto-generated method stub
		return adminDao.getAllTrasportations();
	}

	@Override
	public List<Hotel> getAllHotels() {
		// TODO Auto-generated method stub
		return adminDao.getAllHotels();
	}

	@Override
	public Boolean deleteTransportation_byId(Integer transportId) {
		// TODO Auto-generated method stub
		System.out.println("in servie"+transportId);
		return adminDao.deleteTransportation_byId(transportId);
	}

	@Override
	public Boolean deleteHotel_byId(Integer hotelId) {
		// TODO Auto-generated method stub
		return adminDao.deleteHotel_byId(hotelId);
	}

}
