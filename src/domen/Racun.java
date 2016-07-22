/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.util.Date;

/**
 *
 * @author mdzeletovic
 */
public class Racun {
    
    private long racunID;
    private Date datumIzdavanja;
    private double cena;
    private Zaposleni zaposleniObradio;
    private Clan clanUplatio;

    public Clan getClanUplatio() {
        return clanUplatio;
    }

    public void setClanUplatio(Clan clanUplatio) {
        this.clanUplatio = clanUplatio;
    }

    public Zaposleni getZaposleniObradio() {
        return zaposleniObradio;
    }

    public void setZaposleniObradio(Zaposleni zaposleniObradio) {
        this.zaposleniObradio = zaposleniObradio;
    }

    public long getRacunID() {
        return racunID;
    }

    public void setRacunID(long racunID) {
        this.racunID = racunID;
    }

    public Date getDatumIzdavanja() {
        return datumIzdavanja;
    }

    public void setDatumIzdavanja(Date datumIzdavanja) {
        this.datumIzdavanja = datumIzdavanja;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }
}
