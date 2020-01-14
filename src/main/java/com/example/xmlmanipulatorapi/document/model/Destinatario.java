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
@XmlRootElement(name = "destinatario")
public class Destinatario {

    @XmlElement(name = "codMunicipioDestinatario")
    private Integer codMunicipioDestinatario;
    @XmlElement(name = "NomeMunicipioDestinatario")
    private String NomeMunicipioDestinatario;
    @XmlElement(name = "UfDestinatario")
    private String UfDestinatario;
    @XmlElement(name = "CnpjCpfDestinatario")
    private String CnpjCpfDestinatario;
    @XmlElement(name = "IeDestinatario")
    private String IeDestinatario;
    @XmlElement(name = "RazaoSocialDestinatario")
    private String RazaoSocialDestinatario;
    @XmlElement(name = "LogradouroDestinatario")
    private String LogradouroDestinatario;
    @XmlElement(name = "NumeroDestinatario")
    private String NumeroDestinatario;
    @XmlElement(name = "BairroDestinatario")
    private String BairroDestinatario;
    @XmlElement(name = "CepDestinatario")
    private Integer CepDestinatario;
    @XmlElement(name = "CodPaisDestinatario")
    private Integer CodPaisDestinatario;
    @XmlElement(name = "NomePaisDestinatario")
    private String NomePaisDestinatario;

}
