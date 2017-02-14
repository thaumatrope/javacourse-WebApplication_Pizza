/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication001;

/**
 *
 * @author user704
 */
public class KaffeeDaten {
    
    private String sorte1 = "Milchkaffee";
    private int sorte1ID = 111;
    
    private String sorte2 = "Cappuchino";
    private int sorte2ID = 222;
    
    private String sorte3 = "Latte Macchiato";
    private int sorte3ID = 333;
    
    public String getNameSorte1() {
        return sorte1;
    }
    
    public String getNameSorte2() {
        return sorte2;
    }
    
    public String getNameSorte3() {
        return sorte3;
    }
    
    public void setNameSorte1(String name) {
        sorte1 = name;
    }
    
    public void setNameSorte2(String name) {
        sorte3 = name;
    }
    
    public void setNameSorte3(String name) {
        sorte3 = name;
    }
    
    public int getIDSorte1() {
        return sorte1ID;
    }
    
    public int getIDSorte2() {
        return sorte2ID;
    }
    
    public int getIDSorte3() {
        return sorte3ID;
    }
    
}
