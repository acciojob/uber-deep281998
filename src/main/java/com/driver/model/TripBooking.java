package com.driver.model;

import javax.persistence.*;

@Entity
public class TripBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int tripBookingId;

    String fromLocation;

    String toTocation;

    int distanceInKm;

    TripStatus status;

    int bill;

    @ManyToOne
    @JoinColumn
    Driver driver;

    @ManyToOne
    @JoinColumn
    Customer customer;

    public TripBooking(int tripBookingId, String fromLocation, String toTocation,
                       int distanceInKm, TripStatus status, int bill, Driver driver,
                       Customer customer) {
        this.tripBookingId = tripBookingId;
        this.fromLocation = fromLocation;
        this.toTocation = toTocation;
        this.distanceInKm = distanceInKm;
        this.status = status;
        this.bill = bill;
        this.driver = driver;
        this.customer = customer;
    }

    public TripBooking() {
    }

    public int getTripBookingId() {
        return tripBookingId;
    }

    public String getFromLocation() {
        return fromLocation;
    }

    public String getToLocation() {
        return toTocation;
    }

    public int getDistanceInKm() {
        return distanceInKm;
    }

    public TripStatus getStatus() {
        return status;
    }

    public int getBill() {
        return bill;
    }

    public Driver getDriver() {
        return driver;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setTripBookingId(int tripbookingId) {
        this.tripBookingId = tripBookingId;
    }

    public void setFromLocation(String fromlocation) {
        this.fromLocation = fromLocation;
    }

    public void setToLocation(String tolocation) {
        this.toTocation = toTocation;
    }

    public void setDistanceInKm(int distanceinkm) {
        this.distanceInKm = distanceInKm;
    }

    public void setStatus(TripStatus tripStatus) {
        this.status = status;
    }

    public void setBill(int bill) {
        this.bill = bill;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
