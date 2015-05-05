/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.monaden.finiteautomata.gui;

import java.awt.Color;
import java.awt.FontMetrics;
import se.monaden.finiteautomata.base.FA;
import se.monaden.finiteautomata.base.State;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import se.monaden.finiteautomata.base.Transition;
import se.monaden.finiteautomata.base.exceptions.ExistingStateException;

/**
 *
 * @author adam
 */
public class GraphicalFA extends JPanel {

    private FA fa = null;
    private Set<DraggableState> states = new LinkedHashSet();

    public GraphicalFA() {
        this.setLayout(null);
    }
    
    public void setFa(FA fa) {
        System.out.println("Setting FA");
        this.fa = new FA(
                fa.getType(),
                new HashMap(),
                fa.getStartState(),
                fa.getTransitions(),
                fa.getAlphabet()
        );
        
        int n = fa.getStates().size();
        int k = 0;
        
        for (Map.Entry<String, State> entrySet : fa.getStates().entrySet()) {
            State value = entrySet.getValue();
            try {
                double angle = k*((Math.PI*2)/n);
                Point p = getCirclePos(angle);
                addState(value, p);
                k++;
            } catch (ExistingStateException ex) {
                Logger.getLogger(GraphicalFA.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        repaint();
    }
    
    private Point getCirclePos(double angle) {
        Point center = new Point(
            getWidth()/2,
            getHeight()/2
        );
        int x = center.x+(int)Math.round(Math.sin(angle)*100);
        int y = center.y+(int)Math.round(Math.cos(angle)*100);
        
        return new Point(x, y);
    }
    
    public void addState(State s, Point p) throws ExistingStateException {
        fa.addState(s);
        DraggableState stateBtn = new DraggableState(p, s);
        System.out.printf("%d %d%n",p.x,p.y);
        states.add(stateBtn);
        add(stateBtn);
    }
    
    public void addState(State s) throws ExistingStateException {
        addState(
            s, 
            new Point(
                getWidth()/2,
                getHeight()/2
            )
        );
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
            
//            Map<String, State> states = fa.getStates();
//            int n = 0;
//            
//            for (Map.Entry<String, State> entry : states.entrySet()) {
//                String name = entry.getKey();
//                State s = entry.getValue();
//                FontMetrics fm = g.getFontMetrics();
//                int strWidth = fm.stringWidth(name);
//                int strHeight = fm.getAscent() - fm.getDescent();
//                int centerX = ((n % 2)+1)*50;
//                int centerY = ((n / 2)+1)*50;
//                int x = centerX - strWidth/2;
//                int y = centerY - strHeight/2;
//                int padding = 10;
//                System.out.printf("Painting %s at (%d,%d) %n",name,centerX,centerY);
//                g.setColor(Color.white);
//                g.fillRoundRect( x-padding, y-padding, strWidth+padding*2, strHeight+padding*2, 10, 10);
//                g.setColor(Color.black);
//                g.drawRoundRect( x-padding, y-padding, strWidth+padding*2, strHeight+padding*2, 10, 10);
//                g.drawString(name, x, centerY+strHeight/2);
//                n++;
//            }
        } else {
            System.out.println("FA is null");
        }
    }
    
}
