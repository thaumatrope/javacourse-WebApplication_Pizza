/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_aufbaukurs_002;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author John Westfield
 */

    
public class GUI extends JFrame implements ActionListener {
    
    public static void main(String[] args) {
        JFrame neu=new GUI("erster Versuch");
        new GUI("zweiter Versuch");
        new GUI("dritter Versuch");
        new GUI("vierter Versuch");
    }
    @Override
    public void actionPerformed(ActionEvent nameDesEvents) {
        System.out.println("Methode aufgerufen");
    }
    public GUI(String titel){
        super(titel);
        //neu geht nicht, denn neu ist lokale Variabe
        this.setBounds(200,300,300,200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton knopf=new JButton("klickbar");
        this.add(knopf);
        //Gebraucht wird ein Objekt vom Typ ActionListener //So nicht:   //Endloser Konstruktoraufruf  //ActionListener ae=new GUI("Test");
        knopf.addActionListener(this);
 
        this.setVisible(true);
        
    }
}


