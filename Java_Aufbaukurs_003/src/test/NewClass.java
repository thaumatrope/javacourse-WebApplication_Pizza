/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author John Westfield
 */


public class NewClass {
    
    public NewClass(){
        System.out.println("Konstruktor Klasse NewClass");
    }
}

class NewClass1 {
    
    public NewClass1(){
        System.out.println("Konstruktor Klasse 1");
    }
}


class a2 {
    
    private NewClass2 myNewClass2;
    
     public a2(){
        System.out.println("Konstruktor Klasse a2");
        myNewClass2 = new NewClass2();
    }
    
}

class NewClass2 extends NewClass1{
    
    private int myVar1; 
    
    public NewClass2(){
        myVar1 = 2;
         System.out.println("Konstruktor Klasse 2");
    }

}