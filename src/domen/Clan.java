/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author mdzeletovic
 */
public class Clan extends Lice implements Serializable{
    
    
    private Date poslednjaUplata;

    public Date getPoslednjaUplata() {
        return poslednjaUplata;
    }

    public void setPoslednjaUplata(Date poslednjaUplata) {
        this.poslednjaUplata = poslednjaUplata;
    }

    public Clan(Date poslednjaUplata, String jmbg, String ime, String prezime, String adresa, String email, String telefon) {
        super( jmbg, ime, prezime, adresa, email, telefon);
        this.poslednjaUplata = poslednjaUplata;
    }
    
    public Clan() {
    }
    

    
    
    
}
