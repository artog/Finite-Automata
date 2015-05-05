package se.monaden.finiteautomata.base;

import java.util.Objects;

/**
 *
 * @author Adam
 */
public class State {
    private String name;
    private boolean isFinal;

    public State(String name, boolean isFinal) {
        this.name = name;
        this.isFinal = isFinal;
    }
    
    public State(String name) {
        this(name,false);
    }

    public boolean isFinal() {
        return isFinal;
    }

    public boolean isFinal(boolean isFinal) {
        this.isFinal = isFinal;
        return isFinal;
    }

    public String name() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        if (isFinal) {
            return "("+name+")";
        }
        return name;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.name);
        hash = 79 * hash + (this.isFinal ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final State other = (State) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (this.isFinal != other.isFinal) {
            return false;
        }
        return true;
    }
    
    
    
    
}
