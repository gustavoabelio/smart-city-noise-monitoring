package com.gustavo.smartcitynoisemonitoring.service;

import com.gustavo.smartcitynoisemonitoring.model.Infraction;
import com.gustavo.smartcitynoisemonitoring.model.Sensor;

import java.time.LocalDateTime;

public class SensorService {

    private static final double LIMIT_DECIBELS = 70.0;

    public void processReading(Sensor sensor, Double newDecibels) {

        sensor.setCurrentDecibels(newDecibels);

        if (newDecibels > LIMIT_DECIBELS) {
            createInfraction(sensor, newDecibels);
        }
    }

    private Infraction createInfraction(Sensor sensor, Double measuredDecibels) {

        Infraction infraction = new Infraction(
                null,
                sensor.getId(),
                measuredDecibels,
                LIMIT_DECIBELS,
                LocalDateTime.now()
        );

        System.out.println("🚨 Infração criada para o sensor " + sensor.getName());
        return infraction;
    }
}
