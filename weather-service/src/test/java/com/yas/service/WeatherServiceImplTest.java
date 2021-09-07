package com.yas.service;

import com.yas.dao.WeatherDao;
import com.yas.dto.WeatherDto;
import com.yas.entity.Weather;
import org.apache.cxf.jaxrs.client.WebClient;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class WeatherServiceImplTest {
    public static final String FAKE_APP_ID = "1234567890";
    public static final WeatherDto FAKE_WEATHER =
            new WeatherDto("testCityName",
                    new WeatherDto.MainWeatherData(100,101,102,103,104,105));

    @Mock
    WebClient webClient;
    @Mock
    WeatherDao weatherDao;

    WeatherService weatherService;

    @BeforeEach
    void setUp() {
        weatherService = new WeatherServiceImpl(webClient, FAKE_APP_ID, weatherDao);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void shouldReturnCorrectWeatherData_whenGetWeatherByCity() {
        when(webClient.get(WeatherDto.class)).thenReturn(FAKE_WEATHER);
        when(webClient.reset()).thenReturn(webClient);
        when(webClient.query(anyString(), anyString())).thenReturn(webClient);
        doNothing().when(weatherDao).add(isA(Weather.class));

        WeatherDto wDtoResult = weatherService.getWeatherByCity("testCityName");

        assertEquals(FAKE_WEATHER, wDtoResult);
    }

    @Test
    void shouldReturnCorrectWeatherData_whenGetWeatherByZipAndCountryCode() {
        when(webClient.get(WeatherDto.class)).thenReturn(FAKE_WEATHER);
        when(webClient.reset()).thenReturn(webClient);
        when(webClient.query(anyString(), anyString())).thenReturn(webClient);
        doNothing().when(weatherDao).add(isA(Weather.class));

        WeatherDto wDtoResult = weatherService.getWeatherByZipAndCountryCode("12345678", "ab");

        assertEquals(FAKE_WEATHER, wDtoResult);
    }
}
