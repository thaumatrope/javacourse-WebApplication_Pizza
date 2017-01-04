/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gleichzetig;

/**
 *
 * @author Sanne
 */
public class Rechnen implements Runnable{
    Zaehler z=new Zaehler();
    Zaehler x=new Zaehler();
    @Override
    public void run(){
        for(int i=0;i<5000;i++){
            z.plus();
            z.minus();
    }
        
    }
    public void ausgabe(){
        System.out.println("Die Zahl ist "+z.wert());
    }
}
