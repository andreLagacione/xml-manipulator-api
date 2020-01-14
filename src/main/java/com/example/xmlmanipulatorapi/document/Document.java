package com.example.xmlmanipulatorapi.document;

import com.example.xmlmanipulatorapi.document.model.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@XmlRootElement(name = "documento")
public class Document {

    @XmlElement(name = "_id")
    private String _id;
    @XmlElement(name = "_class")
    private String _class;
    @XmlElement(name = "cUnid")
    private Integer cUnid;
    @XmlElement(name = "tpMed")
    private String tpMed;
    @XmlElement(name = "respSeg")
    private String respSeg;
    @XmlElement(name = "xSeg")
    private String xSeg;
    @XmlElement(name = "nApol")
    private String nApol;
    @XmlElement(name = "tpProp")
    private String tpProp;
    @XmlElement(name = "diferencialAliquota")
    private Boolean diferencialAliquota;
    @XmlElement(name = "idTag")
    private String idTag;
    @XmlElement(name = "cUF")
    private Integer cUF;
    @XmlElement(name = "cCT")
    private Integer cCT;
    @XmlElement(name = "cfop")
    private Integer cfop;
    @XmlElement(name = "forPag")
    private Integer forPag;
    @XmlElement(name = "mod")
    private Integer mod;
    @XmlElement(name = "serie")
    private String serie;
    @XmlElement(name = "nCt")
    private Integer nCt;
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
    private String verProc;
    @XmlElement(name = "cMunEmi")
    private Integer cMunEmi;
    @XmlElement(name = "xMunEmi")
    private String xMunEmi;
    @XmlElement(name = "ufEmi")
    private String ufEmi;
    @XmlElement(name = "modal")
    private Integer modal;
    @XmlElement(name = "tpServ")
    private Integer tpServ;
    @XmlElement(name = "cMunIni")
    private Integer cMunIni;
    @XmlElement(name = "xMunIni")
    private String xMunIni;
    @XmlElement(name = "cMunFim")
    private Integer cMunFim;
    @XmlElement(name = "xMunFim")
    private String xMunFim;
    @XmlElement(name = "retira")
    private Integer retira;
    @XmlElement(name = "toma")
    private Integer toma;
    @XmlElement(name = "xCaracAd")
    private String xCaracAd;
    @XmlElement(name = "xObs")
    private String xObs;
    @XmlElement(name = "tpPer")
    private Integer tpPer;
    @XmlElement(name = "ieTransp")
    private String ieTransp;
    @XmlElement(name = "xNomeTransp")
    private String xNomeTransp;
    @XmlElement(name = "xFantTransp")
    private String xFantTransp;
    @XmlElement(name = "xLgrTransp")
    private String xLgrTransp;
    @XmlElement(name = "nroTransp")
    private String nroTransp;
    @XmlElement(name = "xBairroTransp")
    private String xBairroTransp;
    @XmlElement(name = "cMunTransp")
    private Integer cMunTransp;
    @XmlElement(name = "xMunTransp")
    private String xMunTransp;
    @XmlElement(name = "cepTransp")
    private String cepTransp;
    @XmlElement(name = "ieEmb")
    private String ieEmb;
    @XmlElement(name = "xNomeEmb")
    private String xNomeEmb;
    @XmlElement(name = "xFantEmb")
    private String xFantEmb;
    @XmlElement(name = "xLgrEmb")
    private String xLgrEmb;
    @XmlElement(name = "nroEmb")
    private String nroEmb;
    @XmlElement(name = "xBairroEmb")
    private String xBairroEmb;
    @XmlElement(name = "cMunEmb")
    private Integer cMunEmb;
    @XmlElement(name = "xMunEmb")
    private String xMunEmb;
    @XmlElement(name = "cepEmb")
    private String cepEmb;
    @XmlElement(name = "ufEmb")
    private String ufEmb;
    @XmlElement(name = "cPaisEmb")
    private Integer cPaisEmb;
    @XmlElement(name = "xPaisEmb")
    private String xPaisEmb;
    @XmlElement(name = "xNomeDest")
    private String xNomeDest;
    @XmlElement(name = "xLgrDest")
    private String xLgrDest;
    @XmlElement(name = "nroDest")
    private String nroDest;
    @XmlElement(name = "xBairroDest")
    private String xBairroDest;
    @XmlElement(name = "cMunDest")
    private Integer cMunDest;
    @XmlElement(name = "xMunDest")
    private String xMunDest;
    @XmlElement(name = "cepDest")
    private Integer cepDest;
    @XmlElement(name = "ufDest")
    private String ufDest;
    @XmlElement(name = "cPaisDest")
    private Integer cPaisDest;
    @XmlElement(name = "xPaisDest")
    private String xPaisDest;
    @XmlElement(name = "cst")
    private Integer cst;
    @XmlElement(name = "vBC")
    private Double vBC;
    @XmlElement(name = "pIcms")
    private Double pIcms;
    @XmlElement(name = "vIcms")
    private Double vIcms;
    @XmlElement(name = "xNomeComponenteICMS")
    private String xNomeComponenteICMS;
    @XmlElement(name = "xnomeComponenteFrete")
    private String xnomeComponenteFrete;
    @XmlElement(name = "rntrc")
    private Long rntrc;
    @XmlElement(name = "dPrev")
    private Date dPrev;
    @XmlElement(name = "lota")
    private Integer lota;
    @XmlElement(name = "observacoesTextosFiscais")
    private String observacoesTextosFiscais;
    @XmlElement(name = "tipoEntrega")
    private Integer tipoEntrega;
    @XmlElement(name = "chaveMDFe")
    private String chaveMDFe;
    @XmlElement(name = "total")
    private Integer total;
    @XmlElement(name = "versaoCte")
    private String versaoCte;
    @XmlElement(name = "valoresImpostos")
    private ValoresImposto valoresImpostos;
    @XmlElement(name = "xmlNFeZip")
    private List<XmlNfeZip> xmlNFeZip;
    @XmlElement(name = "embarcador")
    private Embarcador embarcador;
    @XmlElement(name = "transportador")
    private Transportador transportador;
    @XmlElement(name = "destinatario")
    private Destinatario destinatario;
    @XmlElement(name = "proPred")
    private String proPred;
    @XmlElement(name = "vComponenteFrete")
    private Double vComponenteFrete;
    @XmlElement(name = "qCarga")
    private Double qCarga;
    @XmlElement(name = "vMerc")
    private Double vMerc;
    @XmlElement(name = "vRec")
    private Double vRec;
    @XmlElement(name = "vFreteCapa")
    private Double vFreteCapa;
    @XmlElement(name = "vComponenteICMS")
    private Double vComponenteICMS;
    @XmlElement(name = "tpGeracao")
    private String tpGeracao;
    @XmlElement(name = "natOp")
    private String natOp;
    @XmlElement(name = "vMercSeguro")
    private Double vMercSeguro;
    @XmlElement(name = "motoristaCpf")
    private String motoristaCpf;
    @XmlElement(name = "placa")
    private String placa;
    @XmlElement(name = "modFrete")
    private String modFrete;
    @XmlElement(name = "dhEmitFormat")
    private Date dhEmitFormat;
    @XmlElement(name = "emiteHbnmsg")
    private Boolean emiteHbnmsg;
    @XmlElement(name = "codRetornoSefaz")
    private Integer codRetornoSefaz;
    @XmlElement(name = "dataCriacao")
    private Date dataCriacao;
    @XmlElement(name = "situacaoMensageria")
    private Integer situacaoMensageria;
    @XmlElement(name = "cnpjEmbarcador")
    private String cnpjEmbarcador;
    @XmlElement(name = "cnpjTransportador")
    private String cnpjTransportador;
    @XmlElement(name = "cnpjDestinatario")
    private String cnpjDestinatario;
    @XmlElement(name = "tipoDocumento")
    private String tipoDocumento;
    @XmlElement(name = "codTransacaoPortal")
    private Integer codTransacaoPortal;
    @XmlElement(name = "chaveAcesso")
    private String chaveAcesso;
    @XmlElement(name = "parentId")
    private String parentId;
    @XmlElement(name = "nrCapa")
    private Integer nrCapa;
    @XmlElement(name = "nrMapa")
    private Integer nrMapa;
    @XmlElement(name = "qtdeCompl")
    private Integer qtdeCompl;
    @XmlElement(name = "erpOrigem")
    private String erpOrigem;
    @XmlElement(name = "erpNotificacao")
    private String erpNotificacao;
    @XmlElement(name = "capaOrigem")
    private String capaOrigem;
    @XmlElement(name = "puxada")
    private Boolean puxada;
    @XmlElement(name = "DT")
    private String DT;
    @XmlElement(name = "VBZ")
    private String VBZ;
    @XmlElement(name = "cidadeOrigem")
    private String cidadeOrigem;
    @XmlElement(name = "estadoOrigem")
    private String estadoOrigem;
    @XmlElement(name = "cidadeDestino")
    private String cidadeDestino;
    @XmlElement(name = "estadoDestino")
    private String estadoDestino;
    @XmlElement(name = "vTPrest")
    private Double vTPrest;
    @XmlElement(name = "ticketMensageria")
    private String ticketMensageria;
    @XmlElement(name = "descricaoRetornoSefaz")
    private String descricaoRetornoSefaz;
    @XmlElement(name = "xml")
    private String xml;
    @XmlElement(name = "dataAutorizacaoPortal")
    private Date dataAutorizacaoPortal;

}
