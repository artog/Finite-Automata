/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finite.automata;

import finite.automata.base.DFA;
import finite.automata.base.*;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adam
 */
public class FiniteAutomata {
        /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        Set<Symbol> Sigma = new HashSet<>();
        Sigma.add(new Symbol("0"));
        Sigma.add(new Symbol("1"));
        
        
        Set<State> F = new HashSet<>();
        State q1 = new State("Q1");
        State q2 = new State("Q2");
        State q3 = new State("Q3");
        
        F.add(q1);
        F.add(q2);
        F.add(q3);
        
        Set<State> Q = new HashSet<>();
        State q0 = new State("Q0");
        
        Q.addAll(F);
        Q.add(q0);
        
        Delta delta = new Delta() {

            @Override
            public State next(State q, Symbol a) {
                if (q.equals(q0)) {
                    return q1;
                } else if (q.equals(q1)) {
                    return q2;
                } else if (q.equals(q2)) {
                    return q3;
                } else {
                    return q0;
                }
            }
            
        };
        
        String w = "1110";
        
        DFA dfa = new DFA(Q, Sigma, delta, q0, F);
        try {
            System.out.println(dfa.run(Word.fromString(w,Sigma)));
        } catch (LanguageException ex) {
            Logger.getLogger(FiniteAutomata.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static void p(String s) {
        System.out.println(s);
    }
    
}
