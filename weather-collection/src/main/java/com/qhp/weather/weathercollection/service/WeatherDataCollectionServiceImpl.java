package com.qhp.weather.weathercollection.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

@Service
public class WeatherDataCollectionServiceImpl implements WeatherDataCollectionService {
    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";
    private static final long TIME_OUT = 1800L; // 1800s
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    public void syncDateByCityId(String cityId) {
        String url = WEATHER_URI +  "citykey=" + cityId;
        this.saveWeatherData(url);
    }

    private void saveWeatherData(String  url){
        String key = url;
        String strBody = "";
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        ResponseEntity<String> respString = restTemplate.getForEntity(url,String.class);
        if (respString.getStatusCodeValue() == 200) {
            strBody = respString.getBody();
        }
        ops.set("qhp","8888");
        ops.set(key,strBody,TIME_OUT, TimeUnit.SECONDS);
    }
}
