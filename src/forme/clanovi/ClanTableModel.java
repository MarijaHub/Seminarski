/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.clanovi;

import domen.Clan;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author mdzeletovic
 */
public class ClanTableModel extends AbstractTableModel {

    private List<Clan> lc;
    private JTable jtC;
    private final String[] kolone;

    public ClanTableModel(List<Clan> lc, JTable tableClanovi) {
        this.lc = lc;
        jtC = tableClanovi;
        kolone = new String[jtC.getColumnCount()];

        for (int i = 0; i < jtC.getColumnCount(); i++) {

            kolone[i] = jtC.getColumnName(i);
        }
    }

    //private final DateFormat df = new SimpleDateFormat("dd.MM.yyyy");

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
        Clan clan = lc.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return clan.getLiceID();
            case 1:
                return clan.getJmbg();
            case 2:
                return clan.getIme();
            case 3:
                return clan.getPrezime();
            case 4:
                return clan.getAdresa();
            case 5:
                return clan.getEmail();
            case 6:
                return clan.getTelefon();
            case 7:
                return clan.getPoslednjaUplata();
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
        Clan clan = lc.get(rowIndex);
        switch (columnIndex) {
            case 0:
                clan.setLiceID(Long.parseLong((String) aValue));
                break;
            case 1:
                clan.setJmbg((String) aValue);
                break;
            case 2:
                clan.setIme(((String) aValue));
                break;
            case 3:
                clan.setPrezime(((String) aValue));
                break;
            case 4:
                clan.setTelefon(((String) aValue));
                break;
        }
    }

    public Clan getClan(int red) {
        return lc.get(red);
    }

    public void dodajRed() {
        lc.add(new Clan());
        System.out.println("Dodat je novi Clan!");
        fireTableDataChanged();
    }

    public void obrisiRed(int red) {
        lc.remove(red);
        System.out.println("Obrisan je red!");
        fireTableDataChanged();
    }

    public List<Clan> vratiClanove() {
        return lc;
    }



    public Clan getClanPoId(long LiceID) {
        for (Clan clan : lc) {
            if (clan.getLiceID() == LiceID) {
                return clan;
            }
            
        }
        return null;
    }

}
