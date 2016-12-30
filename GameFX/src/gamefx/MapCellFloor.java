/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamefx;

import javafx.scene.paint.Color;

/**
 *
 * @author IBB Teilnehmer
 */
public class MapCellFloor extends MapCell {
    
    public MapCellFloor()
    {
        // set token and color
        this.token = '.';
        this.color = Color.YELLOW;
        
        // for now, floor tiles don't have graphics...
        
    }
}
