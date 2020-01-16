package com.example.xmlmanipulatorapi.document.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ICMS00 {

    @JsonProperty("CST")
    private Double CST;

    @JsonProperty("vBC")
    private Double vBC;

    @JsonProperty("pICMS")
    private Double pICMS;

    @JsonProperty("vICMS")
    private Double vICMS;

}
