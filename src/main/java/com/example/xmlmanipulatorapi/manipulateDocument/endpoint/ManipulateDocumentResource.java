package com.example.xmlmanipulatorapi.manipulateDocument.endpoint;

import com.example.xmlmanipulatorapi.commons.models.PadraoMensagemRetornoDTO;
import com.example.xmlmanipulatorapi.document.model.DocumentXmlDTO;
import com.example.xmlmanipulatorapi.manipulateDocument.service.ManipulateDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

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
    public PadraoMensagemRetornoDTO saveDocumentEdited(
            @RequestParam("documentId") String documentId,
            @RequestParam("oldTagName") String oldTagName,
            @RequestParam("newTagName") String newTagName,
            @RequestParam("tagValue") String tagValue,
            @RequestParam("isEdited") Boolean isEdited
    ) throws Exception {
        String content = this.manipulateDocumentService.saveDocumentEdited(documentId, oldTagName, newTagName, tagValue, isEdited);
        return new PadraoMensagemRetornoDTO(HttpStatus.OK, HttpStatus.valueOf("OK").value(), "Arquivo editado com sucesso!", content);
    }

    @GetMapping
    public List<DocumentXmlDTO> getAllEditedDocument() {
        return this.manipulateDocumentService.getAllEditedDocument();
    }

    @GetMapping
    @RequestMapping(value = "/{id}")
    public String findDocumentByIdAndGetTagName(@PathVariable String id) throws IOException {
        return this.manipulateDocumentService.findDocumentByIdAndGetTagName(id);
    }

}
