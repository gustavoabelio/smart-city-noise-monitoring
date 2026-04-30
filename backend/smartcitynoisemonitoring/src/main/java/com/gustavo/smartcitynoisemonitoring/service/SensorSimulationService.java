package com.gustavo.smartcitynoisemonitoring.service;

import com.gustavo.smartcitynoisemonitoring.repository.SensorRepository;
import com.gustavo.smartcitynoisemonitoring.model.Sensor;

import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SensorSimulationService {

    private final SensorRepository sensorRepository;
    private final SensorService sensorService;

    public SensorSimulationService(SensorRepository sensorRepository,
                                   SensorService sensorService) {
        this.sensorRepository = sensorRepository;
        this.sensorService = sensorService;
    }

    @Scheduled(fixedRate = 10000) 
    public void simulateReadings() {

        List<Sensor> sensors = sensorRepository.findAll();

        for (Sensor sensor : sensors) {

            double noise = 50 + (Math.random() * 50); 

            sensorService.processReading(sensor, noise);
        }
    }
}