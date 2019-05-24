package com.qhp.weather.weathercity.controller;

import com.qhp.weather.weathercity.service.CityDataService;
import com.qhp.weather.weathercity.vo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("city")
public class CityController {
    @Autowired
    CityDataService cityDataService;
    @GetMapping("cityList")
    public List<City> listCity() throws Exception {
        return cityDataService.listCityData();
    }
}
