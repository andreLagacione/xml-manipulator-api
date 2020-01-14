package com.example.xmlmanipulatorapi.document.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@NoArgsConstructor
@XmlRootElement(name = "enderEmit")
public class EnderEmit {

    @XmlElement(name = "xLgr")
    private String xLgr;
    @XmlElement(name = "nro")
    private String nro;
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

}
