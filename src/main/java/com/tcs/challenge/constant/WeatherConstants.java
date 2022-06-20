package com.tcs.challenge.constant;

public class WeatherConstants {
	
	private WeatherConstants() {
		//
	}

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

}
