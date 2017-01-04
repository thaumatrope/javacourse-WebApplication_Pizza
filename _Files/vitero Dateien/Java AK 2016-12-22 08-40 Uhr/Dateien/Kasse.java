/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diebohne;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.Callable;

/**
 *
 * @author Sanne
 */
public class Kasse implements Callable<Integer> {

    @Override
    public Integer call(){
       int[] x=new int[20];
       for(int k=0;k<20;k++){
         x[k]=((int)(Math.random()*250)+1);
      }
       Arrays.sort(x);   
     return x[19];
    }
    
}
