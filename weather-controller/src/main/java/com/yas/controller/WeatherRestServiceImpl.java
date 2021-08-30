package com.yas.controller;

import com.yas.dto.WeatherDto;
import com.yas.service.WeatherService;

public class WeatherRestServiceImpl implements WeatherRestService {
    private final WeatherService weatherService;

    public WeatherRestServiceImpl(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @Override
    public WeatherDto getByCity(String city) {
        return weatherService.getWeatherByCity(city);
    }

    @Override
    public WeatherDto getByZipAndCountryCode(String zip, String countryCode) {
        return weatherService.getWeatherByZipAndCountryCode(zip, countryCode);
    }
}
