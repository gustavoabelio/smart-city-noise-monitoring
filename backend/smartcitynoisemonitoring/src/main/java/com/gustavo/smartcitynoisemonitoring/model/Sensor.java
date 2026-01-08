package com.gustavo.smartcitynoisemonitoring.model;

public class Sensor {

    private Long id;
    private String name;
    private String location;
    private Double currentDecibels;
    private Boolean active;

    public Sensor(Long id, String name, String location, Double currentDecibels, Boolean active) {
        this.id = id;
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


