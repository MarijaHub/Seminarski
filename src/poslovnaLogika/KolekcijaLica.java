/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poslovnaLogika;

import domen.Clan;
import domen.Lice;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mdzeletovic
 */
class KolekcijaLica {

    
    private List<Lice> lica;

    public KolekcijaLica() {
        lica = new ArrayList<>();
    }
    
    public void dodajLice(Lice lice) {
        lica.add(lice);
    }
    public List<Lice> vratiListuL() {
        return lica;
    }
 }
    

