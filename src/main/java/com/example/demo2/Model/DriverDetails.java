package com.example.demo2.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DriverDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer riderId;
    private String driverCurrentLocation;
    private String driverAccepted;
    private String state;


    public Integer getRiderId() {
        return riderId;
    }

    public void setRiderId(Integer riderId) {
        this.riderId = riderId;
    }


    public String getDriverCurrentLocation() {
        return driverCurrentLocation;
    }

    public void setDriverCurrentLocation(String driverCurrentLocation) {
        this.driverCurrentLocation = driverCurrentLocation;
    }

    public String getDriverAccepted() {
        return driverAccepted;
    }

    public void setDriverAccepted(String driverAccepted) {
        this.driverAccepted = driverAccepted;
    }
    public DriverDetails(String name, String dept) {

        this.riderId = riderId;
        this.driverCurrentLocation = driverCurrentLocation;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("{");
        sb.append("id='").append(riderId).append('\'');
        sb.append(", driverCurrentLocation='").append(driverCurrentLocation).append('\'');
        sb.append(", driverAccepted='").append(driverAccepted).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
