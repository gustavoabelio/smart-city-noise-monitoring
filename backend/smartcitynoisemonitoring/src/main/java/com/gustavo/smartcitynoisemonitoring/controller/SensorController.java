package com.gustavo.smartcitynoisemonitoring.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.gustavo.smartcitynoisemonitoring.dto.SensorReadingResponse;
import com.gustavo.smartcitynoisemonitoring.model.Infraction;
import com.gustavo.smartcitynoisemonitoring.model.NoiseReading;
import com.gustavo.smartcitynoisemonitoring.model.Sensor;
import com.gustavo.smartcitynoisemonitoring.service.SensorService;

@RestController
@RequestMapping("/sensors")
public class SensorController {

    private final SensorService sensorService;

    public SensorController(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @PostMapping
    public Sensor createSensor(@RequestBody Sensor sensor) {
        return sensorService.saveSensor(sensor);
    }

    @GetMapping
    public List<Sensor> getAllSensors() {
        return sensorService.getAllSensors();
    }

    @GetMapping("/{id}")
    public Sensor getSensorById(@PathVariable Long id) {
        return sensorService.findSensorById(id);
    }

    @GetMapping("/{id}/read")
    public SensorReadingResponse readSensor(@PathVariable Long id,
                                            @RequestParam Double value) {

        Sensor sensor = sensorService.findSensorById(id);
        Infraction infraction = sensorService.processReading(sensor, value);

        return new SensorReadingResponse(sensor, infraction);
    }

    @GetMapping("/{id}/history")
    public List<NoiseReading> getHistory(@PathVariable Long id) {
        return sensorService.getSensorHistory(id);
    }
}