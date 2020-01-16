package com.example.xmlmanipulatorapi.document.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Reference {

    @JsonProperty("Transforms")
    private Transforms Transforms;

    @JsonProperty("DigestMethod")
    private String DigestMethod;

    @JsonProperty("DigestValue")
    private String DigestValue;

}
