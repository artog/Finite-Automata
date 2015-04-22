/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finite.automata.base;

import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author Adam
 */
public class Word {
    private final Symbol a;
    private final Word next;
    
    public static final Word EMPTY = new Word();
    
    public Word(Symbol a, Word next) {
        this.a = a;
        this.next = next;
    }

    private Word() {
        this.a = null;
        this.next = null;
    }

    @Override
    public String toString() {
        if (a == null) {
            return "";
        }
        
        if (next == null) {
            return a.toString();
        }
        
        return a.toString() + next.toString();
    }
    
    public Symbol a() {
        return a;
    }

    public Word x() {
        return next;
    }
 
    public boolean isValid(Set<Symbol> Sigma) {
        
        if (!Sigma.contains(a)) {
            return false;
        } 
        
        if (next == null) {
            return true;
        }
        
        return next.isValid(Sigma);
    }
    
    
    
    public static Word fromString(String word, Set<Symbol> language) throws LanguageException {
        Symbol a = null;
        char c = word.charAt(0);
        Iterator<Symbol> it = language.iterator();
        while (it.hasNext()) {
            Symbol s = it.next();
            if (s.toString().equals(String.valueOf(c))) {
                a = s;
                break;
            }   
        }
        if (a == null) {
            throw new LanguageException("Invalid symbol: "+c);
        }
            
//        Symbol a = new Symbol(word.charAt(0));
        String restStr = word.substring(1);
        
        Word rest;
        if (restStr.isEmpty()) {
            rest = Word.EMPTY;
        } else {
            rest = fromString(restStr, language);
        }
        return new Word(a, rest);
    }

    
}
