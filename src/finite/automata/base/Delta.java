/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finite.automata.base;

/**
 *
 * @author adam
 */
public abstract class Delta {
    
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