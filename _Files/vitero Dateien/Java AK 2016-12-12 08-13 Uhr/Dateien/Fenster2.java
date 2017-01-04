/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenster;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Sanne
 */
public class Fenster2 extends JFrame implements ActionListener{
    private JPanel meinPanel=new JPanel();
    private JButton knopf1=new JButton("EINS");
    private JButton knopf2=new JButton("Zwei");
    private JButton knopf3=new JButton("Drei");
    public Fenster2(){
        aufbauen();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str=e.getSource().toString();
        System.out.println("Ausgeloest von"+str);
    }
    private void aufbauen(){
        this.setSize(300, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        meinPanel.add(knopf1);
        meinPanel.add(knopf2);
        meinPanel.add(knopf3);
        
        knopf1.addActionListener(this);
        knopf2.addActionListener(this);
        knopf3.addActionListener(this);
        
        this.add(meinPanel);
        
    }
}
