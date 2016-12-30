/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamefx;

import java.util.ArrayList;
import javafx.scene.paint.Color;

/**
 * 
 * @author IBB Teilnehmer
 */
public class MapObjectChest extends MapObject {
    
    // size of this ches (to set maximum number of contents)
    public int size = 5;
    
    // a chest can contain things...
    // todo: better use a set or hashtable to ensure that the same object
    // cannot be put into the same chest more than once etc
    ArrayList<MapObject> contents = new ArrayList<>();
       
    /**
     * Create an empty chest at given position.
     * @param position 
     */
    
    public MapObjectChest(Position position){
        // execute parent constructor...
        super(position);
        
        // override token, color.
        this.token = 'c';
        this.color = Color.BROWN;
        
        // set image
        this.image = GameFX.gameLoop.imageHandler.GetImageFromFile("chest.png");     
    }
    
    /**
     * Put a mab object into the chest.
     * todo: 
     * - check for duplicates
     * - check for maximum size
     * @param object2
     * @return 
     */
    public boolean PutMapObject(MapObject object2)   
    {
        // todo: properly add to contents
        // (check for duplicates etc)
        contents.add(object2);
        return true;
    }
    
    // get text info about chest content
    public String GetContentInfo()
    {
        if(contents.isEmpty()){
            return "empty";            
        }
        else
        {
            // todo: override toString() method of game objects, use it here
            return "some mysterious stuff";
        }
    }
}
