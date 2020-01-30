package com.example.xmlmanipulatorapi.manipulateDocument.service;

import com.example.xmlmanipulatorapi.manipulateDocument.entity.ManipulateDocument;
import com.example.xmlmanipulatorapi.manipulateDocument.repository.ManipulateDocumentRepository;
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
public class ManipulateDocumentService {

    private final ManipulateDocumentRepository manipulateDocumentRepository;

    @Autowired
    public ManipulateDocumentService(ManipulateDocumentRepository manipulateDocumentRepository) {
        this.manipulateDocumentRepository = manipulateDocumentRepository;
    }

    public String processarDocumento(MultipartFile file, String nomeTagCriada, String valorTagCriada) throws IOException, TransformerException, XPathExpressionException, SAXException, ParserConfigurationException {
        Document xml = this.createDocument(file, nomeTagCriada, valorTagCriada);
        String xmlString = this.convertDocumentToString(xml);
        String json = this.convertStringXmlToStringJson(xmlString);

        ManipulateDocument editedDocument = new ManipulateDocument(json);
        this.manipulateDocumentRepository.insert(editedDocument);

        return json;
    }

    private Document createDocument(MultipartFile file, String nomeTagCriada, String valorTagCriada) throws IOException, ParserConfigurationException, SAXException, XPathExpressionException {
        String fileName = file.getOriginalFilename();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document xml = db.parse(fileName);
        return this.adicionarNovaTag(xml, nomeTagCriada, valorTagCriada);
    }

    private String convertDocumentToString(Document xml) throws TransformerException {
        DOMSource source = new DOMSource(xml);
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        StringWriter stringWriter = new StringWriter();
        transformer.transform(source, new StreamResult(stringWriter));
        return stringWriter.getBuffer().toString();
    }

    private String convertStringXmlToStringJson(String xml) throws IOException {
        JsonNode node = this.convertStringXmlToJsonNode(xml);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(node);
    }

    private JsonNode convertStringXmlToJsonNode(String xml) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        return xmlMapper.readTree(xml.getBytes());
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

    public String saveDocumentEdited(String jsonDocument, String oldTagName, String newTagName, String tagValue) {
        Boolean hasOldTag = oldTagName != null && oldTagName.isEmpty();
        Boolean hasNewTag = newTagName != null && newTagName.isEmpty();
        Boolean oldAndNewTagAreEquals = oldTagName.equalsIgnoreCase(newTagName);


        if (hasOldTag) {
            // a tag foi alterada ou removida, pra saber se foi alterada, tem que ter newTag e a new tem que ser diferente da old

            if (hasNewTag && !oldAndNewTagAreEquals) {
                // a tag foi alterada, buscar e remover a tag antiga, adicionar a nova e inserir o valor
            } else {
                // remover a tag
            }
        }
    }

    private JsonNode findNodeDestinatario(String jsonDocument) throws IOException {
        JsonNode node = this.convertStringXmlToJsonNode(jsonDocument);
        return node.path("CTe").path("infCte").path("dest");

        // buscar a retornar o node de destinatario, para permitir se manipula-lo, removendo ou editando a tag conforme a regra
    }

}
