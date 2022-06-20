package com.tcs.challenge.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Sys implements Serializable {
    private static final long serialVersionUID = 3045368676501150427L;
	@lombok.Getter(onMethod_ = {@JsonProperty("type")})
    @lombok.Setter(onMethod_ = {@JsonProperty("type")})
    private Long type;
    @lombok.Getter(onMethod_ = {@JsonProperty("id")})
    @lombok.Setter(onMethod_ = {@JsonProperty("id")})
    private Long id;
    @lombok.Getter(onMethod_ = {@JsonProperty("country")})
    @lombok.Setter(onMethod_ = {@JsonProperty("country")})
    private String country;
    @lombok.Getter(onMethod_ = {@JsonProperty("sunrise")})
    @lombok.Setter(onMethod_ = {@JsonProperty("sunrise")})
    private Long sunrise;
    @lombok.Getter(onMethod_ = {@JsonProperty("sunset")})
    @lombok.Setter(onMethod_ = {@JsonProperty("sunset")})
    private Long sunset;
}
