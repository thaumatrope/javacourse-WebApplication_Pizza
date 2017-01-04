/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package licht;

/**
 *
 * @author Sanne
 */
public class Lampe {
    public void anschalten() throws BirneBrenntDurchException{
        int i=(int)(Math.random()*5000000);
        if((i%3)==0){
            throw new BirneBrenntDurchException();
        }
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
        System.out.print("\u001B[47m       ");System.out.println("\u001B[43;30m@@");
        System.out.print("\u001B[47m      ");System.out.println("\u001B[43;30m@@@@");
        System.out.print("\u001B[47m     ");System.out.println("\u001B[43;30m'@@@@'");
        System.out.print("\u001B[47m     ");System.out.println("\u001B[43;30m@@@@@@");
        System.out.print("\u001B[47m    ");System.out.println("\u001B[43;30m'@@@@@@'");
        System.out.print("\u001B[47m    ");System.out.println("\u001B[43;30m@@@@@@@@");
        System.out.print("\u001B[47m     ");System.out.println("\u001B[43;30m@@@@@@");
        System.out.print("\u001B[47m      ");System.out.println("\u001B[43;30m@@@@");
        System.out.print("");System.out.println("       **        ");
        System.out.print("");System.out.println("       **        ");
        
        
        try{
            Thread.sleep(1000);
        }catch(InterruptedException ie){
            System.out.println("Unterbrechug beim Brennen");
        }
    }
    public void ausschalten(){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
        System.out.print("\u001B[47m       ");System.out.println("\u001B[40;30m@@");
        System.out.print("\u001B[47m      ");System.out.println("\u001B[40;30m@@@@");
        System.out.print("\u001B[47m     ");System.out.println("\u001B[40;30m'@@@@'");
        System.out.print("\u001B[47m     ");System.out.println("\u001B[40;30m@@@@@@");
        System.out.print("\u001B[47m    ");System.out.println("\u001B[40;30m'@@@@@@'");
        System.out.print("\u001B[47m    ");System.out.println("\u001B[40;30m@@@@@@@@");
        System.out.print("\u001B[47m     ");System.out.println("\u001B[40;30m@@@@@@");
        System.out.print("\u001B[47m      ");System.out.println("\u001B[40;30m@@@@");
        System.out.print("");System.out.println("       **        ");
        System.out.print("");System.out.println("       **        ");
        try{
            Thread.sleep(1000);
        }catch(InterruptedException ie){
            System.out.println("Unterbrechun im Aus ");
        }
    }
    
}
