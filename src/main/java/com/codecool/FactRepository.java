package com.codecool;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FactRepository {
    
    private Fact fact;
    private Iterator<Fact> iterator;
    private List<Fact> factList;

    public void addFact(Fact fact) {
        factList.add(fact);
    }

    public FactRepository() {
        this.factList = new ArrayList<Fact>();
    }

    public Iterator<Fact> getIterator() {
        return new FactIterator();
    }

    public Fact getFact() {
        return fact;
    }

    public List<Fact> getFacts() {
        return factList;
    }

    public class FactIterator implements Iterator<Fact>{
        
        private int i = 0;
        
        public boolean hasNext() {
             if (i < factList.size()){
                 i++;
                 return true;
             }
            return false;
        }
        
        public Fact next() {
            if (hasNext()){
                return factList.get(i);
            }
            return null;
        }
    }
}
