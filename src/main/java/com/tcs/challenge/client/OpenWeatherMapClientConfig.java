package com.tcs.challenge.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;

import com.tcs.challenge.config.ApiWeatherProperties;
import com.tcs.challenge.exception.ClientError;
import com.tcs.challenge.exception.ServerError;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
@Slf4j
public class OpenWeatherMapClientConfig {
	@Autowired
	@Setter
	ApiWeatherProperties apiProps;

    @Bean
    WebClient webClient() {
        ExchangeFilterFunction errorFilter = ExchangeFilterFunction
                .ofResponseProcessor(this::exchangeFilterResponseProcessor);

        return WebClient.builder().baseUrl(apiProps.getHost())
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).filter(errorFilter).build();
    }

	private Mono<ClientResponse> exchangeFilterResponseProcessor(ClientResponse response) {
		HttpStatus status = response.statusCode();
		if (status.is5xxServerError()) {
			return response.bodyToMono(String.class).flatMap(body -> Mono.error(new ServerError(status, body)));
		}
		if (status.is4xxClientError()) {
			return response.bodyToMono(String.class).flatMap(body -> {
				log.error("body = {}", body);
				return Mono.error(new ClientError(status, body));
			});
		}
		return Mono.just(response);
	}
}