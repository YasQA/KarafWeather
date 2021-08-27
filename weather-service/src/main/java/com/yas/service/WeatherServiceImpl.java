package com.yas.service;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.yas.dto.WeatherDto;
import org.apache.cxf.jaxrs.client.WebClient;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

public class WeatherServiceImpl implements WeatherService {
    public static String API_KEY = "9bc9127b5ca9be05751bd273761634d4";
    public static String API_URL = "https://api.openweathermap.org/data/2.5/weather";

    @Override
    public WeatherDto getWeatherByCity(String city) {
        List<JacksonJsonProvider> providers = new ArrayList<>();
        providers.add(new JacksonJsonProvider());
        WebClient webClient = WebClient.create(API_URL, providers)
                .query("q", city)
                .query("appid", API_KEY);
        return getWeather(webClient);
    }

    @Override
    public WeatherDto getWeatherByZipAndCountryCode(String zip, String countryCode) {
        List<JacksonJsonProvider> providers = new ArrayList<>();
        providers.add(new JacksonJsonProvider());
        WebClient webClient = WebClient.create(API_URL, providers)
                .query("zip", zip, countryCode)
                .query("appid", API_KEY);
        return getWeather(webClient);
    }

    private WeatherDto getWeather(WebClient webClient) {
        try {
            return webClient.accept(MediaType.APPLICATION_JSON).get(WeatherDto.class);

        } catch (NotFoundException exception) {
            return new WeatherDto("City Not Found", new WeatherDto.Main());
        }
    }

//    private WeatherDto getWeather(WebClient webClient) {
//        try {
//            ObjectMapper objectMapper = new ObjectMapper();
//            String json = webClient.accept(MediaType.APPLICATION_JSON).get(String.class);
//            JsonNode weatherFull = objectMapper.readTree(json);
//
//            WeatherDto weather = new WeatherDto();
//            weather.setCity(weatherFull.findValuesAsText("name").get(0));
//            weather.setTemperature(weatherFull.findValuesAsText("temp").get(0));
//            weather.setWeatherMain(weatherFull.findValuesAsText("main").get(0));
//            return weather;
//        } catch (NotFoundException | JsonProcessingException exception) {
//            return new WeatherDto("City not found", "City not found", "City not found");
//        }
//    }

}
