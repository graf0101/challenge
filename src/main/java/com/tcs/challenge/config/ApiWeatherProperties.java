package com.tcs.challenge.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Data;

@ConfigurationPropertiesScan
@Configuration
@ConfigurationProperties(prefix = "api-weather")
@PropertySource(value = "classpath:api_weather.properties")
@Data
public class ApiWeatherProperties {

	private String host;
	private String key;
	private String limit;
	private String lang;
	private String unit;
}
