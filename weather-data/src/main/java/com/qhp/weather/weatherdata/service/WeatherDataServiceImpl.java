package com.qhp.weather.weatherdata.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qhp.weather.weatherdata.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Service
public class WeatherDataServiceImpl implements  WeatherDataService{
    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    public WeatherResponse getCityWeatherById(String cityid) {
        String url = WEATHER_URI + "citykey=" + cityid;
        return this.doGetWeahter(url);
    }

    public WeatherResponse getCityWeatherByName(String name) {
        String url = WEATHER_URI + "city=" + name;
        return this.doGetWeahter(url);
    }

    private WeatherResponse doGetWeahter(String uri) {
        String key = uri;
        String objStr="";
        ObjectMapper mapper = new ObjectMapper();
        WeatherResponse resp = null;
        ValueOperations<String,String> ops =stringRedisTemplate.opsForValue();
        if(stringRedisTemplate.hasKey(key)){
            objStr = ops.get(uri);
        }else{
            throw new RuntimeException("Don't has data!");
        }
        try{
            resp = mapper.readValue(objStr,WeatherResponse.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return resp;
    }
}
