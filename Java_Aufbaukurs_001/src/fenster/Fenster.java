/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenster;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.*;


/**
 *
 * @author John Westfield
 */
public class Fenster extends JFrame{

    private JButton knopf1 = new JButton("Klick mich!");
    //private JButton knopf2 = new JButton("Klick mich auch!");
    
    public Fenster(){
        this.setSize(300, 200);
        this.add(knopf1);
        //this.add(knopf2);
        /*knopf1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button gedrückt!");
                System.out.println("Event ausgelöst: " + e);
                System.out.println("Event ausgelöst von: " + e.getSource());
                
            }
        });
        */
        knopf1.addActionListener((ActionEvent e) -> {
           
            System.out.println("Button gedrückt!");
            System.out.println("Event ausgelöst: " + e);
            System.out.println("Event ausgelöst von: " + e.getSource());
                
        });
        
        knopf1.addMouseMotionListener(new MouseMotionListener() {
            
            @Override
            public void mouseMoved(MouseEvent e) {                
                System.out.println("Event ausgelöst (Mouse moved): " + e.getPoint());
            }

            
            public void mouseDragged(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });

        
       
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

   
}

    