package com.example.xmlmanipulatorapi.document.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@NoArgsConstructor
@XmlRootElement(name = "ICMS00")
public class ICMS00 {

    @XmlElement(name = "CST")
    private Double CST;
    @XmlElement(name = "vBC")
    private Double vBC;
    @XmlElement(name = "pICMS")
    private Double pICMS;
    @XmlElement(name = "vICMS")
    private Double vICMS;

}
