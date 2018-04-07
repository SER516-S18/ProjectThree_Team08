package main.client.controller;

import main.client.view.*;

/**
 * Client Main
 * @author 
 * @version 1.1
 */
class ClientInitUI {

	/**
	 * Initialize the client GUI
	 */
	public static void initialiseGUI()
	{
		try{
			ClientUILogic clientUILogic = new ClientUILogic();
			ExpressivePanel expressivePanel = new ExpressivePanel();
			ExpressionGraphPanel expressionGraphPanel = new ExpressionGraphPanel();
			MetricGraphPanel metricGraphPanel = new MetricGraphPanel();
			MetricsValuePanel metricsValuePanel = new MetricsValuePanel();
			
			ClientWindow window = new ClientWindow(clientUILogic);
			window.addFacePanel(expressivePanel);
			window.addExpressionGraphPanel(expressionGraphPanel);
			window.addMetricsGraphPanel(metricGraphPanel);
			window.addMetricsValuesPanel(metricsValuePanel);
			window.setVisible(true);
		} catch(Exception exception){
			System.out.println(exception.getMessage());
		}
	}


}