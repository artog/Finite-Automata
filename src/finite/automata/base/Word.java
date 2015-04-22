/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finite.automata.base;

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
    
    public static Word fromString(String word) {
        Symbol a = new Symbol(word.charAt(0));
        String restStr = word.substring(1);
        
        Word rest;
        if (restStr.isEmpty()) {
            rest = Word.EMPTY;
        } else {
            rest = fromString(restStr);
        }
        return new Word(a, rest);
    }
    
}
