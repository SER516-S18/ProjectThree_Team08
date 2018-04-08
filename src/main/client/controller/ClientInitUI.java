package main.client.controller;

import main.client.view.*;

/**
 * Client Main
 * @author Jason Rice
 * @version 1.1
 */
class ClientInitUI {

	/**
	 * Initialize the client GUI
	 */
	public static void initialiseGUI()
	{
		try{
			ClientWindow window = new ClientWindow();
			ExpressivePanel expressivePanel = new ExpressivePanel();
			ExpressionGraphPanel expressionGraphPanel = new ExpressionGraphPanel();
			MetricGraphPanel metricGraphPanel = new MetricGraphPanel();
			MetricsValuePanel metricsValuePanel = new MetricsValuePanel();
			ServerConnectionPanel serverConnectionPanel = new ServerConnectionPanel();
			
			ClientWindowLogic clientWindowLogic = new ClientWindowLogic();
			window.openServer.addActionListener(clientWindowLogic.generateOpenServerActionListener());
			
			ServerConnectionPanelLogic serverConnectionPanelLogic = new ServerConnectionPanelLogic(
					serverConnectionPanel.ipAddressTextField, serverConnectionPanel.portTextField, 
					serverConnectionPanel.startStopButton, serverConnectionPanel.timeStampValueLabel);
			
			serverConnectionPanel.startStopButton.addActionListener(
					serverConnectionPanelLogic.generateStartServerConnectionActionListener());
			
			window.addFacePanel(expressivePanel);
			window.addExpressionGraphPanel(expressionGraphPanel);
			window.addMetricsGraphPanel(metricGraphPanel);
			window.addMetricsValuesPanel(metricsValuePanel);
			window.addServerConnectionPanel(serverConnectionPanel);
			window.pack();
			window.setVisible(true);
		} catch(Exception exception){
			System.out.println(exception.getMessage());
		}
	}


}