/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxproject004;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author jwest
 */
public class JavaFXProject004 extends Application {
    
    
    public JavaFXProject004() {
        String name = Thread.currentThread().getName();
        System.out.println("JavaFXProject004() constructor: " + name);
    }
    
    @Override
    public void init() {
    String name = Thread.currentThread().getName();
    System.out.println("init() method: " + name);
    }
        
    @Override
    public void start(Stage primaryStage) {    
   
        String name = Thread.currentThread().getName();
        System.out.println("start() method: " + name);
        
        
        
        
        Scene scene = new Scene(new Group(), 200, 200);
        primaryStage.setTitle("JavaFX Application Life Cycle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
        
    @Override
    public void stop() {
        String name = Thread.currentThread().getName();
        System.out.println("stop() method: " + name);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(args);
    }
    
}
