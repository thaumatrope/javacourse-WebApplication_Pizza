/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diebohne;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sanne
 */
public class Plakatwerbung extends Werbung implements Runnable{

    @Override
    public void run() {
        while(true){
            werbungMachen();
            System.out.println("Aufs Plakt: ");
       
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Plakatwerbung.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }
    
}
