/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package innerclasstest;

/**
 *
 * @author IBB Teilnehmer
 */
public class InnerClassTest {

    //static int x = 1;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final int x = 1;
        System.out.println("outside before: x=" + x);

        new AbstractClass() {
            public void DoStuff() {
                //int k=InnerClassTest.x;
                System.out.println("inside before: x=" + x);
                // x++;
                System.out.println("inside after: x=" + x);
            }
        }.DoStuff();
        System.out.println("outside after: x=" + x);

        String s1 = new String("teststring");
        String s2 = new String("teststring");
        String s3 = new String("teststring3");

        System.out.println(s1.getClass());

        
//        System.out.println("hash s1=" + s1.hashCode());
//        System.out.println("hash s2=" + s2.hashCode());
//        System.out.println("hash s3=" + s3.hashCode());

        Object myObj = new Object();
        System.out.println("object " + myObj);
        System.out.println("object hash   =" + Integer.toHexString(myObj.hashCode()));
        System.out.println("object idhash =" + Integer.toHexString(System.identityHashCode(myObj)));
        System.out.println("ident-hash s1 =" + Integer.toHexString(System.identityHashCode(s1)));
        System.out.println("ident-hash s2 =" + System.identityHashCode(s2));
        System.out.println("ident-hash s3 =" + System.identityHashCode(s3));
        System.out.println("type@adress: "+myObj.getClass()+"@"+Integer.toHexString(System.identityHashCode(myObj)));
        System.out.println("type@adress: "+s1.getClass()+"@"+Integer.toHexString(System.identityHashCode(s1)));
        
        String s = "hallo";
        System.out.println(s.getClass()+"@"+Integer.toHexString(System.identityHashCode(s)));
        
        
    }

}
