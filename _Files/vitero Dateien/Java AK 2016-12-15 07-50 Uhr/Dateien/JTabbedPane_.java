/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CardLayout;

import javax.swing.*;


/**
 *
 * @author IBB Teilnehmer
 */
public class JTabbedPane_ extends JFrame{
    
    JPanel firstPanel = new JPanel();
    JPanel secondPanel = new JPanel();
    
    JLabel firstLabel = new JLabel("First!");
    JLabel secondLabel = new JLabel("Second!");
    
    JTabbedPane tabbedPane = new JTabbedPane();
    
    public JTabbedPane_(){
        firstPanel.add(firstLabel);
        secondPanel.add(secondLabel);
        
        tabbedPane.add("First panel", firstPanel);
        tabbedPane.add("Second panel", secondPanel);
        this.add(tabbedPane);
    }
    
}
