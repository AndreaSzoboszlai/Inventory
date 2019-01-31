package com.codecool;

import java.util.List;
import java.util.ArrayList;

public class Answer {

    private Value value;
    private SingleValue  value2;
    private ArrayList<Value> values;

    public Answer() {
        values = new ArrayList<Value>();
        value2 = new SingleValue(true, "yes");
        addValue(value2);
    }

    public boolean evaluateAnswerByInput(String input) {
        for (Value v : values) {
            if (v.getInputPattern().contains(input)) {
                return v.getSelectionType();
            }

        }
        return false;
    }


    public void addValue(Value value) {
        values.add(value);
    }
}
