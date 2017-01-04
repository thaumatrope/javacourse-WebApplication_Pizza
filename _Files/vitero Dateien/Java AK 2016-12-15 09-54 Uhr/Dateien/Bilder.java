/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bilder;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Sanne
 */
public class Bilder {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame f= new JFrame();
        //f.setLayout(new BorderLayout());
   
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton knopf = new JButton();
        f.setSize(300,300);
        f.add(knopf);
        ImageIcon bild = new ImageIcon("C:\\Users\\Sanne\\Desktop\\IBB-MeineKurse\\E-270\\Bilder\\Banana.png");
        bild.setImage(bild.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        knopf.setIcon(bild);
        String str="Hallo";
        Object o=str;
        if(o instanceof BorderLayout){
            System.out.println("True");
        }
        else System.out.println("False");
        LayoutManager lm = f.getLayout();
        if(lm instanceof BorderLayout){
            System.out.println("Jo");
        }
        
    
        f.setVisible(true);
    }
    
}
