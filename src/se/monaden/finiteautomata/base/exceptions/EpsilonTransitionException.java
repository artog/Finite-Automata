/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.monaden.finiteautomata.base.exceptions;

import se.monaden.finiteautomata.base.Transition;

/**
 *
 * @author Adam
 */
public class EpsilonTransitionException extends Exception {
    private final Transition source;
    public EpsilonTransitionException(String msg, Transition t) {
        super(msg);
        source = t;
    }

    public Transition getSource() {
        return source;
    }
    
}
