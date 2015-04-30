/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finite.automata.base;

import finite.automata.base.Exceptions.LanguageException;

/**
 *
 * @author Adam
 */
public class Symbol implements Comparable<Object> {
    private final String symbol;
    
    public static Symbol EMPTY = new Symbol();
            
    public Symbol(String symbol) throws LanguageException {
        if (symbol == null) {
            throw new LanguageException("Empty symbol");
        }
        this.symbol = symbol;
    }
    
    public Symbol(char symbol) {
        this.symbol = String.valueOf(symbol);
    }
    private Symbol() {
        this.symbol = null;
    }

    @Override
    public String toString() {
        return symbol;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Symbol) {
            return symbol.compareTo(((Symbol)o).symbol);
        }
        return 0;
    }
    
    
    
}
