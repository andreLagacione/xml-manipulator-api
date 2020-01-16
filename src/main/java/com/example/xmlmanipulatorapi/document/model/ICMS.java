package com.example.xmlmanipulatorapi.document.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ICMS {

    @JsonProperty("ICMS00")
    private ICMS00 ICMS00;

}
