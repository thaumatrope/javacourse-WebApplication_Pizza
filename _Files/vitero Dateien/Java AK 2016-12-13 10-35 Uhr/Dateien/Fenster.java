/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui3;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Sanne
 */
public class Fenster extends JFrame implements ActionListener{
    private JButton[] knopf=new JButton[5];
    private JTextArea meinText=new JTextArea("Dieser Text erscheint" ,20,30);
    private JLabel label=new JLabel("Bezeichner");
    public Fenster(String titel){
        super(titel);
        this.setLayout(new FlowLayout());
        for(int i=0;i<knopf.length;i++){
            knopf[i]=new JButton();
            knopf[i].setText("Button "+i);
            knopf[i].addActionListener(this);//removeActionListener(this) würde Listener entfernen
            this.add(knopf[i]);
        }
        meinText.setBackground(Color.red);
        this.add(label);
        this.add(meinText);
        this.setSize(200,300);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //System.out.println("Ausgeloest von: "+e.getSource());
        if(knopf[0]==e.getSource()){
            System.out.println("Erster Button gedrückt");
            knopf[0].removeActionListener(this);
        }
        if(knopf[1]==e.getSource()){
            System.out.println("Zweiter Button gedrückt");
        }
        if(knopf[2]==e.getSource()){
            System.exit(33);
        }
    }
    
}
