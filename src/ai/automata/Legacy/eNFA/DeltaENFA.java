/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai.automata.Legacy.eNFA;

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
public abstract class DeltaENFA {
    
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
            
            
            Set<State> eClose = next(it.next(),null);
            Iterator<State> eCloseIt = q.iterator();
            
            while (eCloseIt.hasNext()) {
                State p = eCloseIt.next();
                
                nextUnion.addAll(next(p,a));
            }
        }
        
        return hat(nextUnion,x);
    }
}
