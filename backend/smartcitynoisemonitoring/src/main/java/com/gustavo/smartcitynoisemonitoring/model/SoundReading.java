package com.gustavo.smartcitynoisemonitoring.model;

import java.time.LocalDateTime;

public class SoundReading {

    private Long id;
    private Double decibels;
    private LocalDateTime timestamp;
    private Sensor sensor;

    public SoundReading() {
    }

    public SoundReading(Long id, Double decibels, LocalDateTime timestamp, Sensor sensor) {
        this.id = id;
        this.decibels = decibels;
        this.timestamp = timestamp;
        this.sensor = sensor;
    }

    public Long getId() {
        return id;
    }

    public Double getDecibels() {
        return decibels;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public Sensor getSensor() {
        return sensor;
    }
}

