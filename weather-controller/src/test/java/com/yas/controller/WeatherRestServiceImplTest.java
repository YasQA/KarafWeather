package com.yas.controller;

import com.yas.dto.WeatherDto;
import com.yas.service.WeatherService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class WeatherRestServiceImplTest {
    public static final WeatherDto FAKE_WEATHER =
            new WeatherDto("testCityName", new WeatherDto.MainWeatherData(100,101,102,103,104,105));

    @Mock
    private WeatherService weatherService;

    private WeatherRestService weatherRestService;

    @BeforeEach
    void setUp() {
        weatherRestService = new WeatherRestServiceImpl(weatherService);
    }

    @Test
    public void shouldReturnCorrectCityName_whenGetWeatherByCity() {
        when(weatherService.getWeatherByCity("testCityName")).thenReturn(FAKE_WEATHER);

        assertEquals(FAKE_WEATHER.getMainWeatherData().getTemperature(),
                weatherRestService.getByCity("testCityName").getMainWeatherData().getTemperature());
    }

    @Test
    public void shouldReturnCorrectTempData_and_PerformCorrectInteractions_whenGetWeatherByCity() {
        when(weatherService.getWeatherByCity("testCityName")).thenReturn(FAKE_WEATHER);

        WeatherDto weatherDto = weatherRestService.getByCity("testCityName");

        assertEquals(FAKE_WEATHER, weatherDto);
        verify(weatherService, times(1)).getWeatherByCity("testCityName");
        verify(weatherService).getWeatherByCity("testCityName");
    }

    @Test
    public void shouldReturnCorrectTempData_and_PerformCorrectInteractions_whenGetWeatherByZipAndCountryCode() {
        when(weatherService.getWeatherByZipAndCountryCode("121212", "ab")).thenReturn(FAKE_WEATHER);

        WeatherDto weatherDto = weatherRestService.getByZipAndCountryCode("121212", "ab");

        assertEquals(FAKE_WEATHER, weatherDto);
        verify(weatherService, times(1)).getWeatherByZipAndCountryCode("121212", "ab");
        verify(weatherService).getWeatherByZipAndCountryCode("121212", "ab");
    }

}
