/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finite.automata;

import finite.automata.base.*;
import finite.automata.base.DFA.*;
import finite.automata.base.NFA.*;
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
        testNFA();
    } 
    
    public static void testDFA() {
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
        
        DeltaDFA delta = new DeltaDFA() {

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
    public static void testNFA() {
        Set<Symbol> Sigma = new HashSet<>();
        Sigma.add(new Symbol("0"));
        Sigma.add(new Symbol("1"));
        
        
        State q0 = new State("Q0");
        State q1 = new State("Q1");
        State q2 = new State("Q2");
        State q3 = new State("Q3");
        State q4 = new State("Q4");
        State q5 = new State("Q5");
        State q6 = new State("Q6");
        State q7 = new State("Q7");
        State q8 = new State("Q8");
        
        Set<State> F = new HashSet<>();
        F.add(q0);
        F.add(q3);
        F.add(q8);
        
        Set<State> Q = new HashSet<>();
        Set<State> Q0 = new HashSet<>();
        
        Q.add(q0);
        Q.add(q1);
        Q.add(q2);
        Q.add(q3);
        Q.add(q4);
        Q.add(q5);
        Q.add(q6);
        Q.add(q7);
        Q.add(q8);
        
        Q0.add(q0);
        
        
        
        DeltaNFA delta = new DeltaNFA() {

            @Override
            public Set<State> next(State q, Symbol a) {
                Set<State> next = new HashSet();
                if (q.equals(q0)) {
                    next.add(q1);
                    next.add(q4);
                } else if (q.equals(q1)) {
                    next.add(q2);
                } else if (q.equals(q2)) {
                    next.add(q3);
                } else if (q.equals(q3)) {
                    next.add(q1);
                } else if (q.equals(q4)) {
                    next.add(q5);
                } else if (q.equals(q5)) {
                    next.add(q6);
                } else if (q.equals(q6)) {
                    next.add(q7);
                } else if (q.equals(q7)) {
                    next.add(q8);
                } else {
                    next.add(q4);
                }
                    
                    
                
                return next;
            }
            
            
        };
        
        String w = "1111111";
        
        NFA dfa = new NFA(Q, Sigma, delta, Q0, F);
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
