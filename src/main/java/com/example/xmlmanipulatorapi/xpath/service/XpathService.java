package com.example.xmlmanipulatorapi.xpath.service;

import com.example.xmlmanipulatorapi.xpath.repository.XpathRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Service
public class XpathService {

    private final XpathRepository xpathRepository;

    @Autowired
    public XpathService(XpathRepository xpathRepository) {
        this.xpathRepository = xpathRepository;
    }

    public void processarDocumento(MultipartFile file) throws IOException, ParserConfigurationException, SAXException, XPathExpressionException {
        File convertedFile = new File(System.getProperty("java.io.tmpdir") + "/" + file.getName());
        file.transferTo(convertedFile);
        FileInputStream fileInputStream = new FileInputStream(convertedFile);
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(fileInputStream);
        XPath xPath = XPathFactory.newInstance().newXPath();
        String expression = "cteProc";
        NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(document, XPathConstants.NODESET);

        System.out.println(nodeList);
    }

}
