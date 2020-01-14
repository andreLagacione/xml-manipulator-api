package com.example.xmlmanipulatorapi.document.model;

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
@XmlRootElement(name = "embarcador")
public class Embarcador {

    @XmlElement(name = "cnpjCpf")
    private String cnpjCpf;
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
    @XmlElement(name = "complemento")
    private String complemento;
    @XmlElement(name = "bairro")
    private String bairro;
    @XmlElement(name = "cep")
    private String cep;
    @XmlElement(name = "codPais")
    private Integer codPais;
    @XmlElement(name = "nomePais")
    private String nomePais;
    @XmlElement(name = "fone")
    private String fone;
    @XmlElement(name = "municipio")
    private  Municipio municipio;
    @XmlElement(name = "estado")
    private Estado estado;
    @XmlElement(name = "codRegTrib")
    private Integer codRegTrib;
    @XmlElement(name = "fabrica")
    private Boolean fabrica;
    @XmlElement(name = "tipoPrestacaoServico")
    private Integer tipoPrestacaoServico;

}
