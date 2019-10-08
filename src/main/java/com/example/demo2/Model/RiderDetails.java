package com.example.demo2.Model;

import com.example.demo2.Utils.RideType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RiderDetails {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer riderId;
    public String riderCurrentLocation;
    public String riderEndLocation;
    private String state;

    public RiderDetails(Integer riderId, RideType accept) {

    }

    public Integer getRiderId() {
        return riderId;
    }

    public void setRiderId(Integer riderId) {
        this.riderId = riderId;
    }

    public String getRiderCurrentLocation() {
        return riderCurrentLocation;
    }

    public void setRiderCurrentLocation(String riderCurrentLocation) {
        this.riderCurrentLocation = riderCurrentLocation;
    }

    public String getRiderEndLocation() {
        return riderEndLocation;
    }

    public void setRiderEndLocation(String riderEndLocation) {
        this.riderEndLocation = riderEndLocation;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
