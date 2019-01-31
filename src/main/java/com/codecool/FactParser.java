package com.codecool;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FactParser extends XMLParser {

    private FactRepository factRepository;
    private ArrayList<String> idList2 = new ArrayList<String>();
    private String id2;
    private List<Map> listFacts;
    private NodeList nodeList;

    public FactParser(String xmlPath) {
        loadXmlDocument(xmlPath);
        this.factRepository = new FactRepository();
        this.nodeList = doc.getElementsByTagName("Film");
        addFilmsToRepo();

    }

    private void addFilmsToRepo() {
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node tempNode = nodeList.item(i);
            Element tempElement = (Element) tempNode;
            String id = tempElement.getAttribute("id");
            Node descriptionNode = tempElement.getElementsByTagName("Description").item(0);
            String description = ((Element)descriptionNode).getAttribute("value");

            Fact films = new Fact(id, description);
            setFactEvalutaion(films, tempElement);
            this.factRepository.addFact(films);
        }
    }

    private void setFactEvalutaion(Fact fact, Element tempElement) {
        Element evaluationNode = (Element) tempElement.getElementsByTagName("Evals").item(0);
        NodeList evaluations = evaluationNode.getElementsByTagName("Eval");

        for (int i = 0; i < evaluations.getLength(); i++) {
            Element evaluation = (Element) evaluations.item(i);
            String id = evaluation.getAttribute("id");
            String value = evaluation.getTextContent();
            fact.setFactValueByID(id, Boolean.valueOf(value));
        }
    }

/*

    Element rulesElement = doc.getDocumentElement();

    NodeList elementCount = doc.getElementsByTagName("Description");

            for(
    int i = 0; i<elementCount.getLength();i++)

    {
        */
/*System.out.println(rulesElement.getElementsByTagName("Description").item(i).getTextContent());*//*


        final Node rule = rulesElement.getElementsByTagName("Film").item(i);
        id2 = rule.getAttributes().getNamedItem("id").getTextContent();
        idList2.add(id2);


                */
/*Element answerElement = (Element) rulesElement.getElementsByTagName("Evals").item(0);
                Element answerElement2 = (Element) rulesElement.getElementsByTagName("Evals").item(0);
                Element answerElement3 = (Element) rulesElement.getElementsByTagName("Evals").item(0);
                Element answerElement4 = (Element) rulesElement.getElementsByTagName("Evals").item(0);
                Element answerElement5 = (Element) rulesElement.getElementsByTagName("Evals").item(0);
                Element answerElement6 = (Element) rulesElement.getElementsByTagName("Evals").item(0);
                Element answerElement7 = (Element) rulesElement.getElementsByTagName("Evals").item(0);
                Element answerElement8 = (Element) rulesElement.getElementsByTagName("Evals").item(0);

                NodeList selectionNodes = answerElement.getElementsByTagName("Eval");
                NodeList selectionNodes2 = answerElement2.getElementsByTagName("Eval");
                NodeList selectionNodes3 = answerElement3.getElementsByTagName("Eval");
                NodeList selectionNodes4 = answerElement4.getElementsByTagName("Eval");
                NodeList selectionNodes5 = answerElement5.getElementsByTagName("Eval");
                NodeList selectionNodes6 = answerElement6.getElementsByTagName("Eval");
                NodeList selectionNodes7 = answerElement7.getElementsByTagName("Eval");
                NodeList selectionNodes8 = answerElement8.getElementsByTagName("Eval");

                Element firstSelectionNode = (Element) selectionNodes.item(0);
                Element firstSelectionNode2 = (Element) selectionNodes2.item(1);
                Element firstSelectionNode3 = (Element) selectionNodes3.item(2);
                Element firstSelectionNode4 = (Element) selectionNodes4.item(3);
                Element firstSelectionNode5 = (Element) selectionNodes5.item(4);
                Element firstSelectionNode6 = (Element) selectionNodes6.item(5);
                Element firstSelectionNode7 = (Element) selectionNodes7.item(6);
                Element firstSelectionNode8 = (Element) selectionNodes8.item(7);*//*


                */
/*System.out.println(firstSelectionNode.getAttribute("id"));
                System.out.println(firstSelectionNode2.getAttribute("id"));
                System.out.println(firstSelectionNode3.getAttribute("id"));
                System.out.println(firstSelectionNode4.getAttribute("id"));
                System.out.println(firstSelectionNode5.getAttribute("id"));
                System.out.println(firstSelectionNode6.getAttribute("id"));
                System.out.println(firstSelectionNode7.getAttribute("id"));
                System.out.println(firstSelectionNode8.getAttribute("id"));*//*

    }

*/


    public FactRepository getFactRepository() {
        return this.factRepository;
    }

    public ArrayList<String> getID2() {
        return idList2;
    }
}
