/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

/**
 *
 * @author mdzeletovic
 */
public class Zaposleni extends Lice{
    
    private boolean administrator;

    public Zaposleni() {
    }

    

    public boolean isAdministrator() {
        return administrator;
    }

    public void setAdministrator(boolean administrator) {
        this.administrator = administrator;
    }

    public Zaposleni(boolean administrator, long liceID, String jmbg, String ime, String prezime, String adresa, String email, String telefon) {
        //super( jmbg, ime, prezime, adresa, email, telefon);
        this.administrator = administrator;
    }
    
        @Override
    public String toString() {
        return super.getIme() + " " + super.getPrezime(); 
    }
    
    
}
