/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamefx;

import javafx.scene.paint.Color;

/**
 * Map Tile: Wall
 * @author IBB Teilnehmer
 */
public class MapCellWall extends MapCell {
    
    // constructor: set token
    public MapCellWall()
    {
       // /super(0,0);
        //this.position = position;
        this.token = 'X';
        this.color = Color.BLACK;
       image = GameFX.gameLoop.imageHandler.GetImageFromFile("wall.png");
    }
     
    public MapCellWall(int x, int y) {
        //super(x, y);
        token = 'X';
        color = Color.RED;
       image = GameFX.gameLoop.imageHandler.GetImageFromFile("wall.png");
    }
}
