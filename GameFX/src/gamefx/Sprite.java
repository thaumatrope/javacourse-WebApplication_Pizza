/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamefx;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

/**
 * Sprites are game objects which can draw themselves using an image.
 * @author IBB Teilnehmer
 */
public class Sprite extends GameObject implements Drawable {

    // position on screen position of map object (in pixels, top left corner)
    protected Position position = null;

    //  size of bounding box (square)
    protected int size;

    // image reference
    Image image = null;

    String filename;

    Color color;

    /**
     * Constructor
     *
     * @param x screen position on x axis, in pixels
     * @param y screen position on y axis, in pixels
     */
    public Sprite(int x, int y) {
        
        this.size = 32;
        this.position = new Position(x, y);

        // set default image
        //SetImage("sprite.png");

        // set default color
        color = Color.RED;
    }

    /**
     * Constructor
     *
     * @param x screen position on x axis, in pixels
     * @param y screen position on y axis, in pixels
     * @param filename
     */
    public Sprite(int x, int y, String filename) {
        this.size = 32;
        // store position
        this.position = new Position(x, y);

        // set default image
        if (filename != null) {
            SetImage(filename);
        }      

        // set default color
        color = Color.CORAL;
    }

    // set default image
    protected void SetImage(Image image) {
        this.image = image;
    }

    // load image from local file
    protected void SetImage(String filename) {
        System.out.println("Sprite.SetImage(\""+filename+"\")");
        this.filename = filename;
        Image i = new Image("file:" + filename); 
        System.out.println("i = " + i);
        System.out.println("i = " + i.toString());
        System.out.println("i = " + i.isError());
        System.out.println("i = " + i.isBackgroundLoading());
        SetImage(i);
    }

    /**
     * Implementation of Drawable interface
     *
     * @param canvas
     */
    // 
    @Override
    public void DrawOnCanvas(Canvas canvas) {

        GraphicsContext gc = canvas.getGraphicsContext2D();

        // do we have an image?
        if (image != null) {
            // draw our image
            //gc.setFill(Color.BLACK);
            gc.drawImage(image, position.x, position.y);
        } else {
            // no image, use colored rectangle for graphics
            gc.setFill(color);
            gc.fillRect(position.x, position.y, size, size);
        }

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void DrawOnCanvas(Canvas canvas, int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
