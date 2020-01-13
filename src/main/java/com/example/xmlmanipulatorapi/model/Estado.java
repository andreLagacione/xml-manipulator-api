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
@XmlRootElement(name = "estado")
public class Estado {

    @XmlElement(name = "_id")
    private Integer _id;
    @XmlElement(name = "codigoEstado")
    private Integer codigoEstado;
    @XmlElement(name = "sigla")
    private String sigla;
    @XmlElement(name = "nome")
    private String nome;

}
