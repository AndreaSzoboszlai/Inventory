package com.codecool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class ESProvider {
    private FactParser factparser;
    private RuleParser ruleparser;
    private RuleRepository newInstance;
    private FactRepository newInstance2;
    private Map<String, Boolean> questionsWithAnswers;
    private Map<String, Boolean> questionsWithAnswers2;
    private ArrayList<String> questions;
    private ArrayList<String> questions2;
    private ArrayList<String> id;
    private ArrayList<String> id2;
    private List<Map> moviesRules;

    public ESProvider (FactParser factparser, RuleParser ruleparser) {
        this.factparser = factparser;
        this.ruleparser = ruleparser;
        this.newInstance = ruleparser.getRuleRepository();
        this.newInstance2 = factparser.getFactRepository();
        questionsWithAnswers = new HashMap<String, Boolean>();
        questionsWithAnswers2 = new HashMap<String, Boolean>();

    }

    public void collectAnswers() {
        Scanner reader = new Scanner(System.in);
        id = ruleparser.getID();
        id2 = factparser.getID2();
        // aaaaaaaaaaaa
        questions = ruleparser.getQuestions();
        // aaaaaaaaaaaa
        for (int i = 0; i < questions.size(); i++) {
            System.out.println(questions.get(i));
            String answer = reader.nextLine();
            if (answer.equals("yes")) {
                questionsWithAnswers.put(id.get(i), true);
            } else if (answer.equals("no")) {
                questionsWithAnswers.put(id.get(i), false);
            }
        }
        /*for (Map.Entry<String, Boolean> entry: questionsWithAnswers.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }*/
        // aaaaaaaaaaaa


    }

    public boolean getAnswersByQuestion(String questionId) {
        ArrayList<Question> newQ = ruleparser.getQuestionObjects();
        boolean var = false;
        for (int i = 0; i < newQ.size(); i++) {
            //System.out.println(newQ.get(i).getEvaluatedAnswer());
            //System.out.println(questionId);
            //System.out.println(newQ.get(i).getId());
            if (questionId.equals(newQ.get(i).getId())) {
                var = newQ.get(i).getEvaluatedAnswer();
            }
        }
       // System.out.println( var + "             hooroooorg?");
        return var;
    }

    public String evaluate() {
        List<String> results = new ArrayList<String>();
        String a = "";
        Map<Fact, Map<String, Boolean>> filmEvaluations = new HashMap<Fact, Map<String, Boolean>>();
        for (Fact fact: factparser.getFactRepository().getFacts()) {
            filmEvaluations.put(fact, fact.getEvaluations());
        }
        for (Map.Entry<Fact, Map<String, Boolean>> film: filmEvaluations.entrySet()) {
            if (film.getValue().equals(questionsWithAnswers)) {
                results.add(film.getKey().getDesctription());
            }
        }
        for (String film: results) {
            a += film + "\n";
        }
        return a;
    }

    public String evaluate2() {
        ArrayList<String> idS = ruleparser.getID();

        String finalRes = "";
        int i = 0;
        for (Fact facts : factparser.getFactRepository().getFacts()) {
            List<String> results = new ArrayList<String>();
            for (boolean value : facts.getEvaluations().values()) {

                //boolean value = Boolean.valueOf(name);
                //System.out.println(element);
                //System.out.println(getAnswersByQuestion(element) + "  :  " + value);
                ;
                String name = idS.get(i);
                if (getAnswersByQuestion(name) != value) {

                    results.add("False");
                } else {
                    results.add("True");
                }
                i++;

            }

            System.out.println("");
            if (!results.contains("False")) {
                finalRes += facts.getDesctription() + "\n";
            }

            i=0;
        }
        return finalRes;
    }


}
