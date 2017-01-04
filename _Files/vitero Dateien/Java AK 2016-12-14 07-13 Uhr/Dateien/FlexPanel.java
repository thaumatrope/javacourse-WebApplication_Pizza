/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenstermitzeug;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Sanne
 */
public class FlexPanel extends JPanel{
    private JButton componente1=new JButton(" 1 ");
    private JButton componente2=new JButton("2");
    private JButton componente3=new JButton(" 3 ");
    private JButton componente4=new JButton("4");
    private JButton componente5=new JButton(" 5 ");
    private JButton componente6=new JButton("6");
    private JButton componente7=new JButton(" 7 ");
    private JButton componente8=new JButton("8");
    private JButton componente9=new JButton(" 9 ");
    
    public FlexPanel(){
        zeichnen();
    }
    private void zeichnen(){
        this.add(componente1);
        this.add(componente2);
        this.add(componente3);
        this.add(componente4);
        this.add(componente5);
        this.add(componente6);
        this.add(componente7);
        this.add(componente8);
        this.add(componente9);
        
        this.setVisible(false);
    }
    public void neuZeichen(int i){
        this.setVisible(true);
        if(i==1)this.setLayout(new GridLayout(3,3));
        if(i==2){this.setLayout(new FlowLayout());}
    }
}
