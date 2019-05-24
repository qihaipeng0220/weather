package com.qhp.weather.weatherreport.feign;
import com.qhp.weather.weatherreport.vo.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("weather-data")
public interface WeatherDataClient {
    @GetMapping("/weather/cityId/{cityId}")
    WeatherResponse getWeatherDataById(@PathVariable("cityId") String cityId);
}
