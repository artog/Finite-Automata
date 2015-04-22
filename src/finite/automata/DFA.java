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
public abstract class DFA {
    
    public abstract int delta(int q, char a);
    public abstract boolean isFinal(int q);
    public abstract int start();
    
    
    public int deltaHat(int q, String x) {
        char a = x.charAt(0);
        int next = delta(q, a);
        if ("".equals(x.substring(1))) {
            return next;
        }
        return deltaHat(next,x.substring(1));
    }
}
