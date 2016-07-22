/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author mdzeletovic
 */
public class DBKomunikacija {
    
    private Connection connection;
    
    public void UcitajDriver() throws Exception
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new Exception("Neuspesno ucitavanje drivera!", e);
        }
    }
    public void OtvoriKonekciju() throws Exception
    {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/sportskicentar", "root", "marija");
        } catch (SQLException e) {
            throw new  Exception("Neuspesno uspostavljanje konekcije!", e);
        }
    }
    
    public  void ZatvoriKonekciju() throws Exception
    {
        try {
            connection.close();
        } catch (SQLException e) {
            throw  new Exception("Neuspesno zatvaranje konekcije!", e);
        }
    }
    
    public  void sacuvajLice() throws Exception{
        CallableStatement callableStatement = null;
        try {
            String query = "{ call insertLice(?,?,?,?,?,?,?) }";
            ResultSet rs;
            OtvoriKonekciju();
            callableStatement = connection.prepareCall(query);
            callableStatement.setLong("pliceID", 2);
            callableStatement.setString("pjmbg", "555");
            callableStatement.setString("pime", "test ime");
            callableStatement.setString("pprezime", "test prezime");
            callableStatement.setString("padresa", "test adr");
            callableStatement.setString("pemail", "test em");
            callableStatement.setString("ptelefon", "test tel");
            callableStatement.executeUpdate();
            System.out.println("Record is inserted into LICE table!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally {

			if (callableStatement != null) {
				callableStatement.close();
			}

			ZatvoriKonekciju();

		}
    }
}
