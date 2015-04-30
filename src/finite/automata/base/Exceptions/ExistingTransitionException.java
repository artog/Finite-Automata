/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finite.automata.base.Exceptions;

import finite.automata.base.Transition;

/**
 *
 * @author Adam
 */
public class ExistingTransitionException extends Exception {
    
    private final Transition source;
    
    public ExistingTransitionException(Transition t) {
        super("State "+t.from()+" already have transition for "+t.getSymbol());
        source = t;
    }

    public Transition getSource() {
        return source;
    }
    
    
    
}
