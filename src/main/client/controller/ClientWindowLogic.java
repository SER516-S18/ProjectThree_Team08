package main.client.controller;

import java.awt.event.*;
import javax.swing.JMenuItem;

/**
 * Client window logic
 * @author Jason Rice
 * @version 1.0
 */
public class ClientWindowLogic {	
	JMenuItem openServer;
	
	/**
	 * get the reference to the 
	 * @param openServer
	 */
	public ClientWindowLogic(JMenuItem openServer){
		openServer.addActionListener(generateOpenServerActionListener());
		this.openServer = openServer;
	}
	
	/**
	 * Handles the OpenServer menu item logic.
	 *
	 */
	public ActionListener generateOpenServerActionListener(){
		return new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event) {
				ServerInstanceSingleton.startServerInstance();
			}
		};
	}
}
