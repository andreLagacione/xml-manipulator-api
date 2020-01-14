package com.example.xmlmanipulatorapi.document.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@NoArgsConstructor
@XmlRootElement(name = "SignedInfo")
public class SignedInfo {

    @XmlElement(name = "CanonicalizationMethod")
    private String CanonicalizationMethod;
    @XmlElement(name = "SignatureMethod")
    private String SignatureMethod;
    @XmlElement(name = "Reference")
    private Reference Reference;

}
