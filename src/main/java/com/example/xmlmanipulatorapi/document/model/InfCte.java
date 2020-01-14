package com.example.xmlmanipulatorapi.document.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@NoArgsConstructor
@XmlRootElement(name = "infCte")
public class InfCte {

    @XmlElement(name = "ide")
    private Ide ide;
    @XmlElement(name = "compl")
    private Compl compl;
    @XmlElement(name = "emit")
    private Emit emit;
    @XmlElement(name = "rem")
    private Rem rem;
    @XmlElement(name = "dest")
    private Dest dest;
    @XmlElement(name = "vPrest")
    private VPrest vPrest;
    @XmlElement(name = "imp")
    private Imp imp;
    @XmlElement(name = "infCTeNorm")
    private InfCTeNorm infCTeNorm;
    @XmlElement(name = "autXML")
    private AutXML autXML;
    @XmlElement(name = "infRespTec")
    private InfRespTec infRespTec;

}
