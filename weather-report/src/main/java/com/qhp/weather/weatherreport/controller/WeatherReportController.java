package com.qhp.weather.weatherreport.controller;


import com.qhp.weather.weatherreport.feign.CityClient;
import com.qhp.weather.weatherreport.service.WeatherDataReportService;
import com.qhp.weather.weatherreport.vo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/report")
public class WeatherReportController {
    @Autowired
    private WeatherDataReportService weatherDataReportService;
    @Autowired
    private CityClient cityClient;
    @GetMapping("/cityId/{cityId}")
    public ModelAndView getWeatherDataBycityId(@PathVariable("cityId") String cityId, Model model){
        List<City> cityList = cityClient.cityList();
        model.addAttribute("title", "老卫的天气预报");
        model.addAttribute("cityId", cityId);
        model.addAttribute("cityList", cityList);
        model.addAttribute("report", weatherDataReportService.getWeatherDataById(cityId));
        return new ModelAndView("weather/report", "reportModel", model);
    }
}
