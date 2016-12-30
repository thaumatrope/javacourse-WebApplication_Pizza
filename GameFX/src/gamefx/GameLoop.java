package gamefx;

//import gamefx.GameFX.canvas;
import java.awt.Point;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author IBB Teilnehmer
 */
public class GameLoop extends AnimationTimer {

    //public GameFX myGame;
    final long startNanoTime = System.nanoTime();

    // current gametick
    int ticks = 0;

    // current cursor position (for printing text etc)
    Point cursorPos = new Point(0, 0);

    // player object
    MapObjectPlayer player;
    final Position playerStartingPosition = new Position(50, 50);

    // 1x gold object (for testing, move into list of map objects later)
    //MapObjectGold gold;
    // current score
    Score score;

    Sprite testSprite;
    Textfield testText;

    Drawable[] myDrawables;

    GameObject[] myGameObjects;

    // moved to player
    //ounterField counter;
    MapHandler myMap;

    Label cellDescription;

    ImageHandler imageHandler;

    // height of one line (for text output)
    final int lineheight = 30;

    /**
     * Constructor
     *
     */
    public GameLoop() {
        // other objects we create in the game loop need access to the image handler...
        imageHandler = new ImageHandler();
    }

    // post-constructor initialization
    // some stuff cannot easily be done inside the constructor
    // an example is the player class, which loads an image in its constructor
    // to be able to do that it needs access to our imagehandler (by accessing
    // a reference to gameLoop inside GameFX which is only set after the 
    // constructor of GameLoop was executed.
    public void Init() {

        testSprite = new Sprite(150, 50);
        testText = new Textfield("testText", 50, 50);

        myDrawables = new Drawable[2];
        myDrawables[0] = testSprite;
        myDrawables[1] = testText;

        myGameObjects = new GameObject[2];
        myGameObjects[0] = testSprite;
        myGameObjects[1] = testText;

        cursorPos = new Point(0, 0);

        // create score handler
        score = new Score();

        // create map handler
        myMap = new MapHandler();

        // create/load level 1
        myMap.InitLevel(1);

        // create our player object and attach him it to the map
        player = new MapObjectPlayer(new Position(50, 50));
        player.SetCurrentMap(myMap);

        //counter = new CounterField("Health", 0, player.position.x, player.position.y);
        // test: create and add a JavaFX label to the scene
        cellDescription = new Label("Description:");
        cellDescription.setLayoutX(350);
        cellDescription.setLayoutY(100);
        GameFX.root.getChildren().add(cellDescription);
    }

    /**
     * Restarts the game. - reset player position - reset score
     */
    public void RestartGame() {

        // respawn player avatar
        System.out.println("==========RESPAWN AT " + playerStartingPosition.x + "," + playerStartingPosition.y);
        player.Respawn(playerStartingPosition);
        System.out.println("==========RESPAWN AT " + playerStartingPosition.x + "," + playerStartingPosition.y);

        // reset score to zero
        score.Reset();

        cellDescription.setText("RESTART");
    }

    public void TestImageHandler() {

        System.out.println("====================");
        System.out.println("TESTING IMAGEHANDLER");
        System.out.println("====================");

        Image img;

        System.out.println("imageHandler.IsLoaded(test.png)=" + imageHandler.IsLoaded("test.png"));
        System.out.println("imageHandler.IsLoaded(player.png)=" + imageHandler.IsLoaded("player.png"));

        System.out.println("--------------- Current list of images handled:");
        img = imageHandler.GetImageFromFile("player.png");
        for (String s : imageHandler.GetFilenames()) {
            System.out.println("filename: " + s);
        }
        System.out.println("--------------- Current list of images handled:");
        img = imageHandler.GetImageFromFile("sprite.png");
        for (String s : imageHandler.GetFilenames()) {
            System.out.println("filename: " + s);
        }
        System.out.println("--------------- Current list of images handled:");
        img = imageHandler.GetImageFromFile("player.png");
        for (String s : imageHandler.GetFilenames()) {
            System.out.println("filename: " + s);
        }
    }

