package com.example.xmlmanipulatorapi.document.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@NoArgsConstructor
@XmlRootElement(name = "infCarga")
public class InfCarga {

    @XmlElement(name = "vCarga")
    private Double vCarga;
    @XmlElement(name = "proPred")
    private String proPred;
    @XmlElement(name = "infQ")
    private InfQ infQ;
    @XmlElement(name = "vCargaAverb")
    private Double vCargaAverb;

}
