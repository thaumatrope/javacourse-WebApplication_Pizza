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
public class Kaffee extends Thread{
    @Override
    public void run(){
        for(int i=0;i<20;i++){
            try {
                System.out.println("Pulver rein");
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Kaffee.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(" Kaffee kocht, Status: "+i);
            if(i==19){
                System.out.println("Kaffee fertig");
            }
        }
    }
    
}
