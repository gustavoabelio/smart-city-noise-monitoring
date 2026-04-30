package com.gustavo.smartcitynoisemonitoring.controller;

import org.springframework.web.bind.annotation.*;

import com.gustavo.smartcitynoisemonitoring.model.Infraction;
import com.gustavo.smartcitynoisemonitoring.repository.InfractionRepository;
import com.gustavo.smartcitynoisemonitoring.service.InfractionService;
import com.gustavo.smartcitynoisemonitoring.dto.InfractionStatsResponse;

import java.util.List;

@RestController
@RequestMapping("/infractions")
public class InfractionController {

    private final InfractionRepository infractionRepository;
    private final InfractionService infractionService;

    public InfractionController(InfractionRepository infractionRepository,
                                InfractionService infractionService) {
        this.infractionRepository = infractionRepository;
        this.infractionService = infractionService;
    }

    @GetMapping
    public List<Infraction> getAllInfractions() {
        return infractionRepository.findAll();
    }

    @GetMapping("/stats")
    public InfractionStatsResponse getStats() {
        return infractionService.getStats();
    }
}