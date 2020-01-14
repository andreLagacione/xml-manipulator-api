package com.example.xmlmanipulatorapi.fileupload.repository;

import com.example.xmlmanipulatorapi.document.Document;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FileUploadRepository extends MongoRepository<Document, Integer> {
}
