package com.example.xmlmanipulatorapi.fileupload.service;

import com.example.xmlmanipulatorapi.commons.exceptions.ObjectNotFoundException;
import com.example.xmlmanipulatorapi.document.Document;
import com.example.xmlmanipulatorapi.fileupload.repository.FileUploadRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileUploadService {

    private final FileUploadRepository fileUploadRepository;

    @Autowired
    public FileUploadService(FileUploadRepository fileUploadRepository) {
        this.fileUploadRepository = fileUploadRepository;
    }

    public void readFile(MultipartFile file) throws Exception {

        if (file.isEmpty()) {
            throw new ObjectNotFoundException("Selecione um arquivo para enviar!");
        }

        try {
            byte[] bytes = file.getBytes();
            XmlMapper xmlMapper = new XmlMapper();
            Document document = xmlMapper.readValue(bytes, Document.class);
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(document);

        } catch (Exception e) {
            throw new Exception("Erro ao processar o arquivo.", e.getCause());
        }

    }

}
