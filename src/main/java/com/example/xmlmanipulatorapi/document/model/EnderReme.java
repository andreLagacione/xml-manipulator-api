package com.example.xmlmanipulatorapi.document.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@NoArgsConstructor
@XmlRootElement(name = "enderReme")
public class EnderReme {

    @XmlElement(name = "xLgr")
    private String xLgr;
    @XmlElement(name = "nro")
    private String nro;
    @XmlElement(name = "xCpl")
    private String xCpl;
    @XmlElement(name = "xBairro")
    private String xBairro;
    @XmlElement(name = "cMun")
    private Integer cMun;
    @XmlElement(name = "xMun")
    private String xMun;
    @XmlElement(name = "CEP")
    private Integer CEP;
    @XmlElement(name = "UF")
    private String UF;
    @XmlElement(name = "cPais")
    private Integer cPais;
    @XmlElement(name = "xPais")
    private String xPais;

}
