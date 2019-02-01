package com.codecool;

import java.util.List;
import java.util.ArrayList;

public class Answer {

    private Value value;
    private SingleValue  value2;
    private ArrayList<Value> values;

    public Answer() {
        values = new ArrayList<Value>();
        //addValue(new SingleValue(false, "no"));
        addValue(new SingleValue(true, "yes"));
    }

    public boolean evaluateAnswerByInput(String input) {
        boolean var = false;
        for (Value v : values) {
           // System.out.println(input + "           inpu");
           // System.out.println(v.getInputPattern() + "           input pattern");
            if (v.getInputPattern().contains(input)) {
                var = v.getSelectionType();
            }

        }
       // System.out.println(var + "           var");
        return var;
    }


    public void addValue(Value value) {
        values.add(value);
    }
}
