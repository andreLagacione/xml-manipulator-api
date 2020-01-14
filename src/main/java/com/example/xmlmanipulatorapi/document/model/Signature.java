package com.example.xmlmanipulatorapi.document.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@NoArgsConstructor
@XmlRootElement(name = "Signature")
public class Signature {

    @XmlElement(name = "SignedInfo")
    private SignedInfo SignedInfo;
    @XmlElement(name = "SignatureValue")
    private String SignatureValue;
    @XmlElement(name = "KeyInfo")
    private KeyInfo KeyInfo;

}
