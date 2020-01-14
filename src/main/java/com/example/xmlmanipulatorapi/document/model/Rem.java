package com.example.xmlmanipulatorapi.document.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@NoArgsConstructor
@XmlRootElement(name = "rem")
public class Rem {

    @XmlElement(name = "CNPJ")
    private String CNPJ;
    @XmlElement(name = "IE")
    private String IE;
    @XmlElement(name = "xNome")
    private String xNome;
    @XmlElement(name = "xFant")
    private String xFant;
    @XmlElement(name = "enderReme")
    private EnderReme enderReme;

}
