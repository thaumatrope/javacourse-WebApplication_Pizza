/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package einausgabe;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class EinAusgabe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        File text=new File("C:\\Users\\Sanne\\Desktop\\"
                + "IBB-MeineKurse\\E-221\\KW50_Dateien\\Kaffeesorten.txt");
        try {
            //Erstmal einfache byte-ströme;
            InputStream eingabe1=new FileInputStream(text);
            //Alternativ
           // InputStream eingabe2=new FileInputStream("C:\\Users\\Sanne\\Desktop\\"
             //   + "IBB-MeineKurse\\E-221\\KW50_Dateien\\Kaffeesorten.txt");
             int gelesen;
             while((gelesen=eingabe1.read())!=-1){
                 System.out.print((char)gelesen);
             }
        } catch (FileNotFoundException ex) {
            System.out.println("Fehler 1");
        } catch (IOException ex) {
            System.out.println("Fehler 2");
        }
        File neuerTxt=new File("C:\\Users\\Sanne\\Desktop\\" +
           "IBB-MeineKurse\\E-221\\KW50_Dateien\\KaffeesortenNeu.txt");
        
            try {
                if(!neuerTxt.exists()){
                    neuerTxt.createNewFile();
                }
                OutputStream ausgabe1=new FileOutputStream(neuerTxt, true);
                ausgabe1.write("und das auch 3\n".getBytes());
            } catch (IOException ex) {
                System.out.println("Fehler 3");
        }
         File bana1=new File("C:\\Users\\Sanne\\Desktop\\IBB-MeineKurse\\E-221\\KW50_Dateien\\banana.png");   
         File bana2=new File("C:\\Users\\Sanne\\Desktop\\IBB-MeineKurse\\E-221\\KW50_Dateien\\Bilder\\banana4.png");  
         InputStream bildLesen=null;
         OutputStream bildSchreiben=null;
         try{
             bildLesen=new FileInputStream(bana1);
             bildSchreiben=new FileOutputStream(bana2);
             int bildByte;
             while((bildByte=bildLesen.read())!=-1){
                 bildSchreiben.write(bildByte);
             }
            
         } catch (FileNotFoundException ex) {
             System.out.println("Fehler 4");
        } catch (IOException ex) {
             System.out.println("Fehler 5");
        }
         System.out.println("******************************");
         try{
             BufferedInputStream besserLesen=new BufferedInputStream(bildLesen);
             BufferedOutputStream besserSchreiben=new BufferedOutputStream(bildSchreiben);
             byte[] puffer=new byte[1024];
             //bessere read-Methode
             while(besserLesen.read(puffer)!=-1){
                 besserSchreiben.write(puffer);
             }
         } catch (IOException ex) {
             System.out.println("Fehler 6");
        }
        System.out.println("******************************");
        try{
            BufferedReader leser=new BufferedReader(new FileReader(text));
            String zeile;
            BufferedWriter schreiber=new BufferedWriter(new FileWriter("neuerText2.txt"));
            while((zeile=leser.readLine())!=null){
                schreiber.newLine();
                schreiber.write(zeile);
            }
            schreiber.flush();
        } catch (FileNotFoundException ex) {
            System.out.println("Fehler 7");
        } catch (IOException ex) {
            System.out.println("Fehler 8");
        }
    }
    
    
}
