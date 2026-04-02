package com.gustavo.smartcitynoisemonitoring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gustavo.smartcitynoisemonitoring.model.NoiseReading;
import java.util.List;

public interface NoiseReadingRepository extends JpaRepository<NoiseReading, Long> {

    List<NoiseReading> findBySensorIdOrderByTimestampDesc(Long sensorId);

}