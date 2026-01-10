package com.gustavo.smartcitynoisemonitoring.model;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
public class Infraction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Sensor sensor;

    private Double measuredDecibels;
    private Double limitDecibels;
    private LocalDateTime timestamp;

    public Infraction() {}

    public Infraction(Sensor sensor, Double measuredDecibels, Double limitDecibels) {
        this.sensor = sensor;
        this.measuredDecibels = measuredDecibels;
        this.limitDecibels = limitDecibels;
        this.timestamp = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public Double getMeasuredDecibels() {
        return measuredDecibels;
    }

    public Double getLimitDecibels() {
        return limitDecibels;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
