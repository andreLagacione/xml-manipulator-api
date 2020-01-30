package com.example.xmlmanipulatorapi.editarDocumento.service;

import com.example.xmlmanipulatorapi.editarDocumento.entity.EditarDocumento;
import com.example.xmlmanipulatorapi.editarDocumento.repository.EditarDocumentoRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;
import java.io.StringWriter;

@Service
public class EditarDocumentoService {

    private final EditarDocumentoRepository editarDocumentoRepository;

    @Autowired
    public EditarDocumentoService(EditarDocumentoRepository editarDocumentoRepository) {
        this.editarDocumentoRepository = editarDocumentoRepository;
    }

    public String processarDocumento(MultipartFile file, String nomeTagCriada, String valorTagCriada) throws IOException, ParserConfigurationException, SAXException, XPathExpressionException, TransformerException {
        String fileName = file.getOriginalFilename();

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document xml = db.parse(fileName);
        xml = this.adicionarNovaTag(xml, nomeTagCriada, valorTagCriada);

        DOMSource source = new DOMSource(xml);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        StringWriter stringWriter = new StringWriter();
        transformer.transform(source, new StreamResult(stringWriter));
        String xmlString = stringWriter.getBuffer().toString();

        XmlMapper xmlMapper = new XmlMapper();
        JsonNode node = xmlMapper.readTree(xmlString.getBytes());
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(node);

        EditarDocumento editedDocument = new EditarDocumento(json);
        this.editarDocumentoRepository.insert(editedDocument);


        return json;


    }

    private Document adicionarNovaTag(Document xml, String nomeTagCriada, String valorTagCriada) throws XPathExpressionException {
        XPathFactory xpf = XPathFactory.newInstance();
        XPath xPath = xpf.newXPath();

        NodeList nodes = (NodeList) xPath.evaluate("/cteProc/CTe/infCte/dest", xml, XPathConstants.NODESET);

        Node node = nodes.item(0);

        if ("dest".equals(node.getNodeName())) {
            Element newNode = xml.createElement(nomeTagCriada);
            newNode.appendChild(xml.createTextNode(valorTagCriada));
            node = this.removerNodeSeExistir(node, nomeTagCriada);
            node.appendChild(newNode);
        }

        return xml;
    }

    private Node removerNodeSeExistir(Node node, String nomeTagCriada) {
        NodeList children = node.getChildNodes();

        for (int i = 0; i < children.getLength(); i++) {
            Node child = children.item(i);

            if (nomeTagCriada.equals(child.getNodeName())) {
                node.removeChild(child);
            }
        }

        return node;
    }

}
