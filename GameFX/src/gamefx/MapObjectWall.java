/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamefx;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

/**
 *
 * @author Robert
 */
public class MapObjectWall extends MapObject {

    public MapObjectWall(int x, int y)
    {
        this(new Position(0,0));        
    }
    
    public MapObjectWall(Position pos) {
        super(pos);
        token = 'W';
        color = Color.RED;
        //image = new Image("file:wall.png");
        image = GameFX.gameLoop.imageHandler.GetImageFromFile("wall.png");
    }
}
