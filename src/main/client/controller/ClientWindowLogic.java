package main.client.controller;

import java.awt.event.*;

/**
 * Client window logic
 * @author Jason Rice
 * @version 1.0
 */
public class ClientWindowLogic {	
	
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
