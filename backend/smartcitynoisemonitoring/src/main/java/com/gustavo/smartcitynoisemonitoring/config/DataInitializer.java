package com.gustavo.smartcitynoisemonitoring.config;

import com.gustavo.smartcitynoisemonitoring.model.Sensor;
import com.gustavo.smartcitynoisemonitoring.repository.SensorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initSensors(SensorRepository sensorRepository) {
        return args -> {
            if (sensorRepository.count() == 0) {
                Sensor sensor = new Sensor("Sensor Centro", "Centro - Rio Claro", 0.0, true);
                sensorRepository.save(sensor);
            }
        };
    }
}
