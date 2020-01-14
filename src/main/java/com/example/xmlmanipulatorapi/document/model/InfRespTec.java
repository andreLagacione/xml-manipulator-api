package com.example.xmlmanipulatorapi.document.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@NoArgsConstructor
@XmlRootElement(name = "infRespTec")
public class InfRespTec {

    @XmlElement(name = "CNPJ")
    private String CNPJ;
    @XmlElement(name = "xContato")
    private String xContato;
    @XmlElement(name = "email")
    private String email;
    @XmlElement(name = "fone")
    private String fone;

}
