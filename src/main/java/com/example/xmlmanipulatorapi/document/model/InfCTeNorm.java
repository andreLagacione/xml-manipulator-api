package com.example.xmlmanipulatorapi.document.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class InfCTeNorm {

    @JsonProperty("infCarga")
    private InfCarga infCarga;

    @JsonProperty("infDoc")
    private InfDoc infDoc;

    @JsonProperty("infModal")
    private InfModal infModal;

}
