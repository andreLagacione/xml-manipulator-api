package com.example.xmlmanipulatorapi.document.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SignedInfo {

    @JsonProperty("CanonicalizationMethod")
    private String CanonicalizationMethod;

    @JsonProperty("SignatureMethod")
    private String SignatureMethod;

    @JsonProperty("Reference")
    private Reference Reference;

}
