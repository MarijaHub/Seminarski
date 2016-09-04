/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.clanovi;

import domen.Clan;
import forme.clanovi.model.ClanTableModel;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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

        jCmbFilter = new javax.swing.JComboBox<>();
        jTxtFilter = new javax.swing.JTextField();
        jBtnTrazi = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jBtnIzmeni = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTblClanovi = new javax.swing.JTable();

        jCmbFilter.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCmbfilterStateChanded(evt);
            }
        });

        jBtnTrazi.setText("Trazi");
        jBtnTrazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnTraziActionPerformed(evt);
            }
        });

        jLabel1.setText("Filter po:");

        jBtnIzmeni.setText("Izmeni clana");
        jBtnIzmeni.setEnabled(ActiveBtnIzmeni());
        jBtnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnIzmeniActionPerformed(evt);
            }
        });

        jTblClanovi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "LiceID", "JMBG", "Ime", "Prezime", "Telefon"
            }
        ));
        jScrollPane2.setViewportView(jTblClanovi);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCmbFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTxtFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnTrazi)
                        .addGap(83, 83, 83))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(99, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(223, 223, 223)
                .addComponent(jBtnIzmeni)
                .addGap(0, 0, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtnIzmeni)
                .addContainerGap(25, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jCmbfilterStateChanded(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCmbfilterStateChanded
        // TODO add your handling code here:
    }//GEN-LAST:event_jCmbfilterStateChanded

    private void jBtnTraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnTraziActionPerformed
        RowFilter rf = RowFilter.regexFilter(jTxtFilter.getText(), jCmbFilter.getSelectedIndex());
        final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(jTblClanovi.getModel());
        jTblClanovi.setRowSorter(sorter);
        sorter.setRowFilter(rf);


    }//GEN-LAST:event_jBtnTraziActionPerformed

    private void jBtnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIzmeniActionPerformed


    }//GEN-LAST:event_jBtnIzmeniActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnIzmeni;
    private javax.swing.JButton jBtnTrazi;
    private javax.swing.JComboBox<String> jCmbFilter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTblClanovi;
    private javax.swing.JTextField jTxtFilter;
    // End of variables declaration//GEN-END:variables

    private void srediFormu() {

        try {
            for (int i = 0; i < jTblClanovi.getColumnCount(); i++) {
                jCmbFilter.addItem(jTblClanovi.getColumnName(i));
            }

            List<Clan> lc = Kontroler.getInstance().vratiClanove();

            ClanTableModel model = new ClanTableModel(lc, jTblClanovi);

            //DefaultTableModel tableModel = (DefaultTableModel)jTblClanovi.getModel();
            jTblClanovi.setModel(model);
            jTblClanovi.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent event) {
                    //enable button - put it in an EDT to be safe though
                }
            });
            } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }

//        List<Clan> clanovi;
//        try {
//            FileInputStream fileIn = new FileInputStream("C:/Users/mdzeletovic/Documents/NetBeansProjects/Seminarski/tmp/maarijaa.ser");
//            ObjectInputStream in = new ObjectInputStream(fileIn);
//            clanovi = (List<Clan>) in.readObject();
//            //cl = (ArrayList<Clan>) in.readObject();
//            in.close();
//            fileIn.close();
//
////            Scanner s = new Scanner(new File("C:/Users/mdzeletovic/Documents/NetBeansProjects/Seminarski/tmp/maarijaa.ser"));
////            ArrayList<String> lista = new ArrayList<String>();
////            while (s.hasNext()) {
////                lista.add(s.next());
////            }
////            s.close();
//        } catch (IOException i) {
//            i.printStackTrace();
//            return;
//        } catch (ClassNotFoundException c) {
//            System.out.println("Clanclass class not found");
//            c.printStackTrace();
//            return;
//        }
        }

    

    private boolean ActiveBtnIzmeni() {
        if (jTblClanovi.getSelectedRowCount() == 1) {
            return true;
        }
        return false;
    }

}
