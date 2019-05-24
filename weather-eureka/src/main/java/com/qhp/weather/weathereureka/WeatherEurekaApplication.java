package com.qhp.weather.weathereureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class WeatherEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherEurekaApplication.class, args);
	}

}
