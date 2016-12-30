/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamefx;

/**
 * Score class - store current score and draw it on the screen.
 * is a Counterfield with a slightly bigger font than default.
 * can draw itself on the canvas
 * @author IBB Teilnehmer
 */
public class Score extends CounterField {
    
    // constructor: load image, store reference
    public Score()
    {
        super("SCORE", 0,300,50);
        this.name = "SCORE";
        this.textsize = 24;
    }

   
}
