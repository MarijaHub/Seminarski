    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poslovnaLogika;

import domen.Clanarina;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mdzeletovic
 */
public class KolekcijaClanarina {
    
    private List<Clanarina> clanarine;

    public KolekcijaClanarina() {
        clanarine = new ArrayList<>();
    }
    
    public void dodajClanarinu(Clanarina clanarina) {
        clanarine.add(clanarina);
    }
    public List<Clanarina> vratiListuClanarina() {
        return clanarine;
    }
    
}
