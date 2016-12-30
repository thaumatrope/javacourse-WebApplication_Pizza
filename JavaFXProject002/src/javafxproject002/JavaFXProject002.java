/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxproject002;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author jwest
 */
public class JavaFXProject002 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        Label nameLbl = new Label("Enter your name:");
        TextField nameFld = new TextField();
        
        Label msg = new Label();
        msg.setStyle("-fx-text-fill: blue;");
        
        
        // Create buttons
        Button sayHelloBtn = new Button("Say Hello");
        Button exitBtn = new Button("Exit");
        // Add the event handler for the Say Hello button
        sayHelloBtn.setOnAction(e -> {
        String name = nameFld.getText();
        if (name.trim().length() > 0) {
        msg.setText("Hello " + name);
        } else {
        msg.setText("Hello there");
        }
        });
        // Add the event handler for the Exit button
        exitBtn.setOnAction(e -> Platform.exit());
        // Create the root node
        VBox root = new VBox();
        // Set the vertical spacing between children to 5px
        root.setSpacing(5);
        // Add children to the root node
        root.getChildren().addAll(nameLbl, nameFld, msg, sayHelloBtn, exitBtn);
        Scene scene = new Scene(root, 350, 150);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Improved Hello JavaFX Application");
        primaryStage.show();
        
      
        
     }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
