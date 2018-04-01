package main.client.controller;

import main.client.view.ClientUI;

class ClientMain {



	public static void initialiseGUI()
	{
		try{
			ClientUI window = new ClientUI();
		} catch(Exception exception){

		}
	}

	public static void main(String[] args){

		initialiseGUI();
	}


}