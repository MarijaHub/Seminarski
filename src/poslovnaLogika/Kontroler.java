/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poslovnaLogika;
import db.DBKomunikacija;
import domen.Clan;
import domen.Clanarina;
import domen.Lice;
import domen.Racun;
import domen.Zaposleni;
import java.util.List;

/**
 *
 * @author mdzeletovic
 */
public class Kontroler {
    
    private KolekcijaClanarina kClanarina;
    private KolekcijaClanova kClanova;
    private KolekcijaRacuna kRacuna;
    private KolekcijaZaposlenih kZaposlenih;
    private KolekcijaLica kLica;
    private static Kontroler kontroler;
    private db.DBKomunikacija db;
    

    public Kontroler() {
        kClanarina = new KolekcijaClanarina();
        kClanova = new KolekcijaClanova();
        kRacuna = new KolekcijaRacuna();
        kZaposlenih = new KolekcijaZaposlenih();
        kLica = new KolekcijaLica();
        db = new DBKomunikacija();
        
    }
    
//    public void dodajClana(Clan clan) {
//        kClanova.dodajClana(clan);
//    }
    
    public void dodajLice(Lice lice) throws Exception {
        db.UcitajDriver();
        db.OtvoriKonekciju();
        //db.sacuvajClana(lice);
        db.ZatvoriKonekciju();
    }
    
    public void dodajClana(Clan clan) throws Exception {
        db.UcitajDriver();
        db.OtvoriKonekciju();
        db.sacuvajClana(clan);
        db.ZatvoriKonekciju();
    }
    
    public List<Clan> vratiClanove() {
        return kClanova.vratiListuClanova();
    }
    public void dodajRacun(Racun racun) {
        kRacuna.dodajRacun(racun);
    }
    public List<Racun> vratiRacune() {
        return kRacuna.vratiListuRacuna();
    }
    public void dodajZaposlenog(Zaposleni zaposleni) {
        kZaposlenih.dodajZaposlenog(zaposleni);
    }
    public List<Zaposleni> vratiZaposlene() {
        return kZaposlenih.vratiListuZaposlenih();
    }
    public void dodajClanarinu(Clanarina clanarina) {
        kClanarina.dodajClanarinu(clanarina);
    }
    public List<Clanarina> vratiClanarine() {
        return kClanarina.vratiListuClanarina();
    }
    
    public static Kontroler getInstance() {
        if(kontroler == null) {
            kontroler = new Kontroler();
        }
        return kontroler;
    }
}
