/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenster;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Sanne
 */
public class Fenster1 extends JFrame{
    private JButton knopf1 =new JButton("Klick mich");
    //Kein zweiter Knopf:Aktueller LayoutManager zeigt nur eine Komponente an
    public Fenster1(){
        this.setSize(300, 200);
        this.add(knopf1);
        //MeinActionListener mal=new MeinActionListener();
        //wie "früher"
        //knopf1.addActionListener(mal);
        //Etwas enonymer: Anonymes Objekt;
        //knopf1.addActionListener(new MeinActionListener());
        //Oder komplett anonym: anonyme Klasse mit anonymen Object
        knopf1.addActionListener((ActionEvent e) -> {
            System.out.println("Button gedrueckt");
            System.out.println("Das ausgeloeste Event was:"+e);
            System.out.println("AUsgeloest von: "+e.getSource());
        });
        knopf1.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                System.out.println("Event"+e);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                //Nicht zu viele Ausgaben, deshalb auskommentiert
                //System.out.println("Mouse bewegt: "+e.getPoint());
            }
        });
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
