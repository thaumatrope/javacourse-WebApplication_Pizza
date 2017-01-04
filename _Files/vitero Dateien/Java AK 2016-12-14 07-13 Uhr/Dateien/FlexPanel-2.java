/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenstermitzeug;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javafx.scene.control.RadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Sanne
 */
public class FlexPanel extends JPanel{
    //private JButton componente1=new JButton(" 1 ");
    //private JButton componente2=new JButton("2");
    //private JButton componente3=new JButton("   3   ");
    //private JButton componente4=new JButton("4");
    //private JButton componente5=new JButton(" 5 ");
    //private JButton componente6=new JButton("6");
    //private JButton componente7=new JButton(" 7 ");
    private JButton componente8=new JButton("8");
    private JButton componente9=new JButton(" 9 ");
    
    private JSlider componente1=new JSlider(20,80,30);
    private JTextField componente2=new JTextField("Eingaben hier wenn hier mehr");
    private JRadioButton componente3=new JRadioButton("WDR");
    private JRadioButton componente4=new JRadioButton("NDR");
    private JRadioButton componente5=new JRadioButton("SWR");
    private JCheckBox componente6=new JCheckBox("Haekchen hier");
    private JScrollPane componente7;
    
    public FlexPanel(){
        zeichnen();
    }
    private void zeichnen(){
        
        tabErstellen();
        
        componente1.setPaintLabels(true);
        componente1.setPaintTicks(true);
        componente1.setPaintTrack(true);
        componente1.setMinorTickSpacing(2);
        componente1.setMajorTickSpacing(10);
        
        //ButtonGroup nicht graphisch, keine paint(), wird 
        //dem Panel nicht zugefügt
        ButtonGroup sender=new ButtonGroup();
        sender.add(componente3);
        sender.add(componente4);
        sender.add(componente5);
        
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
        if(i==3){
            this.setLayout(new BorderLayout());
            
            this.add(componente7, BorderLayout.CENTER);
            this.add(componente6, BorderLayout.NORTH);
            this.add(componente5, BorderLayout.SOUTH);
            this.add(componente4, BorderLayout.EAST);
            this.add(componente3, BorderLayout.WEST);
            
        }
    }
    private void tabErstellen(){
        String[] ueberschriften={"Ziel","Abflug","Ankuft"};
        String[][] eintraege=new String[5][3];//String[zeilen][Spalten]
        eintraege[0][0]="Berlin";
        eintraege[0][1]="10:00Uhr";
        eintraege[0][2]="11:00Uhr";
        
        eintraege[1][0]="Hamburg";
        eintraege[1][1]="10:00Uhr";
        eintraege[1][2]="11:00Uhr";
        
        eintraege[2][0]="Muenchen";
        eintraege[2][1]="10:00Uhr";
        eintraege[2][2]="11:00Uhr";
        
        eintraege[3][0]="Berlin";
        eintraege[3][1]="10:00Uhr";
        eintraege[3][2]="11:00Uhr";
        
        eintraege[4][0]="Berlin";
        eintraege[4][1]="10:00Uhr";
        eintraege[4][2]="11:00Uhr";
        
        JTable tabelle=new JTable(eintraege, ueberschriften);
        componente7=new JScrollPane(tabelle);
        
    }
}
