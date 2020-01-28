package com.example.xmlmanipulatorapi.editarDocumento.endpoint;

import com.example.xmlmanipulatorapi.editarDocumento.service.EditarDocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/editar-documento")
public class EditarDocumentoResource {

    private final EditarDocumentoService editarDocumentoService;

    @Autowired
    public EditarDocumentoResource(EditarDocumentoService editarDocumentoService) {
        this.editarDocumentoService = editarDocumentoService;
    }

    @PostMapping
    public void uploadFile(@RequestParam("file") MultipartFile file) throws Exception {
        this.editarDocumentoService.processarDocumento(file);
    }

}
