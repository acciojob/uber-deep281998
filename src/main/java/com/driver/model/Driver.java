package com.driver.model;

import org.springframework.data.annotation.Immutable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int driverId;

    String mobile;

    String password;

    @OneToOne(mappedBy = "driver" , cascade = CascadeType.ALL)
    Cab cab;

    @OneToMany(mappedBy = "driver" , cascade = CascadeType.ALL)
    List<TripBooking> tripBookings = new ArrayList<>();

    public Driver(int driverId, String mobile, String password, Cab cab, List<TripBooking> tripBookings) {
        this.driverId = driverId;
        this.mobile = mobile;
        this.password = password;
        this.cab = cab;
        this.tripBookings = tripBookings;
    }

    public Driver() {
    }

    public int getDriverId() {
        return driverId;
    }

    public String getMobile() {
        return mobile;
    }

    public String getPassword() {
        return password;
    }

    public Cab getCab() {
        return cab;
    }

    public List<TripBooking> getTripBookings() {
        return tripBookings;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCab(Cab cab) {
        this.cab = cab;
    }

    public void setTripBookings(List<TripBooking> tripBookings) {
        this.tripBookings = tripBookings;
    }
}
