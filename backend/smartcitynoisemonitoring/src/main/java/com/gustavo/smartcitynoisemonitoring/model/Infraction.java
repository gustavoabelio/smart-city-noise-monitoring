package com.gustavo.smartcitynoisemonitoring.model;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
public class Infraction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double measuredDecibels;
    private Double limitDecibels;
    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "sensor_id")
    private Sensor sensor;

    public Infraction() {}

    public Infraction(Sensor sensor, Double measuredDecibels, Double limitDecibels, LocalDateTime timestamp) {
        this.sensor = sensor;
        this.measuredDecibels = measuredDecibels;
        this.limitDecibels = limitDecibels;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
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

    public Sensor getSensor() {
        return sensor;
    }
}
