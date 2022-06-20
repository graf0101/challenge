package com.tcs.challenge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.challenge.model.Geo;
import com.tcs.challenge.model.Temperature;
import com.tcs.challenge.model.Weather;
import com.tcs.challenge.service.WeatherService;

import reactor.core.publisher.Mono;

@RestController
public class WeatherControllerImpl implements WeatherController {

	@Autowired
	private WeatherService weatherService;

	/**
	 * Method that returns the coordinates of a place receiving as a parameter the
	 * name of a location, in case of finding more than one location with a similar
	 * name, it will choose the first one from the list..
	 * 
	 * @param locationName The location name
	 * @return Wrapped GeoLocation object
	 */
	@Override
	public Mono<ResponseEntity<Geo>> getGeolocationByName(@PathVariable String locationName) {
		Mono<Geo> geolocation = weatherService.getGeolocationByName(locationName);
		return geolocation.map(ResponseEntity::ok).defaultIfEmpty(ResponseEntity.notFound().build());
	}

	/**
	 * Method that returns the temperature in degrees Celsius receiving as a
	 * parameter the latitude and longitude of a location, in case of finding more
	 * than one location with a similar name, it will choose the first one from the
	 * list.
	 * 
	 * @param locationLat The latitude of location name.
	 * @param locationLon The longitude of location name.
	 * @return Wrapped Weather object
	 */
	@Override
	public Mono<ResponseEntity<Weather>> getWeatherByCoodinates(@PathVariable String locationLat,
			@PathVariable String locationLon) {
		Mono<Weather> weather = weatherService.getWeatherByCoodinates(locationLat, locationLon);
		return weather.map(ResponseEntity::ok).defaultIfEmpty(ResponseEntity.notFound().build());
	}

	/**
	 * Method that returns the temperature in degrees Celsius receiving as a
	 * parameter the name of a location, in case of finding more than one location
	 * with a similar name, it will choose the first one from the list.
	 * 
	 * @param locationName The location name
	 * @return Wrapped Temperature object
	 */
	@Override
	public Mono<ResponseEntity<Temperature>> getWeatherByName(String locationName) {
		Mono<Temperature> weatherTemp = weatherService.getWeatherByName(locationName).map(Weather::getTemperature);
		return weatherTemp.map(ResponseEntity::ok).defaultIfEmpty(ResponseEntity.notFound().build());
	}

}