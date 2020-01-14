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
@XmlRootElement(name = "municipio")
public class Municipio {

    @XmlElement(name = "_id")
    private Integer _id;
    @XmlElement(name = "codigoIbge")
    private Integer codigoIbge;
    @XmlElement(name = "nome")
    private String nome;
    @XmlElement(name = "estado")
    private Integer estado;
    @XmlElement(name = "aliquota")
    private Double aliquota;
    @XmlElement(name = "emissaoNFSeManual")
    private Boolean emissaoNFSeManual;

}
