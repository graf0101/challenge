package com.tcs.challenge.client;

import java.net.URI;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;

import com.tcs.challenge.config.ApiWeatherProperties;
import com.tcs.challenge.model.Geo;
import com.tcs.challenge.model.Weather;

import lombok.Setter;
import reactor.core.publisher.Mono;

@Component
@PropertySource("classpath:api_weather.properties")
public class OpenWeatherMapClient {

	@Autowired
	@Setter
	ApiWeatherProperties apiProps;
// 	TODO Validate when reponse is empty or null 
	public Mono<Geo> getGeolocationByName(String locationName) {
		return WebClient.create(apiProps.getHost()).get()
				.uri(uriBuilder -> buildGeoUri(locationName, apiProps.getLimit(), uriBuilder))				
				.exchangeToFlux(clientResponse -> clientResponse.bodyToFlux(Geo.class)).next()
                .log("Geo Fetched:");
	}
	
// 	TODO Validate when reponse is empty or null
	public Mono<Weather> getWeatherByCoordinates(String locationLat, String locationLon) {
		return WebClient.create(apiProps.getHost()).get()
				.uri(uriBuilder -> buildWeatherUri(locationLat, locationLon, apiProps.getUnit(), uriBuilder))
				.exchangeToFlux(clientResponse -> clientResponse.bodyToFlux(Weather.class))
				.next().log("Weather Fetched  : ");
	}

	private URI buildWeatherUri(String locationLat, String locationLon, String units, UriBuilder uriBuilder) {
		return uriBuilder.path("/data/2.5/weather").queryParam("lat", locationLat).queryParam("lon", locationLon)
				.queryParam("units", units).queryParam("lang", apiProps.getLang())
				.queryParam("appid", apiProps.getKey()).build();
	}

	private URI buildGeoUri(String locationName, String string, UriBuilder uriBuilder) {
		return uriBuilder.path("/geo/1.0/direct").queryParam("q", locationName).queryParam("limit", string)
				.queryParam("appid", apiProps.getKey()).build();
	}
}