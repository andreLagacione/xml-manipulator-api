package com.example.xmlmanipulatorapi.document.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@NoArgsConstructor
@XmlRootElement(name = "infCTeNorm")
public class InfCTeNorm {

    @XmlElement(name = "infCarga")
    private InfCarga infCarga;
    @XmlElement(name = "infDoc")
    private InfDoc infDoc;
    @XmlElement(name = "infModal")
    private InfModal infModal;

}
