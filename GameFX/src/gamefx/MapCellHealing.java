/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamefx;

import javafx.scene.paint.Color;

/**
 * Map tile which heals the player.
 * @author IBB Teilnehmer
 */
public class MapCellHealing extends MapCell {
     
    /**
     * Constructor: setup token and color.
     */
    public MapCellHealing() {
        this.token = 'h';
        this.color = Color.RED;
        image = GameFX.gameLoop.imageHandler.GetImageFromFile("heart.png");
    }
}
