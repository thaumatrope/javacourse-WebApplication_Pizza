/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eulerproblems;

/**
 *
 * @author SRH
 */
public class EulerProblems {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
    
    Problems problems001= new Problems();
    
    int limit001=1000;
    System.out.println("Das Ergebnis des 1. Problems mit Grenzwert "+limit001+" ist "+problems001.multiple35(limit001));
    
    double limit002=4e6;
    System.out.println("Das Ergebnis des 2. Problems mit Grenzwert "+limit002+" ist "+problems001.partSumFibonacci(limit002,2));
    
    long factorize=600851475143L;
    //long factorize=2310L;
    System.out.println("Das Ergebnis des 3. Problems für die Zahl "+factorize+" ist "+problems001.largestPrimeFactor(factorize));
        
    int power=2;
    System.out.println("Das Ergebnis des 4. Problems mit maximal "+(power+1)+"-stelligen Zahlen ist "+problems001.palimdromicNumber(power));
    }
}
