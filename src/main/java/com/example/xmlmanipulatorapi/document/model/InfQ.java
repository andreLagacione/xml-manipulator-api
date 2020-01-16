package com.example.xmlmanipulatorapi.document.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class InfQ {

    @JsonProperty("cUnid")
    private Double cUnid;

    @JsonProperty("tpMed")
    private String tpMed;

    @JsonProperty("qCarga")
    private Double qCarga;

}
