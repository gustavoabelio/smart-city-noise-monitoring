package com.gustavo.smartcitynoisemonitoring.service;

import com.gustavo.smartcitynoisemonitoring.model.Infraction;
import com.gustavo.smartcitynoisemonitoring.model.Sensor;
import com.gustavo.smartcitynoisemonitoring.repository.InfractionRepository;
import com.gustavo.smartcitynoisemonitoring.repository.SensorRepository;
import org.springframework.stereotype.Service;

@Service
public class SensorService {

    private static final double LIMIT_DECIBELS = 70.0;

    private final SensorRepository sensorRepository;
    private final InfractionRepository infractionRepository;

    public SensorService(SensorRepository sensorRepository,
                         InfractionRepository infractionRepository) {
        this.sensorRepository = sensorRepository;
        this.infractionRepository = infractionRepository;
    }

    public Sensor findSensorById(Long id) {
        return sensorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sensor não encontrado"));
    }

    public Infraction processReading(Sensor sensor, Double newDecibels) {

        sensor.setCurrentDecibels(newDecibels);
        sensorRepository.save(sensor);

        if (newDecibels >= LIMIT_DECIBELS) {
            Infraction infraction = new Infraction(sensor, newDecibels, LIMIT_DECIBELS);
            return infractionRepository.save(infraction);
        }

        return null;
    }
}
