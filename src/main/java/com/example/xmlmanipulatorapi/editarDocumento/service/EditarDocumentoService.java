package com.example.xmlmanipulatorapi.editarDocumento.service;

import com.example.xmlmanipulatorapi.editarDocumento.repository.EditarDocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;

@Service
public class EditarDocumentoService {

    private final EditarDocumentoRepository editarDocumentoRepository;

    @Autowired
    public EditarDocumentoService(EditarDocumentoRepository editarDocumentoRepository) {
        this.editarDocumentoRepository = editarDocumentoRepository;
    }

    public void processarDocumento(MultipartFile file, String nomeTagCriada) throws IOException, ParserConfigurationException, SAXException, XPathExpressionException {
        String fileName = file.getOriginalFilename();

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document xml = db.parse(fileName);

        XPathFactory xpf = XPathFactory.newInstance();
        XPath xPath = xpf.newXPath();

        NodeList nodes = (NodeList) xPath.evaluate("/cteProc/CTe/infCte/dest/enderDest", xml, XPathConstants.NODESET);

        for (int i = 0; i < nodes.getLength(); i++) {
            System.out.println("Node name: " + nodes.item(i).getNodeName() + " - " + "Node value: " + nodes.item(i).getNodeValue());
        }

    }

}
