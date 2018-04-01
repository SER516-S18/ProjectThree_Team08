package main.client.view;

import java.awt.*;
import javax.swing.*;

/**
 * Graphical User Interface (GUI) of the client.
 * @author Jason Rice
 * @version 1.0
 */
public class ClientUI extends JFrame{
	private JPanel clientPanel;
	private JTabbedPane clientTabs;
	private JMenuBar clientMenu;
	
	public ClientUI(){
		initializeMenuBar();
		initializeClientTabs();
		
		this.setTitle("Client");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setJMenuBar(this.clientMenu);
		this.clientPanel = new JPanel();
		this.clientPanel.add(this.clientTabs);
		this.add(this.clientPanel);
		this.pack();
		this.setLocation(200,200);
		this.setMinimumSize(new Dimension(1250, 650));
		this.setVisible(true);
	}
	
	/**
	* Initializes and populates the tab pane.
	*/
	private void initializeClientTabs(){
		Color borderColor = Color.darkGray;
		
		JTabbedPane clientTabs = new JTabbedPane();

		JPanel metricsValuesPanel = new JPanel();
		metricsValuesPanel.setPreferredSize(new Dimension(400, 550));
		metricsValuesPanel.setBorder(BorderFactory.createLineBorder(borderColor));
		
		JPanel metricGraphPanel = new JPanel();
		metricGraphPanel.setPreferredSize(new Dimension(800, 550));
		metricGraphPanel.setBorder(BorderFactory.createLineBorder(borderColor));
		
		JPanel metricsTab = new JPanel(new BorderLayout());
		metricsTab.add(metricsValuesPanel, BorderLayout.WEST);
		metricsTab.add(metricGraphPanel, BorderLayout.EAST);
		
		JPanel facePanel = new JPanel();
		facePanel.setPreferredSize(new Dimension(500, 550));
		facePanel.setBorder(BorderFactory.createLineBorder(borderColor));
		
		JPanel expressionGraphPanel = new JPanel();
		expressionGraphPanel.setPreferredSize(new Dimension(700, 550));
		expressionGraphPanel.setBorder(BorderFactory.createLineBorder(borderColor));
		
		JPanel expressionsTab = new JPanel(new BorderLayout());
		expressionsTab.add(facePanel, BorderLayout.WEST);
		expressionsTab.add(expressionGraphPanel, BorderLayout.EAST);
		
		clientTabs.addTab("Expressions", expressionsTab);
		clientTabs.addTab("Metrics", metricsTab);
		this.clientTabs = clientTabs;
	}
	
	/**
	* Initializes the menu bar.
	*/
	private void initializeMenuBar(){
		JMenuBar clientMenu = new JMenuBar();
		JMenu menu = new JMenu("Menu");
		JMenuItem openServer = new JMenuItem("Open Server");
		JMenuItem startConnection = new JMenuItem("Start Connection");
		menu.add(openServer);
		menu.add(startConnection);
		clientMenu.add(menu);
		this.clientMenu = clientMenu;
	}
}
