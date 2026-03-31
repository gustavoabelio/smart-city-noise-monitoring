package com.gustavo.smartcitynoisemonitoring.repository;

import com.gustavo.smartcitynoisemonitoring.model.Infraction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface InfractionRepository extends JpaRepository<Infraction, Long> {
    @Query("SELECT COUNT(i) FROM Infraction i")
    Long countInfractions();

    @Query("SELECT AVG(i.measuredDecibels) FROM Infraction i")
    Double averageNoise();

    @Query("SELECT MAX(i.measuredDecibels) FROM Infraction i")
    Double maxNoise();
}