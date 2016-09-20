/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.racuni;

import forme.clanovi.*;
import domen.Clan;
import domen.Clanarina;
import domen.Racun;
import domen.Zaposleni;
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
public class RacunTableModel extends AbstractTableModel {

    private List<Racun> lc;
    private JTable jtC;
    private final String[] kolone;

    public RacunTableModel(List<Racun> lc, JTable tableRacuni) {
        this.lc = lc;
        jtC = tableRacuni;
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
        Racun racun = lc.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return racun.getRacunID();
            case 1:
                return racun.getDatumIzdavanja();
            case 2:
                return racun.getCena();
            case 3:
                return racun.getZaposleniObradio();
            case 4:
                return racun.getClanUplatio();
            case 5:
                return racun.getClanarina();
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
        Racun racun = lc.get(rowIndex);
        switch (columnIndex) {
            case 0:
                racun.setRacunID(Long.parseLong((String) aValue));
                break;
            case 1:
                racun.setDatumIzdavanja((Date) aValue);
                break;
            case 2:
                racun.setCena(((Double) aValue));
                break;
            case 3:
                racun.setZaposleniObradio(((Zaposleni) aValue));
                break;
            case 4:
                racun.setClanUplatio(((Clan) aValue));
                break;
            case 5:
                racun.setClanarina(((Clanarina) aValue));
                break;
        }
    }

    public Racun getRacun(int red) {
        return lc.get(red);
    }

    public void dodajRed() {
        lc.add(new Racun());
        System.out.println("Dodat je novi Clan!");
        fireTableDataChanged();
    }

    public void obrisiRed(int red) {
        lc.remove(red);
        System.out.println("Obrisan je red!");
        fireTableDataChanged();
    }

    public List<Racun> vratiClanove() {
        return lc;
    }

    public Racun getRacunPoId(long RacunID) {
        for (Racun r : lc) {
            if (r.getRacunID() == RacunID) {
                return r;
            }

        }
        return null;
    }

}
