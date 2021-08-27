package com.yas.service;

import com.yas.dto.WeatherDto;

public interface WeatherService {
    WeatherDto getWeatherByCity(String city);
    WeatherDto getWeatherByZipAndCountryCode(String zip, String countryCode);
}
