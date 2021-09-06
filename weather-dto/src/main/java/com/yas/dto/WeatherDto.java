package com.yas.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherDto {
    @JsonProperty("name")
    private String cityName;

    @JsonProperty("main")
    private MainWeatherData mainWeatherData;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class MainWeatherData {
        @JsonProperty("temp")
        private double temperature;

        @JsonProperty("feels_like")
        private double feelsLike;

        @JsonProperty("temp_min")
        private double temperatureMin;

        @JsonProperty("temp_max")
        private double temperatureMax;

        @JsonProperty("pressure")
        private double pressure;

        @JsonProperty("humidity")
        private double humidity;
    }

}
