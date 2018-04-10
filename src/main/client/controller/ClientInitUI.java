package main.client.controller;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import main.client.view.*;
import main.model.EmotionMessageBean;

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
			EmotionMessageBean emotionMessageBean = new EmotionMessageBean();
			ClientEndpoint clientEndPoint = new ClientEndpoint(emotionMessageBean);

			ExpressivePanel expressivePanel = new ExpressivePanel(emotionMessageBean);
			ExpressionGraphPanel expressionGraphPanel = new ExpressionGraphPanel();
			MetricGraphPanel metricGraphPanel = new MetricGraphPanel();
			MetricsValuePanel metricsValuePanel = new MetricsValuePanel();
			ServerConnectionPanel serverConnectionPanel = new ServerConnectionPanel();
			

			
			ClientWindowLogic clientWindowLogic = new ClientWindowLogic();
			window.openServer.addActionListener(clientWindowLogic.generateOpenServerActionListener());
			
			ServerConnectionPanelLogic serverConnectionPanelLogic = new ServerConnectionPanelLogic(
					clientEndPoint, emotionMessageBean, serverConnectionPanel.ipAddressTextField, 
					serverConnectionPanel.portTextField, serverConnectionPanel.startStopButton, 
					serverConnectionPanel.timeStampValueLabel);
			serverConnectionPanel.startStopButton.addActionListener(
					serverConnectionPanelLogic.generateStartServerConnectionActionListener());
			
			emotionMessageBean.addObserver(serverConnectionPanelLogic);
			emotionMessageBean.addObserver(expressivePanel);
			
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