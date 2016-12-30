/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaProjekt_CoffeeShopV1;

/**
 *
 * @author Administrator
 */
public class Shop {
    
    private Kaffee[] meinKaffee = new Kaffee[3];
    
    public void unsereKaffees(){
        
        Kaffee k0 = new Kaffee("Latte Macchiato", 3.29, 111);
        Kaffee k1 = new Kaffee("Milchkaffee", 2.11, 222);
        Kaffee k2 = new Kaffee("Cappuchino", 4.50, 333);
        
        meinKaffee[0] = k0;
        meinKaffee[1] = k1;
        meinKaffee[2] = k2;
        
        //System.out.println("Der Preis ist: " + meinKaffee[0].getPreis());
        
    }
    
    public void anzeigen(){
        
        for (int i = 0; i < meinKaffee.length; i++){
            System.out.print("Heute gibt es bei uns:");
            System.out.print(meinKaffee[i].getSorte());
            System.out.print(" für den Preis von ");
            System.out.print(meinKaffee[i].getPreis() + "€\n");
            System.out.println("Sie bestellen ihn über: " + meinKaffee[i].getID());
            
        }
    }
    
    public Kaffee finde (int id){
        for (int i = 0; i < meinKaffee.length; i++){
            if (id == meinKaffee[i].getID())
                return meinKaffee[i];
        }
        return null;
    }
    
    public void rechnungErstellen(Kunde meinKunde){
        
        System.out.println("Danke, dass du bei uns bestellt hast, " + meinKunde.getName());
        double rechnung = meinKunde.getKaffee().getPreis();
        System.out.println("Deine Rechnung beträgt :" + rechnung + "€");
    }
    
}
