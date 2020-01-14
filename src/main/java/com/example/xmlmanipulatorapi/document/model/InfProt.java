package com.example.xmlmanipulatorapi.document.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@XmlRootElement(name = "infProt")
public class InfProt {

    @XmlElement(name = "tpAmb")
    private Integer tpAmb;
    @XmlElement(name = "verAplic")
    private String verAplic;
    @XmlElement(name = "chCTe")
    private String chCTe;
    @XmlElement(name = "dhRecbto")
    private Date dhRecbto;
    @XmlElement(name = "nProt")
    private String nProt;
    @XmlElement(name = "digVal")
    private String digVal;
    @XmlElement(name = "cStat")
    private Integer cStat;
    @XmlElement(name = "xMotivo")
    private String xMotivo;

}
