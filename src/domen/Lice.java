/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;

/**
 *
 * @author mdzeletovic
 */
public class Lice implements Serializable{
    
    private long liceID;
    private String jmbg;
    private String ime;
    private String prezime;private String adresa;
    private String email;
    private String telefon;

    public Lice( String jmbg, String ime, String prezime, String adresa, String email, String telefon) {
        this.liceID = liceID;
        this.jmbg = jmbg;
        this.ime = ime;
        this.prezime = prezime;
        this.adresa = adresa;
        this.email = email;
        this.telefon = telefon;
    }

    public Lice() {
    }
    
    

    public long getLiceID() {
        return liceID;
    }

    public void setLiceID(long liceID) {
        this.liceID = liceID;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
    
}
