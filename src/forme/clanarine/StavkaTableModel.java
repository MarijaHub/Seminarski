/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.clanarine;

import domen.Clanarina;
import domen.StavkaClanarine;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author mdzeletovic
 */
public class StavkaTableModel extends AbstractTableModel {
    private List<StavkaClanarine> listaStavki;
    private JTable tabelaStavki;
    private final String[] kolone = new String[]{"Naziv", "Broj termina nedeljno", "Cena termina"};;

    public StavkaTableModel() {
        listaStavki = new ArrayList<>();
    }


    @Override
    public int getRowCount() {
        if (listaStavki == null) {
            return 0;
        }
        return listaStavki.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StavkaClanarine stavka = listaStavki.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return stavka.getNaziv();
            case 1:
                return stavka.getBrTerminaNedeljno();
            case 2:
                return stavka.getCenaTermina();
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
        StavkaClanarine stavka = listaStavki.get(rowIndex);
        switch (columnIndex) {
            case 0:
                stavka.setNaziv((String) aValue);
                break;
            case 1:
                stavka.setBrTerminaNedeljno(Integer.parseInt((String) aValue));
                break;
            case 2:
                stavka.setCenaTermina(Double.parseDouble((String) aValue));
                break;
        }
    }

    public StavkaClanarine getStavka(int red) {
        return listaStavki.get(red);
    }

    public void dodajRed() {
        listaStavki.add(new StavkaClanarine());
        fireTableDataChanged();
    }

    public void obrisiRed(int red) {
        listaStavki.remove(red);
        System.out.println("Obrisan je red!");
        fireTableDataChanged();
    }

    public List<StavkaClanarine> vratiStavke() {
        return listaStavki;
    }
}
