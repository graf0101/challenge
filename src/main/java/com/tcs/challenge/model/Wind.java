package com.tcs.challenge.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Wind implements Serializable{
    private static final long serialVersionUID = 7182259028164528561L;
	@lombok.Getter(onMethod_ = {@JsonProperty("speed")})
    @lombok.Setter(onMethod_ = {@JsonProperty("speed")})
    private Double speed;
    @lombok.Getter(onMethod_ = {@JsonProperty("deg")})
    @lombok.Setter(onMethod_ = {@JsonProperty("deg")})
    private Long deg;
    @lombok.Getter(onMethod_ = {@JsonProperty("gust")})
    @lombok.Setter(onMethod_ = {@JsonProperty("gust")})
    private Double gust;
}
