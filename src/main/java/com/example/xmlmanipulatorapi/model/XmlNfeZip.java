package com.example.xmlmanipulatorapi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "xmlNfeZip")
public class XmlNfeZip {

    private String chaveAcesso;
    private String serieNFe;
    private String numeroNFe;
    private String valorFrete;

}
