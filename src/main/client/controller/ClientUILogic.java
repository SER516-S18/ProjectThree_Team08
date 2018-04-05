package main.client.controller;

import java.awt.event.*;

/**
 * Client GUI logic
 * @author Jason Rice
 * @version 1.0
 */
public class ClientUILogic {
	private ActionListener openServerActionListener;
	private ActionListener startServerActionListener;
	
	public ClientUILogic(){
		initializeOpenServerActionListener();
		initializeStartServerActionListener();
	}
	
	/**
	 * Handles the OpenServer menu item logic.
	 */
	public void initializeOpenServerActionListener(){
		this.openServerActionListener = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event) {
				System.out.println("Open Server action performed.");
			}
		};
	}
	
	/**
	 * Handles the StartServer menu item logic.
	 */
	public void initializeStartServerActionListener(){
		this.startServerActionListener = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event) {
				System.out.println("Start Server Action Performed.");
			}
		};
	}
	
	/**
	 * Get the Open Server Action Listener.
	 * @return ActionListener
	 */
	public ActionListener getOpenServerActionListener(){
		return this.openServerActionListener;
	}
	
	/**
	 * Get the Start Server Action Listener.
	 * @return ActionListener
	 */
	public ActionListener getStartServerActionListener(){
		return this.startServerActionListener;
	}
}
