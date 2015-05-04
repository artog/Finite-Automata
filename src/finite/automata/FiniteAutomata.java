/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finite.automata;

import finite.automata.base.Exceptions.LanguageException;
import finite.automata.base.*;
import finite.automata.gui.MainFrame;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
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
        
        MainFrame mf = new MainFrame();
        mf.setVisible(true);
        
//        try {
////            testFA();
//            Alphabeth a = new Alphabeth("abc");
//            
//            
//            Set<String> words = a.getWords(5);
//            
//            System.out.println(words.toString());
//            
//        } catch (LanguageException ex) {
//            Logger.getLogger(FiniteAutomata.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        Set<String> perms = new HashSet();
//        String[] a = {"0","1","2","3","4"};
        
        
//        new FiniteAutomata();
        
        
    } 

    public FiniteAutomata() {
        Comparator cmp = new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                String s1 = (String)o1;
                String s2 = (String)o2;
                
                if (s1.length() == s2.length()) {
                    return s1.compareTo(s2);
                }
                
                return s1.length() - s2.length();
            }
        };
        
        
        TreeMap<String,S> transitions = new TreeMap(cmp);
        init(transitions);
        
        String[] a = {"0","1","2"};
        ArrayList<String> skip = new ArrayList(Arrays.asList(a));
        transitions.get("0").zero.addAll(new TreeSet(Arrays.asList("0")));
        transitions.get("0").one .addAll(new TreeSet(Arrays.asList("0","1")));
        transitions.get("0").two .addAll(new TreeSet(Arrays.asList("4")));
        transitions.get("1").one .addAll(new TreeSet(Arrays.asList("2")));
        transitions.get("2").one .addAll(new TreeSet(Arrays.asList("3")));
        transitions.get("3").zero.addAll(new TreeSet(Arrays.asList("3")));
        transitions.get("3").one .addAll(new TreeSet(Arrays.asList("3")));
        transitions.get("3").two .addAll(new TreeSet(Arrays.asList("3")));
        transitions.get("4").zero.addAll(new TreeSet(Arrays.asList("4")));
        transitions.get("4").one .addAll(new TreeSet(Arrays.asList("1","4")));
        transitions.get("4").two .addAll(new TreeSet(Arrays.asList("0")));

        for (Map.Entry<String, S> entry : transitions.entrySet()) {
            String key = entry.getKey();
            if (skip.indexOf(key) != -1) {
                continue;
            }
            S value = entry.getValue();
            String[] parts = key.split("");
            for (String symb : a) {
                TreeSet<String> union = new TreeSet();
                for (String part : parts) {
                    union.addAll(transitions.get(part).getSet(symb));
                }
                value.getSet(symb).addAll(union);
                
            }
        }
        
        
        
        
        System.out.printf("%5s | %5s |  %5s |  %5s |%n", "","0","1","2");
        
        for (Map.Entry<String, S> entry : transitions.entrySet()) {
            String key = entry.getKey();
            S value = entry.getValue();
            String s = String.format("%5s | %5s |  %5s |  %5s |",
                    key,
                    value.getStr("0"),
                    value.getStr("1"),
                    value.getStr("2")
            );
            System.out.println(s);
        }
    }
    
    
    
    class S {

        public final TreeSet<String> zero = new TreeSet();
        public final TreeSet<String> one = new TreeSet();
        public final TreeSet<String> two = new TreeSet();
        
        public S() {
            
        }

        public void addToSet(HashSet<String> add,String index) {
            if (index == "0") {
                zero.addAll(add);
            } else if (index == "1") {
                one.addAll(add);
            } else {
                two.addAll(add);
            }
        }
        
        public String getStr(String index) {
            switch (index) {
                case "0":
                    return setToStr(zero);
                case "1":
                    return setToStr(one);
                default:
                    return setToStr(two);
            }
        }
        
        public TreeSet<String> getSet(String index) {
            if (null != index) switch (index) {
                case "0":
                    return zero;
                case "1":
                    return one;
            }
            return two;
        }
    }
    
    public static String setToStr(TreeSet<String> set) {
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            String n = it.next();
            sb.append(n);
        }
        return sb.toString();
    }
    
    private void init(TreeMap<String,S> all) {
        all.put("0",new S());
        all.put("1",new S());
        all.put("2",new S());
        all.put("3",new S());
        all.put("4",new S());
        all.put("01",new S());
        all.put("02",new S());
        all.put("03",new S());
        all.put("04",new S());
        all.put("12",new S());
        all.put("13",new S());
        all.put("14",new S());
        all.put("23",new S());
        all.put("24",new S());
        all.put("34",new S());
        all.put("012",new S());
        all.put("013",new S());
        all.put("014",new S());
        all.put("023",new S());
        all.put("024",new S());
        all.put("034",new S());
        all.put("123",new S());
        all.put("124",new S());
        all.put("134",new S());
        all.put("234",new S());
        all.put("0123",new S());
        all.put("0124",new S());
        all.put("0134",new S());
        all.put("0234",new S());
        all.put("1234",new S());
        all.put("01234",new S());
    }
    
    public static void testFA() throws LanguageException {
        Set<Symbol> alphabet = new HashSet();
        Symbol a = new Symbol("a");
        alphabet.add(a);
        
        
        HashMap<String,State> states = new HashMap();
        final State q0 = new State("q0",true);
        final State q1 = new State("q1");
        final State q2 = new State("q2");
        
        states.put(q0.name(),q0);
        states.put(q1.name(),q1);
        states.put(q2.name(),q2);
        
        
        
        Set<Transition> ts = new HashSet();
        ts.add(new Transition(q0, q1, a));
        ts.add(new Transition(q1, q2, a));
        ts.add(new Transition(q2, q0, a));
        
        
        System.out.println(states);
        System.out.println(ts);
        
        String w = "aaaa";
        Word word = Word.fromString(w,alphabet);
        
        
        
        FA dfa = new FA(FA.Type.DFA,states, q0, ts, alphabet);
        
    }
