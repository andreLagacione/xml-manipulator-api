package com.example.xmlmanipulatorapi.xpath.service;

import com.example.xmlmanipulatorapi.xpath.repository.XpathRepository;
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
public class XpathService {

    private final XpathRepository xpathRepository;

    @Autowired
    public XpathService(XpathRepository xpathRepository) {
        this.xpathRepository = xpathRepository;
    }

    public void processarDocumento(MultipartFile file) throws IOException, ParserConfigurationException, SAXException, XPathExpressionException {
        String fileName = file.getOriginalFilename();

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document xml = db.parse(fileName);

        XPathFactory xpf = XPathFactory.newInstance();
        XPath xPath = xpf.newXPath();

        Node nodes = (Node) xPath.evaluate("/cteProc", xml, XPathConstants.NODE);

//        for (int i = 0; i < nodes.getLength(); i++) {
//            System.out.println("Node name: " + nodes.item(i).getNodeName() + " - " + "Node value: " + nodes.item(i).getNodeValue());
//        }

        NodeList childs = nodes.getChildNodes();

        for (int n = childs.getLength() - 1; n >= 0; n--) {
            Node child = childs.item(n);
            short nodeType = child.getNodeType();
            if (nodeType == Node.ELEMENT_NODE) {
                System.out.println("Element node: " + child);
            }
            else if (nodeType == Node.TEXT_NODE) {
                String trimmedNodeVal = child.getNodeValue().trim();
                if (trimmedNodeVal.length() == 0){
                    System.out.println("Node vazio");
//                    nodes.removeChild(child);
                }
                else {
                    System.out.println("Node value: " + trimmedNodeVal);
                    child.setNodeValue(trimmedNodeVal);
                }
            } else if (nodeType == Node.COMMENT_NODE) {
                nodes.removeChild(child);
            }
        }

    }

}
