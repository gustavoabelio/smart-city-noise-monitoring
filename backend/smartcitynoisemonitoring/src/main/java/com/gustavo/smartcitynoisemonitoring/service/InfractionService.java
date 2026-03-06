package com.gustavo.smartcitynoisemonitoring.service;

import org.springframework.stereotype.Service;

import com.gustavo.smartcitynoisemonitoring.dto.InfractionStatsResponse;
import com.gustavo.smartcitynoisemonitoring.repository.InfractionRepository;

@Service
public class InfractionService {

    private final InfractionRepository infractionRepository;

    public InfractionService(InfractionRepository infractionRepository) {
        this.infractionRepository = infractionRepository;
    }

    public InfractionStatsResponse getStats() {
        Long total = infractionRepository.countInfractions();
        Double avg = infractionRepository.averageNoise();
        Double max = infractionRepository.maxNoise();

        return new InfractionStatsResponse(total, avg, max);
    }
}