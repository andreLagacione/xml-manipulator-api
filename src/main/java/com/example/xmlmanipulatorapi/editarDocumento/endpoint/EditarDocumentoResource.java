package com.example.xmlmanipulatorapi.editarDocumento.endpoint;

import com.example.xmlmanipulatorapi.editarDocumento.service.EditarDocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.transform.dom.DOMSource;

@RestController
@RequestMapping(value = "/editar-documento")
public class EditarDocumentoResource {

    private final EditarDocumentoService editarDocumentoService;

    @Autowired
    public EditarDocumentoResource(EditarDocumentoService editarDocumentoService) {
        this.editarDocumentoService = editarDocumentoService;
    }

    @PostMapping
    public String saveDocumentEdited(
            @RequestParam("file") MultipartFile file,
            @RequestParam("nomeTagCriada") String nomeTagCriada,
            @RequestParam("valorTagCriada") String valorTagCriada
    ) throws Exception {
        return this.editarDocumentoService.processarDocumento(file, nomeTagCriada, valorTagCriada);
    }

}
