package com.tcs.challenge.model;

import java.io.Serializable;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Geo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2756916306859371764L;
	@lombok.Getter(onMethod_ = { @JsonProperty("name") })
	@lombok.Setter(onMethod_ = { @JsonProperty("name") })
	@ApiModelProperty(required = true, example = "Londres", notes="Nombre Ciudad")
	private String name;
	@lombok.Getter(onMethod_ = { @JsonProperty("local_names") })
	@lombok.Setter(onMethod_ = { @JsonProperty("local_names") })
	private Map<String, String> localNames;
	@lombok.Getter(onMethod_ = { @JsonProperty("lat") })
	@lombok.Setter(onMethod_ = { @JsonProperty("lat") })
	@ApiModelProperty(required = true, example = "51.5073219", notes="Latitud")
	private Double lat;
	@lombok.Getter(onMethod_ = { @JsonProperty("lon") })
	@lombok.Setter(onMethod_ = { @JsonProperty("lon") })
	@ApiModelProperty(required = true, example = "-0.1276474", notes="Longitud")
	private Double lon;
	@lombok.Getter(onMethod_ = { @JsonProperty("country") })
	@lombok.Setter(onMethod_ = { @JsonProperty("country") })
	@ApiModelProperty(required = true, example = "CL", notes="Código de país")
	private String country;
	@lombok.Getter(onMethod_ = { @JsonProperty("state") })
	@lombok.Setter(onMethod_ = { @JsonProperty("state") })
	@ApiModelProperty(required = true, example = "England", notes="Estado")
	private String state;
}
