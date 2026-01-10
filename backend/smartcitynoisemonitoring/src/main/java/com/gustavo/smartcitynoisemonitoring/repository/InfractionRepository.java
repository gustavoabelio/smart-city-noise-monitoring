package com.gustavo.smartcitynoisemonitoring.repository;

import com.gustavo.smartcitynoisemonitoring.model.Infraction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InfractionRepository extends JpaRepository<Infraction, Long> {
}
