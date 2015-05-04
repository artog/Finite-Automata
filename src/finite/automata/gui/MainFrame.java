/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finite.automata.gui;

/**
 *
 * @author adam
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainToolbar = new javax.swing.JToolBar();
        newStateBtn = new javax.swing.JButton();
        newTransitionBtn = new javax.swing.JButton();
        graphicPanel = new AutomataPanel();
        menu = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        exitItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainToolbar.setRollover(true);

        newStateBtn.setText("New State");
        newStateBtn.setFocusable(false);
        newStateBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        newStateBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        newStateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newStateBtnActionPerformed(evt);
            }
        });
        mainToolbar.add(newStateBtn);

        newTransitionBtn.setText("New Transition");
        newTransitionBtn.setFocusable(false);
        newTransitionBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        newTransitionBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        newTransitionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newTransitionBtnActionPerformed(evt);
            }
        });
        mainToolbar.add(newTransitionBtn);

        getContentPane().add(mainToolbar, java.awt.BorderLayout.NORTH);

        graphicPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout graphicPanelLayout = new javax.swing.GroupLayout(graphicPanel);
        graphicPanel.setLayout(graphicPanelLayout);
        graphicPanelLayout.setHorizontalGroup(
            graphicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        graphicPanelLayout.setVerticalGroup(
            graphicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 254, Short.MAX_VALUE)
        );

        getContentPane().add(graphicPanel, java.awt.BorderLayout.CENTER);

        fileMenu.setText("File");

        exitItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_MASK));
        exitItem.setText("Exit");
        exitItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitItem);

        menu.add(fileMenu);

        editMenu.setText("Edit");
        menu.add(editMenu);

        setJMenuBar(menu);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitItemActionPerformed

    private void newStateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newStateBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newStateBtnActionPerformed

    private void newTransitionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newTransitionBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newTransitionBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JPanel graphicPanel;
    private javax.swing.JToolBar mainToolbar;
    private javax.swing.JMenuBar menu;
    private javax.swing.JButton newStateBtn;
    private javax.swing.JButton newTransitionBtn;
    // End of variables declaration//GEN-END:variables
}
