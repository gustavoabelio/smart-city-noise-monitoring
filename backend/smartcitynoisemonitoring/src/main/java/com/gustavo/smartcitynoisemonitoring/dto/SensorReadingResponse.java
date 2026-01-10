package com.gustavo.smartcitynoisemonitoring.dto;

import com.gustavo.smartcitynoisemonitoring.model.Infraction;
import com.gustavo.smartcitynoisemonitoring.model.Sensor;

public class SensorReadingResponse {

    private Sensor sensor;
    private Infraction infraction;

    public SensorReadingResponse(Sensor sensor, Infraction infraction) {
        this.sensor = sensor;
        this.infraction = infraction;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public Infraction getInfraction() {
        return infraction;
    }
}
