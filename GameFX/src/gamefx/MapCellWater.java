/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamefx;

import javafx.scene.paint.Color;

/**
 * Map tile which drains player health.
 * @author IBB Teilnehmer
 */
public class MapCellWater extends MapCell {

    /**
     * Constructor: setup token and color.
     */
    public MapCellWater() {
        this.token = 'w';
        this.color = Color.BLUE;
        image = GameFX.gameLoop.imageHandler.GetImageFromFile("water.png");
    }
}
