/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamefx;

import javafx.scene.canvas.Canvas;

/**
 *
 * @author Robert
 */
public interface Drawable {
    // can draw itself on a canvas
    // might be done differently by implementing classes
    // (for example, draw at fixed position)
    public void DrawOnCanvas(Canvas canvas);
    public void DrawOnCanvas(Canvas canvas, int x, int y);
    //public void DrawOnCanvas(GraphicsContext gc);
    
    // can also print itself into the console, for debug purposes
    //public void DrawInConsole();
}
