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
public class Symbol {
    private final String symbol;

    public Symbol(String symbol) {
        this.symbol = symbol;
    }

    public Symbol(char symbol) {
        this.symbol = String.valueOf(symbol);
    }

    @Override
    public String toString() {
        return symbol;
    }
    
    
    
}
