package com.example.xmlmanipulatorapi.model;

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
@XmlRootElement(name = "valoresImposto")
public class ValoresImposto {

    @XmlElement(name = "cst")
    private String cst;
    @XmlElement(name = "vBC")
    private Double vBC;
    @XmlElement(name = "pIcms")
    private Double pIcms;
    @XmlElement(name = "vIcms")
    private Double vIcms;
    @XmlElement(name = "cfop")
    private Double cfop;
    @XmlElement(name = "pCprb")
    private Double pCprb;

}
