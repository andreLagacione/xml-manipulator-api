package com.example.xmlmanipulatorapi.editarDocumento.repository;

import com.example.xmlmanipulatorapi.editarDocumento.entity.EditarDocumento;
import org.springframework.data.mongodb.repository.MongoRepository;

import javax.xml.transform.dom.DOMSource;

public interface EditarDocumentoRepository extends MongoRepository<EditarDocumento, Integer> {

}
