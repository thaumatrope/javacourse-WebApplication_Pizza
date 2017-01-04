/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beispiel;

/**
 *
 * @author Sanne
 */
public class Zwei {
    EIns e;
    public Zwei(){
        Fabrik b=new Fabrik();
        e=b.getEins();
        e.meth();
        e.meth("Neue Info aus zwei");
    }
}
