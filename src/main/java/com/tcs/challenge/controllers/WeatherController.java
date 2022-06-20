package com.tcs.challenge.controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tcs.challenge.model.Geo;
import com.tcs.challenge.model.Temperature;
import com.tcs.challenge.model.Weather;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import reactor.core.publisher.Mono;

@RequestMapping("/location/search")
public interface WeatherController {

	public static final String CODE_404 = "404";
	public static final String CODE_400 = "400";
	public static final String CODE_200 = "200";
	public static final String LOCATION_NOT_FOUND = "Location not found";
	public static final String INVALID_LOCATION = "Invalid Location";
	public static final String SUCCESSFUL_OPERATION = "Successful operation";

	public static final String WEATHER_BY_COORDINATES_DESCRIPTION = "Method that returns meteorological information associated with a latitude and longitude";
	public static final String WEATHER_BY_COORDINATES_SUMMARY = "Get WeatherData using Coordinates fron Location Name";
	public static final String WEATHER_BY_NAME_DESCRIPTION = "Return a Location Temperature, executing 2 calls, first obtaining the coordinates of the first city and then using the coordinates to obtain the temperature associated with the cordenadas obtained";
	public static final String WEATHER_BY_NAME_SUMMARY = "Get Tempeture using GPS Coordinates";

	public static final String GEO_BY_NAME_DESCRIPTION = "Method that returns georeferencing information from the first result associated with the name of the searched location";
	public static final String GEO_BY_NAME_SUMMARY = "Get GPS Coordinates fron Location Name";

	@Operation(summary = WEATHER_BY_NAME_SUMMARY, description = WEATHER_BY_NAME_DESCRIPTION, responses = {
			@ApiResponse(responseCode = CODE_200, description = SUCCESSFUL_OPERATION, content = @Content(schema = @Schema(implementation = Temperature.class))),
			@ApiResponse(responseCode = CODE_400, description = INVALID_LOCATION),
			@ApiResponse(responseCode = CODE_404, description = LOCATION_NOT_FOUND) })
	@GetMapping(value = "/{locationName}", produces = MediaType.APPLICATION_JSON_VALUE)
	Mono<ResponseEntity<Temperature>> getWeatherByName(
			@Parameter(description = "Location Name", example = "London", required = true) @Validated @PathVariable("locationName") String locationName);

	@Operation(summary = GEO_BY_NAME_SUMMARY, description = GEO_BY_NAME_DESCRIPTION, responses = {
			@ApiResponse(responseCode = CODE_200, description = SUCCESSFUL_OPERATION, content = @Content(schema = @Schema(implementation = Geo.class))),
			@ApiResponse(responseCode = CODE_400, description = INVALID_LOCATION),
			@ApiResponse(responseCode = CODE_404, description = LOCATION_NOT_FOUND) })
	@GetMapping(value = "/getGeolocationByName/{locationName}", produces = MediaType.APPLICATION_JSON_VALUE)
	Mono<ResponseEntity<Geo>> getGeolocationByName(
			@Parameter(description = "Location Name", example = "London", required = true) @PathVariable String locationName);

	@Operation(summary = WEATHER_BY_COORDINATES_SUMMARY, description = WEATHER_BY_COORDINATES_DESCRIPTION, responses = {
			@ApiResponse(responseCode = CODE_200, description = SUCCESSFUL_OPERATION, content = @Content(schema = @Schema(implementation = Geo.class))),
			@ApiResponse(responseCode = CODE_400, description = INVALID_LOCATION),
			@ApiResponse(responseCode = CODE_404, description = LOCATION_NOT_FOUND) })
	@GetMapping(value = "/lat/{locationLat}/lon/{locationLon}", produces = MediaType.APPLICATION_JSON_VALUE)
	Mono<ResponseEntity<Weather>> getWeatherByCoodinates(
			@Parameter(description = "Location Latitude", example = "51.5073219", required = true) @Validated @PathVariable String locationLat,
			@Parameter(description = "Location Longitude", example = "-0.1276474", required = true) @Validated @PathVariable String locationLon);

}
