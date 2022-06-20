package com.tcs.challenge.service;

import com.tcs.challenge.model.Geo;
import com.tcs.challenge.model.Weather;

import reactor.core.publisher.Mono;

public interface WeatherService {

	Mono<Geo> getGeolocationByName(String locationName);

	Mono<Weather> getWeatherByCoodinates(String locationLat, String locationLon);

	Mono<Weather> getWeatherByName(String locationName);

}
