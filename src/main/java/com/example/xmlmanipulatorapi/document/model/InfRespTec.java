package com.example.xmlmanipulatorapi.document.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class InfRespTec {

    @JsonProperty("CNPJ")
    private String CNPJ;

    @JsonProperty("xContato")
    private String xContato;

    @JsonProperty("email")
    private String email;

    @JsonProperty("fone")
    private String fone;

}
