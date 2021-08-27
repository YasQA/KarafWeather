package com.yas.controller;

import com.yas.dto.WeatherDto;

public interface WeatherRestService {
    WeatherDto getByCity(String city);
    WeatherDto getByZipAndCountryCode(String zip, String countryCode);
}
