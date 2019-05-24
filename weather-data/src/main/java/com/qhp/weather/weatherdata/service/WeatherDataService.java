package com.qhp.weather.weatherdata.service;

import com.qhp.weather.weatherdata.vo.WeatherResponse;

public interface WeatherDataService {
    WeatherResponse getCityWeatherById(String cityid);
    WeatherResponse getCityWeatherByName(String name);
}
