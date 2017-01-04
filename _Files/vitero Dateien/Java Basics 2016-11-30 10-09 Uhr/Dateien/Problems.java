/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package eulerproblems;

import java.lang.StringBuffer;

/**
 *
 * @author SRH
 */
public class Problems{
    //Attribute

    //Konstruktoren
    
    //Methoden
    
    //public int partSum(int[])// vllt partSum ueber einen Array auswerten
    public int multiple35(int limit){
        /**
         * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
Find the sum of all the multiples of 3 or 5 below 1000.
         */
        int sum=0;
        for (int zahl=0;zahl<limit;zahl++) {
            if ((zahl%3==0) || (zahl%5==0)) {
                sum+=zahl;
            }
        }
        return sum;
    }
    public int partSumFibonacci(double limit, int teiler) {
        int fib1=1;
        int fib2=1;
        int tmp;
        int sum=0;
        while (fib2<limit){
            //System.out.print(fib2+", ");
            tmp=fib2;
            fib2=fib1+fib2;
            fib1=tmp;
            if (fib2%teiler==0){
                sum+=fib2;
            }
        }
        //System.out.println(fib2);
        return sum;
    }
    public long largestPrimeFactor(long zahl){
        long largest=1L;
        long factor=2L;
        //System.out.print("\t"+zahl+" = ");
        while (factor*factor<=zahl) {
            while (zahl%factor==0) {
                //System.out.print(""+factor+"*");
                zahl=zahl/factor;
                largest=Math.max(largest,factor);
            }
            factor++;
        }
        //System.out.println(""+zahl);
        largest=Math.max(largest,zahl);
        return largest;
    }
    public boolean isPalindrom(String inputString){
        String reverseString=new StringBuffer(inputString).reverse().toString();
        return (reverseString.equals(inputString));
    }
    public int palimdromicNumber(int power) {
        int lowlimit=(int) Math.pow(10,power);
        int uplimit=(int) Math.pow(10, power + 1);
        int prod;
        int largest = 0;
        for (int i = lowlimit; i < uplimit;i++) {//FOREACH
            for (int j=lowlimit;j<uplimit;j++) {//FOREACH
                prod=i*j;
                if (isPalindrom(Integer.toString(prod))){
                    largest=Math.max(prod,largest);
                }
            }
        }
        return largest;
    }
}
