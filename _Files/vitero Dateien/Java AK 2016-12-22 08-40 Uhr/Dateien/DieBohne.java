/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diebohne;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sanne
 */
public class DieBohne {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Kaffee caf=new Kaffee();
        Sandwich sand=new Sandwich();
        caf.start();
        sand.start();
        Thread t1=new Thread(new RadioWerbung(),"Radio");
        Thread t2=new Thread(new Plakate());
        t1.start();
        
        t2.setDaemon(true);
        t2.start();
    
        //Einen Thread mehrfach starten
        ExecutorService ichMachdas=Executors.newCachedThreadPool();
        ichMachdas.execute(sand);
        ichMachdas.execute(sand);
        ichMachdas.execute(sand);
        //Schritt 9
        Kasse k=new Kasse();
        Future<Integer> preis =ichMachdas.submit(k);
        try {
            double d=0.01*preis.get();
            System.out.println("Der Preis heute ist"+d);
        } catch (InterruptedException ex) {
            Logger.getLogger(DieBohne.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(DieBohne.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
