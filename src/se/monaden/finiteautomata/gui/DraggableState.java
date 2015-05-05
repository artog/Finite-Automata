/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.monaden.finiteautomata.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.Timer;
import javax.swing.border.LineBorder;
import se.monaden.finiteautomata.base.State;

/**
 *
 * @author Adam
 */
public class DraggableState extends JButton {
    
    private Point pos;
    private State state;
    
    private final Color hoverBackgroundColor = Color.white;
    private final Color pressedBackgroundColor = Color.LIGHT_GRAY;

    public DraggableState(Point pos, State state) {
        super(state.name());
        super.setContentAreaFilled(false);
        
        this.pos = pos;
        this.state = state;
        
        this.setBorder(new LineBorder(Color.black));
        this.setBackground(Color.white);
        this.setMargin(new Insets(10, 10, 10, 10));
        update();
        
        this.addMouseListener(new MouseListener() {
            Timer timer = new Timer(10,new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    Point p = MainFrame.graphicsPanel.getMousePosition();
                    if (p == null) {
                        timer.stop();
                        return;
                    }
                    setPosition(p);
                    update();
                }
            });
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Click");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("Press");
                timer.start();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("Release");
                timer.stop();
            }

            @Override
            public void mouseEntered(MouseEvent e) { }

            @Override
            public void mouseExited(MouseEvent e) { }
        });
    }

    private void update() {
        Dimension size = getPreferredSize();
        Insets margin = this.getMargin();
        int w = size.width+margin.left+margin.right;
        int h = size.height+margin.top+margin.bottom;
        
        if (w < h) {
            w = h;
        }
        this.setBounds(
                pos.x - w/2, 
                pos.y - h/2, 
                w, 
                h
        );
    }
    
    public void setPosition(Point p) {
        this.pos = p;
    }
    
    
    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isPressed()) {
            g.setColor(pressedBackgroundColor);
        } else if (getModel().isRollover()) {
            g.setColor(hoverBackgroundColor);
        } else {
            g.setColor(getBackground());
        }
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }

    @Override
    public void setContentAreaFilled(boolean b) {
    }

    public Color getHoverBackgroundColor() {
        return hoverBackgroundColor;
    }

    public Color getPressedBackgroundColor() {
        return pressedBackgroundColor;
    }

//    @Override
//    protected void paintComponent(Graphics g) 
//    {
//        super(g);
//        FontMetrics fm = g.getFontMetrics();
//        int strWidth = fm.stringWidth(state.name());
//        int strHeight = fm.getAscent() - fm.getDescent();
//        
//        int x = pos.x - strWidth/2;
//        int y = pos.y - strHeight/2;
//        int padding = 10;
////        System.out.printf("Painting %s at (%d,%d) %n",name,pos.x,pos.y);
//        g.setColor(Color.white);
//        g.fillRoundRect( x-padding, y-padding, strWidth+padding*2, strHeight+padding*2, 10, 10);
//        g.setColor(Color.black);
//        g.drawRoundRect( x-padding, y-padding, strWidth+padding*2, strHeight+padding*2, 10, 10);
//        g.drawString(state.name(), x, pos.y+strHeight/2);
//    }
}
