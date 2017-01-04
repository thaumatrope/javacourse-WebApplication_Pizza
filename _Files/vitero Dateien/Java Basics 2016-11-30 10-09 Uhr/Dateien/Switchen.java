/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package switchen;

/**
 *
 * @author Sanne
 */
public class Switchen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Welcher Monat?");
        int i=1;
        switch (i){
            case 1:
                System.out.println("Januar");
                break;
            case 2:
                System.out.println("Feburar");
                break;
            case 3:
                System.out.println("Maerz");
                break;
            case 8:
                System.out.println("August");
                break;
            case 9:
                System.out.println("September");
                break;
            default: 
                System.out.println("Nicht in diesem Jahr");
        }
        boolean b=true;
        if(b){
            System.out.println("Das ist wahr");
        }
        do{
            System.out.println("Das kommt genau ein mal");
        }while(!b);
        Test t=new Test();
        System.out.println("Der String ist:"+t.str);
        System.out.println("Die Zahl ist: "+t.zahl);
        System.out.println("Der Boolean ist: "+t.wahr);
    }
    
}
