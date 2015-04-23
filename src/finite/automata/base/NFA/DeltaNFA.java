/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finite.automata.base.NFA;

import finite.automata.base.State;
import finite.automata.base.Symbol;
import finite.automata.base.Word;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author adam
 */
public abstract class DeltaNFA {
    
    public abstract Set<State> next(State q, Symbol a);
    
    
    public Set<State> hat(Set<State> q, Word ax) {
        Symbol a = ax.a();
        Word x = ax.x();
        
        if (x == null) {
            return q;
        }
        Set<State> nextUnion =  new HashSet();
        
        Iterator<State> it = q.iterator();
        while (it.hasNext()) {
            nextUnion.addAll(next(it.next(),a));
        }
        
        return hat(nextUnion,x);
    }
}
