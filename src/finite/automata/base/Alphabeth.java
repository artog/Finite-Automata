/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finite.automata.base;

import finite.automata.base.Exceptions.LanguageException;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author adam
 */
public class Alphabeth extends TreeSet<Symbol> {
    
    public Alphabeth(String[] symbs) throws LanguageException {
        for (String a : symbs) {
            this.add(new Symbol(a));
        }
    }
    
    public Alphabeth(String symbs) throws LanguageException {
        for (char a : symbs.toCharArray()) {
            this.add(new Symbol(a));
        }
    }
    
    public Set<String> getWords(int length) {
        Set<String> words = new TreeSet();
        // Base case
        if (length == 1) {
            for (Iterator<Symbol> it = this.iterator(); it.hasNext();) {
                Symbol a = it.next();
                words.add(a.toString());
            }
            return words;
        }
        
        Set<String> oneShort = getWords(length-1);
        for (Iterator<Symbol> it = this.iterator(); it.hasNext();) {
            Symbol a = it.next();
            for (String word : oneShort) {
                words.add(a+word);
            }
        }
        return words;
    }
}
