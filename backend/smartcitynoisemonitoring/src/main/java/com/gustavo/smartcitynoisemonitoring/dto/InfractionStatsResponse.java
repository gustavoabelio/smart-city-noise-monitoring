package com.gustavo.smartcitynoisemonitoring.dto;

public class InfractionStatsResponse {

    private Long totalInfractions;
    private Double averageNoise;
    private Double maxNoise;

    public InfractionStatsResponse(Long totalInfractions, Double averageNoise, Double maxNoise) {
        this.totalInfractions = totalInfractions;
        this.averageNoise = averageNoise;
        this.maxNoise = maxNoise;
    }

    public Long getTotalInfractions() {
        return totalInfractions;
    }

    public Double getAverageNoise() {
        return averageNoise;
    }

    public Double getMaxNoise() {
        return maxNoise;
    }
}