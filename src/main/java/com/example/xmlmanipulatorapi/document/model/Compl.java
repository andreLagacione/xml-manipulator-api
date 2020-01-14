package com.example.xmlmanipulatorapi.document.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@XmlRootElement(name = "compl")
public class Compl {

    @XmlElement(name = "xCaracAd")
    private String xCaracAd;
    @XmlElement(name = "xObs")
    private String xObs;
    @XmlElement(name = "ObsCont")
    private List<ObsCont> ObsCont;

}
