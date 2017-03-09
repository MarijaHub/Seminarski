/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.glavna;

import forme.clanarine.JDPrikazClanarina;
import forme.clanarine.FrmUnosClanarine;
//import forme.clanovi.FrmPrikazClanova;
import forme.clanovi.FrmClanoviUnosPretraga;
import forme.clanovi.JDPrikazClanova;
import forme.racuni.PrikazRacuna;
import forme.racuni.UnosRacunaa;
import java.awt.BorderLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import poslovnaLogika.Kontroler;

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
        jMRacuni = new javax.swing.JMenu();
        jMIUnosRacuna = new javax.swing.JMenuItem();
        jMIPrikazRacuna = new javax.swing.JMenuItem();

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

        jMRacuni.setText("Racuni");

        jMIUnosRacuna.setText("Unos racuna");
        jMIUnosRacuna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIUnosRacunaActionPerformed(evt);
            }
        });
        jMRacuni.add(jMIUnosRacuna);

        jMIPrikazRacuna.setText("Prikaz racuna");
        jMIPrikazRacuna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIPrikazRacunaActionPerformed(evt);
            }
        });
        jMRacuni.add(jMIPrikazRacuna);

        jMBGlavniMeni.add(jMRacuni);

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
        FrmClanoviUnosPretraga frmClanovi = new FrmClanoviUnosPretraga(1, null);
        frmClanovi.setVisible(true);
        setLocationRelativeTo(null);
        JOptionPane.showMessageDialog(this, "Sistem je zapamtio novu članarinu");

    }//GEN-LAST:event_jMIUnosClanovaActionPerformed

    private void jMIUnosClanarineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIUnosClanarineActionPerformed
        try {
            FrmUnosClanarine frmUnosClanarine = new FrmUnosClanarine(1, null);
            frmUnosClanarine.setVisible(true);
            setLocationRelativeTo(null);
        } catch (Exception ex) {
            Logger.getLogger(FrmGlavna.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMIUnosClanarineActionPerformed

    private void jMIPrikazClanovaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIPrikazClanovaActionPerformed
        try {
            JDPrikazClanova dialogPrikaz = new JDPrikazClanova(this, rootPaneCheckingEnabled, Kontroler.getInstance().vratiClanove());
            dialogPrikaz.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(FrmGlavna.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMIPrikazClanovaActionPerformed

    private void jMIPrikazClanarineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIPrikazClanarineActionPerformed
        try {
            JDPrikazClanarina f = new JDPrikazClanarina(this, rootPaneCheckingEnabled, Kontroler.getInstance().vratiClanarine());
            f.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(FrmGlavna.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMIPrikazClanarineActionPerformed

    private void jMIIzmenaClanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIIzmenaClanaActionPerformed
        FrmClanoviUnosPretraga frmClanovi = new FrmClanoviUnosPretraga(2, null);
        frmClanovi.setVisible(true);
        setLocationRelativeTo(null);
    }//GEN-LAST:event_jMIIzmenaClanaActionPerformed

    private void jMIUnosRacunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIUnosRacunaActionPerformed
        try {
            UnosRacunaa frmUnosRacuna = new UnosRacunaa();
            frmUnosRacuna.setVisible(true);
            setLocationRelativeTo(null);
        } catch (Exception ex) {
            Logger.getLogger(FrmGlavna.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMIUnosRacunaActionPerformed

    private void jMIPrikazRacunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIPrikazRacunaActionPerformed
        try {
            PrikazRacuna dialog = new PrikazRacuna(null, true, Kontroler.getInstance().vratiRacune());
            dialog.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(FrmGlavna.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMIPrikazRacunaActionPerformed

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
    private javax.swing.JMenuItem jMIPrikazRacuna;
    private javax.swing.JMenuItem jMIUnosClanarine;
    private javax.swing.JMenuItem jMIUnosClanova;
    private javax.swing.JMenuItem jMIUnosRacuna;
    private javax.swing.JMenu jMRacuni;
    private javax.swing.JMenuItem jMenuItem1;
    // End of variables declaration//GEN-END:variables
}
