package com.example.xmlmanipulatorapi.xpath.endpoint;

import com.example.xmlmanipulatorapi.xpath.service.XpathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
@RequestMapping(value = "/x-path")
public class XpathResource {

    private final XpathService xpathService;

    @Autowired
    public XpathResource(XpathService xpathService) {
        this.xpathService = xpathService;
    }

    @PostMapping
    public void uploadFile(@RequestParam("file") MultipartFile file) throws Exception {
        this.xpathService.processarDocumento(file);
    }

}
