package com.example.xmlmanipulatorapi.document.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Transforms {

    @JsonProperty("Transform")
    private String Transform;

}
