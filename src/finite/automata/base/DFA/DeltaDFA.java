/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finite.automata.base.DFA;

import finite.automata.base.State;
import finite.automata.base.Symbol;
import finite.automata.base.Word;

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
