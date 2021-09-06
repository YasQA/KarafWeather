package com.yas.service;

import com.yas.dao.WeatherDao;
import com.yas.dto.WeatherDto;
import com.yas.entity.Weather;
import org.apache.cxf.jaxrs.client.WebClient;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.MediaType;

public class WeatherServiceImpl implements WeatherService {
    private final WebClient webClient;
    private final String appId;
    private final WeatherDao weatherDao;

    public WeatherServiceImpl(WebClient webClient, String appId, WeatherDao weatherDao) {
        this.webClient = webClient;
        this.appId = appId;
        this.weatherDao = weatherDao;
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
            WeatherDto weatherDto = webClient.accept(MediaType.APPLICATION_JSON).get(WeatherDto.class);
            weatherDao.add(new Weather(weatherDto));
            return weatherDto;
        } catch (NotFoundException exception) {
            return new WeatherDto("City Not Found", new WeatherDto.MainWeatherData());
        }
    }
}
