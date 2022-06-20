package com.tcs.challenge.client;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriBuilder;

import com.tcs.challenge.config.ApiWeatherProperties;
import com.tcs.challenge.model.Geo;
import com.tcs.challenge.model.Weather;

import lombok.Setter;
import reactor.core.publisher.Mono;

@Service
@Component
@PropertySource("classpath:api_weather.properties")
public class OpenWeatherMapClient {

	private static final String PATH_WEATHER = "/data/2.5/weather";
	private static final String PATH_GEO = "/geo/1.0/direct";
	@Autowired
	@Setter
	ApiWeatherProperties apiProps;

	@Autowired
	OpenWeatherMapClientConfig webClientConfig;

	public Mono<Geo> getGeolocationByName(String locationName) {

		return webClientConfig
				.webClient()
				.get()
				.uri(uriBuilder -> buildGeoUri(locationName, apiProps.getLimit(), uriBuilder))
				.accept(MediaType.APPLICATION_JSON).retrieve()
				.onStatus(HttpStatus::is5xxServerError, clientResponse -> Mono.empty())
				.onStatus(HttpStatus::is4xxClientError, clientResponse -> Mono.empty())
				.bodyToFlux(Geo.class)
				.next()
				.log("Geo Fetched  : ");
	}

	public Mono<Weather> getWeatherByCoordinates(String locationLat, String locationLon) {
		return webClientConfig
				.webClient()
				.get()
				.uri(uriBuilder -> buildWeatherUri(locationLat, locationLon, apiProps.getUnit(), uriBuilder))
				.exchangeToFlux(clientResponse -> clientResponse.bodyToFlux(Weather.class))
				.next()
				.log("Weather Fetched  : ");
	}

	private URI buildWeatherUri(String locationLat, String locationLon, String units, UriBuilder uriBuilder) {
		return uriBuilder.path(PATH_WEATHER).queryParam("lat", locationLat).queryParam("lon", locationLon)
				.queryParam("units", units).queryParam("lang", apiProps.getLang())
				.queryParam("appid", apiProps.getKey()).build();
	}

	private URI buildGeoUri(String locationName, String string, UriBuilder uriBuilder) {
		return uriBuilder.path(PATH_GEO).queryParam("q", locationName).queryParam("limit", string)
				.queryParam("appid", apiProps.getKey()).build();
	}
}