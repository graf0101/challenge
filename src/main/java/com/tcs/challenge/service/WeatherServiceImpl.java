package com.tcs.challenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.challenge.client.OpenWeatherMapClient;
import com.tcs.challenge.model.Geo;
import com.tcs.challenge.model.Weather;

import reactor.core.publisher.Mono;

@Service
public class WeatherServiceImpl implements WeatherService {

	@Autowired
	private OpenWeatherMapClient openWeatherMapClient;

	@Override
	public Mono<Geo> getGeolocationByName(String locationName) {
		return openWeatherMapClient.getGeolocationByName(locationName);
	}

	@Override
	public Mono<Weather> getWeatherByCoodinates(String locationLat, String locationLon) {
		return openWeatherMapClient.getWeatherByCoordinates(locationLat, locationLon);
	}

	@Override
	public Mono<Weather> getWeatherByName(String locationName) {
		return openWeatherMapClient.getGeolocationByName(locationName)
				.flatMap(t -> getWeatherByCoodinates(t.getLat().toString(), t.getLon().toString()));

	}
}
