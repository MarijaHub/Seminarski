/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.clanarine;

import domen.Clan;
import domen.Clanarina;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author mdzeletovic
 */
public class ClanarinaTableModel extends AbstractTableModel {

    private List<Clanarina> lc;
    private JTable jtC;
    private final String[] kolone;

    public ClanarinaTableModel(List<Clanarina> lc, JTable tableClanarine) {
        this.lc = lc;
        jtC = tableClanarine;
        kolone = new String[jtC.getColumnCount()];

        for (int i = 0; i < jtC.getColumnCount(); i++) {

            kolone[i] = jtC.getColumnName(i);
        }
    }


    @Override
    public int getRowCount() {
        if (lc == null) {
            return 0;
        }
        return lc.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Clanarina clanarina = lc.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return clanarina.getClanarinaID();
            case 1:
                return clanarina.getVaziOd();
            case 2:
                return clanarina.getVaziDo();
            case 3:
                return clanarina.getCena();
            default:
                return "ooon/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Clanarina clan = lc.get(rowIndex);
        switch (columnIndex) {
            case 0:
                clan.setClanarinaID(Long.parseLong((String) aValue));
                break;
            case 1:
                clan.setVaziOd((Date) aValue);
                break;
            case 2:
                clan.setVaziDo(((Date) aValue));
                break;
            case 3:
                clan.setCena(((Double) aValue));
                break;
        }
    }

    public Clanarina getClan(int red) {
        return lc.get(red);
    }

    public void dodajRed() {
        lc.add(new Clanarina());
        System.out.println("Dodata je nova Clanarina!");
        fireTableDataChanged();
    }

    public void obrisiRed(int red) {
        lc.remove(red);
        System.out.println("Obrisan je red!");
        fireTableDataChanged();
    }

    public List<Clanarina> vratiClanarine() {
        return lc;
    }


}
