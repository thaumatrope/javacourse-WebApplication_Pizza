/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diebohne;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sanne
 */
public class Sandwich extends Thread{
    @Override
    public void run(){
         for(int i=0;i<20;i++){
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(Kaffee.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Sandwich toastet. Status: "+i);
            if(i==19){
                System.out.println("Sandwich heiss");
            }
        }
    }          
}
