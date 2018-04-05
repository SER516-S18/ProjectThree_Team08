package main.client.controller;

import main.client.view.ClientWindow;
import main.client.view.ExpressivePanel;
import main.client.view.MetricGraphPanel;
import main.client.view.MetricsValuePanel;

/**
 * Client Main
 * @author 
 * @version 1.1
 */
class ClientMain {

	/**
	 * Initialize the client GUI
	 */
	public static void initialiseGUI()
	{
		try{
			ClientUILogic clientUILogic = new ClientUILogic();
			ExpressivePanel expressivePanel = new ExpressivePanel();
			MetricGraphPanel metricGraphPanel = new MetricGraphPanel();
			MetricsValuePanel metricsValuePanel = new MetricsValuePanel();
			
			ClientWindow window = new ClientWindow(clientUILogic);
			window.addFacePanel(expressivePanel);
			window.addMetricsGraphPanel(metricGraphPanel);
			window.addMetricsValuesPanel(metricsValuePanel);
			window.setVisible(true);
		} catch(Exception exception){
			System.out.println(exception.getMessage());
		}
	}

	/**
	 * Main
	 * @param args
	 */
	public static void main(String[] args){
		initialiseGUI();
	}


}