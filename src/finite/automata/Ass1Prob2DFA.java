/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finite.automata;

/**
 *
 * @author Adam
 */
public class Ass1Prob2DFA extends DFA {

    public final int Q1 = 0;
    public final int Q2 = 1;
    public final int Q3 = 2;
    public final int Q4 = 3;
    public int delta(int q, char a) {
        switch (q) {
            case Q1:
                return Q2;
            case Q2:
                return Q3;
            case Q3:
                return Q4; 
            default:
                return Q1; 
        }
    }

    public boolean isFinal(int q) {
        if (q == Q1) {
            return false; 
        } else {
            return true;                 
        }
    }

    public int start() {
        return Q1;
    }
    
}
