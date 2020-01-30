package com.example.xmlmanipulatorapi.manipulateDocument.endpoint;

import com.example.xmlmanipulatorapi.manipulateDocument.service.ManipulateDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String saveDocumentEdited(
            @RequestParam("file") MultipartFile file,
            @RequestParam("nomeTagCriada") String nomeTagCriada,
            @RequestParam("valorTagCriada") String valorTagCriada
    ) throws Exception {
        return this.manipulateDocumentService.processarDocumento(file, nomeTagCriada, valorTagCriada);
    }

}
