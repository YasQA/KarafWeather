//package com.yas.service;
//
//import com.yas.dto.WeatherDto;
//import org.apache.cxf.jaxrs.client.WebClient;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class WeatherServiceImplTest {
//    private final WeatherService weatherService;
//
//    public WeatherServiceImplTest(WeatherService weatherService) {
//        this.weatherService = weatherService;
//    }
//
//    @BeforeEach
//    void setUp() {
//    }
//
//    @AfterEach
//    void tearDown() {
//    }
//
//    @Test
//    void getWeatherByCityName_correctCityReturned_test() {
//        //weatherService = new WeatherServiceImpl(webClient, appId);
//        assertEquals("Boston", weatherService.getWeatherByCity("Boston").getCityName());
//    }
//}
