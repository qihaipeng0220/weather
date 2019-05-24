package com.qhp.weather.weatherreport.feign;

import com.qhp.weather.weatherreport.vo.City;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("weather-city")
public interface CityClient {
    @GetMapping("/city/cityList")
    List<City> cityList();
}
