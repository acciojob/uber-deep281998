package com.driver.services.impl;

import com.driver.model.TripBooking;
import com.driver.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.driver.model.Customer;
import com.driver.model.Driver;
import com.driver.repository.CustomerRepository;
import com.driver.repository.DriverRepository;
import com.driver.repository.TripBookingRepository;
import com.driver.model.TripStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository2;

	@Autowired
	DriverRepository driverRepository2;

	@Autowired
	TripBookingRepository tripBookingRepository2;

	@Override
	public void register(Customer customer) {
		customerRepository2.save(customer);
		//Save the customer in database
	}

	@Override
	public void deleteCustomer(Integer customerId) {
		customerRepository2.deleteById(customerId);
		// Delete customer without using deleteById function

	}

	@Override
	public TripBooking bookTrip(int customerId, String fromLocation,
								String toLocation, int distanceInKm) throws Exception{
		List<Driver> driverList = new ArrayList<>();
		driverList = driverRepository2.findAll();
		Driver driver = null;
		for (Driver driver1 : driverList){
			if(driver1.getCab().getAvailable()){
				driver = driver1;
				break;
			}
		}
		if(driver == null){
			throw new Exception("No cab avialable");
		}
		Optional<Customer> optionalCustomer = customerRepository2.findById(customerId);
		if(optionalCustomer.isEmpty()){
			throw new Exception("customer not present");
		}
		driver.getCab().setAvailable(false);
		Customer customer = optionalCustomer.get();

		TripBooking tripBooking = new TripBooking();
		tripBooking.setFromLocation(fromLocation);
		tripBooking.setToLocation(toLocation);
		tripBooking.setDistanceInKm(distanceInKm);
		tripBooking.setBill(0);
		tripBooking.setStatus(TripStatus.CONFIRMED);
		tripBooking.setDriver(driver);
		tripBooking.setCustomer(customer);


		List<TripBooking> tripBookingList = driver.getTripBookings();
		tripBookingList.add(tripBooking);

		List<TripBooking> tripBookingList1 = customer.getTripBookings();
		tripBookingList1.add(tripBooking);

		customerRepository2.save(customer);
		driverRepository2.save(driver);
		tripBookingRepository2.save(tripBooking);
		return tripBooking;

		//Book the driver with lowest driverId who is free (cab available variable is Boolean.TRUE). If no driver is available, throw "No cab available!" exception
		//Avoid using SQL query

	}

	@Override
	public void cancelTrip(Integer tripId){
		Optional<TripBooking> tripBookingOptional = tripBookingRepository2.findById(tripId);

		if(!tripBookingOptional.isPresent()){
			return;
		}

		TripBooking tripBooking = tripBookingOptional.get();
		tripBooking.getDriver().getCab().setAvailable(true);
		tripBooking.setBill(0);
		tripBooking.setStatus(TripStatus.CANCELED);

		tripBookingRepository2.save(tripBooking);
		//Cancel the trip having given trip Id and update TripBooking attributes accordingly

	}

	@Override
	public void completeTrip(Integer tripId){
		Optional<TripBooking> optionalTripBooking = tripBookingRepository2.findById(tripId);
		if(optionalTripBooking.isEmpty()){
			return;
		}
		TripBooking tripBooking = optionalTripBooking.get();
		tripBooking.setBill(tripBooking.getDriver().getCab().getPerKmRate() * tripBooking.getDistanceInKm());
		tripBooking.setStatus(TripStatus.COMPLETED);
		tripBookingRepository2.save(tripBooking);
		//Complete the trip having given trip Id and update TripBooking attributes accordingly

	}
}
