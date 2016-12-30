/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxproject003;

import java.util.List;
import java.util.Map;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 *
 * @author jwest
 */
public class JavaFXProject003 extends Application {
    
     
    @Override
        public void start(Stage primaryStage) {
        // Get application parameters
        Parameters p = this.getParameters();
        Map<String, String> namedParams = p.getNamed();
        List<String> unnamedParams = p.getUnnamed();
        List<String> rawParams = p.getRaw();
        String paramStr = "Named Parameters: " + namedParams + "\n" +
        "Unnamed Parameters: " + unnamedParams + "\n" +
        "Raw Parameters: " + rawParams;
        TextArea ta = new TextArea(paramStr);
        Group root = new Group(ta);
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Application Parameters");
        primaryStage.show();
        }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
