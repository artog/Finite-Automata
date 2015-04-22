/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finite.automata;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Adam
 */
public class FiniteAutomata {
    public static boolean run(DFA dfa,String x) {
        int last = dfa.deltaHat(dfa.start(), x);
        return dfa.isFinal(last);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String w = "10011111";
        DFA dfa = new Ass1Prob2DFA();
        System.out.println(FiniteAutomata.run(dfa,w));
    }
    
}
