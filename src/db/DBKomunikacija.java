/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import domen.Clan;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author mdzeletovic
 */
public class DBKomunikacija {

    private Connection connection;

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

    public void sacuvajClana(Clan clan) throws Exception {
        CallableStatement callableStatement = null;
        try {
            String query = "{ call insertClan(?,?,?,?,?,?,?,?) }";
            OtvoriKonekciju();
            callableStatement = connection.prepareCall(query);
            callableStatement.setLong("pliceID", clan.getLiceID());
            callableStatement.setString("pjmbg", clan.getJmbg());
            callableStatement.setString("pime", clan.getIme());
            callableStatement.setString("pprezime", clan.getPrezime());
            callableStatement.setString("padresa", clan.getAdresa());
            callableStatement.setString("pemail", clan.getEmail());
            callableStatement.setString("ptelefon", clan.getTelefon());
            //java.util.Date datum1 = clan.getPoslednjaUplata();
            //java.sql.Date uplata = new Date(datum1.getTime()) ;
            //callableStatement.setDate("PoslednjaUplata", "2011-08-08");
            callableStatement.executeUpdate();
            System.out.println("Record is inserted into LICE table!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {

            if (callableStatement != null) {
                callableStatement.close();
            }

            ZatvoriKonekciju();

        }
    }
}
