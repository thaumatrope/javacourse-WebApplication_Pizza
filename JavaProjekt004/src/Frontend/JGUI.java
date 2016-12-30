/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frontend;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author John Westfield
 */
public abstract class JGUI extends JFrame implements ActionListener, ChangeListener, ListSelectionListener, DocumentListener  {

    
    protected JMenuBar jMenuBar = new JMenuBar();;
    protected Toolkit tk = Toolkit.getDefaultToolkit();
    
    protected void setMiddlePosition(){
        
      
        Dimension dim = tk.getScreenSize();
        
        int posx = (dim.width / 2) - (this.getWidth() / 2);
        int posyx = (dim.height / 2) - (this.getHeight() / 2);
        
        this.setLocation(posx, posyx);        
        
    }
    
    protected void init_Menu(){        
        
        this.setVisible(true);
    }
    
}
