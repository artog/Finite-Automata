/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai.automata.Legacy.NFA;

import se.monaden.finiteautomata.base.State;
import se.monaden.finiteautomata.base.Symbol;
import se.monaden.finiteautomata.base.Word;
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
