package com.gustavo.smartcitynoisemonitoring.controller;

import com.gustavo.smartcitynoisemonitoring.model.Sensor;
import com.gustavo.smartcitynoisemonitoring.service.SensorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sensors")
public class SensorController {

    private final SensorService sensorService = new SensorService();

    // Endpoint de teste
    @GetMapping("/test")
    public String test() {
        return "Sensor API funcionando!";
    }

    // Simula leitura de sensor
    @GetMapping("/read")
    public String readSensor(@RequestParam Double value) {

        Sensor sensor = new Sensor(
                1L,
                "Sensor Centro",
                "Centro - Rio Claro",
                0.0,
                true
        );

        sensorService.processReading(sensor, value);

        return "Leitura processada: " + value + " dB";
    }
}
