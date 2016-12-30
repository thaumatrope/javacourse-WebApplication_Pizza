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
 * generic map object - has a color - has a position - can draw itself onto
 * canvas
 *
 * @author IBB Teilnehmer
 */
public abstract class MapObject {

    // position of map object (in pixels)
    protected Position position;

    protected char token;

    // color of map object (todo: add image)
    protected Color color;

    // size of map object in pixels (for rectangular bounding box)
    protected Size size = new Size(32, 32);

    // image for this map object
    protected Image image = null;

    /**
     * Create map object at given position.
     *
     * @param position
     */
    public MapObject(Position position) {
        // store position
        this.position = position;

        // set a default color
        color = Color.LIGHTPINK;

    }

    // getter for position
    public Position getPixelPosition() {
        return this.position;
    }

    // get map position in cells
    public Position getMapPosition() {
        Position pt = new Position(
                (position.x + MapHandler.cellsize / 2) / MapHandler.cellsize,
                (position.y + MapHandler.cellsize / 2) / MapHandler.cellsize);
        return pt;
    }

    // get map position at specified pixel posotion
    // this would belong into the maphandler class!
    public Position getMapPositionAtPixelpos(Position pixelpos) {
        Position pt = new Position(pixelpos.x / MapHandler.cellsize, pixelpos.y / MapHandler.cellsize);
        return pt;
    }

    /**
     * Collision check against another map object
     * 
     * @param mapObject2
     * @return 
     */
    public boolean OverlapsWith(MapObject mapObject2) {
        return OverlapsWith(mapObject2.position, mapObject2.size);
    }

    /**
     * Collision check against another object
     * @param position2
     * @param size2
     * @return 
     */
    public boolean OverlapsWith(Position position2, Size size2) {
        if (position.x + size.w < position2.x
                || position2.x + size2.w < position.x
                || position.y + size.h < position2.y
                || position2.y + size2.h < position.y) {
            // no overlap
            return false;
        } else {
            // overlap!
            return true;
        }
    }

    /**
     * Draw map object on specified canvas. If object is associated with an
     * image file, draw the image if no image exists, fallback to colored
     * rectangle
     *
     * @param canvas
     */
    public void DrawOnCanvas(Canvas canvas) {
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // do we have an image?
        if (image != null) {
            // draw our image
            gc.drawImage(image, position.x, position.y);
            //gc.dra
        } else {
            // no image, use colored rectangle for graphics
            gc.setFill(color);
            gc.fillRect(
                    position.x * MapHandler.cellsize,
                    position.y * MapHandler.cellsize,
                    size.w, size.h);
        }
    }

    /**
     * Debug output into console.
     */
//    public void DrawInConsole() {
//        System.out.println(token);
//    }
}
