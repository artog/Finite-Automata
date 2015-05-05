/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.monaden.finiteautomata.base;

import java.util.Objects;

/**
 *
 * @author Adam
 */
public class Transition {
    private final State from;
    private final State to;
    private final Symbol symbol;

    public Transition(State from, State to, Symbol symbol) {
        if (from == null || to == null || symbol == null) {
            throw new IllegalArgumentException();
        }
        this.from = from;
        this.to = to;
        this.symbol = symbol;
    }

    public State transition(State q, Symbol a) {
        if (q.equals(from) && symbol.equals(a)) {
            return to;
        }
        return null;
    }
    
    public State from() {
        return from;
    }

    public State to() {
        return to;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.from);
        hash = 23 * hash + Objects.hashCode(this.to);
        hash = 23 * hash + Objects.hashCode(this.symbol);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Transition other = (Transition) obj;
        if (!Objects.equals(this.from, other.from)) {
            return false;
        }
        if (!Objects.equals(this.to, other.to)) {
            return false;
        }
        
        return Objects.equals(this.symbol, other.symbol);
    }

    @Override
    public String toString() {
        return  from + ":" + symbol + " -> " + to;
    }
    
    
}
