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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mdzeletovic
 */
public class Kontroler {

//    private KolekcijaClanarina kClanarina;
//    private KolekcijaClanova kClanova;
//    private KolekcijaRacuna kRacuna;
//    private KolekcijaZaposlenih kZaposlenih;
//    private KolekcijaLica kLica;
    private static Kontroler kontroler;
    private db.DBKomunikacija db;

    public Kontroler() {
//        kClanarina = new KolekcijaClanarina();
//        kClanova = new KolekcijaClanova();
//        kRacuna = new KolekcijaRacuna();
//        kZaposlenih = new KolekcijaZaposlenih();
//        kLica = new KolekcijaLica();
        db = new DBKomunikacija();

    }

    public void dodajClana(Clan clan) throws Exception {

        try {
            db.UcitajDriver();
            db.OtvoriKonekciju();
            db.sacuvajLice(clan);
            db.sacuvajClana(clan);
            db.commitTransakcije();
        } catch (Exception e) {
            db.rollbackTransakcije();
            throw e;
        }
        finally {
            db.ZatvoriKonekciju();
        }
    }

    public List<Clan> vratiClanove() throws Exception {
        db.UcitajDriver();
        db.OtvoriKonekciju();
        List<Clan> lc = db.traziSveClanove();
        //db.commitTransakcije();
        db.ZatvoriKonekciju();
        return lc;
    }

    public void dodajRacun(Racun racun) {
        //kRacuna.dodajRacun(racun);
    }

    public List<Racun> vratiRacune() {
        return new ArrayList<>();//return kRacuna.vratiListuRacuna();
    }

    public void dodajZaposlenog(Zaposleni zaposleni) {
        //kZaposlenih.dodajZaposlenog(zaposleni);
    }

    public List<Zaposleni> vratiZaposlene() {
        return new ArrayList<>();
//return kZaposlenih.vratiListuZaposlenih();
    }

    public void dodajClanarinu(Clanarina clanarina) throws Exception {
        try {
            db.UcitajDriver();
            db.OtvoriKonekciju();
            db.sacuvajClanarinu(clanarina);
            db.commitTransakcije();
        } catch (Exception e) {
            db.rollbackTransakcije();
            throw e;
        }
        finally {
            db.ZatvoriKonekciju();
        }
    }

    public List<Clanarina> vratiClanarine() throws Exception {
        db.UcitajDriver();
        db.OtvoriKonekciju();
        List<Clanarina> lc = db.traziSveClanarine();
        db.ZatvoriKonekciju();
        return lc;
    }

    public static Kontroler getInstance() {
        if (kontroler == null) {
            kontroler = new Kontroler();
        }
        return kontroler;
    }

    public void izmeniClana(Clan clan) throws Exception {
        db.UcitajDriver();
        db.OtvoriKonekciju();
        db.izmeniLice(clan);
        db.sacuvajLice(clan);
        db.ZatvoriKonekciju();
    }

    public List<Clan> traziClana(String whereUslov) throws Exception {
        db.UcitajDriver();
        db.OtvoriKonekciju();
        List<Clan> c = db.traziClana(whereUslov);
        db.ZatvoriKonekciju();
        return c;
    }

}
