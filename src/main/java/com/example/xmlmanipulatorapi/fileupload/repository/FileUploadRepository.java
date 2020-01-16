package com.example.xmlmanipulatorapi.fileupload.repository;

import com.example.xmlmanipulatorapi.document.model.CteProc;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FileUploadRepository extends MongoRepository<CteProc, Integer> {
}
