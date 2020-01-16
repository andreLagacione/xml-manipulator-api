package com.example.xmlmanipulatorapi.document.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class InfCarga {

    @JsonProperty("vCarga")
    private Double vCarga;

    @JsonProperty("proPred")
    private String proPred;

    @JsonProperty("infQ")
    private InfQ infQ;

    @JsonProperty("vCargaAverb")
    private Double vCargaAverb;

}
