package main.client.controller;

import main.client.view.ClientWindow;
import main.client.view.ExpressionGraphPanel;
import main.client.view.ExpressivePanel;
import main.client.view.MetricGraphPanel;
import main.client.view.MetricsValuePanel;
import main.client.view.ServerConnectionPanel;
import main.model.EmotionMessageBean;

/**
 * Client
 * @author Balachandar Sampath, Jason Rice
 * @version 1.0
 */

public class Client {
	
	/**
	 * Client Main
	 * @param args
	 * @throws Exception
	 */
    public static void main(String[] args) throws Exception {
    	try{
			EmotionMessageBean emotionMessageBean = new EmotionMessageBean();
			ClientEndpoint clientEndPoint = new ClientEndpoint(emotionMessageBean);

			ClientWindow window = new ClientWindow();
			ExpressivePanel expressivePanel = new ExpressivePanel(emotionMessageBean);
			ExpressionGraphPanel expressionGraphPanel = new ExpressionGraphPanel(emotionMessageBean);
			MetricGraphPanel metricGraphPanel = new MetricGraphPanel(emotionMessageBean);
			MetricsValuePanel metricsValuePanel = new MetricsValuePanel(metricGraphPanel);
			ServerConnectionPanel serverConnectionPanel = new ServerConnectionPanel();
			
			ClientWindowLogic clientWindowLogic = new ClientWindowLogic(window.openServer);
			ServerConnectionPanelLogic serverConnectionPanelLogic = new ServerConnectionPanelLogic(
					clientEndPoint, emotionMessageBean, serverConnectionPanel.ipAddressTextField, 
					serverConnectionPanel.portTextField, serverConnectionPanel.startStopButton, 
					serverConnectionPanel.timeStampValueLabel);
			
			emotionMessageBean.addObserver(serverConnectionPanelLogic);
			emotionMessageBean.addObserver(expressivePanel);
			emotionMessageBean.addObserver(metricGraphPanel);
			emotionMessageBean.addObserver(expressionGraphPanel);
			
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