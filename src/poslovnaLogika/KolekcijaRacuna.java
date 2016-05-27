/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poslovnaLogika;

import domen.Racun;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mdzeletovic
 */
public class KolekcijaRacuna {
    
    private List<Racun> racuni;

    public KolekcijaRacuna() {
        racuni = new ArrayList<>();
    }
    
    public void dodajRacun(Racun racun) {
        racuni.add(racun);
    }
    public List<Racun> vratiListuRacuna() {
        return racuni;
    }
}
