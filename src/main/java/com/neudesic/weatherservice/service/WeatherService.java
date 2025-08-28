package com.neudesic.weatherservice.service;

import com.neudesic.weatherservice.model.Location;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.HashMap;
import java.util.Map;

@Service
public class WeatherService {

    private String apiKey = "afaa89657333c05b2acdb4626d64783b";
    private String baseUrl = "https://api.openweathermap.org/data/3.0/onecall";
    private Map<String, Location> locations = new HashMap<>();

    @PostConstruct
    void setup(){
        Location l = new Location();
        l.setLatitude("40.7128");
        l.setLongitude("-74.0060");
        l.setName("New York");
        locations.put("new york", l);
        l = new Location();
        l.setLatitude("51.5074");
        l.setLongitude("-0.1278");
        l.setName("London");
        locations.put("new york", l);
        locations.put("london", l);
    }


    public String getWeather(String location) {
        // Placeholder for actual weather retrieval logic
        RestClient restClient = RestClient.create();
        String response = restClient.get()
                .uri(baseUrl + "?lat=" + locations.get(location.toLowerCase()).getLatitude() +
                     "&lon=" + locations.get(location.toLowerCase()).getLongitude() +
                     "&appid=" + apiKey)
                .retrieve().body(String.class);
        return response;
    }

    public String getWeatherForecast(String location) {
        // Placeholder for actual weather forecast retrieval logic
        return "Weather forecast for " + location;
    }
}
