package com.example.xmlmanipulatorapi.document.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CTe {

    @JsonProperty("infCte")
    private InfCte infCte;

    @JsonProperty("infCTeSupl")
    private InfCTeSupl infCTeSupl;

    @JsonProperty("Signature")
    private Signature Signature;

}
