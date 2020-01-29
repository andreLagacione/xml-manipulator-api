package com.example.xmlmanipulatorapi.editarDocumento.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.xml.transform.dom.DOMSource;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "xpathDocument")
public class EditarDocumento {

    private DOMSource file;

}
