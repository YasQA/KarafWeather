package com.yas.entity;

import com.savoirtech.hecate.annotation.PartitionKey;
import com.yas.dto.WeatherDto;
import lombok.*;

import java.util.UUID;

@Data
public class Weather {
    @PartitionKey
    private String id;
    private String city;
    private double temperature;
    private double feelsLike;
    private double temperatureMin;
    private double temperatureMax;
    private double pressure;
    private double humidity;

    public Weather(WeatherDto weatherDto) {
        this.id = UUID.randomUUID().toString();
        this.city = weatherDto.getCityName();
        this.temperature = weatherDto.getMainWeatherData().getTemperature();
        this.feelsLike = weatherDto.getMainWeatherData().getFeelsLike();
        this.temperatureMin = weatherDto.getMainWeatherData().getTemperatureMin();
        this.temperatureMax = weatherDto.getMainWeatherData().getTemperatureMax();
        this.pressure = weatherDto.getMainWeatherData().getPressure();
        this.humidity = weatherDto.getMainWeatherData().getHumidity();
    }
}
