package com.sapient.helper;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 * @author ssi248
 *
 */
public class XMLUtility {

    public static NodeList getXMLNodes(final String xmlFileName, final String tagName) {
        NodeList nList = null;
        try {
            File xmlFile = new File(xmlFileName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            nList = doc.getElementsByTagName(tagName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return nList;
    }

}
