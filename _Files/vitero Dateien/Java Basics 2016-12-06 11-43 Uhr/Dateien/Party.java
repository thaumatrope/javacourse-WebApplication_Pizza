/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package party;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sanne
 */
public class Party {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        /*System.out.print("Heute ist "+args[0]);
        for(int i=1; i<6;i++){
            System.out.print(" " + args[i]);
        }
        System.out.println("\n");
        int i,j;
        i=1;
        j=0;
        try{
            double d=i/j;
        }catch(ArithmeticException ae){
            System.out.println("Division durch 0 ist SCHLECHT");
        }
        System.out.println("Und auch das wird ausgeführt");
        try{
            String str=args[3];
            int zahl;
            Integer meineZahl=new Integer(str);//Objekttyp zu int
            zahl=meineZahl;
            zahl++;
            double h=i/zahl;
            //und hier passiert noch viel mehr
        }catch(ArrayIndexOutOfBoundsException ar){
            System.out.println("Leider viel zu wenig Info");
            
        }catch(ArithmeticException ae){
            System.out.println("Division durch 0 ist SCHLECHT");
        }
        finally{
            System.out.println("Das kommt immer");
            //Aufräumen
        }
        
        
        
        
         System.out.println("Und auch das wird ausgeführt");
        
        System.out.println("Eingabe");
        
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Party.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Ausgabe");*/
        Einladung schlumpf=new Einladung();
        try{
            schlumpf.einladen("Papa Schlumpf");
            schlumpf.einladen("Gargamel");
            schlumpf.einladen("Schlumpfine");
        }catch (NichtEingeladen ne){
            System.out.println("DU NICHT");
            //throw ne;
        }catch(Exception e){
            System.out.println("Irgendwas anderes ist schief gelaufen");
        }
        System.out.println("Hier geht es weiter wie bisher");
    } 
        
}
   

