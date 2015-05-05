/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.monaden.finiteautomata.base;

import se.monaden.finiteautomata.base.exceptions.LanguageException;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 * @author adam
 */
public class DebuggableFA extends FA {
    private Set<State> currentPositions = null;
    private Symbol a = null;
    private Word rest = null;
    
    
    
    public Set<State> debug(String word) throws LanguageException {
        Word w = Word.fromString(word, this.alphabet);
        this.a = w.a();
        this.rest = w.x();
        
        this.currentPositions = new LinkedHashSet();
        this.currentPositions.add(startState);
        return this.currentPositions;
    }
    
    public Set<State> step() {
        if (rest.equals(Word.EMPTY)) {
            return currentPositions;
        }
        
        Set<State> result = new LinkedHashSet();
        for (State q : currentPositions) {
            result.addAll(delta(q,a));
        }
        currentPositions = result;
        this.a = rest.a();
        this.rest = rest.x();
        return result;
    }
}
