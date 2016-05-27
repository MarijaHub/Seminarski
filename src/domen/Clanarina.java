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
public class Clanarina {
    
    private long clanarinaID;
    private Date vaziOd;
    private Date VaziDo;
    private double Cena;

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
    
    
    
}
