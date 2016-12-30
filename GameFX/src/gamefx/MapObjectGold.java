/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamefx;


/**
 * Map object: MapObjectGold
 additional data: value
 * @author IBB Teilnehmer
 */
public class MapObjectGold extends MapObject{

    // how much gold?
    public int value;
    
    /**
     * Default constructor: default value of 10.
     */
    public MapObjectGold()
    {
        this(10, new Position(0,0));
    }
    
    /**
     * Create Gold object with specific value.
     * @param value 
     */
    public MapObjectGold(int value, Position position)
    {
        // why is this necessary?!
        super(position);
        
        // store value
        this.value = value;

        // store position
        this.position = position;
        
        // set image
        image = GameFX.gameLoop.imageHandler.GetImageFromFile("gold.png");
    }
}
