/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.glavna;

import forme.clanarine.FrmPrikazClanarina;
import forme.clanarine.FrmUnosClanarine;
import forme.clanovi.FrmPrikazClanova;
import forme.clanovi.FrmClanovi;
import java.awt.BorderLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;

/**
 *
 * @author mdzeletovic
 */
public class FrmGlavna extends javax.swing.JFrame {

    /**
     * Creates new form FrmGlavna
     */
    public FrmGlavna() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMBGlavniMeni = new javax.swing.JMenuBar();
        jMClanovi = new javax.swing.JMenu();
        jMIUnosClanova = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMIPrikazClanova = new javax.swing.JMenuItem();
        jMClanarine = new javax.swing.JMenu();
        jMIUnosClanarine = new javax.swing.JMenuItem();
        jMIPrikazClanarine = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMClanovi.setText("Clanovi");

        jMIUnosClanova.setText("Unos clana");
        jMIUnosClanova.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIUnosClanovaActionPerformed(evt);
            }
        });
        jMClanovi.add(jMIUnosClanova);

        jMenuItem1.setText("Izmena clana");
        jMenuItem1.setActionCommand("IzmenaClana");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIIzmenaClanaActionPerformed(evt);
            }
        });
        jMClanovi.add(jMenuItem1);

        jMIPrikazClanova.setText("Prikaz clanova");
        jMIPrikazClanova.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIPrikazClanovaActionPerformed(evt);
            }
        });
        jMClanovi.add(jMIPrikazClanova);

        jMBGlavniMeni.add(jMClanovi);

        jMClanarine.setText("Clanarine");

        jMIUnosClanarine.setText("Unos clanarine");
        jMIUnosClanarine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIUnosClanarineActionPerformed(evt);
            }
        });
        jMClanarine.add(jMIUnosClanarine);

        jMIPrikazClanarine.setText("Prikaz clanarina");
        jMIPrikazClanarine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIPrikazClanarineActionPerformed(evt);
            }
        });
        jMClanarine.add(jMIPrikazClanarine);

        jMBGlavniMeni.add(jMClanarine);

        setJMenuBar(jMBGlavniMeni);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMIUnosClanovaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIUnosClanovaActionPerformed
        FrmClanovi frmClanovi = new FrmClanovi(1);
        frmClanovi.setVisible(true);
        setLocationRelativeTo(null);
        
    }//GEN-LAST:event_jMIUnosClanovaActionPerformed

    private void jMIUnosClanarineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIUnosClanarineActionPerformed
        FrmUnosClanarine frmUnosClanarine = new FrmUnosClanarine();
        frmUnosClanarine.setVisible(true);
        setLocationRelativeTo(null);
    }//GEN-LAST:event_jMIUnosClanarineActionPerformed

    private void jMIPrikazClanovaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIPrikazClanovaActionPerformed
            FrmPrikazClanova f = new FrmPrikazClanova();
            JDialog d = new JDialog(this, "Prikaz clanova", true);
            d.setLayout(new BorderLayout());           
            d.add(f, BorderLayout.CENTER);
            d.pack();
            d.setLocationRelativeTo(null);
            d.setVisible(true);
        
        
    }//GEN-LAST:event_jMIPrikazClanovaActionPerformed

    private void jMIPrikazClanarineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIPrikazClanarineActionPerformed
        JDialog d = new JDialog(this, "Prikaz clanarina", true);
        d.setLayout(new BorderLayout());
        FrmPrikazClanarina f = new FrmPrikazClanarina();
        d.add(f, BorderLayout.CENTER);
        d.pack();
        d.setLocationRelativeTo(null);
        d.setVisible(true);
    }//GEN-LAST:event_jMIPrikazClanarineActionPerformed

    private void jMIIzmenaClanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIIzmenaClanaActionPerformed
        FrmClanovi frmClanovi = new FrmClanovi(2);
        frmClanovi.setVisible(true);
        setLocationRelativeTo(null);
    }//GEN-LAST:event_jMIIzmenaClanaActionPerformed

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
            java.util.logging.Logger.getLogger(FrmGlavna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmGlavna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmGlavna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmGlavna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmGlavna().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMBGlavniMeni;
    private javax.swing.JMenu jMClanarine;
    private javax.swing.JMenu jMClanovi;
    private javax.swing.JMenuItem jMIPrikazClanarine;
    private javax.swing.JMenuItem jMIPrikazClanova;
    private javax.swing.JMenuItem jMIUnosClanarine;
    private javax.swing.JMenuItem jMIUnosClanova;
    private javax.swing.JMenuItem jMenuItem1;
    // End of variables declaration//GEN-END:variables
}
