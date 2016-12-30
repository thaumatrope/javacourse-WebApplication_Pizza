/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamefx;

import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

/**
 *
 * @author IBB Teilnehmer
 */
class MapObjectPlayer extends MapObject {

    // text field for name
    //String name = "PLAYER";
    Textfield nameField = null;
    MapHandler currentMap = null;
    CounterField health = null;

    static final int STARTHEALTH = 256;
    
    // additional image when player is dead
    //Image imageDead;

    // constructor: store position
    MapObjectPlayer(Position position) {

        // execute parent constructor
        super(position);

        // set a specific color
        color = Color.VIOLET;

        // load FX image from filesystem
        //image = new Image("file:player.png", true);
        image = GameFX.gameLoop.imageHandler.GetImageFromFile("player.png");
        
        

        nameField = new Textfield("PLAYER", position.x, position.y + 40);
        health = new CounterField("Health", STARTHEALTH, position.x, position.y);
    }

    public void Respawn(Position position) {
        //
        // note:
        // this.position = position   would create an interesting bug
        // the player would use the passed reference as new reference for
        // his position, and write there
        //
        this.position.x = position.x;
        this.position.y = position.y;     
        
        this.nameField.text = "respawned";
        this.health.SetValue(STARTHEALTH);
        
        // use image for alive
        image = GameFX.gameLoop.imageHandler.GetImageFromFile("player.png");
    }

    /**
     * Check if player is dead (health is zero).
     *
     * @return true if health is zero (or lower)
     */
    public boolean IsDead() {
        return health.GetValue() <= 0;
    }
    
    /**
     * Check if player is alive (zero health).
     * @return true if health > 0
     */
    public boolean IsAlive()
    {
        return health.GetValue()>0;
    }

    /**
     * Update player object. This is called every tick by the game loop
     */
    public void UpdateLogic() {
        // only when alive...
        if (IsAlive()) {
            // slowly increase health until start value
            if (health.GetValue() < STARTHEALTH) {
                health.Increase(1);
            }
        }
        else
        {
            image = GameFX.gameLoop.imageHandler.GetImageFromFile("player_dead.png");
        }
    }

    /**
     * Draw player onto canvas.
     *
     * @param canvas
     */
    @Override
    public void DrawOnCanvas(Canvas canvas) {

        // draw player
        super.DrawOnCanvas(canvas);

        // draw name
        nameField.position.x = this.position.x;
        nameField.position.y = this.position.y + 40;
        nameField.DrawOnCanvas(canvas);

        // draw health
        health.position = position;
        health.DrawOnCanvas(canvas);

        //counter.Increase(1);
        //GraphicsContext gc = canvas.getGraphicsContext2D();
        //gc.fillText(name, position.x, position.y+40);
    }

    /**
     * Attach player to a game map.
     *
     * @param map
     */
    void SetCurrentMap(MapHandler map) {
        currentMap = map;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * try to move player, return whether successful
     *
     * @return true = moved, false = movement impossible
     */
    public boolean MoveLeft() {
        if (currentMap == null) {
            return false;
        }

//        int x = (player.position.x + MapCell.CELLSIZE / 2) / MapCell.CELLSIZE;
//        int y = (player.position.y + MapCell.CELLSIZE / 2) / MapCell.CELLSIZE;
//        x *= MapCell.CELLSIZE;
//        y *= MapCell.CELLSIZE;
        // ask map if move is possible
        Position nextPos = getMapPosition();
        nextPos.x--;
        if (currentMap.IsEmpty(nextPos)) {
            position.x--;
            return true;
        } else {
            return false;
        }
    }

    /**
     * try to move player, return whether successful
     *
     * @return true = moved, false = movement impossible
     */
    public boolean MoveRight() {
        Position nextPos = getMapPosition();
        nextPos.x++;
        if (currentMap.IsEmpty(nextPos)) {
            position.x++;
            return true;
        } else {
            return false;
        }
    }

    /**
     * try to move player, return whether successful
     *
     * @return true = moved, false = movement impossible
     */
    public boolean MoveUp() {
        Position nextPos = getMapPosition();
        nextPos.y--;
        if (currentMap.IsEmpty(nextPos)) {
            position.y--;
            return true;
        } else {
            return false;
        }
    }

    /**
     * try to move player, return whether successful
     *
     * @return true = moved, false = movement impossible
     */
    public boolean MoveDown() {
        Position nextPos = getMapPosition();
        nextPos.y++;
        if (currentMap.IsEmpty(nextPos)) {
            position.y++;
            return true;
        } else {
            return false;
        }
    }

}
