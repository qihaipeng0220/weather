package com.qhp.weather.weatherreport.service;

import com.qhp.weather.weatherreport.vo.Weather;

public interface WeatherDataReportService {
    Weather getWeatherDataById(String cityId);
}
