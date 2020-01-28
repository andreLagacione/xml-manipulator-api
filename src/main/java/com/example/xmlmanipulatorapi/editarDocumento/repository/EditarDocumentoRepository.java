package com.example.xmlmanipulatorapi.editarDocumento.repository;

import com.example.xmlmanipulatorapi.editarDocumento.entity.EditarDocumento;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface XpathRepository extends MongoRepository<EditarDocumento, Integer> {
}
