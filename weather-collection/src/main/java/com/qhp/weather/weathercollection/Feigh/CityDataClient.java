package com.qhp.weather.weathercollection.Feigh;

import com.qhp.weather.weathercollection.vo.City;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("weather-city")
public interface CityDataClient {
    @GetMapping("/city/cityList")
    List<City> listCity();
}