//    
//    public static void testDFA() {
//        Set<Symbol> Sigma = new HashSet<>();
//        Sigma.add(new Symbol("0"));
//        Sigma.add(new Symbol("1"));
//        
//        
//        Set<State> F = new HashSet<>();
//        F.add(q1);
//        F.add(q2);
//        F.add(q3);
//        
//        Set<State> Q = new HashSet<>();
//        final State q0 = new State("Q0");
//        
//        Q.addAll(F);
//        Q.add(q0);
//        
//        DeltaDFA delta = new DeltaDFA() {
//
//            @Override
//            public State next(State q, Symbol a) {
//                if (q.equals(q0)) {
//                    return q1;
//                } else if (q.equals(q1)) {
//                    return q2;
//                } else if (q.equals(q2)) {
//                    return q3;
//                } else {
//                    return q0;
//                }
//            }
//            
//        };
//        
//        String w = "1110";
//        
//        DFA dfa = new DFA(Q, Sigma, delta, q0, F);
//        try {
//            System.out.println(dfa.run(Word.fromString(w,Sigma)));
//        } catch (LanguageException ex) {
//            Logger.getLogger(FiniteAutomata.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    public static void testNFA() {
//        Set<Symbol> Sigma = new HashSet<>();
//        Sigma.add(new Symbol("0"));
//        Sigma.add(new Symbol("1"));
//        
//        
//        final State q0 = new State("Q0");
//        final State q1 = new State("Q1");
//        final State q2 = new State("Q2");
//        final State q3 = new State("Q3");
//        final State q4 = new State("Q4");
//        final State q5 = new State("Q5");
//        final State q6 = new State("Q6");
//        final State q7 = new State("Q7");
//        final State q8 = new State("Q8");
//        
//        Set<State> F = new HashSet<>();
//        F.add(q0);
//        F.add(q3);
//        F.add(q8);
//        
//        Set<State> Q = new HashSet<>();
//        Set<State> Q0 = new HashSet<>();
//        
//        Q.add(q0);
//        Q.add(q1);
//        Q.add(q2);
//        Q.add(q3);
//        Q.add(q4);
//        Q.add(q5);
//        Q.add(q6);
//        Q.add(q7);
//        Q.add(q8);
//        
//        Q0.add(q0);
//        
//        
//        
//        DeltaNFA delta;
//        delta = new DeltaNFA() {
//            
//            @Override
//            public Set<State> next(State q, Symbol a) {
//                Set<State> next = new HashSet();
//                if (q.equals(q0)) {
//                    next.add(q1);
//                    next.add(q4);
//                } else if (q.equals(q1)) {
//                    next.add(q2);
//                } else if (q.equals(q2)) {
//                    next.add(q3);
//                } else if (q.equals(q3)) {
//                    next.add(q1);
//                } else if (q.equals(q4)) {
//                    next.add(q5);
//                } else if (q.equals(q5)) {
//                    next.add(q6);
//                } else if (q.equals(q6)) {
//                    next.add(q7);
//                } else if (q.equals(q7)) {
//                    next.add(q8);
//                } else {
//                    next.add(q4);
//                }
//                
//                
//                
//                return next;
//            }
//            
//            
//        };
//        
//        String w = "1111111";
//        
//        NFA dfa = new NFA(Q, Sigma, delta, Q0, F);
//        try {
//            System.out.println(dfa.run(Word.fromString(w,Sigma)));
//        } catch (LanguageException ex) {
//            Logger.getLogger(FiniteAutomata.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    
    
    public static void p(String s) {
        System.out.println(s);
    }
    
}
