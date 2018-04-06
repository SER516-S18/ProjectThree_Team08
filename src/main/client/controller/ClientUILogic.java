package main.client.controller;

import java.awt.event.*;

import javax.swing.JTextField;

/**
 * Client GUI logic
 * @author Jason Rice
 * @version 1.0
 */
public class ClientUILogic {
	public ActionListener openServerActionListener;
	public ActionListener startServerConnectionActionListener;
	
	public ClientUILogic(){}
	
	/**
	 * Handles the OpenServer menu item logic.
	 */
	public void initializeOpenServerActionListener(){
		openServerActionListener = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event) {
				System.out.println("Open Server action performed.");
			}
		};
	}
	
	/**
	 * Handles the Start connection logic.
	 */
	public void initializeStartServerConnectionActionListener(JTextField ip, JTextField port){
		startServerConnectionActionListener = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event) {
				System.out.println("Start Server Action Performed.");
				System.out.println("ip address: " + ip.getText());
				System.out.println("port: " + port.getText());
			}
		};
	}
}
