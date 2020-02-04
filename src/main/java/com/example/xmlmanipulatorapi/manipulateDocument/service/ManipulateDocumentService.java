package com.example.xmlmanipulatorapi.manipulateDocument.service;

import com.example.xmlmanipulatorapi.commons.exceptions.ObjectNotFoundException;
import com.example.xmlmanipulatorapi.manipulateDocument.entity.ManipulateDocument;
import com.example.xmlmanipulatorapi.manipulateDocument.repository.ManipulateDocumentRepository;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.json.JSONObject;
import org.json.XML;
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

    public String processarDocumento(MultipartFile file, String nomeTagCriada, String valorTagCriada) throws Exception {

        if (file.isEmpty()) {
            throw new ObjectNotFoundException("Selecione um arquivo para enviar!");
        }

        try {
            Document xml = this.createDocument(file, nomeTagCriada, valorTagCriada);
            String xmlString = this.convertDocumentToString(xml);
            String json = this.convertStringXmlToStringJson(xmlString);

            ManipulateDocument editedDocument = new ManipulateDocument(json);
            this.manipulateDocumentRepository.insert(editedDocument);

            return this.convertStringJsonToStringXml(json);
        } catch (Exception e) {
            throw new Exception("Erro ao processar o arquivo.", e.getCause());
        }
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

    public JsonNode convertStringXmlToJsonNode(String xml) throws IOException {
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

    public String saveDocumentEdited(String xmlDocument, String oldTagName, String newTagName, String tagValue) throws IOException {
        Boolean hasOldTag = oldTagName != null && !oldTagName.isEmpty();
        Boolean hasNewTag = newTagName != null && !newTagName.isEmpty();
        Boolean oldAndNewTagAreEquals = oldTagName.equalsIgnoreCase(newTagName);
        String jsonDocument = this.convertStringXmlToStringJson(xmlDocument);
        JsonNode destinatarioNode = this.findNodeDestinatario(jsonDocument);


        if (hasOldTag) {
            if (hasNewTag && !oldAndNewTagAreEquals) {
                destinatarioNode = this.updateTag(destinatarioNode, oldTagName, newTagName, tagValue);
            } else {
                destinatarioNode = this.removeNode(destinatarioNode, oldTagName);
            }
        }

        String newJsonDocument = this.updateDocumentWithNewDest(jsonDocument, destinatarioNode);
        ManipulateDocument editedDocument = new ManipulateDocument(newJsonDocument);
        this.manipulateDocumentRepository.insert(editedDocument);

        return this.convertStringJsonToStringXml(newJsonDocument);
    }

    private JsonNode findNodeDestinatario(String jsonDocument) throws IOException {
        JsonNode node = this.convertJsonStringToJsonNode(jsonDocument);
        return node.path("CTe").path("infCte").path("dest");
    }

    private JsonNode convertJsonStringToJsonNode(String jsonDocument) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonFactory jsonFactory = mapper.getFactory();
        JsonParser jsonParser = jsonFactory.createParser(jsonDocument);
        return mapper.readTree(jsonParser);
    }

    private JsonNode updateTag(JsonNode destinatarioNode, String oldTagName, String newTagName, String tagValue) {
        destinatarioNode = this.removeNode(destinatarioNode, oldTagName);
        return this.setNewTag(destinatarioNode, newTagName, tagValue);
    }

    private JsonNode removeNode(JsonNode node, String oldTagName) {
        ObjectNode objectNode = (ObjectNode) node;
        objectNode.remove(oldTagName);
        return (JsonNode) objectNode;
    }

    private JsonNode setNewTag(JsonNode node, String newTagName, String tagValue) {
        ObjectNode objectNode = (ObjectNode) node;
        objectNode.put(newTagName, tagValue);
        return (JsonNode) objectNode;
    }

    private String updateDocumentWithNewDest(String document, JsonNode newDest) throws IOException {
        JsonNode node = this.convertJsonStringToJsonNode(document);
        JsonNode infCteNode = node.path("CTe").path("infCte");
        JsonNode cteNode = node.path("CTe");

        infCteNode = this.removeNode(infCteNode, "dest");
        cteNode = this.removeNode(cteNode, "infCte");

        infCteNode = this.updateNode(infCteNode, "dest", newDest);
        cteNode = this.updateNode(cteNode, "infCte", infCteNode);
        node = this.updateNode(node, "CTe", cteNode);

        return this.convertJsonNodeToString(node);
    }

    public String convertJsonNodeToString(JsonNode node) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(node);
    }

    private JsonNode updateNode(JsonNode nodeToUpdate, String nodeName, JsonNode newNodeValue) {
        ObjectNode objectNode = (ObjectNode) nodeToUpdate;
        objectNode.set(nodeName, newNodeValue);
        return  (JsonNode) objectNode;
    }

    public String convertStringJsonToStringXml(String json) {
        JSONObject jsonObject = new JSONObject(json);
        String xml = "<cteProc versao=\"3.00\" xmlns=\"http://www.portalfiscal.inf.br/cte\">" + XML.toString(jsonObject) + "</cteProc>";
        return xml;
    }

}
