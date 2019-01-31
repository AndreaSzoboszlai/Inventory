package com.codecool;

import java.util.Map;
import java.util.Scanner;

public class Question {

    private String id;
    private String question;
    private Answer answer;
    private Map<String, Boolean> filmFacts;
    private Scanner reader;
    private String reply;

    public Question(String id, String question) {
        this.id = id;
        this.question = question;
        //answer = new;
        System.out.println(question);
        reader = new Scanner(System.in);
        String reply = reader.nextLine();
        // aaaaaaaaaaaa

        // aaaaaaaaaaaa
    }

    public boolean getEvaluatedAnswer() {


        answer = new Answer();
        boolean evaluatedAnswer = answer.evaluateAnswerByInput(reply);
        return evaluatedAnswer;
    }

    public String getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public Answer getAnswer() {
        return new Answer();
    }

    public boolean getReply() {
        if (reply.equals("yes")) {
            return true;
        }
        return false;
    }

}
