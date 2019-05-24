package com.qhp.weather.weatherreport.service;


import com.qhp.weather.weatherreport.feign.WeatherDataClient;
import com.qhp.weather.weatherreport.vo.Weather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherDataReportServiceImpl implements WeatherDataReportService {
    @Autowired
    private WeatherDataClient weatherDataClient;
    public Weather getWeatherDataById(String cityId) {
        return weatherDataClient.getWeatherDataById(cityId).getData();
    }
}
