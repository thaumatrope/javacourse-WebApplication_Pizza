/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenstermitzeug;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author Sanne
 */
public class FensterMitMenu extends JFrame implements ActionListener{
    JMenuBar leiste=new JMenuBar();
    JMenu eintrag1=new JMenu("Layout");
    JMenu eintrag2=new JMenu("Anderer Kram");
    JMenuItem item1=new JMenuItem("Grid");
    JMenuItem item2=new JMenuItem("Flow");
    JMenuItem item3=new JMenuItem("Border");
    
    FlexPanel meinPanel=new FlexPanel();
    
    public FensterMitMenu(){
        super("Fenster mit Menu");
        zeichen();
    }
    private void zeichen(){
        leiste.add(eintrag1);
        leiste.add(eintrag2);
        eintrag1.add(item1);
        eintrag1.add(item2);
        eintrag1.add(item3);
       
       item1.addActionListener(this);
       item2.addActionListener(this);
       item3.addActionListener(this);
        
       // this.add(leiste);DIE eine Menuleiste wird nicht zugefügt sondern gesetzt
       this.setJMenuBar(leiste);
       
       this.add(meinPanel);
       
        this.setSize(500,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("EREIGNIS:");
        if(e.getSource()==item1){
            System.out.println("Gedrückt"+item1.getActionCommand());
        }
        if(e.getSource()==item2){
            System.out.println("Gedrückt"+item2.getActionCommand());
        }
        if(e.getSource()==item3){
            System.out.println("Gedrückt"+item3.getActionCommand());
        }
        
    }
}
