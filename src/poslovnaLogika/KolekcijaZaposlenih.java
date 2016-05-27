/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poslovnaLogika;

import domen.Zaposleni;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mdzeletovic
 */
public class KolekcijaZaposlenih {
    
    private List<Zaposleni> zaposleni;

    public KolekcijaZaposlenih() {
        zaposleni = new ArrayList<>();
    }
    
    public void dodajZaposlenog(Zaposleni zaposleni) {
        this.zaposleni.add(zaposleni);
    }
    public List<Zaposleni> vratiListuZaposlenih() {
        return zaposleni;
    }
}
