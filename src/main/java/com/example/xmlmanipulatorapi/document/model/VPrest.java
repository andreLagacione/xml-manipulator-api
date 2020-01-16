package com.example.xmlmanipulatorapi.document.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class VPrest {

    @JsonProperty("vTPrest")
    private Double vTPrest;

    @JsonProperty("vRec")
    private Double vRec;

    @JsonProperty("Comp")
    private List<Comp> Comp;

}
