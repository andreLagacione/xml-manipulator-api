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
@XmlRootElement(name = "valoresImposto")
public class ValoresImposto {

    private String cst;
    private Double vBC;
    private Double pIcms;
    private Double vIcms;
    private Double cfop;
    private Double pCprb;

}
