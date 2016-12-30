/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_aufbaukurs_005;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;

/**
 *
 * @author John Westfield
 */
public final class FensterFlex extends JPanel{
    
    private JButton componente1 = new JButton(" 1 ");
    private JButton componente2 = new JButton(" 2 ");
    private JButton componente3 = new JButton(" 3 ");
    private JButton componente4 = new JButton(" 4 ");
    private JButton componente5 = new JButton(" 5 ");
    private JButton componente6 = new JButton(" 6 ");
    private JButton componente7 = new JButton(" 7 ");
    private JButton componente8 = new JButton(" 8 ");
    private JButton componente9 = new JButton(" 9 ");
    
    private JSlider componente10 = new JSlider(20,80,30);
    
    public FensterFlex(){
        
    }    
    
    private void zeichnen(int mode){      
        
        if ((mode == 1) || (mode == 2)){ 
            
            LayoutManager myLM;
            
            componente10.setPaintLabels(true);
            componente10.setPaintTicks(true);
            componente10.setPaintTrack(true);
            componente10.setMinorTickSpacing(2);
            componente10.setMajorTickSpacing(10);

            this.add(componente1);
            this.add(componente2);
            this.add(componente3);
            this.add(componente4);
            this.add(componente5);
            this.add(componente6);
            this.add(componente7);
            this.add(componente8);
            this.add(componente9);

            this.add(componente10);      
            
        }else if (mode == 3){        
                      
            this.add(componente10, BorderLayout.CENTER);
            this.add(componente2, BorderLayout.NORTH);
            this.add(componente3, BorderLayout.SOUTH);
            this.add(componente4, BorderLayout.EAST);
            //this.add(componente5, BorderLayout.WEST);
            //this.add(componente6, BorderLayout.WEST);
            //this.add(componente7, BorderLayout.WEST);
            //this.add(componente8, BorderLayout.WEST);
            this.add(componente9, BorderLayout.WEST);
                        
        }
               
        
        
//        myJFrame.getContentPane().removeAll()
//        myJFrame.getContentPane().invalidate()
//
//        myJFrame.getContentPane().add(newContentPanel)
//        myJFrame.getContentPane().revalidate()
        
    }
    
    public void neuZeichnen(int mode){
        
        this.removeAll();
        
        switch (mode) {
            case 1:
                this.setLayout(new GridLayout(3,3));
                System.out.println("GridLayout");
                this.zeichnen(mode);
                break;
            case 2:
                this.setLayout(new FlowLayout());
                System.out.println("FlowLayout");
                this.zeichnen(mode);
                break;
            case 3:
                this.setLayout(new BorderLayout());       
                System.out.println("BorderLayout");
                this.zeichnen(mode);
                break;
            default:
                break;
        }
//      this.setVisible(false); 
//      this.setVisible(true);
        this.validate();
               
    }
    
}
