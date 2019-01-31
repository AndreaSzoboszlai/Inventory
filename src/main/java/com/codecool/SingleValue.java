package com.codecool;

public class SingleValue extends Value {


    public SingleValue(boolean selectionType, String param) {
        this.selectionType = selectionType;
        this.inputPattern.add(param);
    }

    public SingleValue getSingleValue() {
        return new SingleValue(selectionType, inputPattern.get(0));
    }
}


