package com.tcs.challenge.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Clouds implements Serializable {
	private static final long serialVersionUID = -5020785043419754519L;
	@lombok.Getter(onMethod_ = { @JsonProperty("all") })
	@lombok.Setter(onMethod_ = { @JsonProperty("all") })
	private Long all;
}
