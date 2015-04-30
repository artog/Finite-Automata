/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finite.automata.base;

import finite.automata.base.Exceptions.InvalidFileException;
import finite.automata.base.Exceptions.ExistingTransitionException;
import finite.automata.base.Exceptions.ExistingStateException;
import finite.automata.base.Exceptions.EpsilonTransitionException;
import finite.automata.base.Exceptions.LanguageException;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

/**
 * A finite automaton, can be deterministic and non-deterministic. 
 * Supports epsilon transitions when non-deterministic.
 * @author Adam
 */
public class FA {
    
    private final HashMap<String,State> states;
    private State startState;
    private final Set<Transition> transitions;
    private final Set<Symbol> alphabet;
    private Type type;
    
    /**
     * NFA is used to denote the non-deterministic type. 
     * Using DFA constricts what kinds of transitions can be done.
     */
    public enum Type { NFA, DFA }
    

    public FA(
            Type t, 
            HashMap<String,State> states, 
            State startState, 
            Set<Transition> transitions, 
            Set<Symbol> alphabet
    ) {
        this.type = t;
        this.states = states;
        this.startState = startState;
        this.transitions = transitions;
        this.alphabet = alphabet;
    }

    public FA() {
        this(Type.NFA,
            new HashMap(),
            null,
            new HashSet(),
            new HashSet()
        );
    }
    
    /**
     * Adds a state
     * @param s 
     * @throws ExistingStateException Thrown when trying to add an existing state.
     */
    public void  addState(State s) 
            throws ExistingStateException 
    {
        if (states.containsKey(s.name())) {
            throw new ExistingStateException();
        }
        states.put(s.name(), s);
    }
    
    /**
     * Get all states to where we can go from q by reading a
     * @param q
     * @param a
     * @return 
     */
    public Set<State> delta(State q, Symbol a) {
        Iterator<Transition> it = transitions.iterator();
        
        Set<State> next = new HashSet();
        
        while (it.hasNext()) {
            Transition t = it.next();
            State state = t.transition(q,a);
            if (state != null) {
                next.add(state);
            }
        }
        return next;
    }
    
    /**
     * Get all states to where we can go from all 
     * states in qs by reading the word ax
     * @param qs
     * @param ax
     * @return 
     */
    public Set<State> deltaHat(Set<State> qs, Word ax) {
        Symbol a = ax.a();
        Word x = ax.x();
        
        if (x == null) {
            return qs;
        }
        Set<State> nextUnion =  new HashSet();
        
        Iterator<State> it = qs.iterator();
        while (it.hasNext()) {
            nextUnion.addAll(delta(it.next(),a));
        }
        
        return deltaHat(nextUnion,x);
    }
    
    /**
     * Add a transition to the automata
     * @param t
     * @throws ExistingTransitionException Thrown if attempting to add a 
     * transition when the automata is a DFA
     * @throws EpsilonTransitionException Thrown when attempting to 
     * add a Epsilon-transition to a DFA
     */
    public void addTransition(Transition t) 
            throws ExistingTransitionException, 
                   EpsilonTransitionException 
    {
        
        if (this.type == Type.DFA) {
            if (t.getSymbol() == Symbol.EMPTY) {
                throw new EpsilonTransitionException("Unable to add epsilon transition in a DFA",t);
            }
            // Check all transitions for of one that 
            // that the same from state and symbol.
            Iterator<Transition> it = transitions.iterator();
            while (it.hasNext()) {
                Transition other = it.next();
                if (t.from().equals(other.from())
                        && t.getSymbol().equals(other.getSymbol())) {
                    throw new ExistingTransitionException(t);
                }
            }
        } 
        transitions.add(t);
    }
    
    /**
     * 
     * @see addTransition(Transition t)
     * @param from
     * @param to
     * @param symb
     * @throws ExistingTransitionException
     * @throws EpsilonTransitionException 
     */
    public void addTransition(State from, State to, Symbol symb) 
            throws ExistingTransitionException, 
                   EpsilonTransitionException 
    {
        addTransition(
                new Transition(from, to, symb)
        );
    }

