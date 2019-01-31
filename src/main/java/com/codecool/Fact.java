package com.codecool;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Fact {
    private String id;
    private String desctription;

    private Map<String, Boolean> evaluations;

    public Fact(String id, String desctription) {
        this.id = id;
        this.desctription = desctription;
        this.evaluations = new HashMap<String, Boolean>();
    }

    public Map<String, Boolean> getEvaluations()
    {
        return evaluations;
    }

    public String getId() {
        return id;
    }

    public String getDesctription() {
        return desctription;
    }

    public Set<String> getIdSet() {
        Set set = new HashSet();
        set.add(id);
        return set;

    }

    public void setFactValueByID(String id, boolean value) {
        this.evaluations.put(id, value);

    }

    public boolean getValueById(String id) {

            return this.evaluations.get(id);


    }

}
