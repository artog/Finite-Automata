/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai.automata.Legacy.NFA;

import se.monaden.finiteautomata.base.exceptions.LanguageException;
import se.monaden.finiteautomata.base.State;
import se.monaden.finiteautomata.base.Symbol;
import se.monaden.finiteautomata.base.Word;
import java.util.Set;

/**
 *
 * @author Adam
 */
public class NFA {
    
    

    private final Set<State> Q;
    private final Set<Symbol> Sigma;
    private final DeltaNFA d;
    private final Set<State> q0;
    private final Set<State> F;

    public NFA(Set<State> Q, Set<Symbol> Sigma, DeltaNFA d, Set<State> q0, Set<State> F) {
        this.Q = Q;
        this.Sigma = Sigma;
        this.d = d;
        this.q0 = q0;
        this.F = F;
    }

    public boolean run(Word ax)
            throws LanguageException
    {
        Set<State> end = d.hat(q0, ax);
        System.out.println("end is "+end);
        F.retainAll(end);
        return F.size() > 0;
    }
    
}
