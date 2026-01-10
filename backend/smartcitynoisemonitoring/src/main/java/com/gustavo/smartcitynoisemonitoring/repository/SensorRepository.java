package com.gustavo.smartcitynoisemonitoring.repository;

import com.gustavo.smartcitynoisemonitoring.model.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorRepository extends JpaRepository<Sensor, Long> {
}
