package finite.automata.base;

/**
 *
 * @author Adam
 */
public class State {
    public final String name;

    public State(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
}
