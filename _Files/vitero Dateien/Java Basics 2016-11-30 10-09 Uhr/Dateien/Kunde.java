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
public class Kunde {
    private Kaffee caf;
    /**
     * Name soll den Kundennamen angeben
     */
    private String name;
    /**
     * Hier wird immer die aktuelle Bestellung über die ID angegeben
     */
    private int bestellung;//Im Moment vorinitialisiert mit 0
    /**
     * Statischer Platz für unser Logo
     */
    public static final String logo="DIE BOHNE";
    
    /**
     * Einziger Konstruktor, der Name des Kunden ist notwenig zur Erzeugung
     * @param kname Eintrag des Namens, der erfragt wird in der main
     */
    public Kunde(String kname){
        name=kname;
        System.out.println("Kunde erzeugt mit Namen: "+ kname);
        
    }
    public String getName(){
        return name;
    }
    /**
     * Setzt die Eigenschaft bestellung auf den aktuellen Wert
     * @param best soll nur 111,222 oder 333 enthalten
     */
    public void bestellen(int best){
        bestellung=best;
    }
    public int getBestellung(){
        return bestellung;
    }
    public void setKaffee(Kaffee caf){
        this.caf=caf;
    }
    public Kaffee getKaffee(){
        return caf;
    }
}
