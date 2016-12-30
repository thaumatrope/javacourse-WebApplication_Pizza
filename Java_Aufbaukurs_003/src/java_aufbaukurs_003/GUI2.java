/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_aufbaukurs_003;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 *
 * @author John Westfield
 */
public class GUI2 extends JFrame implements ActionListener, MouseMotionListener {
    
    private JButton[] knopf = new JButton[5];
    private JTextArea meinText = new JTextArea("Dieser Text erscheint", 20, 30);
    
    public GUI2(String titel){
        super(titel);
        this.setLayout(new FlowLayout());
        
        int i = 0;
        for(JButton j: knopf){
            j = new JButton();
            knopf[i++] = j;
            
            j.setText("Button");
            j.addActionListener(this);
            this.add(j);
        }
        
        this.add(meinText);
        this.setSize(200,300);
        this.setVisible(true);
    }
    
   
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        System.out.println("Ausgelöst von:" + e.getSource());
        if(knopf[0] == e.getSource()){
            System.out.println("Button 0 gedrückt!");
        }else if(knopf[1] == e.getSource()){
            System.out.println("Button 1 gedrückt!");
        }else if(knopf[2] == e.getSource()){
            System.exit(33);
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
