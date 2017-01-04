/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datenimfenster;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author Sanne
 */
public class Datenfenster extends JFrame implements ActionListener,FocusListener {
    JTextField user=new JTextField("Username");
    JTextField pass=new JTextField("Passwort");
    JButton einloggen=new JButton("Einloggen");
    public Datenfenster(){
        bauen();
    }
    private void bauen(){
        this.setLayout(new GridLayout(3,1));
        user.addFocusListener(this);
        add(user);
        pass.addFocusListener(this);
        add(pass);
        einloggen.addActionListener(this);
        add(einloggen);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocation(200, 200);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            //Aufbau zur Datenbank
            Class.forName("com.mysql.jdbc.Driver");
            String verbindung="jdbc:mysql://localhost:3306/user?zeroDateTimeBehavior=convertToNull";
            Connection conn=DriverManager.getConnection(verbindung, "'root'", "");
            Statement stm=conn.createStatement();
            String sql="select * from pass where User= '"+user.getText()+"'";
            ResultSet rs=stm.executeQuery(sql);
           
            rs.next();
            if(rs.getString(1).equals("Susanne")&&rs.getString(2).equals(pass.getText())){
               
                    System.out.println("Du darfst");
                
            }else System.out.println("Falscher User");
          
           
        } catch (ClassNotFoundException ex) {
            System.out.println("keine solche Klasse");
        } catch (SQLException ex) {
            System.out.println("Keine Verbindung");
        }
        
    }

    @Override
    public void focusGained(FocusEvent e) {
        ((JTextField)e.getSource()).setText("");
    }

    @Override
    public void focusLost(FocusEvent e) {}
    
}
