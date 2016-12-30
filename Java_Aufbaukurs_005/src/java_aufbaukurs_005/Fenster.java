/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_aufbaukurs_005;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author John Westfield
 */
public class Fenster extends JFrame implements ActionListener{
    
    JMenuBar leiste = new JMenuBar();
    JMenu eintrag1 = new JMenu("Layout");
    JMenu eintrag2 = new JMenu("Anderes");
    
    JMenuItem item1 = new JMenuItem("Grid");
    JMenuItem item2 = new JMenuItem("Flow");
    JMenuItem item3 = new JMenuItem("Border");
    
    FensterFlex meinPanel = new FensterFlex();
    
    public Fenster(){
        super("Fesnter mit Menu");
        this.aufbauen();
        
    }
    private void aufbauen(){
        
        leiste.add(eintrag1);
        leiste.add(eintrag2);
        eintrag1.add(item1);
        eintrag1.add(item2);
        eintrag1.add(item3);
        
        item1.addActionListener(this);
        item2.addActionListener(this);
        item3.addActionListener(this);
        
        this.add(meinPanel);
        this.setJMenuBar(leiste);
        this.setSize(500, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
        if(e.getSource() == item1){
            System.out.println("Gedrückt " + item1.getActionCommand());
            meinPanel.neuZeichnen(1);
        }else if(e.getSource() == item2){
            System.out.println("Gedrückt " + item2.getActionCommand());
            meinPanel.neuZeichnen(2);
        }else if(e.getSource() == item3){
            System.out.println("Gedrückt " + item3.getActionCommand());
            meinPanel.neuZeichnen(3);
        }
        
    }
    
}
