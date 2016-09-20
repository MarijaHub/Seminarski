/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import domen.Clan;
import domen.Clanarina;
import domen.Lice;
import domen.Racun;
import domen.StavkaClanarine;
import domen.Zaposleni;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mdzeletovic
 */
public class DBKomunikacija {

    private Connection connection;
    private long clanarinaID;

    public long getClanarinaID() {
        return clanarinaID;
    }

    // <editor-fold defaultstate="collapsed" desc="Driver i konekcija">
    public void UcitajDriver() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new Exception("Neuspesno ucitavanje drivera!", e);
        }
    }

    public void OtvoriKonekciju() throws Exception {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/sportskicentar", "root", "marija");
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            throw new Exception("Neuspesno uspostavljanje konekcije!", e);
        }
    }

    public void ZatvoriKonekciju() throws Exception {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new Exception("Neuspesno zatvaranje konekcije!", e);
        }
    }
// </editor-fold>

    public void sacuvajLice(Lice lice) throws Exception {

        String query = "Insert into Lice(`Jmbg` ,`Ime`,`Prezime`,`Adresa`,`Email`,`Telefon`,`ModifyTime`) "
                + "VALUES (?,?,?,?,?,?,?)";

        PreparedStatement naredba = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

        naredba.setString(1, lice.getJmbg());
        naredba.setString(2, lice.getIme());
        naredba.setString(3, lice.getPrezime());
        naredba.setString(4, lice.getAdresa());
        naredba.setString(5, lice.getEmail());
        naredba.setString(6, lice.getTelefon());
        naredba.setDate(7, new java.sql.Date(new java.util.Date().getTime()));

        naredba.executeUpdate();
        ResultSet rs = naredba.getGeneratedKeys();
        if (rs.next()) {
            lice.setLiceID(rs.getLong(1));
        }
    }

    public void sacuvajClana(Clan clan) throws Exception {

        String query = "Insert into Clan "
                + " VALUES (?,?,?)";

        PreparedStatement naredba = connection.prepareStatement(query);

        naredba.setLong(1, clan.getLiceID());
        naredba.setDate(2, new java.sql.Date(clan.getPoslednjaUplata().getTime()));     //new java.sql.Date(new java.util.Date().getTime()));
        naredba.setDate(3, new java.sql.Date(new java.util.Date().getTime()));

        naredba.executeUpdate();

    }

    public void izmeniLice(Lice lice) throws SQLException {

        String query = "UPDATE  Lice SET Ime = ?,Prezime=?,Adresa=?,Email=?,Telefon=?,ModifyTime=? where LiceID =" + lice.getLiceID();

        PreparedStatement naredba = connection.prepareStatement(query);

        naredba.setString(1, lice.getIme());
        naredba.setString(2, lice.getPrezime());
        naredba.setString(3, lice.getAdresa());
        naredba.setString(4, lice.getEmail());
        naredba.setString(5, lice.getTelefon());
        naredba.setDate(6, new java.sql.Date(new java.util.Date().getTime()));

        naredba.executeUpdate();

    }

    public List<Clan> traziClana(String whereUslov) throws Exception {
        try {
            List<Clan> listaClanova = new ArrayList<>();

            String sql = "Select * from clan inner join lice on clanid = liceid where liceid in (SELECT LiceID FROM Lice \n"
                    + "Where " + whereUslov + ")";

            Statement sqlStatement = connection.createStatement();
            ResultSet rs = sqlStatement.executeQuery(sql);
            while (rs.next()) {
                Clan clan = new Clan();
                clan.setLiceID(rs.getLong("LiceID"));
                clan.setAdresa(rs.getString("Adresa"));
                clan.setEmail(rs.getString("Email"));
                clan.setIme(rs.getString("Ime"));
                clan.setJmbg(rs.getString("Jmbg"));
                clan.setPoslednjaUplata(rs.getDate("PoslednjaUplata"));
                clan.setPrezime(rs.getString("Prezime"));
                clan.setTelefon(rs.getString("Telefon"));

                listaClanova.add(clan);
            }

            rs.close();
            sqlStatement.close();
            return listaClanova;
        } catch (SQLException ex) {
            throw new Exception("Neuspesno ucitavanje clanova!", ex);
        }
    }

    public Zaposleni traziZaposleniPoID(long id) throws Exception {
        try {
            String sql = "Select * from Zaposleni inner join Lice on  ZaposleniID = LiceID where ZaposleniID = " + id;
            Zaposleni zap = new Zaposleni();
            Statement sqlStatement = connection.createStatement();
            ResultSet rs = sqlStatement.executeQuery(sql);
            while (rs.next()) {

                zap.setLiceID(rs.getLong("LiceID"));
                zap.setAdresa(rs.getString("Adresa"));
                zap.setEmail(rs.getString("Email"));
                zap.setIme(rs.getString("Ime"));
                zap.setJmbg(rs.getString("Jmbg"));
                zap.setPrezime(rs.getString("Prezime"));
                zap.setTelefon(rs.getString("Telefon"));
                if (rs.getShort("Administrator") == 1) {
                    zap.setAdministrator(true);
                } else {
                    zap.setAdministrator(false);
                }
            }

            rs.close();
            sqlStatement.close();
            return zap;
        } catch (SQLException ex) {
            throw new Exception("Neuspesno ucitavanje clanova!", ex);
        }
    }

    public List<Clan> traziSveClanove() throws Exception {
        try {
            List<Clan> listaClanova = new ArrayList<>();
            String sql = "SELECT LiceID, jmbg, ime, prezime, adresa, email, telefon, clanID, poslednjaUplata FROM Lice inner join Clan on ClanID = LiceID";
            Statement sqlStatement = connection.createStatement();
            ResultSet rs = sqlStatement.executeQuery(sql);
            while (rs.next()) {
                Clan clan = new Clan();
                clan.setLiceID(rs.getLong("LiceID"));
                clan.setAdresa(rs.getString("Adresa"));
                clan.setEmail(rs.getString("Email"));
                clan.setIme(rs.getString("Ime"));
                clan.setJmbg(rs.getString("Jmbg"));
                clan.setPoslednjaUplata(rs.getDate("PoslednjaUplata"));
                clan.setPrezime(rs.getString("Prezime"));
                clan.setTelefon(rs.getString("Telefon"));

                listaClanova.add(clan);
            }
            rs.close();
            sqlStatement.close();
            return listaClanova;
        } catch (SQLException ex) {
            throw new Exception("Neuspesno ucitavanje clanova!", ex);
        }
    }

    public void commitTransakcije() throws Exception {
        try {
            connection.commit();
        } catch (SQLException ex) {
            throw new Exception("Neuspesan commit transakcije!", ex);
        }
    }

    public void rollbackTransakcije() throws Exception {
        try {
            connection.rollback();
        } catch (SQLException ex) {
            throw new Exception("Neuspesan rollback transakcije!", ex);
        }
    }

    public void sacuvajClanarinu(Clanarina clanarina) throws SQLException {
        String query = "Insert into Clanarina(`VaziOD` ,`VaziDo`,`Cena`,`ZaposleniKreirao`) "
                + "VALUES (?,?,?,?)";

        PreparedStatement naredba = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

        naredba.setDouble(3, clanarina.getCena());
        naredba.setDate(1, new java.sql.Date(clanarina.getVaziOd().getTime()));
        naredba.setDate(2, new java.sql.Date(clanarina.getVaziDo().getTime()));
        naredba.setLong(4, clanarina.getZaposleniKreirao().getLiceID());

        naredba.executeUpdate();
        ResultSet rs = naredba.getGeneratedKeys();
        if (rs.next()) {
            clanarina.setClanarinaID(rs.getLong(1));
        }
        clanarinaID = clanarina.getClanarinaID();
    }

    public List<Clanarina> traziSveClanarine() throws Exception {
        try {
            List<Clanarina> lista = new ArrayList<>();
            String sql = "SELECT ClanarinaID, VaziOd, VaziDo, Cena, ZaposleniKreirao FROM Clanarina ";
            Statement sqlStatement = connection.createStatement();
            ResultSet rs = sqlStatement.executeQuery(sql);
            while (rs.next()) {
                Clanarina c = new Clanarina();
                c.setClanarinaID(rs.getLong("ClanarinaID"));
                c.setVaziOd(rs.getDate("VaziOD"));
                c.setVaziDo(rs.getDate("VaziDo"));
                c.setCena(rs.getDouble("Cena"));
                c.setZaposleniKreirao(traziZaposleniPoID(rs.getLong("ZaposleniKreirao")));

                lista.add(c);
            }
            rs.close();
            sqlStatement.close();
            return lista;
        } catch (SQLException ex) {
            throw new Exception("Neuspesno ucitavanje clanarina!", ex);
        }
    }

    public void sacuvajStavku(StavkaClanarine s, long clanarinaID) throws SQLException {
        String query = "Insert into StavkaClanarine(`Naziv` ,`BrojTerminaNedeljno`,`CenaTermina`,`ClanarinaID` ) "
                + "VALUES (?,?,?,?)";

        PreparedStatement naredba = connection.prepareStatement(query);

        naredba.setString(1, s.getNaziv());
        naredba.setInt(2, s.getBrTerminaNedeljno());
        naredba.setDouble(3, s.getCenaTermina());
        naredba.setLong(4, s.getClanarinaID());
        //naredba.setLong(4, clanarinaID);

        naredba.executeUpdate();
    }

    public List<Zaposleni> vratiZaposlene() throws Exception {
        try {
            List<Zaposleni> lista = new ArrayList<>();
            String sql = "SELECT Lice.LiceID, jmbg, ime, prezime, adresa, email, telefon, Administrator FROM Lice inner join Zaposleni on ZaposleniID = Lice.LiceID";
            Statement sqlStatement = connection.createStatement();
            ResultSet rs = sqlStatement.executeQuery(sql);
            while (rs.next()) {
                Zaposleni zap = new Zaposleni();
                zap.setLiceID(rs.getLong("LiceID"));
                zap.setAdresa(rs.getString("Adresa"));
                zap.setEmail(rs.getString("Email"));
                zap.setIme(rs.getString("Ime"));
                zap.setJmbg(rs.getString("Jmbg"));
                zap.setPrezime(rs.getString("Prezime"));
                zap.setTelefon(rs.getString("Telefon"));
                if (rs.getShort("Administrator") == 1) {
                    zap.setAdministrator(true);
                } else {
                    zap.setAdministrator(false);
                }

                lista.add(zap);
            }
            rs.close();
            sqlStatement.close();
            return lista;
        } catch (SQLException ex) {
            throw new Exception("Neuspesno ucitavanje clanarina!", ex);
        }
    }

    public void sacuvajRacun(Racun racun) throws SQLException {
        String query = "Insert into Racun(`DatumIzdavanja`,`Cena`,`ZaposleniObradio`,`ClanUplatio`,`ClanarinaID` ) "
                + "VALUES (?,?,?,?,?)";

        PreparedStatement naredba = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

        naredba.setDate(1, new java.sql.Date(racun.getDatumIzdavanja().getTime()));
        naredba.setDouble(2, racun.getCena());
        naredba.setLong(3, racun.getZaposleniObradio().getLiceID());
        naredba.setLong(4, racun.getClanUplatio().getLiceID());
        naredba.setLong(5, racun.getClanarina().getClanarinaID());

        naredba.executeUpdate();
        ResultSet rs = naredba.getGeneratedKeys();
        if (rs.next()) {
            racun.setRacunID(rs.getLong(1));
        }
    }

    public List<Racun> vratiRacune() throws Exception {
        try {
            List<Racun> lista = new ArrayList<>();
            String sql = "SELECT * FROM Racun ";
            Statement sqlStatement = connection.createStatement();
            ResultSet rs = sqlStatement.executeQuery(sql);
            while (rs.next()) {
                Racun racun = new Racun();
                racun.setRacunID(rs.getLong("RacunID"));
                racun.setDatumIzdavanja(rs.getDate("DatumIzdavanja"));
                racun.setCena(rs.getDouble("Cena"));
                racun.setZaposleniObradio(traziZaposleniPoID(rs.getLong("ZaposleniObradio")));
                racun.setClanUplatio(traziClanPoID(rs.getLong("ClanUplatio")));
                racun.setClanarina(traziClanarnaPoID(rs.getLong("ClanarinaID")));

                lista.add(racun);
            }
            rs.close();
            sqlStatement.close();
            return lista;
        } catch (SQLException ex) {
            throw new Exception("Neuspesno ucitavanje clanarina!", ex);
        }
    }

    private Clan traziClanPoID(long id) throws Exception {
        try {
            String sql = "Select * from Clan inner join Lice on  ClanID = LiceID where ClanID = " + id;
            Statement sqlStatement = connection.createStatement();
            ResultSet rs = sqlStatement.executeQuery(sql);
            Clan clan = new Clan();
            while (rs.next()) {

                clan.setLiceID(rs.getLong("LiceID"));
                clan.setAdresa(rs.getString("Adresa"));
                clan.setEmail(rs.getString("Email"));
                clan.setIme(rs.getString("Ime"));
                clan.setJmbg(rs.getString("Jmbg"));
                clan.setPoslednjaUplata(rs.getDate("PoslednjaUplata"));
                clan.setPrezime(rs.getString("Prezime"));
                clan.setTelefon(rs.getString("Telefon"));
            }
            rs.close();
            sqlStatement.close();
            return clan;
        } catch (SQLException ex) {
            throw new Exception("Neuspesno ucitavanje clanova!", ex);
        }
    }

    private Clanarina traziClanarnaPoID(long id) throws Exception {
        try {
            Clanarina c = new Clanarina();

            String sql = "Select * from Clanarina  where Clanarinaid = " + id;

            Statement sqlStatement = connection.createStatement();
            ResultSet rs = sqlStatement.executeQuery(sql);
            while (rs.next()) {
                c.setClanarinaID(rs.getLong("ClanarinaID"));
                c.setVaziOd(rs.getDate("VaziOD"));
                c.setVaziDo(rs.getDate("VaziDo"));
                c.setCena(rs.getDouble("Cena"));
                c.setZaposleniKreirao(traziZaposleniPoID(rs.getLong("ZaposleniKreirao")));
            }

            rs.close();
            sqlStatement.close();
            return c;
        } catch (SQLException ex) {
            throw new Exception("Neuspesno ucitavanje clanova!", ex);
        }
    }

    public void brisiRacun(Racun selektovaniRacun) throws SQLException {
        String query = "Delete from  Racun where RacunID = " + selektovaniRacun.getRacunID();

        PreparedStatement naredba = connection.prepareStatement(query);

        naredba.executeUpdate();

//        Statement naredba = connection.createStatement();
//        naredba.executeUpdate(query);
    }
}
