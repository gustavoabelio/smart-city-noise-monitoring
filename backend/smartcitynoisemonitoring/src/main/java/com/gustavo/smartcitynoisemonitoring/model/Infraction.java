package com.gustavo.smartcitynoisemonitoring.model;

import java.time.LocalDateTime;

public class Infraction {

    private Long id;
    private Long sensorId;
    private Double measuredDecibels;
    private Double limitDecibels;
    private LocalDateTime timestamp;

    public Infraction(Long id,
                      Long sensorId,
                      Double measuredDecibels,
                      Double limitDecibels,
                      LocalDateTime timestamp) {
        this.id = id;
        this.sensorId = sensorId;
        this.measuredDecibels = measuredDecibels;
        this.limitDecibels = limitDecibels;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public Long getSensorId() {
        return sensorId;
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
