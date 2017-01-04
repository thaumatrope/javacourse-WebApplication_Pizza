/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gleichzetig;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Sanne
 */
public class Zaehler {
    private int zahl=0;
    Lock schloss=new ReentrantLock();
//    public void plus(){
//        //speichere Zahl zwischen
//        //Addiee 1 dazu
//        //schreibe an die ursprüngliche Stelle
//        //++-Operation ist NICHT atomar!!!
//        zahl++;
//    }
//    public void minus(){
//        zahl--;
//    }
    //*****Schützen der Methode****//
    
//    //Methode wird gesamt ausgeführt oder garnicht
//    public synchronized void plus(){
//        zahl++;
//    }
//    //Auch synchronisieren, sonst kann sie 
//    // auf dem Bereich zahl arbeiten...unterbrochen werden...
//    //wenn sie nichts tun soll.
//     public synchronized void minus(){
//        zahl--;
//    }
//    
//    public void plus(){
//        //Fasst die Operation zu einer Atomaren Operation zusammen
//        //mit Objektreferenz Stichwort Mutex
//        //Objekt hat einen Schlüssel, mit  synchronized(this)
//        //nimmt die Methode den Schlüssel DIESES Objekts an sich und kein
//        //andere synchroniserte Methode komm an DIESES Objekt ran.
//        synchronized(this){
//            zahl++;
//        }
//    }
//    //Muss auch synchronisieren, hat sonst trotzdem Zugriff aud das Objekt
//    public void minus(){
//        synchronized(this){
//            zahl--;
//        }
//   }
    public void plus(){
        schloss.lock();
        try{
            zahl++;
        }finally{
            schloss.unlock();
        }
    }
    public void minus(){
        schloss.lock();
        try{
            zahl--;
        }finally{
            schloss.unlock();
        }
    }
    public int wert(){
        return zahl;
    }
}
