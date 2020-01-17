package com.example.xmlmanipulatorapi.document.service;

import com.example.xmlmanipulatorapi.commons.exceptions.ObjectNotFoundException;
import com.example.xmlmanipulatorapi.document.model.CteProc;
import com.example.xmlmanipulatorapi.document.model.DocumentListDTO;
import com.example.xmlmanipulatorapi.document.repository.DocumentRepository;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Service
public class DocumentService {

    private final DocumentRepository documentRepository;

    @Autowired
    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
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

            this.documentRepository.insert(document);


        } catch (Exception e) {
            throw new Exception("Erro ao processar o arquivo.", e.getCause());
        }

    }

    public DocumentListDTO getDocumentos() {
        List<CteProc> cteProcList = this.documentRepository.findAll();
        return new DocumentListDTO(cteProcList);
    }

}
