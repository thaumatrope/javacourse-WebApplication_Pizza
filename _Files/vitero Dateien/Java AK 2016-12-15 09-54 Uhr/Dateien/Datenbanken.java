/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datenbanken;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

/**
 *
 * @author Sanne
 */
public class Datenbanken {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        //Datenbank mit Tabelle anlegen
        //Library einfügen
        //Verbindung zur Datenbank (NETBEANS)
        //Services Tab, recht auf Databases klicken
        Class.forName("com.mysql.jdbc.Driver");//Läd die Klasser Treiber und registriert das Porgramm
        String verbindung="jdbc:mysql://localhost:3306/dezmber_e211?zeroDateTimeBehavior=convertToNull";
        //Treibermanager erstellt die Verbindung und leite sie an das Programm weier
        Connection myCon=DriverManager.getConnection(verbindung, "'root'", "");
        //Connecztion Objekt erstellt ein Statement Objekt und leitet es ans Programm weiter
        Statement mystm=myCon.createStatement();
        //SQL String
        String eingabe="Insert INTO teilnehmer"
                + "(Vorname, Nachname, id) values('Susanne', 'Schroeter', 2 )";
        //Statementobjekt kann SQL Befehle an die Datenbank senden
        mystm.executeUpdate(eingabe);
        //SQL String
        String abfrage="Select * from Teilnehmer";
        //Statmentobject senden SQL-Befehl an Datenbank und kann Ergebnis der Abrage
        //entgegen nehme und ans Programm weiterleiten
        //Statement erzeugt Resultset, das Ergebnisse enthält
        ResultSet meiRes=mystm.executeQuery(abfrage);
        //Resultset kann zeilenqweise auslesen mit next
        while(meiRes.next()){
            //Aus einer Zeile mit getString/getInt/getByte...Daten formatiert auslesen
            String tabName=meiRes.getString(1);//erster Index ist 1
            int i=meiRes.getInt(3);
            System.out.println("Gelesen "+tabName +" "+i);
        }
        
    
    }
    
}
