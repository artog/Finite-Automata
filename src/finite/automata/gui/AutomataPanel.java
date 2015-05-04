/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finite.automata.gui;

import finite.automata.base.FA;
import finite.automata.base.State;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JPanel;

/**
 *
 * @author adam
 */
public class AutomataPanel extends JPanel {

    private FA fa = null;

    public void setFa(FA fa) {
        this.fa = fa;
    }
    
    
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING, 
                RenderingHints.VALUE_ANTIALIAS_ON
        );
        
        if (fa != null) {
            
            HashMap<String, State> states = fa.getStates();
            int n = 0;
            
            for (Map.Entry<String, State> entry : states.entrySet()) {
                String name = entry.getKey();
                State s = entry.getValue();
                g.drawString(name, (n % 4)*50, (n / 4)*50);
            }
        }
    }
    
}
