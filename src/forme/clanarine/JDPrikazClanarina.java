/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.clanarine;

import domen.Clanarina;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author mdzeletovic
 */
public class JDPrikazClanarina extends javax.swing.JDialog {

    /**
     * Creates new form JDPrikazClanarina
     */
    List<Clanarina> listaZaPrikaz;
    public JDPrikazClanarina(java.awt.Frame parent, boolean modal, List<Clanarina> lista) {
        super(parent, modal);
        listaZaPrikaz = lista;
        initComponents();
        srediFormu();
        jTblClanarine.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                if (jTblClanarine.getSelectedRowCount() == 1) {
                    jBtnIzmeniClanarinu.setEnabled(true);
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jCmbFilter = new javax.swing.JComboBox<>();
        jTxtFilter = new javax.swing.JTextField();
        jBtnTrazi = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTblClanarine = new javax.swing.JTable();
        jBtnIzmeniClanarinu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Filter po:");

        jBtnTrazi.setText("Trazi");
        jBtnTrazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnTraziActionPerformed(evt);
            }
        });

        jTblClanarine.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ClanarinaID", "VaziOd", "VaziDo", "Cena"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTblClanarine.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jTblClanarine);

        jBtnIzmeniClanarinu.setText("Izmeni clanarinu");
        jBtnIzmeniClanarinu.setEnabled(false);
        jBtnIzmeniClanarinu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnIzmeniClanarinuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCmbFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTxtFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtnTrazi)
                .addGap(43, 43, 43))
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(176, 176, 176)
                .addComponent(jBtnIzmeniClanarinu)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCmbFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnTrazi)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jBtnIzmeniClanarinu)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 479, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnTraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnTraziActionPerformed
        RowFilter rf = RowFilter.regexFilter(jTxtFilter.getText(), jCmbFilter.getSelectedIndex());
        final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(jTblClanarine.getModel());
        jTblClanarine.setRowSorter(sorter);
        sorter.setRowFilter(rf);
        jTblClanarine.clearSelection();
    }//GEN-LAST:event_jBtnTraziActionPerformed

    private void jBtnIzmeniClanarinuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIzmeniClanarinuActionPerformed
        try {
            int pom = jTblClanarine.getSelectedRow();
            long ClanarinaID = (long) jTblClanarine.getModel().getValueAt(pom, 0);
            Clanarina selektovanaClanarina = ((ClanarinaTableModel) jTblClanarine.getModel()).getClanarinaPoId(ClanarinaID);
            
            FrmUnosClanarine frm = new FrmUnosClanarine(2, selektovanaClanarina);
            frm.setVisible(true);
            
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(JDPrikazClanarina.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBtnIzmeniClanarinuActionPerformed

    private void srediFormu() {
        
         try {
            for (int i = 0; i < jTblClanarine.getColumnCount(); i++) {
                jCmbFilter.addItem(jTblClanarine.getColumnName(i));
            }
             
            ClanarinaTableModel model = new ClanarinaTableModel(listaZaPrikaz, jTblClanarine);

            jTblClanarine.setModel(model);

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        
        
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnIzmeniClanarinu;
    private javax.swing.JButton jBtnTrazi;
    private javax.swing.JComboBox<String> jCmbFilter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTblClanarine;
    private javax.swing.JTextField jTxtFilter;
    // End of variables declaration//GEN-END:variables

}
