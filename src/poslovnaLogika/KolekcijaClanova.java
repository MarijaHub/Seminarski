/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poslovnaLogika;

import domen.Clan;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mdzeletovic
 */
public class KolekcijaClanova {
    
    private List<Clan> clanovi;

    public KolekcijaClanova() {
        clanovi = new ArrayList<>();
    }
    
    public void dodajClana(Clan clan) {
        clanovi.add(clan);
    }
    public List<Clan> vratiListuClanova() {
        return clanovi;
    }
}
