package com.qhp.weather.weathercity.service;

import com.qhp.weather.weathercity.util.XmlBuilder;
import com.qhp.weather.weathercity.vo.City;
import com.qhp.weather.weathercity.vo.CityList;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
@Service
public class CityDataServiceImpl implements CityDataService {

    public List<City> listCityData() throws  Exception {
        Resource resource = new ClassPathResource("cityList.xml");
        BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream(),"utf-8"));
        StringBuffer buff = new StringBuffer();
        String line=null;
        while((line=reader.readLine())!=null){
            buff.append(line);
        }
        reader.close();
        CityList cityList = (CityList)XmlBuilder.xmlStrToObject(CityList.class,buff.toString());
       return cityList.getCityList();
    }
}
