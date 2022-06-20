package com.tcs.challenge;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.tcs.challenge.model.Geo;
import com.tcs.challenge.model.Temperature;
import com.tcs.challenge.model.Weather;

@ContextConfiguration(classes = SpringBootRestExampleApplication.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:api_weather.properties")
class WeatherRouterTest {

	@Autowired
	private WebTestClient webTestClient;

	@Value("${api-weather.host}")
	private String host;

	@Test
	void testPropertieFile() {
		assertThat(host).isEqualTo("http://api.openweathermap.org");
	}

	@Test
	void testGetWeatherByName() {
		String locationName = "London";
		webTestClient.get().uri("/location/search/{locationName}", locationName).accept(MediaType.APPLICATION_JSON)
				.exchange().expectStatus().isOk().expectBody(Temperature.class).value(w -> {
					assertThat(w).isNotNull();
				});
	}

	@Test
	void testGetGeolocationByName() {
		String locationName = "London";
		webTestClient.get().uri("/location/search/getGeolocationByName/{locationName}", locationName)
				.accept(MediaType.APPLICATION_JSON).exchange().expectStatus().isOk().expectBody(Geo.class).value(w -> {
					assertThat(w).isNotNull();
				});
	}

	@Test
	void testGetWeatherByCoodinates() {
		String locationLat = "51.5073219";
		String locationLon = "-0.1276474";
		webTestClient.get().uri("/location/search/lat/{locationLat}/lon/{locationLon}", locationLat, locationLon)
				.accept(MediaType.APPLICATION_JSON).exchange().expectStatus().isOk().expectBody(Weather.class)
				.value(w -> {
					assertThat(w).isNotNull();
				});
	}

}