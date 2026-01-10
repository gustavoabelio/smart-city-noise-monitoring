package com.gustavo.smartcitynoisemonitoring.controller;

import com.gustavo.smartcitynoisemonitoring.dto.SensorReadingResponse;
import com.gustavo.smartcitynoisemonitoring.model.Infraction;
import com.gustavo.smartcitynoisemonitoring.model.Sensor;
import com.gustavo.smartcitynoisemonitoring.service.SensorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sensors")
public class SensorController {

    private final SensorService sensorService;

    public SensorController(SensorService sensorService) {
        this.sensorService = sensorService;
    }


    @GetMapping("/test")
    public String test() {
        return "Sensor API funcionando";
    }

    @GetMapping("/read")
    public SensorReadingResponse readSensor(@RequestParam Double value) {

        Sensor sensor = sensorService.findSensorById(1L);


    Infraction infraction = sensorService.processReading(sensor, value);

    return new SensorReadingResponse(sensor, infraction);
}

}
