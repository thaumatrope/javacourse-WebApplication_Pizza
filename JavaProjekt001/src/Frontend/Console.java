/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frontend;

import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class Console {
    
    public void cls(){
        System.out.println("Console...CLS");
        System.out.print("\033[H\033[2J");
    }
    
    public void printEmptyLine(int num){
        for (int i = 0; i < num; i++){
            System.out.println("");
        } 
    }
    public void printStars (int num){
        for (int i = 0; i < num; i++){
            System.out.print("*");
        }
        System.out.print("\n");           
    }
    
    public void printDashes (int num){
        for (int i = 0; i < num; i++){
            System.out.print("-");
        }
        System.out.print("\n");           
    }
    
    public int getInputInteger (){
        
        Scanner input = new Scanner(System.in);
        int myInt = 0;
        boolean loop;
        
        do{ 
             
            try {
                loop = false;                
                String myAnswer = input.nextLine();
                myInt = Integer.parseInt(myAnswer);

            } catch (NumberFormatException e) {
               loop = true;
               System.out.println("Bitte eine Zahl eingeben:");
               
            }            
            
        }while(loop);
        
        return myInt;
    }
    
    public double getInputDouble (){
        
        Scanner input = new Scanner(System.in);
        double myDouble = 0;
        boolean loop;
        
        do{
            
            try {
                loop = false;
                String myAnswer = input.nextLine();
                myDouble = Double.parseDouble(myAnswer);

            } catch (NumberFormatException e) {
               loop = true;               
               System.out.println("Bitte eine Zahl eingeben:");
               
            }            
            
        }while(loop);       
        
        return myDouble;
    }
    
     public String getInputString (){
        
        Scanner input = new Scanner(System.in);        
        String myAnswer = input.nextLine();           
        
       return myAnswer;
    }

    
}
