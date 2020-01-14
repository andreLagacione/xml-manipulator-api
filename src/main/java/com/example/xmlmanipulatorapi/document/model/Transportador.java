package com.example.xmlmanipulatorapi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "transportador")
public class Transportador {

    @XmlElement(name = "_id")
    private Integer _id;
    @XmlElement(name = "regimeTributario")
    private String regimeTributario;
    @XmlElement(name = "cnpjCpf")
    private String cnpjCpf;
    @XmlElement(name = "serieCTe")
    private String serieCTe;
    @XmlElement(name = "serie")
    private String serie;
    @XmlElement(name = "serieMDFe")
    private String serieMDFe;
    @XmlElement(name = "ie")
    private String ie;
    @XmlElement(name = "nomeRazaoSocial")
    private String nomeRazaoSocial;
    @XmlElement(name = "nomeFantasia")
    private String nomeFantasia;
    @XmlElement(name = "logradouro")
    private String logradouro;
    @XmlElement(name = "nrLogradouro")
    private String nrLogradouro;
    @XmlElement(name = "bairro")
    private String bairro;
    @XmlElement(name = "cep")
    private String cep;
    @XmlElement(name = "nomeSeguradora")
    private String nomeSeguradora;
    @XmlElement(name = "numeroApoliceSeguro")
    private String numeroApoliceSeguro;
    @XmlElement(name = "nomeSeguradoraSecundaria")
    private String nomeSeguradoraSecundaria;
    @XmlElement(name = "numeroApoliceSeguroSecundaria")
    private String numeroApoliceSeguroSecundaria;
    @XmlElement(name = "rntrc")
    private Long rntrc;
    @XmlElement(name = "municipio")
    private Municipio municipio;
    @XmlElement(name = "estado")
    private Estado estado;
    @XmlElement(name = "email")
    private String email;
    @XmlElement(name = "im")
    private String im;
    @XmlElement(name = "codigoRegistroServico")
    private String codigoRegistroServico;
    @XmlElement(name = "issRetidoFonte")
    private Boolean issRetidoFonte;
    @XmlElement(name = "codigoTributacaoMunicipal")
    private String codigoTributacaoMunicipal;
    @XmlElement(name = "regimeEspecialTributacao")
    private Boolean regimeEspecialTributacao;
    @XmlElement(name = "emissaoNFSeManual")
    private Boolean emissaoNFSeManual;
    @XmlElement(name = "emissaoSegundaQuinzenaNaCompetenciaAnterior")
    private Boolean emissaoSegundaQuinzenaNaCompetenciaAnterior;
    @XmlElement(name = "caminhoCertificado")
    private String caminhoCertificado;
    @XmlElement(name = "senhaCertificado")
    private String senhaCertificado;
    @XmlElement(name = "emailPuxada")
    private String emailPuxada;
    @XmlElement(name = "porcentualCPRB")
    private Double porcentualCPRB;
    @XmlElement(name = "emiteMDFe")
    private Boolean emiteMDFe;
    @XmlElement(name = "emiteMDFeIntermunicipal")
    private Boolean emiteMDFeIntermunicipal;
    @XmlElement(name = "emiteMDFeIntermunicipal")
    private Boolean creditoPresumido;
    @XmlElement(name = "dedicada")
    private Boolean dedicada;
    @XmlElement(name = "spot")
    private Boolean spot;
    @XmlElement(name = "autoseguro")
    private Boolean autoseguro;
    @XmlElement(name = "cnpjSeguradora")
    private String cnpjSeguradora;
    @XmlElement(name = "seguroContingenciaRota")
    private Boolean seguroContingenciaRota;
    @XmlElement(name = "seguroContingenciaPuxada")
    private Boolean seguroContingenciaPuxada;
    @XmlElement(name = "responsavelSeguro")
    private String responsavelSeguro;
    @XmlElement(name = "tipoTransportador")
    private String tipoTransportador;
    @XmlElement(name = "versaoCte")
    private String versaoCte;

}
