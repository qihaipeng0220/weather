package com.qhp.weather.weathercollection.job;

import com.qhp.weather.weathercollection.Feigh.CityDataClient;
import com.qhp.weather.weathercollection.service.WeatherDataCollectionService;
import com.qhp.weather.weathercollection.vo.City;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;

public class WeatherDataSyncJob extends QuartzJobBean {
    @Autowired
    private CityDataClient cityDataClient;
    @Autowired
    private WeatherDataCollectionService weatherDataCollectionService;
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        List<City> cityList = cityDataClient.listCity();
        for (City city: cityList) {
            weatherDataCollectionService.syncDateByCityId(city.getCityId());
        }
        

    }
}
