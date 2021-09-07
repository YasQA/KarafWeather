package com.yas.entity;

import com.yas.dto.WeatherDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class WeatherTest {
    public static final WeatherDto FAKE_WEATHER =
            new WeatherDto("testCityName", new WeatherDto.MainWeatherData(100,101,102,103,104,105));

    @Test
    public void shouldCreateCorrectWeatherObject_whenConstructorWithDtoCall() {
        Weather expectedWeather = new Weather("12345678", "testCityName", 100, 101, 102, 103, 104, 105);
        Weather weather = new Weather(FAKE_WEATHER);
        weather.setId("12345678");

        assertEquals(expectedWeather, weather);
    }

}