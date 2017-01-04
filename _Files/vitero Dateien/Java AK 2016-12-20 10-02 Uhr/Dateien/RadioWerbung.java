/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diebohne;

/**
 *
 * @author Sanne
 */
public class RadioWerbung extends Werbung implements Runnable{
    @Override
    public void werbungMachen(){
        System.out.print("Tata: Herhören: Unser Kaffee ist der beste");
    }

    @Override
    public void run() {
        
       for(int i=1;i<=5;i++){
           werbungMachen();
           System.out.println(" bei Sender "+i);
       }
                }
   
}
