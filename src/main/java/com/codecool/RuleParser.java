package com.codecool;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;

public class RuleParser extends XMLParser {

    private RuleRepository ruleRepository;
    private ArrayList<String> questionList = new ArrayList<String>();
    private ArrayList<String> idList = new ArrayList<String>();
    private String question;
    private String id;
    private ArrayList<Question> questList = new ArrayList<Question>();
    private Question quest;

    public RuleParser(String xmlPath) {
        this.ruleRepository = new RuleRepository();
        try {
            loadXmlDocument(xmlPath);


            Element rulesElement = doc.getDocumentElement();

            NodeList elementCount = doc.getElementsByTagName("Question");

            for (int i = 0; i < elementCount.getLength(); i++) {

                final Node rule = rulesElement.getElementsByTagName("Rule").item(i);
                id = rule.getAttributes().getNamedItem("id").getTextContent();
                question = rulesElement.getElementsByTagName("Question").item(i).getTextContent();
                questionList.add(question);
                idList.add(id);
                quest = new Question(id, question);
                questList.add(new Question(id, question));

            //aaaaaaaaaaaa

            /*Element answerElement = (Element) rulesElement.getElementsByTagName("Answer").item(0);
            Element answerElement2 = (Element) rulesElement.getElementsByTagName("Answer").item(0);*/

            /*NodeList selectionNodes = answerElement.getElementsByTagName("Selection");
            NodeList selectionNodes2 = answerElement2.getElementsByTagName("Selection");*/

            /*Element firstSelectionNode = (Element) selectionNodes.item(0);
            Element firstSelectionNode2 = (Element) selectionNodes2.item(1);*/

/*            Element singleValueElement = (Element) firstSelectionNode.getElementsByTagName("SingleValue").item(0);
            Element singleValueElement2 = (Element) firstSelectionNode2.getElementsByTagName("SingleValue").item(0);*/

            /*System.out.println(singleValueElement.getAttribute("value"));
            System.out.println(singleValueElement2.getAttribute("value"));*/

            //aaaaaaaaaaaa
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public RuleRepository getRuleRepository() {
        return this.ruleRepository;
    }

    public ArrayList<String> getQuestions() {
        return questionList;

    }
// aaaaaaaaaaaa
/*    public void createQuestions() {
        Question question = new Question();
        ruleRepository.addQuestion(question);

    }*/
// aaaaaaaaaaaa
    public ArrayList<String> getID() {
        return idList;
    }


    public ArrayList<Question> getQuestionObjects() {
        return questList;
    }
}
