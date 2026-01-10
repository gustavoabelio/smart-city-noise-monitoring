package com.gustavo.smartcitynoisemonitoring.service;

import java.time.LocalDateTime;

import com.gustavo.smartcitynoisemonitoring.model.Infraction;
import com.gustavo.smartcitynoisemonitoring.model.Sensor;

public class SensorService {

    private static final double LIMIT_DECIBELS = 70.0;

    public Infraction processReading(Sensor sensor, Double newDecibels) {

        sensor.setCurrentDecibels(newDecibels);

        if (newDecibels >= LIMIT_DECIBELS) {
            return createInfraction(sensor, newDecibels);
        }

        return null;
    }

    private Infraction createInfraction(Sensor sensor, Double measuredDecibels) {
        
        System.out.println("Infração criada para o " + sensor.getName());

        return new Infraction(sensor, measuredDecibels, LIMIT_DECIBELS, LocalDateTime.now());        
    }

}
