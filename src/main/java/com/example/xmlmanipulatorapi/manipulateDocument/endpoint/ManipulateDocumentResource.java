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
    public String createDocumentEdited(
            @RequestParam("file") MultipartFile file,
            @RequestParam("tagName") String tagName,
            @RequestParam("tagValue") String tagValue
    ) throws Exception {
        return this.manipulateDocumentService.processarDocumento(file, tagName, tagValue);
    }

    @PostMapping
    @RequestMapping(value = "/edit")
    public String saveDocumentEdited(
            @RequestParam("jsonDocument") String jsonDocument,
            @RequestParam("oldTagName") String oldTagName,
            @RequestParam("newTagName") String newTagName,
            @RequestParam("tagValue") String tagValue
    ) throws Exception {
        return this.manipulateDocumentService.saveDocumentEdited(jsonDocument, oldTagName, newTagName, tagValue);
    }

}
