/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sammlung;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Sanne
 */
public class Sammlung {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] namen={"Andreas","Christin","Robert"};
       
        for(String str:namen){//for each Schleife
            System.out.println("Der Teilnehmer heisst: "+str);
        }
        Collection werte1=new ArrayList();
        werte1.add(namen);
        werte1.add("Adam");
        werte1.add(15);
        werte1.add(true);
        Boolean b1=new Boolean("false");
        werte1.add(b1);
        werte1.add(new Boolean("false"));
        for(Object o:werte1){
            System.out.println(o);
        }
        ArrayList werte2=new ArrayList();
        werte2.add(namen);
        werte2.add("Adam");
        werte2.add(15);
        werte2.add(true);
        werte2.add(b1);
        werte2.add(new Boolean("false"));
        
        for(int i=0; i<werte2.size();i++){
            System.out.println("In der Liste mit der Groesse "+werte2.size()+" ist das Element "
                    +werte2.get(i));
        }
        System.out.println("**************************");
        werte2.add(namen);
        werte2.add("Adam");
        werte2.add("Adam");
        werte2.add("Adam");
        werte2.add(15);
        werte2.add(15);
        werte2.add(15);
        werte2.add(true);
        werte2.add(b1);
        werte2.add(new Boolean("false"));
         for(int i=0; i<werte2.size();i++){
            System.out.println("In der Liste mit der Groesse "+werte2.size()+" ist das Element "
                    +werte2.get(i));
        }
        
         Collection<String> werte3=new ArrayList<>();//Jetzt nur noch Strings
         werte3.add("Justus");
         werte3.add("Peter");
         werte3.add("Peter");
         werte3.add("Peter");
         werte3.add("Bob");
         //werte3.add(new Object());//nicht erlaubt
         for(String str:werte3){
             int i=str.indexOf("t");
             System.out.println("Der Name enthält das t an der Stelle "+i);
         }
         System.out.println("------------------------------------");
         Set <Integer> zahlen=new TreeSet<>();
         zahlen.add(1);
         zahlen.add(6);
         zahlen.add(18);
         zahlen.add(3);
         zahlen.add(18);
         zahlen.add(18);
         for(Integer i:zahlen){
             System.out.println("Die Zahl ist: "+i);
         }
        Set <String> daten=new TreeSet<>();
        daten.add("Eins");
        daten.add("Zwei");
        daten.add("Eins");
        daten.add("Zwei");
        daten.add("eins");
        daten.add("zwei");
        for(String str:daten){
            System.out.println("Gelesen: "+str);
        }
        System.out.println("?????????????????????????????????");
        Map<Integer,String> werte4=new HashMap<>();
        werte4.put(7,"A");
        werte4.put(6, "B");
        werte4.put(5, "C");
        werte4.put(9,"A");
        werte4.put(10, "B");
        werte4.put(11, "C");
        werte4.put(12,"F");
        werte4.put(2, "F");
        werte4.put(4, "F");
        for(String str:werte4.values()){
            System.out.println("Text: "+str);
        }
        
    }
    
}
