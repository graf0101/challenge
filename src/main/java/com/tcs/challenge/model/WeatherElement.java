package com.tcs.challenge.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
@NoArgsConstructor
public class WeatherElement implements Serializable{
    private static final long serialVersionUID = -4714338008563318690L;
	@lombok.Getter(onMethod_ = {@JsonProperty("id")})
    @lombok.Setter(onMethod_ = {@JsonProperty("id")})
    private Long id;
    @lombok.Getter(onMethod_ = {@JsonProperty("main")})
    @lombok.Setter(onMethod_ = {@JsonProperty("main")})
    private String main;
    @lombok.Getter(onMethod_ = {@JsonProperty("description")})
    @lombok.Setter(onMethod_ = {@JsonProperty("description")})
    private String description;
    @lombok.Getter(onMethod_ = {@JsonProperty("icon")})
    @lombok.Setter(onMethod_ = {@JsonProperty("icon")})
    private String icon;
}
