package com.example.xmlmanipulatorapi.document.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@NoArgsConstructor
@XmlRootElement(name = "CTe")
public class CTe {

    @XmlElement(name = "infCte")
    private InfCte infCte;
    @XmlElement(name = "infCTeSupl")
    private InfCTeSupl infCTeSupl;
    @XmlElement(name = "Signature")
    private Signature Signature;

}
