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
@XmlRootElement(name = "ide")
public class Ide {

    @XmlElement(name = "cUF")
    private Integer cUF;
    @XmlElement(name = "cCT")
    private Integer cCT;
    @XmlElement(name = "CFOP")
    private Integer CFOP;
    @XmlElement(name = "natOp")
    private String natOp;
    @XmlElement(name = "mod")
    private Integer mod;
    @XmlElement(name = "serie")
    private Integer serie;
    @XmlElement(name = "nCT")
    private Integer nCT;
    @XmlElement(name = "dhEmi")
    private Date dhEmi;
    @XmlElement(name = "tpImp")
    private Integer tpImp;
    @XmlElement(name = "tpEmis")
    private Integer tpEmis;
    @XmlElement(name = "cDV")
    private Integer cDV;
    @XmlElement(name = "tpAmb")
    private Integer tpAmb;
    @XmlElement(name = "tpCTe")
    private Integer tpCTe;
    @XmlElement(name = "procEmi")
    private Integer procEmi;
    @XmlElement(name = "verProc")
    private Integer verProc;
    @XmlElement(name = "cMunEnv")
    private Integer cMunEnv;
    @XmlElement(name = "xMunEnv")
    private String xMunEnv;
    @XmlElement(name = "UFEnv")
    private String UFEnv;
    @XmlElement(name = "modal")
    private Integer modal;
    @XmlElement(name = "tpServ")
    private Integer tpServ;
    @XmlElement(name = "cMunIni")
    private Integer cMunIni;
    @XmlElement(name = "xMunIni")
    private String xMunIni;
    @XmlElement(name = "UFIni")
    private String UFIni;
    @XmlElement(name = "cMunFim")
    private Integer cMunFim;
    @XmlElement(name = "xMunFim")
    private String xMunFim;
    @XmlElement(name = "UFFim")
    private String UFFim;
    @XmlElement(name = "retira")
    private Integer retira;
    @XmlElement(name = "indIEToma")
    private Integer indIEToma;
    @XmlElement(name = "toma3")
    private Toma3 toma3;

}