    public void setStartState(State startState) {
        this.startState = startState;
    }
    
    
    
    public static FA fromFile(File source) 
            throws InvalidFileException, LanguageException, ExistingTransitionException, EpsilonTransitionException 
    {
        
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(source);
            
            Node rootNode = doc.getDocumentElement();
            if (rootNode instanceof Element) {
                Element root = (Element) rootNode;
                
                if (!"automata".equals(root.getNodeName())) {
                    throw new InvalidFileException();
                }
                // Save type
                String typeStr = root.getAttribute("type");
                Type type =  Type.NFA;
                if (typeStr != null && typeStr.toLowerCase() == "dfa") {
                    type = Type.DFA;
                }
                
                HashMap<String,State> states = new HashMap();
                Set<Symbol> alphabet = new TreeSet();
                Set<Transition> transitions = new TreeSet();
                
                FA automata = new FA(
                        type,
                        states, 
                        null, 
                        transitions, 
                        alphabet
                );
                NodeList alphabets = root.getElementsByTagName("alphabeth");
                Element alphabetElement = alphabets.getLength() > 0 && alphabets.item(0) instanceof Element
                        ? (Element) alphabets.item(0) 
                        : null;
                if (alphabetElement == null) {
                    throw new LanguageException("Missing alphabet");
                }
                NodeList symbolNodes = alphabetElement.getElementsByTagName("symbol");
                for (int i = 0; i < symbolNodes.getLength(); i++) {
                    Node get = symbolNodes.item(i);
                    if (get instanceof Element) {
                        Element e = (Element) get;
                        String symb = e.getAttribute("value");
                        alphabet.add(new Symbol(symb));
                    }
                }
                
                
                
                NodeList statesNodes = root.getElementsByTagName("alphabeth");
                Element statesElement = statesNodes.getLength() > 0 && statesNodes.item(0) instanceof Element
                        ? (Element) statesNodes.item(0) 
                        : null;
                if (statesElement == null) {
                    throw new InvalidFileException("Missing states");
                }
                NodeList stateNodes = statesElement.getElementsByTagName("state");
                for (int i = 0; i < stateNodes.getLength(); i++) {
                    Node get = stateNodes.item(i);
                    if (get instanceof Element) {
                        Element e = (Element) get;
                        String name = e.getAttribute("name");
                        String isFinal = e.getAttribute("isFinal");
                        String isStart = e.getAttribute("isStart");
                        State q = new State(name);
                        if ("true".equals(isFinal)) {
                            q.isFinal(true);
                        }
                        states.put(name, q);
                        if ("true".equals(isStart)) {
                            automata.setStartState(q);
                        }
                    }
                }
                
                
                
                
                NodeList transitionsNodes = root.getElementsByTagName("alphabeth");
                Element transitionsElement = transitionsNodes.getLength() > 0 && transitionsNodes.item(0) instanceof Element
                        ? (Element) transitionsNodes.item(0) 
                        : null;
                if (transitionsElement != null) {
                    NodeList transitionNodes = transitionsElement.getElementsByTagName("state");
                    for (int i = 0; i < transitionNodes.getLength(); i++) {
                        Node get = transitionNodes.item(i);
                        if (get instanceof Element) {
                            Element e = (Element) get;
                            
                            String fromStr = e.getAttribute("from");
                            String toStr = e.getAttribute("to");
                            String symbolStr = e.getAttribute("symbol");
                            
                            State from = states.get(fromStr);
                            State to = states.get(toStr);
                            
                            Symbol symb = null;
                            
                            Iterator<Symbol> it = alphabet.iterator();
                            while (it.hasNext()) {
                                Symbol next = it.next();
                                if (next.toString().equals(symbolStr)) {
                                    symb = next;
                                }
                            }
                            if (symb == null) {
                                throw new LanguageException("Missing symbol "+symbolStr);
                            }
                            automata.addTransition(from, to, symb);
                        }
                    }
                } 
            } 
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(FA.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(FA.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FA.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        throw new InvalidFileException();
    }
}