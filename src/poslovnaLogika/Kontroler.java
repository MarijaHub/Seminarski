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
import domen.StavkaClanarine;
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
        } finally {
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

    public void dodajRacun(Racun racun) throws Exception {
        try {
            db.UcitajDriver();
            db.OtvoriKonekciju();
            db.sacuvajRacun(racun);
            db.commitTransakcije();
        } catch (Exception e) {
            db.rollbackTransakcije();
            throw e;
        } finally {
            db.ZatvoriKonekciju();
        }
    }

    public List<Racun> vratiRacune() throws Exception {
        db.UcitajDriver();
        db.OtvoriKonekciju();
        List<Racun> lc = db.vratiRacune();
        //db.commitTransakcije();
        db.ZatvoriKonekciju();
        return lc;
    }

    public void dodajZaposlenog(Zaposleni zaposleni) {
        //kZaposlenih.dodajZaposlenog(zaposleni);
    }

    public List<Zaposleni> vratiZaposlene() throws Exception {
        db.UcitajDriver();
        db.OtvoriKonekciju();
        List<Zaposleni> lista = db.vratiZaposlene();
        db.ZatvoriKonekciju();
        return lista;
    }

    public void dodajClanarinu(Clanarina clanarina) throws Exception {
        try {
            db.UcitajDriver();
            db.OtvoriKonekciju();
            db.sacuvajClanarinu(clanarina);
            for (StavkaClanarine s : clanarina.getStavke()) {
                s.setClanarinaID(clanarina.getClanarinaID());
                db.sacuvajStavku(s, db.getClanarinaID());
            }
            db.commitTransakcije();
        } catch (Exception e) {
            db.rollbackTransakcije();
            throw e;
        } finally {
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
        db.ZatvoriKonekciju();
    }

    public List<Clan> traziClana(String whereUslov) throws Exception {
        db.UcitajDriver();
        db.OtvoriKonekciju();
        List<Clan> c = db.traziClana(whereUslov);
        db.ZatvoriKonekciju();
        return c;
    }

    public void brisiRacun(Racun selektovaniRacun) throws Exception {
        db.UcitajDriver();
        db.OtvoriKonekciju();
        db.brisiRacun(selektovaniRacun);
        db.ZatvoriKonekciju();
    }

}
