/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dateien;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Sanne
 */
public class Dateien {

    public static void main(String[] args) {
        File meineDatei=new File("C:\\Users\\Sanne\\Desktop\\IBB-MeineKurse\\E-221\\KW50_Dateien\\Kaffeesorten.txt");
        //Frage nach der Existenz
        System.out.println("Gibt es Kaffeesorten.txt? "+ meineDatei.exists());
        System.out.println("Der Pfad zur Kaffeesorten.txt: "+meineDatei.getAbsolutePath());
        System.out.println(" Kaffeesorten.txt ist im Verzeichnis: "+meineDatei.getParent());
        System.out.println("Kaffeesorten.txt ist " + meineDatei.isDirectory());
        File verzeichnis=new File(meineDatei.getParent());
        System.out.println("Ist das ein Verzeichnis? "+verzeichnis.isDirectory());
        try {
            System.out.println("Der kanonische Pfad von Kaffeesorten.txt: "+meineDatei.getCanonicalPath());
        } catch (IOException ex) {
            System.out.println("Da ist was schief gelaufen");
        }
        File banana=new File("banana.jpg");
        System.out.println("Banana ist unter: "+banana.getAbsolutePath());
        if(!banana.exists()){
            System.out.println("Gibt es noch nicht");
            try {
                banana.createNewFile();
            } catch (IOException ex) {
                System.out.println("Datei konnte nicht angelegt werden");
            }
        }
        else System.out.println("Datei existiert");
        
        File bild=new File("..\\..\\KW50_Dateien\\Bilder");
        System.out.println("Pfad zum Bild"+ bild.getAbsolutePath());
        try {
            System.out.println("Besser so: "+bild.getCanonicalPath());
        } catch (IOException ex) {
            System.out.println("Bilderverzeichnis nicht gefunden");
        }
        File[] dateien=bild.listFiles();
        System.out.println("??"+bild.exists());
//        System.out.println(dateien);
//        for(File f:dateien){
//            System.out.println(f.getName());
//        }
    }
    
}
