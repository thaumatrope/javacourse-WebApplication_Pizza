/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamefx;

import java.util.ArrayList;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Start of implementation for new class which holds game world data.
 * Currently this is all inside GameLoop, which is getting ugly...
 * 
 * @author Robert
 */
public class GameWorld {

    MapObjectPlayer player;
    ArrayList<MapObjectWall> walls;

    public GameWorld() {
        player = new MapObjectPlayer(new Position(10, 100));
        walls = new ArrayList<>();
        MapObjectWall w = new MapObjectWall(new Position(0, 0));
        walls.add(w);
        walls.add(new MapObjectWall(32, 0));
        walls.add(new MapObjectWall(64, 0));
        walls.add(new MapObjectWall(96, 0));
    }

    public void DrawOnCanvas(GraphicsContext gc) {
        player.position.y--;
        if (player.position.y <= 0) {
            player.position.y = 150;
        }

        // draw map objects
        // draw map cells
        for (MapObjectWall w : walls) {
            w.DrawOnCanvas(gc.getCanvas());
        }
        
        // draw player
        player.DrawOnCanvas(gc.getCanvas());

        gc.setFill(Color.BLACK);
        if (player.OverlapsWith(walls.get(0))) {
            gc.fillText("overlap", 0, 50);
        } else {
            gc.fillText("ok", player.position.x + 16, player.position.y + 25 + 16);
        }
    }
}
