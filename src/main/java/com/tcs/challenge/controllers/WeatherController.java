package com.tcs.challenge.controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tcs.challenge.constant.WeatherConstants;
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

	@Operation(summary = WeatherConstants.WEATHER_BY_NAME_SUMMARY, description = WeatherConstants.WEATHER_BY_NAME_DESCRIPTION, responses = {
			@ApiResponse(responseCode = WeatherConstants.CODE_200, description = WeatherConstants.SUCCESSFUL_OPERATION, content = @Content(schema = @Schema(implementation = Temperature.class))),
			@ApiResponse(responseCode = WeatherConstants.CODE_400, description = WeatherConstants.INVALID_LOCATION),
			@ApiResponse(responseCode = WeatherConstants.CODE_404, description = WeatherConstants.LOCATION_NOT_FOUND) })
	@GetMapping(value = "/{locationName}", produces = MediaType.APPLICATION_JSON_VALUE)
	Mono<ResponseEntity<Temperature>> getWeatherByName(
			@Parameter(description = "Location Name", example = "London", required = true) @Validated @PathVariable("locationName") String locationName);

	@Operation(summary = WeatherConstants.GEO_BY_NAME_SUMMARY, description = WeatherConstants.GEO_BY_NAME_DESCRIPTION, responses = {
			@ApiResponse(responseCode = WeatherConstants.CODE_200, description = WeatherConstants.SUCCESSFUL_OPERATION, content = @Content(schema = @Schema(implementation = Geo.class))),
			@ApiResponse(responseCode = WeatherConstants.CODE_400, description = WeatherConstants.INVALID_LOCATION),
			@ApiResponse(responseCode = WeatherConstants.CODE_404, description = WeatherConstants.LOCATION_NOT_FOUND) })
	@GetMapping(value = "/getGeolocationByName/{locationName}", produces = MediaType.APPLICATION_JSON_VALUE)
	Mono<ResponseEntity<Geo>> getGeolocationByName(
			@Parameter(description = "Location Name", example = "London", required = true) @PathVariable String locationName);

	@Operation(summary = WeatherConstants.WEATHER_BY_COORDINATES_SUMMARY, description = WeatherConstants.WEATHER_BY_COORDINATES_DESCRIPTION, responses = {
			@ApiResponse(responseCode = WeatherConstants.CODE_200, description = WeatherConstants.SUCCESSFUL_OPERATION, content = @Content(schema = @Schema(implementation = Geo.class))),
			@ApiResponse(responseCode = WeatherConstants.CODE_400, description = WeatherConstants.INVALID_LOCATION),
			@ApiResponse(responseCode = WeatherConstants.CODE_404, description = WeatherConstants.LOCATION_NOT_FOUND) })
	@GetMapping(value = "/lat/{locationLat}/lon/{locationLon}", produces = MediaType.APPLICATION_JSON_VALUE)
	Mono<ResponseEntity<Weather>> getWeatherByCoodinates(
			@Parameter(description = "Location Latitude", example = "51.5073219", required = true) @Validated @PathVariable String locationLat,
			@Parameter(description = "Location Longitude", example = "-0.1276474", required = true) @Validated @PathVariable String locationLon);

}
