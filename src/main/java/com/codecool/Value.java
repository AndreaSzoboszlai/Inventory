package com.codecool;

import java.util.ArrayList;
import java.util.List;

public abstract class Value {


    protected List<String> inputPattern = new ArrayList<String>();
    protected boolean selectionType;

    public List<String> getInputPattern() {
        return inputPattern;
    }

    public boolean getSelectionType()  {
        return selectionType;
    }

}
