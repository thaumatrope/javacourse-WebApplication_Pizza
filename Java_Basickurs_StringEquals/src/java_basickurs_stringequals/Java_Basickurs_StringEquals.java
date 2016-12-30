/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_basickurs_stringequals;

/**
 *
 * @author John Westfield
 */
public class Java_Basickurs_StringEquals {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String a = "New Shit";
        String b = a;
        
        if(a == b){
            System.out.println("String same Reference");
        }else if (a.equalsIgnoreCase(b)){
            System.out.println("String same Content");
        }
        
        String c = new String("New Shit");
        b = c;
        
        if(a == b){
            System.out.println("String same Reference");
        }else if (a.equalsIgnoreCase(b)){
            System.out.println("String same Content");
        }
        
    }
    
}
