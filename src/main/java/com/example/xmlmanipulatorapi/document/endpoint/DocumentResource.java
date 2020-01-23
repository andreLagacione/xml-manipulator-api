package com.example.xmlmanipulatorapi.document.endpoint;

import com.example.xmlmanipulatorapi.commons.models.PadraoMensagemRetornoDTO;
import com.example.xmlmanipulatorapi.document.model.CteProc;
import com.example.xmlmanipulatorapi.document.model.DocumentListDTO;
import com.example.xmlmanipulatorapi.document.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping(value = "/document")
public class DocumentResource {

    private final DocumentService documentService;

    @Autowired
    public DocumentResource(DocumentService documentService) {
        this.documentService = documentService;
    }

    @PostMapping
    public PadraoMensagemRetornoDTO uploadFile(@RequestParam("file") MultipartFile file) throws Exception {
        this.documentService.readFile(file);
        return new PadraoMensagemRetornoDTO(HttpStatus.OK, HttpStatus.valueOf("OK").value(), "Arquivo enviado com sucesso!");
    }

    @GetMapping
    public DocumentListDTO getDocumentos() {
        return this.documentService.getDocumentos();
    }
}