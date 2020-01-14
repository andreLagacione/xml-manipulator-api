package com.example.xmlmanipulatorapi.document.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@NoArgsConstructor
@XmlRootElement(name = "protCTe")
public class ProtCTe {

    @XmlElement(name = "infProt")
    private InfProt infProt;

}
