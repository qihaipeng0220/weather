package com.qhp.weather.weathercity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableDiscoveryClient
public class WeatherCityApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherCityApplication.class, args);
	}

}
