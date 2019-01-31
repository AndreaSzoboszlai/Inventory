package com.codecool;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class testParser {

    
    public static  void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        
        System.out.println(System.getProperty("user.dir"));
        System.out.println("ganajrakástalicska");
        
        InputStream is = new FileInputStream("rules.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document d = db.parse(is);
        
        Element root = d.getDocumentElement();
        
        for (int i = 0; i < root.getElementsByTagName("Rule").getLength(); i++){
            Node n = root.getElementsByTagName("Rule").item(i);
            
            if (n.getNodeType() == n.ELEMENT_NODE){
                
                Element r = (Element) n;
                
                for(int j = 0; j  < r.getElementsByTagName("Answer").getLength(); j++) {
                    Node n2 = r.getElementsByTagName("Answer").item(j);
                    if (n2.getNodeType() == n2.ELEMENT_NODE) {
                        
                        Element r2 = (Element) n2;
                        
                        for (int k = 0; k < r2.getElementsByTagName("Selection").getLength(); k++) {
                            Node n3 = r2.getElementsByTagName("Selection").item(k);
                            if (n3.getNodeType() == n3.ELEMENT_NODE) {
                                Element r3 = (Element) n3;
                                
                                for (int l = 0; l < r3.getElementsByTagName("SingleValue").getLength(); l++) {
                                    Node n4 = r3.getElementsByTagName("SingleValue").item(l);
                                    if (n4.getNodeType() == n4.ELEMENT_NODE) {
                                        Element r5 = (Element) n4;
                                        
                                        System.out.println(r5.getAttribute("value"));
                                        
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
