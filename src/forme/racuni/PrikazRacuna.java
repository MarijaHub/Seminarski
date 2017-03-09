/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.racuni;

import domen.Clan;
import domen.Racun;
import forme.clanovi.ClanTableModel;
import forme.clanovi.FrmClanoviUnosPretraga;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import poslovnaLogika.Kontroler;

/**
 *
 * @author mdzeletovic
 */
public class PrikazRacuna extends javax.swing.JDialog {

    /**
     * Creates new form PrikazRacuna
     */
    List<Racun> listaZaPrikaz;
    Racun racunSel;

    public PrikazRacuna(java.awt.Frame parent, boolean modal, List<Racun> listaZaPrikaz) {
        super(parent, modal);

        this.listaZaPrikaz = listaZaPrikaz;
        initComponents();
        srediFormu();
        jTblRacuni.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                if (jTblRacuni.getSelectedRowCount() == 1) {
                    jBtnStorniraj.setEnabled(true);
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCmbFilter = new javax.swing.JComboBox<>();
        jTxtFilter = new javax.swing.JTextField();
        jBtnTrazi = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jBtnStorniraj = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTblRacuni = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jBtnTrazi.setText("Trazi");
        jBtnTrazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnTraziActionPerformed(evt);
            }
        });

        jLabel1.setText("Filter po:");

        jBtnStorniraj.setText("Storniraj");
        jBtnStorniraj.setEnabled(false);
        jBtnStorniraj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnStornirajActionPerformed(evt);
            }
        });

        jTblRacuni.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "RacunID", "Datum izdavanja", "Cena", "Zaposleni obradio", "Clan uplatio", "ClanarinaID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTblRacuni);

        jButton1.setText("Detalji");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel1)
                        .addGap(62, 62, 62)
                        .addComponent(jCmbFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(jBtnStorniraj)
                        .addGap(114, 114, 114)
                        .addComponent(jButton1)))
                .addContainerGap(132, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(261, 261, 261)
                            .addComponent(jTxtFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jBtnTrazi))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jCmbFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 212, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnStorniraj)
                    .addComponent(jButton1))
                .addGap(23, 23, 23))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addComponent(jTxtFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jBtnTrazi))
                    .addGap(11, 11, 11)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(56, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnTraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnTraziActionPerformed
        RowFilter rf = RowFilter.regexFilter(jTxtFilter.getText(), jCmbFilter.getSelectedIndex());
        final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(jTblRacuni.getModel());
        jTblRacuni.setRowSorter(sorter);
        sorter.setRowFilter(rf);
    }//GEN-LAST:event_jBtnTraziActionPerformed

    private void jBtnStornirajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnStornirajActionPerformed
        try {
            int pom = jTblRacuni.getSelectedRow();
            long RacunID = (long) jTblRacuni.getModel().getValueAt(pom, 0);
            Racun selektovaniRacun = ((RacunTableModel) jTblRacuni.getModel()).getRacunPoId(RacunID);
            
            Kontroler.getInstance().brisiRacun(selektovaniRacun);
           ((RacunTableModel) jTblRacuni.getModel()).fireTableDataChanged();
            
        } catch (Exception ex) {
            Logger.getLogger(PrikazRacuna.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBtnStornirajActionPerformed


    private void srediFormu() {
        try {
            for (int i = 0; i < jTblRacuni.getColumnCount(); i++) {
                jCmbFilter.addItem(jTblRacuni.getColumnName(i));
            }

            RacunTableModel model = new RacunTableModel(listaZaPrikaz, jTblRacuni);

            jTblRacuni.setModel(model);

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnStorniraj;
    private javax.swing.JButton jBtnTrazi;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jCmbFilter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTblRacuni;
    private javax.swing.JTextField jTxtFilter;
    // End of variables declaration//GEN-END:variables
}