    @Override
    public void handle(long currentNanoTime) {

        //myGame.
        // calculate seconds since program start
        double t = (currentNanoTime - startNanoTime) / 1000000000.0;
        //System.out.println("t = " + t);

        ticks++;

        // first we check for input from keyboard or mouse
        HandleInput();

        // handle logical updates
        UpdateLogic();

        // clear map every 5 ticks
        if (ticks % 60 == 0) {
            //myGame.ClearMap();
        }

        // clear canvas with solid color
        GameFX.ClearCanvas();

        // randomly fill map with 1 monre block
        //myGame.gameMap.FillRandomly(1);
        // redraw map
        //myGame.DrawMap();
        //GameFX.DrawMap();
        myMap.DrawOnCanvas(GameFX.canvas);

        // draw image at player position
        //gc.drawImage(image1, playerPos.x, playerPos.y);
        player.DrawOnCanvas(GameFX.canvas);

        // test: draw some strings
        GraphicsContext gc = GameFX.canvas.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        gc.setStroke(Color.RED);
        gc.setLineWidth(1);

        if (GameFX.mousePosition == null) {
            System.out.println(" GameFX.mousePosition is null!!!");
        } else {
            GameFX.mousePosition.toString();
        }

        cursorPos.x = 100;
        cursorPos.y = 400;

        // debug output of currently pressed cursor keys
        String keys = "keys: ";
        if (GameFX.keyboardInput.contains("LEFT")) {
            keys = keys + "left ";
        }
        if (GameFX.keyboardInput.contains("RIGHT")) {
            keys = keys + "right ";
        }
        if (GameFX.keyboardInput.contains("UP")) {
            keys = keys + "up ";
        }
        if (GameFX.keyboardInput.contains("DOWN")) {
            keys = keys + "down ";
        }
        gc.fillText(keys, cursorPos.x, cursorPos.y);

        // next line
        cursorPos.y += lineheight;

        // debug output of mouse position
        gc.fillText("mouse:" + GameFX.mousePosition, cursorPos.x, cursorPos.y);

        // next line
        cursorPos.y += lineheight;

        // player position in pixels
        gc.fillText("player: " + player.getPixelPosition().toString(), cursorPos.x, cursorPos.y);

        // next line
        cursorPos.y += lineheight;

//        // player position on map
//        gc.fillText("playerOnMap: " + player.getMapPosition().toString(), cursorPos.x, cursorPos.y);
//
//        // next line
//        cursorPos.y += lineheight;
        // debug output player respawn position
        gc.fillText("playerRespawn: " + playerStartingPosition.x + "," + playerStartingPosition.y, cursorPos.x, cursorPos.y);

        // next line
        cursorPos.y += lineheight;

        // tell score to draw itself
        //score.text="ASDF";
        score.DrawOnCanvas(GameFX.canvas);
        //testSprite.DrawOnCanvas(GameFX.canvas);

        ////////////////////////
        // draw all drawables..
        ///////////////////////
        for (GameObject o : myGameObjects) {
            if (o != null) {
                if (o instanceof Drawable) {
                    ((Drawable) o).DrawOnCanvas(GameFX.canvas);
                }
            }
        }

        // quick and dirty implementation of pickup logic for gold object
        // todo: move into update logic of map, add interface for "pickupable" etc.
        if (myMap.gold != null) {

            myMap.gold.DrawOnCanvas(GameFX.canvas);

            // // test if player is at gold position
            if (myMap.gold.OverlapsWith(player)) {
                System.out.println("pickup gold!!!!!");
                myMap.gold = null;
                score.Increase(1000);
            }
        }

        // quick and dirty implementation of a chest (with content)
        if (myMap.chest != null) {
            myMap.chest.DrawOnCanvas(GameFX.canvas);

            // test if player is at chest position
            if (myMap.chest.OverlapsWith(player)) {
                System.out.println("chest contents:" + myMap.chest.GetContentInfo());
            }
        }

        // test: draw rectangle at player's map position
        int x = (player.position.x + MapCell.CELLSIZE / 2) / MapCell.CELLSIZE;
        int y = (player.position.y + MapCell.CELLSIZE / 2) / MapCell.CELLSIZE;
        x *= MapCell.CELLSIZE;
        y *= MapCell.CELLSIZE;

        gc.setStroke(Color.RED);

        gc.strokeRect(x, y, MapCell.CELLSIZE, MapCell.CELLSIZE);
    }

    // do logic updates (increase counters etc)
    public void UpdateLogic() {
        // test: inscrease score by 1
        //score.Increase(1);

        player.UpdateLogic();
        
        // move our test sprite
        testSprite.position.x ++;
        if(testSprite.position.x >=400)
            testSprite.position.x = 0;

        // show description for cell under player position
        int x = (player.position.x+player.size.w/2) / MapCell.CELLSIZE;
        int y = (player.position.y+player.size.h/2) / MapCell.CELLSIZE;

        MapCell c = myMap.mapcells[x][y];

        if (c instanceof MapCellFloor) {
            // player overlapping with:            
            // floor: do nothing
            cellDescription.setText("pos:" + x + "," + y + "=Floor");
        } else if (c instanceof MapCellWall) {
            // player overlapping with:            
            // wall: should not be possible, but currently our 
            // collision detection doesn't work too well.
            cellDescription.setText("pos:" + x + "," + y + "=Wall");
        } else if (c instanceof MapCellWater) {
            // player overlapping with:            
            // water: decrease score
            cellDescription.setText("pos:" + x + "," + y + "=Water");
            System.out.println("water is dangerous!");
            score.Decrease(5);
            player.health.Decrease(2);
        } else if (c instanceof MapCellHealing) {
            // player overlapping with:            
            // healing field, heals player
            cellDescription.setText("pos:" + x + "," + y + "=Healing");
            System.out.println("healing player...");
            player.health.Increase(5);
        } else {
            // player overlapping with:            
            // unknown field type
            cellDescription.setText("pos:" + x + "," + y + "=Unknown");
        }
    }

    /**
     * Handle input from mouse or keyboard.
     */
    public void HandleInput() {

        // check if input object exists
        if (GameFX.keyboardInput == null) {
            System.out.println("GameFX.keyboardInput is null!!!");
            return;
        }

        // for now, we only check the cursor keys
        if (GameFX.keyboardInput.contains("LEFT")) {
            if (player.MoveLeft() == false) {
                //System.out.println("left not possible");
            };
        }
        if (GameFX.keyboardInput.contains("RIGHT")) {
            if (!player.MoveRight()) {
                //System.out.println("right not possible");
            }
        }
        if (GameFX.keyboardInput.contains("UP")) {
            if (!player.MoveUp()) {
                //System.out.println("up not possible");
            }
        }
        if (GameFX.keyboardInput.contains("DOWN")) {
            if (!player.MoveDown()) {
                //System.out.println("down not possible");
            }
        }
    }

};
