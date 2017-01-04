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
        //Nur um ein paar Objekte zu verschicken
        Kunde[] k1=new Kunde[5];
        String s1="a";
        int u=2;
        for(int i=0; i<5;i++){
            k1[i]=new Kunde();
            k1[i].setNachname("Name "+s1);
            s1+="a";
            k1[i].setUmsatz(i);
        }
        //Objekte erzeugt..weiter mit den Lese/Schreiben Operationen
//        try {
//            OutputStream os=new FileOutputStream("FuerMeineObjekte.data");
//            ObjectOutputStream objSchreiber=new ObjectOutputStream(os);
//            for(Kunde k2:k1){
//                objSchreiber.writeObject(k2);
//            }
//            objSchreiber.flush();
//        } catch (FileNotFoundException ex) {
//            System.out.println("Datei nicht zugreifbar");
//        } catch (IOException ex) {
//            System.out.println("Strom tut nicht");
//            ex.printStackTrace();
//        }                 
        try{
            ObjectInputStream objLeser=new ObjectInputStream(new FileInputStream("FuerMeineObjekte.data"));
            
            Kunde nk=null;
            for(int i=0; i<5;i++){
                nk=(Kunde)objLeser.readObject();
                System.out.println("Nachname ist: "+nk.getNachname());
            }
            
            
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EinAusgabe.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EinAusgabe.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EinAusgabe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
