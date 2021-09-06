package com.yas.controller;

import com.yas.dto.WeatherDto;
import com.yas.service.WeatherService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class WeatherRestServiceImplTest {
    public static final WeatherDto FAKE_WEATHER =
            new WeatherDto("testCityName", new WeatherDto.MainWeatherData(100,101,102,103,104,105));

    @Mock
    private WeatherService weatherService;
    private WeatherRestService weatherRestService;


    @BeforeEach
    void setUp() {
        //weatherService = Mockito.mock(WeatherService.class);
        weatherRestService = new WeatherRestServiceImpl(weatherService);
    }

    @Test
    public void shouldReturnCorrectCityName_whenGetWeatherByCity() {
        when(weatherService.getWeatherByCity("testCityName")).thenReturn(FAKE_WEATHER);

        assertEquals(FAKE_WEATHER.getMainWeatherData().getTemperature(),
                weatherRestService.getByCity("testCityName").getMainWeatherData().getTemperature());
    }

    @Test
    public void shouldReturnCorrectTempData_whenGetWeatherByCity() {
        when(weatherService.getWeatherByCity("testCityName")).thenReturn(FAKE_WEATHER);

        WeatherDto wDto = weatherRestService.getByCity("testCityName");

        assertEquals(FAKE_WEATHER, wDto);

    }

    @Test
    public void shouldPerformCorrectNumberOfInteractions_whenGetWeatherByCity() {
        when(weatherService.getWeatherByCity("testCityName")).thenReturn(FAKE_WEATHER);
        weatherRestService.getByCity("testCityName").getCityName();

        verify(weatherService, times(1)).getWeatherByCity("testCityName");
    }

    @Test
    public void shouldPerformInteractionWithCorrectArgument_whenGetWeatherByCity() {
        when(weatherService.getWeatherByCity("testCityName")).thenReturn(FAKE_WEATHER);
        weatherRestService.getByCity("testCityName").getCityName();

        verify(weatherService).getWeatherByCity("testCityName");
    }

    @Test
    public void shouldReturnCorrectCityName_whenGetWeatherByZipAndCountryCode() {
        when(weatherService.getWeatherByZipAndCountryCode("12345", "us")).thenReturn(FAKE_WEATHER);

        assertEquals(FAKE_WEATHER.getMainWeatherData().getTemperature(),
                weatherRestService.getByZipAndCountryCode("12345", "us").getMainWeatherData().getTemperature());
    }

    @Test
    public void shouldReturnCorrectTempData_whenGetWeatherByZipAndCountryCode() {
        when(weatherService.getWeatherByZipAndCountryCode("12345", "us")).thenReturn(FAKE_WEATHER);

        assertEquals(FAKE_WEATHER.getMainWeatherData().getTemperature(),
                weatherRestService.getByZipAndCountryCode("12345", "us").getMainWeatherData().getTemperature());
        assertEquals(FAKE_WEATHER.getMainWeatherData().getHumidity(),
                weatherRestService.getByZipAndCountryCode("12345", "us").getMainWeatherData().getHumidity());
        assertEquals(FAKE_WEATHER.getMainWeatherData().getPressure(),
                weatherRestService.getByZipAndCountryCode("12345", "us").getMainWeatherData().getPressure());
    }

    @Test
    public void shouldPerformCorrectNumberOfInteractions_whenGetWeatherByZipAndCountryCode() {
        when(weatherService.getWeatherByZipAndCountryCode("12345", "us")).thenReturn(FAKE_WEATHER);
        weatherRestService.getByZipAndCountryCode("12345", "us").getCityName();

        verify(weatherService, times(1)).getWeatherByZipAndCountryCode("12345", "us");
    }

    @Test
    public void shouldPerformInteractionWithCorrectArgument_whenGetWeatherByZipAndCountryCode() {
        when(weatherService.getWeatherByZipAndCountryCode("12345", "us")).thenReturn(FAKE_WEATHER);
        weatherRestService.getByZipAndCountryCode("12345", "us").getCityName();

        verify(weatherService).getWeatherByZipAndCountryCode("12345", "us");
    }

}
