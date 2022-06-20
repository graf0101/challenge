package com.tcs.challenge.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Weather implements Serializable{
    private static final long serialVersionUID = -544344479266026307L;
	@lombok.Getter(onMethod_ = {@JsonProperty("coord")})
    @lombok.Setter(onMethod_ = {@JsonProperty("coord")})
    private Coord coord;
    @lombok.Getter(onMethod_ = {@JsonProperty("weather")})
    @lombok.Setter(onMethod_ = {@JsonProperty("weather")})
    private List<WeatherElement> weather;
    @lombok.Getter(onMethod_ = {@JsonProperty("base")})
    @lombok.Setter(onMethod_ = {@JsonProperty("base")})
    private String base;
    @lombok.Getter(onMethod_ = {@JsonProperty("main")})
    @lombok.Setter(onMethod_ = {@JsonProperty("main")})
    private Temperature temperature;
    @lombok.Getter(onMethod_ = {@JsonProperty("visibility")})
    @lombok.Setter(onMethod_ = {@JsonProperty("visibility")})
    private Long visibility;
    @lombok.Getter(onMethod_ = {@JsonProperty("wind")})
    @lombok.Setter(onMethod_ = {@JsonProperty("wind")})
    private Wind wind;
    @lombok.Getter(onMethod_ = {@JsonProperty("clouds")})
    @lombok.Setter(onMethod_ = {@JsonProperty("clouds")})
    private Clouds clouds;
    @lombok.Getter(onMethod_ = {@JsonProperty("dt")})
    @lombok.Setter(onMethod_ = {@JsonProperty("dt")})
    private Long dt;
    @lombok.Getter(onMethod_ = {@JsonProperty("sys")})
    @lombok.Setter(onMethod_ = {@JsonProperty("sys")})
    private Sys sys;
    @lombok.Getter(onMethod_ = {@JsonProperty("timezone")})
    @lombok.Setter(onMethod_ = {@JsonProperty("timezone")})
    private Long timezone;
    @lombok.Getter(onMethod_ = {@JsonProperty("id")})
    @lombok.Setter(onMethod_ = {@JsonProperty("id")})
    private Long id;
    @lombok.Getter(onMethod_ = {@JsonProperty("name")})
    @lombok.Setter(onMethod_ = {@JsonProperty("name")})
    private String name;
    @lombok.Getter(onMethod_ = {@JsonProperty("cod")})
    @lombok.Setter(onMethod_ = {@JsonProperty("cod")})
    private Long cod;
}
