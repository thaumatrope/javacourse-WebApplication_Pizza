/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamefx;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;

/**
 * Tool class for loading and storing our images.
 * Duplicates are not created, if the same filename is passed 
 * more than once into GetImageFromFile(), an already buffered 
 * image object will be returned instead.
 * 
 * This makes life easier when multiple objects want to use
 * the same image reference.
 *
 * @author IBB Teilnehmer
 */
public class ImageHandler {

    // map filenames to images
    protected static Map<String, Image> imageMap;

    /**
     * Constructor: create hash map.
     */
    public ImageHandler() {
        // create map
        imageMap = new HashMap<>();
    }

    /**
     * Load an imagefile from local filesystem.
     *
     * @param filename (with extension, ex. "picture.png")
     * @return loaded Image, or null if file not found
     * @throws ExceptionFileNotFound
     * @throws ExceptionFileDuplicate
     */
    private Image Load(String filename) throws ExceptionFileNotFound, ExceptionFileDuplicate {
        
        // check if file is already loaded
        if (IsLoaded(filename)) {
            throw new ExceptionFileDuplicate(filename);
        }

        // try to load the file
        Image image = null;
        String fileURL="file:"+filename;
        try {
            image = new Image(fileURL);
            System.out.println("image loaded: ");
            System.out.println("error?" + image.isError());
            System.out.println("bg loading?" + image.isBackgroundLoading());
        } catch (IllegalArgumentException e) {
            // invalid filename!
            throw new ExceptionFileNotFound(filename);
        }

        // store in our map
        // Q: do we really want to store null values in our map?
        imageMap.put(filename, image);
        
        return image;
    }
    
    /**
     * Get reference to image by filename.
     * 
     * @param filename
     * @return 
     */
    public Image GetImageFromFile(String filename)
    {
        Image image = null;
        
        try {
            // try loading image from file 
            image = Load(filename);
            
        } catch (ExceptionFileNotFound ex) {
            // file not found: complain about it
            Logger.getLogger(ImageHandler.class.getName()).log(Level.SEVERE, null, ex);  
            
        } catch (ExceptionFileDuplicate ex) {
            
            // do not load duplicate images, instead use those from our list
//            int i = filenameList.indexOf(filename);
//            image = imageList.get(i);
            image = imageMap.get(filename);
        }
        
        return image;
    }

    /**
     * Check if an image was already loaded.
     * 
     * @param filename
     * @return true if image is already in our list
     */
    public boolean IsLoaded(String filename) {
        // check if this filename already exists
        boolean found = imageMap.containsKey(filename);
        return found;
    }

    /**
     * Get an array with all filenames in our map.
     * 
     * @return ArrayList<String>  list of filenames
     */
    public ArrayList<String> GetFilenames() {
        // get all our keys (filenames are keys)
        Set<String> set = imageMap.keySet();

        // stuff them into an array list
        ArrayList<String> list=new ArrayList<>();
        list.addAll(set);

        // return array list
        return list;
    }
}
