package com.example.xmlmanipulatorapi.document.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Emit {

    @JsonProperty("CNPJ")
    private String CNPJ;

    @JsonProperty("IE")
    private Integer IE;

    @JsonProperty("xNome")
    private String xNome;

    @JsonProperty("xFant")
    private String xFant;

    @JsonProperty("enderEmit")
    private EnderEmit enderEmit;

}
