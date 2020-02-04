package com.example.xmlmanipulatorapi.manipulateDocument.endpoint;

import com.example.xmlmanipulatorapi.commons.models.PadraoMensagemRetornoDTO;
import com.example.xmlmanipulatorapi.manipulateDocument.service.ManipulateDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/edited-document")
public class ManipulateDocumentResource {

    private final ManipulateDocumentService manipulateDocumentService;

    @Autowired
    public ManipulateDocumentResource(ManipulateDocumentService manipulateDocumentService) {
        this.manipulateDocumentService = manipulateDocumentService;
    }

    @PostMapping
    @RequestMapping(value = "/create")
    public PadraoMensagemRetornoDTO createDocumentEdited(
            @RequestParam("file") MultipartFile file,
            @RequestParam("tagName") String tagName,
            @RequestParam("tagValue") String tagValue
    ) throws Exception {
        String content = this.manipulateDocumentService.processarDocumento(file, tagName, tagValue);
        return new PadraoMensagemRetornoDTO(HttpStatus.OK, HttpStatus.valueOf("OK").value(), "Arquivo editado com sucesso!", content);
    }

    @PostMapping
    @RequestMapping(value = "/edit")
    public String saveDocumentEdited(
            @RequestParam("xmlDocument") String xmlDocument,
            @RequestParam("oldTagName") String oldTagName,
            @RequestParam("newTagName") String newTagName,
            @RequestParam("tagValue") String tagValue
    ) throws Exception {
        return this.manipulateDocumentService.saveDocumentEdited(xmlDocument, oldTagName, newTagName, tagValue);
    }

}
