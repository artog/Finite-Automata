/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finite.automata.base;

import finite.automata.base.*;
import java.util.Set;

/**
 *
 * @author Adam
 */
public class DFA {
    
    

    private final Set<State> Q;
    private final Set<Symbol> Sigma;
    private final Delta d;
    private final State q0;
    private final Set<State> F;

    public DFA(Set<State> Q, Set<Symbol> Sigma, Delta d, State q0, Set<State> F) {
        this.Q = Q;
        this.Sigma = Sigma;
        this.d = d;
        this.q0 = q0;
        this.F = F;
    }

    public boolean run(Word ax)
            throws LanguageException
    {
        State end = d.hat(q0, ax);
        System.out.println("end is "+end);
        return F.contains(end);
    }
    
}
