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
@XmlRootElement(name = "vPrest")
public class VPrest {

    @XmlElement(name = "vTPrest")
    private Double vTPrest;
    @XmlElement(name = "vRec")
    private Double vRec;
    @XmlElement(name = "Comp")
    private List<Comp> Comp;

}
