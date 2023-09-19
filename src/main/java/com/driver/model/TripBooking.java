package com.driver.model;

import javax.persistence.*;

@Entity
public class TripBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int tripbookingId;

    String fromlocation;

    String tolocation;

    int distanceinkm;

    TripStatus tripStatus;

    int bill;

    @ManyToOne
    @JoinColumn
    Driver driver;

    @ManyToOne
    @JoinColumn
    Customer customer;

    public TripBooking(int tripbookingId, String fromlocation, String tolocation,
                       int distanceinkm, TripStatus tripStatus, int bill, Driver driver,
                       Customer customer) {
        this.tripbookingId = tripbookingId;
        this.fromlocation = fromlocation;
        this.tolocation = tolocation;
        this.distanceinkm = distanceinkm;
        this.tripStatus = tripStatus;
        this.bill = bill;
        this.driver = driver;
        this.customer = customer;
    }

    public TripBooking() {
    }

    public int getTripbookingId() {
        return tripbookingId;
    }

    public String getFromlocation() {
        return fromlocation;
    }

    public String getTolocation() {
        return tolocation;
    }

    public int getDistanceinkm() {
        return distanceinkm;
    }

    public TripStatus getTripStatus() {
        return tripStatus;
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

    public void setTripbookingId(int tripbookingId) {
        this.tripbookingId = tripbookingId;
    }

    public void setFromlocation(String fromlocation) {
        this.fromlocation = fromlocation;
    }

    public void setTolocation(String tolocation) {
        this.tolocation = tolocation;
    }

    public void setDistanceinkm(int distanceinkm) {
        this.distanceinkm = distanceinkm;
    }

    public void setTripStatus(TripStatus tripStatus) {
        this.tripStatus = tripStatus;
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
