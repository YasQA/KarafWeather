package com.yas.service;

import com.yas.dto.WeatherDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class WeatherServiceImplTest {
    public static final WeatherDto FAKE_WEATHER =
            new WeatherDto("testCityName", new WeatherDto.Main(100,101,102,103,104,105));

    @Mock
    WeatherService weatherService;
    @Mock
    WeatherDto weatherDto;

    @BeforeEach
    void setUp() {
        weatherDto = Mockito.mock(WeatherDto.class);
        weatherService = Mockito.mock(WeatherService.class);
    }

    @AfterEach
    void tearDown() {
        weatherDto = null;
        weatherService = null;
    }

    @Test
    void getWeatherByCityName_correctCityReturned_test() {
        when(weatherDto.getName()).thenReturn("testCityName");
        when(weatherService.getWeatherByCity("testCityName")).thenReturn(weatherDto);

        assertEquals("testCityName", weatherService.getWeatherByCity("testCityName").getName());
    }

    @Test
    void getWeatherByZipAndCountryCode_correctCityReturned_test() {
        when(weatherDto.getName()).thenReturn("testCityName");
        when(weatherService.getWeatherByZipAndCountryCode("010101", "us")).thenReturn(weatherDto);

        assertEquals("testCityName", weatherService.getWeatherByZipAndCountryCode("010101", "us").getName());
    }

    @Test
    void getWeatherByCityName_correctTempReturned_test() {
        when(weatherDto.getMain()).thenReturn(FAKE_WEATHER.getMain());
        when(weatherService.getWeatherByCity("testCityName")).thenReturn(weatherDto);

        assertEquals(100.0, weatherService.getWeatherByCity("testCityName").getMain().getTemp());
    }

    @Test
    void getWeatherByZipAndCountryCode_correctTempReturned_test() {
        when(weatherDto.getMain()).thenReturn(FAKE_WEATHER.getMain());
        when(weatherService.getWeatherByZipAndCountryCode("010101", "us")).thenReturn(weatherDto);

        assertEquals(100.0, weatherService.getWeatherByZipAndCountryCode("010101", "us").getMain().getTemp());
    }

    @Test
    void getWeatherByWrongCityName_CityNotFoundReturned_test() {
        when(weatherDto.getName()).thenReturn("City Not Found");
        when(weatherService.getWeatherByCity("testCityName")).thenReturn(weatherDto);

        assertEquals("City Not Found", weatherService.getWeatherByCity("testCityName").getName());
    }

    @Test
    void getWeatherByWrongZipCode_CityNotFoundReturned_test() {
        when(weatherDto.getName()).thenReturn("City Not Found");
        when(weatherService.getWeatherByZipAndCountryCode("111111", "us")).thenReturn(weatherDto);

        assertEquals("City Not Found", weatherService.getWeatherByZipAndCountryCode("111111", "us").getName());
    }
}
