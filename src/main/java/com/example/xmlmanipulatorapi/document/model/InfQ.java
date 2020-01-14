package com.example.xmlmanipulatorapi.document.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@NoArgsConstructor
@XmlRootElement(name = "infQ")
public class InfQ {

    @XmlElement(name = "cUnid")
    private Double cUnid;
    @XmlElement(name = "tpMed")
    private String tpMed;
    @XmlElement(name = "qCarga")
    private Double qCarga;

}
