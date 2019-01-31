package com.codecool;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RuleRepository {


    private Iterator<Question> iterator;
    private Question question;
    private List<Question> questions;
    private Map<String, Question> ruleRepMap;

    public RuleRepository() {
        this.iterator = new QuestionIterator();
        this.question = question;
        this.questions = questions;
        this.ruleRepMap = ruleRepMap;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public Iterator<Question> getIterator() {
        return new QuestionIterator();
    }

    class QuestionIterator implements Iterator {

        private int i = 0;

        public boolean hasNext() {
            if (i < questions.size()) {
                i++;
                return true;

            }
            return false;
        }

        public Object next() {
            if (this.hasNext()) {
                return questions.get(i);
            }
            return null;
        }
    }
}
