/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Sanne
 */
public class GUI2 extends JFrame implements ActionListener {
    public static void main(String[] args) {
        JFrame neu=new GUI2("erster Versuch");
        new GUI2("zweiter Versuch");
        new GUI2("dritter Versuch");
        new GUI2("vierter Versuch");
    }
    @Override
    public void actionPerformed(ActionEvent nameDesEvents) {
        System.out.println("Methode aufgerufen");
    }
    public GUI2(String titel){
        super(titel);
        //neu geht nicht, denn neu ist lokale Variabe
        this.setBounds(200,300,300,200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton knopf=new JButton("klickbar");
        this.add(knopf);
        //Gebraucht wird ein Objekt vom Typ ActionListener //So nicht:   //Endloser Konstruktoraufruf  //ActionListener ae=new GUI2("Test");
        knopf.addActionListener(this);
 
        this.setVisible(true);
        
    }
}
