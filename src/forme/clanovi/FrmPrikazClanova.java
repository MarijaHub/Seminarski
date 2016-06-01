/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.clanovi;

import domen.Clan;
import java.util.List;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import poslovnaLogika.Kontroler;

/**
 *
 * @author mdzeletovic
 */
public class FrmPrikazClanova extends javax.swing.JPanel {

    /**
     * Creates new form FrmPrikazClanova
     */
    public FrmPrikazClanova() {
        initComponents();
        srediFormu();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTblClanovi = new javax.swing.JTable();
        jCmbFilter = new javax.swing.JComboBox<>();
        jTxtFilter = new javax.swing.JTextField();
        jBtnTrazi = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jTblClanovi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "LiceID", "JMBG", "Ime", "Prezime", "Telefon"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTblClanovi.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(jTblClanovi);
        jTblClanovi.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jCmbFilter.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                BlaBla(evt);
            }
        });

        jBtnTrazi.setText("Trazi");
        jBtnTrazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnTraziActionPerformed(evt);
            }
        });

        jLabel1.setText("Filter po:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCmbFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTxtFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtnTrazi)
                .addGap(83, 83, 83))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCmbFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnTrazi)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BlaBla(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_BlaBla
        // TODO add your handling code here:
    }//GEN-LAST:event_BlaBla

    private void jBtnTraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnTraziActionPerformed
        RowFilter rf = RowFilter.regexFilter(jTxtFilter.getText(), jCmbFilter.getSelectedIndex());
        //jTblClanovi.getRowSorter().setSortKeys(keys); setRowFilter(rf);
        final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(jTblClanovi.getModel());
        jTblClanovi.setRowSorter(sorter);
        sorter.setRowFilter(rf);
        
        
    }//GEN-LAST:event_jBtnTraziActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnTrazi;
    private javax.swing.JComboBox<String> jCmbFilter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTblClanovi;
    private javax.swing.JTextField jTxtFilter;
    // End of variables declaration//GEN-END:variables

    private void srediFormu() {
        for (int i = 0; i < jTblClanovi.getColumnCount(); i++) {
            jCmbFilter.addItem(jTblClanovi.getColumnName(i));
        }
        
        List<Clan> lc = Kontroler.getInstance().vratiClanove();
        DefaultTableModel tableModel = (DefaultTableModel) jTblClanovi.getModel();
        for (Clan c : lc) {
            Object[] red = new Object[9];
            red[0] = c.getLiceID();
            red[1] = c.getJmbg();
            red[2] = c.getIme();
            red[3] = c.getPrezime();
            red[4] = c.getTelefon();
            tableModel.addRow(red);
        }
        
        
    }
}