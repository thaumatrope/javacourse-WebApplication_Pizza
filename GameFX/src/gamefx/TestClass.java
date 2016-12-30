/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamefx;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author IBB Teilnehmer
 */
public class TestClass {

    void DoTest() {
        // test read
        TestReadFromFile();
    }

    void TestReadFromFile() {
        System.out.println("TestReadFromFile()");

        String content = null;
        //File file = new File("test.txt");
        //FileReader reader = null;

        try (BufferedReader br = new BufferedReader(new FileReader("test.txt"))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            content = sb.toString();
        } catch (IOException e) {
            System.out.println("An error occured while reading from file!");
            e.printStackTrace();
        } 
        
        System.out.println("content = " + content);
    }

    void TestWriteIntoFile() {
        System.out.println("test.");

        try {
            // Create file 
            FileWriter fstream = new FileWriter("out.txt");
            BufferedWriter out = new BufferedWriter(fstream);
            out.write("Hello Java");
            //Close the output stream
            out.close();
        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
    }
}
