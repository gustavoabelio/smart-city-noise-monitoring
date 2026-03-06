package com.gustavo.smartcitynoisemonitoring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gustavo.smartcitynoisemonitoring.model.Infraction;
import com.gustavo.smartcitynoisemonitoring.model.Sensor;
import com.gustavo.smartcitynoisemonitoring.repository.InfractionRepository;
import com.gustavo.smartcitynoisemonitoring.repository.SensorRepository;

@Service
public class SensorService {

    private static final double LIMIT_DECIBELS = 70.0;

    private final SensorRepository sensorRepository;
    private final InfractionRepository infractionRepository;

    private static final Logger log = LoggerFactory.getLogger(SensorService.class);

    public SensorService(SensorRepository sensorRepository,
                         InfractionRepository infractionRepository) {
        this.sensorRepository = sensorRepository;
        this.infractionRepository = infractionRepository;
    }

    public Sensor findSensorById(Long id) {
        return sensorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sensor não encontrado"));
    }

    public Sensor saveSensor(Sensor sensor) {
        return sensorRepository.save(sensor);
    }

    public List<Sensor> getAllSensors() {
        return sensorRepository.findAll();
    }

    public Infraction processReading(Sensor sensor, Double newDecibels) {
        log.info("Processing sensor reading: sensorId={}, value={}", sensor.getId(), newDecibels);

        sensor.setCurrentDecibels(newDecibels);
        sensorRepository.save(sensor);

        if (newDecibels >= LIMIT_DECIBELS) {
            log.warn("Noise limit exceeded for sensor {}", sensor.getId());

            Infraction infraction = new Infraction(sensor,newDecibels,LIMIT_DECIBELS);

            return infractionRepository.save(infraction);
        }

        return null;
    }
}