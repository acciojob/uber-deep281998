package com.driver.model;

import javax.persistence.*;

@Entity
public class Cab {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    int perKmRate;

    boolean available;

    @OneToOne
    @JoinColumn
    Driver driver;

    public Cab() {
    }

    public Cab(int id, int perKmRate, boolean available, Driver driver) {
        this.id = id;
        this.perKmRate = perKmRate;
        this.available = available;
        this.driver = driver;
    }

    public int getId() {
        return id;
    }

    public int getPerKmRate() {
        return perKmRate;
    }

    public boolean getAvailable() {
        return available;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPerKmRate(int perkmrate) {
        this.perKmRate = perkmrate;
    }

    public void setAvailable(boolean avialable) {
        this.available = avialable;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}
