package com.yas.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherDto {
    private String name;
    private Main main;

    public WeatherDto() {
    }

    public WeatherDto(String name, Main main) {
        this.name = name;
        this.main = main;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public static class Main {
        private String temp;
        private String feels_like;
        private String temp_min;
        private String temp_max;
        private String pressure;
        private String humidity;

        public String getTemp() {
            return temp;
        }

        public void setTemp(String temp) {
            this.temp = temp;
        }

        public String getFeels_like() {
            return feels_like;
        }

        public void setFeels_like(String feels_like) {
            this.feels_like = feels_like;
        }

        public String getTemp_min() {
            return temp_min;
        }

        public void setTemp_min(String temp_min) {
            this.temp_min = temp_min;
        }

        public String getTemp_max() {
            return temp_max;
        }

        public void setTemp_max(String temp_max) {
            this.temp_max = temp_max;
        }

        public String getPressure() {
            return pressure;
        }

        public void setPressure(String pressure) {
            this.pressure = pressure;
        }

        public String getHumidity() {
            return humidity;
        }

        public void setHumidity(String humidity) {
            this.humidity = humidity;
        }
    }

    //    private String city;
//    private String temperature;
//    private String weatherMain;
//
//    public WeatherDto() {
//    }
//
//    public WeatherDto(String city, String temperature, String weatherMain) {
//        this.city = city;
//        this.temperature = temperature;
//        this.weatherMain = weatherMain;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//    public void setTemperature(String temperature) {
//        this.temperature = temperature;
//    }
//
//    public void setWeatherMain(String weatherMain) {
//        this.weatherMain = weatherMain;
//    }
//
//    public String getCity() {
//        return city;
//    }
//
//    public String getTemperature() {
//        return temperature;
//    }
//
//    public String getWeatherMain() {
//        return weatherMain;
//    }
}
