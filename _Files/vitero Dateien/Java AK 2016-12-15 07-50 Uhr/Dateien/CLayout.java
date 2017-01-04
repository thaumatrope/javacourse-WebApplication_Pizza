/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CardLayout;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author IBB Teilnehmer
 */
public class CLayout extends JFrame{
   
    // Drei Containers new JPanel()
    JPanel panelCont = new JPanel();
    JPanel panelFirst = new JPanel();
    JPanel panelSecond = new JPanel();
    
    //Buttons
    JButton buttonOne = new JButton("Switch to second panel/workspace");
    JButton buttonSecond = new JButton("Switch to first panel/workspace");
    CardLayout cl = new CardLayout();
    
    
    //Constructor
    public CLayout(){
        super("CardLayout");
        
       
        panelCont.setLayout(cl);
       
        panelFirst.add(buttonOne);
        panelSecond.add(buttonSecond);
        
        panelFirst.setBackground(Color.BLUE);
        panelSecond.setBackground(Color.GREEN);
        
        panelCont.add(panelFirst,"1");
        panelCont.add(panelSecond,"2");
        cl.show(panelCont, "1");
        
        
        this.add(panelCont);
        
        
        buttonOne.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(panelCont, "2");
            }
        });


        buttonSecond.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                cl.show(panelCont, "1");
            }
        });
    }
    
}
