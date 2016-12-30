/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamefx;

import java.awt.Point;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Main class, Java FX application
 *
 * @author IBB Teilnehmer
 */
public class GameFX extends Application {

    // todo: get rid of statics... do the handle() methods NEED statics?
    static Canvas canvas;
    static Scene scene;
    static Group root;

    static Menu menuFile;
    static Menu menuEdit;
    static Menu menuRun;
    static MenuBar menuBar;
    static MenuItem menuItemNew;
    static MenuItem menuItemLoad;
    static MenuItem menuItemSave;
    static MenuItem menuItemExit;
    static MenuItem menuItemUndo;
    static MenuItem menuItemRedo;
    static MenuItem menuItemStartGame;
    static MenuItem menuItemStartLevel1;
    static MenuItem menuItemStartLevel2;
    static MenuItem menuItemStartLevel3;

    //static MapHandler gameMap;
    static GameLoop gameLoop;

    static ArrayList<String> keyboardInput;  // move to game loop?
    static Point mousePosition;  // move to game loop?

    /**
     * FX Application starting point.
     *
     * @param primaryStage
     */
    @Override
    public void start(Stage primaryStage) {

        // do some tests first
//        System.out.println("testing...");
//        TestClass t = new TestClass();
//        t.DoTest();

        // create mapdata first
        //InitMap();
        InitUI(primaryStage);

        // add event handlers
        AddEventHandlers(scene);

        // create and start game loop
        gameLoop = new GameLoop();
        gameLoop.Init();
        gameLoop.start();
    }

    /**
     * Create and set event handlers for mouse and keyboard.
     *
     * @param myscene which scene gets the events?
     */
    void AddEventHandlers(Scene myscene) {

        // create input objects if necessary
        if (keyboardInput == null) {
            keyboardInput = new ArrayList<String>();
        }

        if (mousePosition == null) {
            mousePosition = new Point(0, 0);
        }

        // keyboard event handlers
        myscene.setOnKeyPressed(
                new EventHandler<KeyEvent>() {
                    public void handle(KeyEvent e) {
                        String code = e.getCode().toString();

                        // only add once... prevent duplicates
                        if (!keyboardInput.contains(code)) {
                            keyboardInput.add(code);
                        }
                    }
                });

        myscene.setOnKeyReleased(
                new EventHandler<KeyEvent>() {
                    public void handle(KeyEvent e) {
                        String code = e.getCode().toString();
                        keyboardInput.remove(code);
                    }
                });

        // mouse event handlers:
        myscene.setOnMouseClicked(
                new EventHandler<MouseEvent>() {
                    public void handle(MouseEvent e) {
                        // empty
                    }
                });

        myscene.setOnMouseClicked(
                new EventHandler<MouseEvent>() {
                    public void handle(MouseEvent e) {
                        mousePosition.x = (int) e.getX();
                        mousePosition.y = (int) e.getY();
                    }
                });
    }

    /**
     * Initialize User Interface - create canvas - setup stage Q: should we set
     * the event handlers here too?
     *
     * @param stage
     */
    public void InitUI(Stage stage) {

        //////////////////////////
        // create basic FX stuff: 
        // Group, Scene, Canvas
        //////////////////////////
        // create root
        // simple version: group
        // groups simply render their children without applying fancy layout
        root = new Group();

        // create scene
        scene = new Scene(root); //, 300, 250);

        // create a canvas and make it a child of root
        canvas = new Canvas(500, 500);

        //////////////////////////
        // create menu 
        // create menu items
        //////////////////////////
        // create menubar
        menuBar = new MenuBar();

        // create menus
        menuFile = new Menu("File");
        menuEdit = new Menu("Edit");
        menuRun = new Menu("Run");

        // create menu item file - new
        menuItemNew = new MenuItem("New");
        menuItemNew.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                System.out.println("menuItemNew");
                System.out.println("todo: create new map");
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });

        // create menu item file - load
        // clicking it will load a new map from the local filesystem
        menuItemLoad = new MenuItem("Load");
        menuItemLoad.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                System.out.println("menuItemNew");
                throw new UnsupportedOperationException("load map - Not supported yet.");
            }
        });

        // create menu item file - save
        // clicking it will save the current map to the local file system
        menuItemSave = new MenuItem("Save");
        menuItemSave.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                System.out.println("menuItemSave");
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });

        // create menu item file - exit
        // clicking it will exit the application
        menuItemExit = new MenuItem("Exit");
        menuItemExit.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                System.exit(0);
            }
        });

        // create menu item edit - undo
        menuItemUndo = new MenuItem("Undo");
        menuItemUndo.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                System.out.println("menuItemUndo");
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });

        // create menu item edit - redo
        menuItemRedo = new MenuItem("Redo");
        menuItemRedo.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                System.out.println("menuItemRedo");
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });

        // create menu item run - start game
        menuItemStartGame = new MenuItem("Respawn");
        menuItemStartGame.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                // tell game loop to restart
                gameLoop.RestartGame();
            }
        });

        // create menu item run - level 1
        menuItemStartLevel1 = new MenuItem("Level 1");
        menuItemStartLevel1.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                // tell game loop to restart and load level 1
                gameLoop.RestartGame();
                gameLoop.myMap.InitLevel(1);
            }
        });
        // create menu item run - level 1
        menuItemStartLevel2 = new MenuItem("Level 2");
        menuItemStartLevel2.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                // tell game loop to restart and load level 2
                gameLoop.RestartGame();
                gameLoop.myMap.InitLevel(2);
            }
        });
        // create menu item run - level 1
        menuItemStartLevel3 = new MenuItem("Level 3");
        menuItemStartLevel3.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                // tell game loop to restart and load level 3
                gameLoop.RestartGame();
                gameLoop.myMap.InitLevel(3);
            }
        });

        // add submenu items to the menus
        menuFile.getItems().addAll(menuItemNew, menuItemLoad, menuItemSave, new SeparatorMenuItem(), menuItemExit);
        menuEdit.getItems().addAll(menuItemUndo, menuItemRedo);
        menuRun.getItems().addAll(menuItemStartGame, new SeparatorMenuItem(),menuItemStartLevel1,menuItemStartLevel2,menuItemStartLevel3 );

        // add menus to the menubar
        menuBar.getMenus().addAll(menuFile, menuEdit, menuRun);

        //////////////////////////
        // add all elements to 
        // our root object
        //////////////////////////
        
        // add canvas and menubar
        root.getChildren().addAll(canvas, menuBar);

        ////////////////////////////////////////////
        // set title caption, set scene, show window
        ////////////////////////////////////////////
        stage.setTitle("GameMapFX");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Clear canvas with given color
     *
     * @param color
     */
    public static void ClearCanvas(Color color) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(color);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    /**
     * clear canvas with white color
     */
    public static void ClearCanvas() {
        ClearCanvas(Color.WHITE);
    }

    /**
     * Add a button the the UI.
     *
     * @param root
     */
    public void AddButton(Group root) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        root.getChildren().add(btn);
    }

    /**
     * main entry point for the whole program: launches FX application
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
