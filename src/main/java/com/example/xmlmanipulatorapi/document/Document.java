package com.example.xmlmanipulatorapi.document.model;

import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "document")
public class Document {

    @Id
    private String id;



}
