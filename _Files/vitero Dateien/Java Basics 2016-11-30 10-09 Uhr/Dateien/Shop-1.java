/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diebohne;

/**
 *
 * @author Sanne
 */
public class Shop {
    private Kaffee[] meineKaffees=new Kaffee[3];//Hier wird kommt noch Dynamik rein
    
    public void unsereKaffees(){
        Kaffee k0 = new Kaffee("Latte Macciato", 3.29, 111);
        Kaffee k1=new Kaffee("Milchkaffee", 2.11,222);
        Kaffee k2=new Kaffee("Cappucchino", 4.50,333);
        
        meineKaffees[0]=k0;
        meineKaffees[1]=k1;
        meineKaffees[2]=k2;
    }
    public void anzeigen(){
        for(int i=0;i<meineKaffees.length;i++ ){
            System.out.print("Heute gibt es bei uns: ");
            System.out.print(meineKaffees[i].getSorte());
            System.out.print(" für den Preis von ");
            System.out.print(meineKaffees[i].getPreis()+"€\n");
            System.out.println("Sie bestellen ihn über: "+ meineKaffees[i].getId());
            
        }
    }
    public Kaffee finde(int id){
        for(int i=0;i<meineKaffees.length;i++ ){
            if(id==meineKaffees[i].getId()){
                return meineKaffees[i];
            }
        }
        return null;
    }
    public void rechnungErstellen(Kunde meinKunde){
        System.out.println("Danke dass du heute bei uns warst, " +meinKunde.getName());
        double rechnung=meinKunde.getKaffee().getPreis();
        System.out.println("Deine Rechnung beträgt "+rechnung+"€");
    }
}
