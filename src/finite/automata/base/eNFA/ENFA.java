/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finite.automata.base.eNFA;

import finite.automata.base.NFA.*;
import finite.automata.base.DFA.*;
import finite.automata.base.*;
import finite.automata.base.LanguageException;
import finite.automata.base.State;
import finite.automata.base.Symbol;
import finite.automata.base.Word;
import java.util.Set;

/**
 *
 * @author Adam
 */
public class ENFA {
    
    

    private final Set<State> Q;
    private final Set<Symbol> Sigma;
    private final DeltaNFA d;
    private final Set<State> q0;
    private final Set<State> F;

    public ENFA(Set<State> Q, Set<Symbol> Sigma, DeltaNFA d, Set<State> q0, Set<State> F) {
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
