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
public class Coord implements Serializable {
	private static final long serialVersionUID = 4140256635192666126L;
	@lombok.Getter(onMethod_ = { @JsonProperty("lon") })
	@lombok.Setter(onMethod_ = { @JsonProperty("lon") })
	@ApiModelProperty(required = true, example = "-0.1276474", notes="Longitud")
	private Double lon;
	@lombok.Getter(onMethod_ = { @JsonProperty("lat") })
	@lombok.Setter(onMethod_ = { @JsonProperty("lat") })
	@ApiModelProperty(required = true, example = "51.5073219", notes="Latitud")
	private Double lat;
}
