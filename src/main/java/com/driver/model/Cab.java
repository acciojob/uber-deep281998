package com.driver.model;

import javax.persistence.*;

@Entity
public class Cab {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    int perkmrate;

    boolean avialable;

    @OneToOne
    @JoinColumn
    Driver driver;

    public Cab() {
    }

    public Cab(int id, int perkmrate, boolean avialable, Driver driver) {
        this.id = id;
        this.perkmrate = perkmrate;
        this.avialable = avialable;
        this.driver = driver;
    }

    public int getId() {
        return id;
    }

    public int getPerkmrate() {
        return perkmrate;
    }

    public boolean isAvialable() {
        return avialable;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPerkmrate(int perkmrate) {
        this.perkmrate = perkmrate;
    }

    public void setAvialable(boolean avialable) {
        this.avialable = avialable;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}
