package com.example.xmlmanipulatorapi.document.service;

import com.example.xmlmanipulatorapi.commons.exceptions.ObjectNotFoundException;
import com.example.xmlmanipulatorapi.document.model.DocumentXml;
import com.example.xmlmanipulatorapi.document.model.DocumentXmlDTO;
import com.example.xmlmanipulatorapi.document.repository.DocumentRepository;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

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
            DocumentXml documentXml = xmlMapper.readValue(readContent, DocumentXml.class);
            this.documentRepository.insert(documentXml);
        } catch (Exception e) {
            throw new Exception("Erro ao processar o arquivo.", e.getCause());
        }

    }

    public List<DocumentXmlDTO> getDocumentos() {
        List<DocumentXml> documentXmlList = this.documentRepository.findAll();
        List<DocumentXmlDTO> documentXmlDTOList = documentXmlList.stream().map(item -> this.mapDocumentsDto(item)).collect(Collectors.toList());
        return documentXmlDTOList;
    }

    private DocumentXmlDTO mapDocumentsDto(DocumentXml documentXml) {
        DocumentXmlDTO documentXmlDTO = new DocumentXmlDTO();
//        documentXmlDTO.setId(documentXml.get_Id());
        documentXmlDTO.setCnpjEmissor(documentXml.getCteProc().getCTe().getInfCte().getEmit().getCNPJ());
        documentXmlDTO.setCidadeCidadeEmissor(documentXml.getCteProc().getCTe().getInfCte().);
        documentXmlDTO.setCnpjRemetente(documentXml.getCteProc().getCTe().getInfCte().);
        documentXmlDTO.setCidadeEstadoRemetente(documentXml.getCteProc().getCTe().getInfCte().);
        documentXmlDTO.setCnpjDestinatario(documentXml.getCteProc().getCTe().getInfCte().);
        documentXmlDTO.setCidadeEstadoDestinatario(documentXml.getCteProc().getCTe().getInfCte().);
        documentXmlDTO.setChaveAcesso(documentXml.getCteProc().getCTe().getInfCte().);
        documentXmlDTO.setDataEmissao(documentXml.getCteProc().getCTe().getInfCte().);
        documentXmlDTO.setEdited(false);
        return documentXmlDTO;
    }

}
