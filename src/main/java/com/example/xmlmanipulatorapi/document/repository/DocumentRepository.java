package com.example.xmlmanipulatorapi.document.repository;

import com.example.xmlmanipulatorapi.document.model.CteProc;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DocumentRepository extends MongoRepository<CteProc, Integer> {
}
