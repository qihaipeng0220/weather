package com.qhp.weather.weatherdata.controller;

import com.qhp.weather.weatherdata.service.WeatherDataService;
import com.qhp.weather.weatherdata.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherDataController {

    @Autowired
    WeatherDataService weatherDataService;
    @GetMapping("/cityId/{cityId}")
    public WeatherResponse getWeatherByCityId(@PathVariable("cityId") String cityId){
        return weatherDataService.getCityWeatherById(cityId);
    }
    @GetMapping("/cityName/{cityName}")
    public WeatherResponse getWeatherByName(@PathVariable("cityName") String cityName){
        return weatherDataService.getCityWeatherByName(cityName);
    }
}
