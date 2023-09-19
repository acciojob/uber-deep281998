package com.driver.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int customerId;

    String mobile;

    String password;

    @OneToMany(mappedBy = "customer" , cascade = CascadeType.ALL)
    List<TripBooking> tripBookings = new ArrayList<>();

    public Customer() {
    }

    public Customer(int customerId, String mobile, String password, List<TripBooking> tripBookings) {
        this.customerId = customerId;
        this.mobile = mobile;
        this.password = password;
        this.tripBookings = tripBookings;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getMobile() {
        return mobile;
    }

    public String getPassword() {
        return password;
    }

    public List<TripBooking> getTripBookings() {
        return tripBookings;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTripBookings(List<TripBooking> tripBookings) {
        this.tripBookings = tripBookings;
    }
}
