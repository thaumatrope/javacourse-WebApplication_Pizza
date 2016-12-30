/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_datenbank_001;

import java.sql.*;
import com.mysql.jdbc.Connection;


/**
 *
 * @author John Westfield
 */
public class Java_Datenbank_001 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        
        
        Class.forName("com.mysql.jdbc.Driver");
        String verbindung = "jdbc:mysql://localhost:3306/mydb_01?zeroDateTimeBehavior=convertToNull";
        Connection myCon = (Connection) DriverManager.getConnection(verbindung, "root", "");
        Statement mySt = myCon.createStatement();
        String anfrage = "INSERT INTO teilnehmer (Vorname, Nachname, ID) VALUES ( 'John','Westfield', 1),( 'Herr', 'Wichtig', 2)";
        mySt.executeUpdate(anfrage);
        
        String abfrage = "SELECT * FROM teilnehmer";
        ResultSet myRes = mySt.executeQuery(abfrage);
        
        while (myRes.next()){
            
            String myTab = myRes.getString(1);
            int i = myRes.getInt(3);
            System.out.println("Result: " + myTab + ", ID: " + i);
            
        }
    }
    
}
