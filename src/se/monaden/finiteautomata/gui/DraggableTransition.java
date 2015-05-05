/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.monaden.finiteautomata.gui;

import se.monaden.finiteautomata.base.State;
import se.monaden.finiteautomata.base.Symbol;
import se.monaden.finiteautomata.base.Transition;

/**
 *
 * @author Adam
 */
public class DraggableTransition extends Transition {

    
    
    public DraggableTransition(State from, State to, Symbol symbol) {
        super(from, to, symbol);
    }

    public DraggableTransition(Transition t) {
        super(t.from(), t.to(), t.getSymbol());
    }
    
    
    
}
