/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai.automata.Legacy.DFA;

import se.monaden.finiteautomata.base.State;
import se.monaden.finiteautomata.base.Symbol;
import se.monaden.finiteautomata.base.Word;

/**
 *
 * @author adam
 */
public abstract class DeltaDFA {
    
    public abstract State next(State q, Symbol a);
    
    
    public State hat(State q, Word ax) {
        Symbol a = ax.a();
        Word x = ax.x();
        
        if (x == null) {
            return q;
        }
        
        return hat(next(q,a),x);
    }
}
