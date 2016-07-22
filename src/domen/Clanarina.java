/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.util.Date;
import java.util.List;

/**
 *
 * @author mdzeletovic
 */
public class Clanarina {
    
    private long clanarinaID;
    private Date vaziOd;
    private Date VaziDo;
    private double Cena;
    private List <StavkaClanarine> stavke; 
    private Zaposleni zaposleniKreirao;

    public Zaposleni getZaposleniKreirao() {
        return zaposleniKreirao;
    }

    public void setZaposleniKreirao(Zaposleni zaposleniKreirao) {
        this.zaposleniKreirao = zaposleniKreirao;
    }

    public List<StavkaClanarine> getStavke() {
        return stavke;
    }

    public void setStavke(List<StavkaClanarine> stavke) {
        this.stavke = stavke;
    }

    public long getClanarinaID() {
        return clanarinaID;
    }

    public void setClanarinaID(long clanarinaID) {
        this.clanarinaID = clanarinaID;
    }

    public Date getVaziOd() {
        return vaziOd;
    }

    public void setVaziOd(Date vaziOd) {
        this.vaziOd = vaziOd;
    }

    public Date getVaziDo() {
        return VaziDo;
    }

    public void setVaziDo(Date VaziDo) {
        this.VaziDo = VaziDo;
    }

    public double getCena() {
        return Cena;
    }

    public void setCena(double Cena) {
        this.Cena = Cena;
    }

    public Clanarina(long clanarinaID, Date vaziOd, Date VaziDo, double Cena) {
        this.clanarinaID = clanarinaID;
        this.vaziOd = vaziOd;
        this.VaziDo = VaziDo;
        this.Cena = Cena;
    }
    
    
    
}
