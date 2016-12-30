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
 * Parent class for map cells
 *
 * @author IBB Teilnehmer
 */
public class MapCell extends GameObject implements Drawable{

    // character representing map cell (for debug output as string)
    protected char token;

    // color representing map cell (for drawing on canvas)
    protected Color color;

    // cells are stored in a 2d array, so we don't need a position...
    //public Point position;
    // size of a cell in pixels
    protected static final int CELLSIZE = 32;

    // image for this map cell
    protected Image image = null;

    public MapCell() {
        // store position
        //this.position = position;

        // default: set token for empty, set color to white
        this.token = '.';
        this.color = Color.WHITE;
    }

    /**
     * draw this cell onto the canvas (at given position)
     *
     * @param canvas
     * @param x position (in map units, not pixels!)
     * @param y position (in map units, not pixels!)
     */
    public void DrawOnCanvas(Canvas canvas, int x, int y) {
        //System.out.println("MapCell - DrawOnCanvas()");

        //cellsize = Maphandler.cellsize;
        
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // if we have an image, use it for drawingg
        if (image != null) {
            // draw image
            gc.drawImage(image, x * CELLSIZE, y * CELLSIZE);
        } else {
            // no image exists, draw colored rectangel
            gc.setFill(color);
            gc.fillRect(x * CELLSIZE, y * CELLSIZE, CELLSIZE, CELLSIZE);;
        }
    }

    @Override
    public void DrawOnCanvas(Canvas canvas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
