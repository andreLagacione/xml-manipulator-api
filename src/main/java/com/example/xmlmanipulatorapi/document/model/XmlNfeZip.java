package com.example.xmlmanipulatorapi.document.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "xmlNfeZip")
public class XmlNfeZip {

    @XmlElement(name = "chaveAcesso")
    private String chaveAcesso;
    @XmlElement(name = "serieNFe")
    private String serieNFe;
    @XmlElement(name = "numeroNFe")
    private String numeroNFe;
    @XmlElement(name = "valorFrete")
    private String valorFrete;

}
