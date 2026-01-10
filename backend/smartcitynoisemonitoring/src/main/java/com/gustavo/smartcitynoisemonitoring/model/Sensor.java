package com.gustavo.smartcitynoisemonitoring.model;

import jakarta.persistence.*;

@Entity
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;
    private Double currentDecibels;
    private Boolean active;

    public Sensor() {}

    public Sensor(String name, String location, Double currentDecibels, Boolean active) {
        this.name = name;
        this.location = location;
        this.currentDecibels = currentDecibels;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public Double getCurrentDecibels() {
        return currentDecibels;
    }

    public Boolean getActive() {
        return active;
    }

    public void setCurrentDecibels(Double currentDecibels) {
        this.currentDecibels = currentDecibels;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

}


