/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gleichzetig;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sanne
 */
public class Gleichzetig {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Rechnen r=new Rechnen();
        Thread t1=new Thread(r);
        Thread t2=new Thread(r);
        t1.start();
        t2.start();
        try {
            //NICHT für fremde Threads
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Gleichzetig.class.getName()).log(Level.SEVERE, null, ex);
        }
        r.ausgabe();
    }
    
}
