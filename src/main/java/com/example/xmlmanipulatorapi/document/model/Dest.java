package com.example.xmlmanipulatorapi.document.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@NoArgsConstructor
@XmlRootElement(name = "dest")
public class Dest {

    @XmlElement(name = "CNPJ")
    private String CNPJ;
    @XmlElement(name = "IE")
    private Integer IE;
    @XmlElement(name = "xNome")
    private String xNome;
    @XmlElement(name = "enderDest")
    private EnderDest enderDest;

}
