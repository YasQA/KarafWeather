package com.yas.controller;

import com.yas.dto.WeatherDto;
import com.yas.service.WeatherService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/")
public class WeatherRestServiceImpl implements WeatherRestService {
    private final WeatherService weatherService; //to inject

    public WeatherRestServiceImpl(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @Override
    @Path("/{city}")
    @Produces("application/json")
    @GET
    public WeatherDto getByCity(@PathParam("city") String city) {
        return weatherService.getWeatherByCity(city);
    }

    @Override
    @Path("/{code}/{zip}")
    @Produces("application/json")
    @GET
    public WeatherDto getByZipAndCountryCode(@PathParam("zip") String zip, @PathParam("code") String countryCode) {
        return weatherService.getWeatherByZipAndCountryCode(zip, countryCode);
    }
}
