package com.yas.service;

import com.yas.dto.WeatherDto;
import org.apache.cxf.jaxrs.client.WebClient;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.MediaType;

public class WeatherServiceImpl implements WeatherService {
    private final WebClient webClient;
    private final String appId;

    public WeatherServiceImpl(WebClient webClient, String appId){
        this.webClient = webClient;
        this.appId = appId;
    }

    @Override
    public WeatherDto getWeatherByCity(String city) {
        webClient.reset()
                .query("q", city)
                .query("appid", appId);
        return getWeather(webClient);
    }

    @Override
    public WeatherDto getWeatherByZipAndCountryCode(String zip, String countryCode) {
        webClient.reset()
                .query("zip", zip, countryCode)
                .query("appid", appId);
        return getWeather(webClient);
    }

    private WeatherDto getWeather(WebClient webClient) {
        try {
            return webClient.accept(MediaType.APPLICATION_JSON).get(WeatherDto.class);
        } catch (NotFoundException exception) {
            return new WeatherDto("City Not Found", new WeatherDto.Main());
        }
    }
}
