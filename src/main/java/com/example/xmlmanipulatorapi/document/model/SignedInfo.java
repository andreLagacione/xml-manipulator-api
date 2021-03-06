package com.example.xmlmanipulatorapi.document.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SignedInfo {

    @JsonProperty("CanonicalizationMethod")
    private String CanonicalizationMethod;

    @JsonProperty("SignatureMethod")
    private String SignatureMethod;

    @JsonProperty("Reference")
    private Reference Reference;

}
