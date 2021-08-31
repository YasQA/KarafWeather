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
//    public static final WeatherDto FAKE_WEATHER =
//            new WeatherDto("testCityName", new WeatherDto.MainWeatherData(100,101,102,103,104,105));
//
//    private final WebClient webClient;
//    private final String appId;
//
//    public WeatherServiceImplTest(WebClient webClient, String appId) {
//        this.webClient = webClient;
//        this.appId = appId;
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
//        WeatherService weatherService = new WeatherServiceImpl(webClient, appId);
//        assertEquals("Boston", weatherService.getWeatherByCity("Boston").getCityName());
//    }
//}
