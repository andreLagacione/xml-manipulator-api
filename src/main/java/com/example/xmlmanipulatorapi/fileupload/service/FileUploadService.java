package com.example.xmlmanipulatorapi.fileupload.service;

import com.example.xmlmanipulatorapi.commons.exceptions.ObjectNotFoundException;
import com.example.xmlmanipulatorapi.document.model.CteProc;
import com.example.xmlmanipulatorapi.fileupload.repository.FileUploadRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Paths;

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
            XmlMapper xmlMapper = new XmlMapper();
            String readContent = new String(Files.readAllBytes(Paths.get(file.getOriginalFilename())));

            CteProc document = xmlMapper.readValue(readContent, CteProc.class);
            System.out.println("File: " + document);

//            ObjectMapper objectMapper = new ObjectMapper();
//            String json = objectMapper.writeValueAsString(document);

        } catch (Exception e) {
            throw new Exception("Erro ao processar o arquivo.", e.getCause());
        }

    }

}
