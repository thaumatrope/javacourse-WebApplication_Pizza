/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frontend;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


/**
 *
 * @author John Westfield
 */

public class JGUIDialog extends JDialog {

	private static final long serialVersionUID = 1L;

	public JGUIDialog(JFrame main, String title, String message) {
		super(main, title, Dialog.ModalityType.APPLICATION_MODAL);
		System.out.println("creating the window..");
                
                // Create a message
		JPanel messagePane = new JPanel();
		messagePane.add(new JLabel(message));
		// get content pane, which is usually the
		// Container of all the dialog's components.
		getContentPane().add(messagePane);

		// Create a button
		JPanel buttonPane = new JPanel();
		JButton button = new JButton("Close me");
		buttonPane.add(button);
		// set action listener on the button
		button.addActionListener(new MyActionListener());
		getContentPane().add(buttonPane, BorderLayout.PAGE_END);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
                //pack();
                this.setSize(300, 150);               
                this.setLocationRelativeTo(main);
                
		setVisible(true);
	}

	// override the createRootPane inherited by the JDialog, to create the rootPane.
	// create functionality to close the window when "Escape" button is pressed
	public JRootPane createRootPane() {
		JRootPane rootPane = new JRootPane();
		KeyStroke stroke = KeyStroke.getKeyStroke("ESCAPE");
		Action action = new AbstractAction() {
			
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				System.out.println("escaping..");
				setVisible(false);
				dispose();
			}
		};
		InputMap inputMap = rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		inputMap.put(stroke, "ESCAPE");
		rootPane.getActionMap().put("ESCAPE", action);
		return rootPane;
	}

	// an action listener to be used when an action is performed
	// (e.g. button is pressed)
	class MyActionListener implements ActionListener {

		//close and dispose of the window.
		public void actionPerformed(ActionEvent e) {
			System.out.println("disposing the window..");
			setVisible(false);
			dispose();
		}
	}
        
}
