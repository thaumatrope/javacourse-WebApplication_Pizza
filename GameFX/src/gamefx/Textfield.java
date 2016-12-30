/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamefx;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * A textfield can render a String into the canvas at a given position.
 * 
 * @author IBB Teilnehmer
 */
public class Textfield extends GameObject implements Drawable {

    // position in pixels
    Position position;
    
    // text
    String text;
    
    int textsize = 12;

    /**
     * Constructor: create new text at position x,y
     *
     * @param text
     * @param x
     * @param y
     */
    public Textfield(String text, int x, int y) {
        this.text = text;
        this.position = new Position(x, y);
    }

    /**
     * Draw component onto canvas.
     *
     * @param canvas
     */
    @Override
    public void DrawOnCanvas(Canvas canvas) {

        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.setFill(Color.RED);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(1);
        Font theFont = Font.font("Arial", FontWeight.NORMAL, textsize);
        gc.setFont(theFont);
        gc.fillText(this.text, position.x, position.y);
        gc.strokeText(this.text, position.x, position.y);
    }

    @Override
    public void DrawOnCanvas(Canvas canvas, int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
