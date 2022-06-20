package com.tcs.challenge.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.*;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Temperature implements Serializable {
	private static final long serialVersionUID = 2191462452867850295L;
	@lombok.Getter(onMethod_ = { @JsonProperty("temp") })
	@lombok.Setter(onMethod_ = { @JsonProperty("temp") })
	@ApiModelProperty(required = true, example = "10.42", notes="Temperatura")
	private Double temp;
	@lombok.Getter(onMethod_ = { @JsonProperty("feels_like") })
	@lombok.Setter(onMethod_ = { @JsonProperty("feels_like") })
	@ApiModelProperty(required = true, example = "9.84", notes="Sensación térmica")
	private Double feelsLike;
	@lombok.Getter(onMethod_ = { @JsonProperty("temp_min") })
	@lombok.Setter(onMethod_ = { @JsonProperty("temp_min") })
	@ApiModelProperty(required = true, example = "5", notes="Temperatura Min.")
	private Double tempMin;
	@lombok.Getter(onMethod_ = { @JsonProperty("temp_max") })
	@lombok.Setter(onMethod_ = { @JsonProperty("temp_max") })
	@ApiModelProperty(required = true, example = "22", notes="Temperatura Max.")
	private Double tempMax;
	@lombok.Getter(onMethod_ = { @JsonProperty("pressure") })
	@lombok.Setter(onMethod_ = { @JsonProperty("pressure") })
	@ApiModelProperty(required = true, example = "1015", notes="Presión PSI")
	private Long pressure;
	@lombok.Getter(onMethod_ = { @JsonProperty("humidity") })
	@lombok.Setter(onMethod_ = { @JsonProperty("humidity") })
	@ApiModelProperty(required = true, example = "90", notes="% Humedad")
	private Long humidity;
}
