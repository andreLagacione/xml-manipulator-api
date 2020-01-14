package com.example.xmlmanipulatorapi.document.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@NoArgsConstructor
@XmlRootElement(name = "Reference")
public class Reference {

    @XmlElement(name = "Transforms")
    private Transforms Transforms;
    @XmlElement(name = "DigestMethod")
    private String DigestMethod;
    @XmlElement(name = "DigestValue")
    private String DigestValue;

}
