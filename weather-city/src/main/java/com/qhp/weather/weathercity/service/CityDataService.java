package com.qhp.weather.weathercity.service;

import com.qhp.weather.weathercity.vo.City;

import java.util.List;

public interface CityDataService {
    List<City> listCityData() throws Exception;
}
