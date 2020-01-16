package com.example.xmlmanipulatorapi.document.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Compl {

    @JsonProperty("xCaracAd")
    private String xCaracAd;

    @JsonProperty("xObs")
    private String xObs;

    @JsonProperty("ObsCont")
    private List<ObsCont> ObsCont = new ArrayList<>();

}
