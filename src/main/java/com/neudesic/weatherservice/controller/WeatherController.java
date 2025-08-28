package com.neudesic.weatherservice.controller;

import com.neudesic.weatherservice.service.WeatherService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/{location}")
    public ResponseEntity<String> getWeather(@PathVariable String location) {
        String weatherInfo = weatherService.getWeather(location);
        return ResponseEntity.ok(weatherInfo);

    }
    public ResponseEntity<String> getWeatherForecast(String location) {
        // Placeholder for actual weather forecast retrieval logic
        String forecastInfo = "Weather forecast for " + location;
        return ResponseEntity.ok(forecastInfo);
    }
}
