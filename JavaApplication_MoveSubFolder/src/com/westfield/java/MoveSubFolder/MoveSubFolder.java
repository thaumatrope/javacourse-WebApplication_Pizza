package com.westfield.java.MoveSubFolder;

import com.westfield.java.console.Console;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author John Westfield
 */
public class MoveSubFolder {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        boolean noValidDir;
        String[] filesInDir;
        File fileRoot;
        
        String helloText = "MoveSubFolder v1";        
        Console myConsole = new Console();   
        
        
        do {
            noValidDir = true;
            myConsole.cls_init(helloText);
            System.out.println("Please enter Path to directory: ");
            String myRoot = myConsole.getInputString();
            
            fileRoot = new File(myRoot);  
            
            myConsole.printEmptyLine(1);
            myConsole.printDashes(1);
            myConsole.printEmptyLine(1);
            
            if (fileRoot.exists() && fileRoot.isDirectory()) {
                noValidDir = false;
                System.out.println("Is valid directory: " + myRoot);
            } else {
                noValidDir = true;
                System.out.println("NO valid directory: " + myRoot);
            }   
            
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(MoveSubFolder.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        } while (noValidDir);
        
        // get a listing of all files in the directory
        filesInDir = fileRoot.list();
        
        // sort the list of files (optional)
        Arrays.sort(filesInDir);
        
        // have everything i need, just print it now
        for ( int i=0; i < filesInDir.length; i++ )
        {
            String tryFile1 = fileRoot.getAbsolutePath() + "\\" + filesInDir[i];
            
            File testFileParent = new File(tryFile1);
             if (testFileParent.exists() && testFileParent.isDirectory()) {               
                System.out.println("Is valid directory: " + testFileParent);
                
                String tryFile2 = fileRoot.getAbsolutePath() + "\\" + filesInDir[i] + "\\" + filesInDir[i];
                File testFileChild = new File(tryFile2);
                if (testFileChild.exists() && testFileChild.isDirectory()) {               
                   System.out.println("Is valid directory: " + testFileChild);

                    try {
                        MoveSubFolder.copyDirectory(testFileChild, testFileParent);
                    } catch (IOException ex) {
                        Logger.getLogger(MoveSubFolder.class.getName()).log(Level.SEVERE, null, ex);
                    }


               } else {
                   noValidDir = true;
                   System.out.println("NO valid directory: " + testFileChild);
               } 
                
            } else {
                noValidDir = true;
                System.out.println("NO valid directory: " + testFileParent);
            } 
         
        }
         
    }
    
    
    // If targetLocation does not exist, it will be created.
    public static void copyDirectory(File sourceLocation , File targetLocation) throws IOException 
    {
        if (sourceLocation.isDirectory()) {
            if (!targetLocation.exists()) {
                targetLocation.mkdir();
            }

            String[] children = sourceLocation.list();
            for (int i=0; i<children.length; i++)
            {
                copyDirectory(new File(sourceLocation, children[i]), new File(targetLocation, children[i]));
            }
            MoveSubFolder.deleteFile(sourceLocation);
            
        } else {
            InputStream in = new FileInputStream(sourceLocation);
            OutputStream out = new FileOutputStream(targetLocation);            
            
            // Copy the bits from instream to outstream
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }            
            
            in.close();
            out.close();
            
             MoveSubFolder.deleteFile(sourceLocation);
            
        }
    }
    
    
    public static void deleteFile(File source)
    {
                
        try{                
            if(source.delete()){
                    System.out.println(source.getName() + " is deleted!");
            }else{
                    System.out.println("Delete operation is failed. " + source.getAbsolutePath());
            }

        }catch(Exception e){

                e.printStackTrace();

        }
        
    }
    
}
