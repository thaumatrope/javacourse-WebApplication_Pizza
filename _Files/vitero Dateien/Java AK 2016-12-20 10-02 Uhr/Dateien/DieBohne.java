/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diebohne;
import java.lang.*;
/**
 *
 * @author Sanne
 */
public class DieBohne {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Kaffeekochen und Sandwich toasten gleichzeitig
        Kaffee caf=new Kaffee();
        Sandwich sand=new Sandwich();
        caf.start();//NICHT die run sondern die start Methode für den eigenen Thread
        sand.start();//NICHT die run sondern die start Methode für den eigenen Thread
        Thread t1=new Thread(new RadioWerbung());
        t1.start();
        Thread t2=new Thread(new Plakatwerbung());
        t2.setDaemon(true);
        t2.start();
        
    }
    
}
