/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenster;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author John Westfield
 */
public class Fenster1 extends JFrame implements ActionListener{
    
    private JPanel meinPanel = new JPanel();
    private JButton meinKnopf1 = new JButton();
    private JButton meinKnopf2 = new JButton();
    private JButton meinKnopf3 = new JButton();
    private JTextField meinTextfeld = new JTextField("Type here");
    private JTextArea meinTextBereich = new JTextArea(10, 40);
    private JScrollPane scrollbar = new JScrollPane(meinTextBereich, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    
    
    public Fenster1(){
        
        aufbauen();
    }    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void aufbauen(){
        
        this.setSize(400, 300);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        
        int posx = (dim.width / 2) - (this.getWidth() / 2);
        int posyx = (dim.height / 2) - (this.getHeight() / 2);
        
        this.setLocation(posx, posyx);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //meinKnopf2.setBorderPainted(false);
        //meinKnopf2.setContentAreaFilled(false);
        
        meinKnopf2.setToolTipText("Helloo!");
                
        this.setLocationRelativeTo(null);
        meinPanel.add(meinKnopf1);
        meinPanel.add(meinKnopf2);
        meinPanel.add(meinKnopf3);
        
        meinTextfeld.setColumns(30);
        meinTextfeld.setText("DO Type here");
        
        meinPanel.add(meinTextfeld);
        
        meinTextBereich.setText("Typosssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss");
        meinTextBereich.setLineWrap(true);
        
        meinPanel.add(meinTextBereich);
        meinPanel.add(scrollbar);
        meinTextBereich.setWrapStyleWord(true);
                
        meinKnopf1.addActionListener(this);
        meinKnopf2.addActionListener(this);
        meinKnopf3.addActionListener(this);
        
        this.add(meinPanel);
        
        this.setTitle("JFrame for Beginner's");
        
         
    }
    
}   
