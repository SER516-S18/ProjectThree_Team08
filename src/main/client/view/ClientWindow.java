package main.client.view;

import java.awt.*;
import javax.swing.*;
import main.client.controller.ClientWindowLogic;

/**
 * Graphical User Interface (GUI) for the client window.
 * @author Jason Rice
 * @version 1.2
 */
public class ClientWindow extends JFrame{
	private JMenuBar menuBar;
	private JTabbedPane clientTabbedPane;
	private JPanel clientPanel;
	private JPanel metricsValuesPanelArea;
	private JPanel metricsGraphPanelArea;
	private JPanel metricsTab;
	private JPanel facePanelArea;
	private JPanel expressionGraphPanelArea;
	private JPanel expressionsTab;
	private JPanel serverConnectionPanel;
	public JMenuItem openServer;
	
	/**
	 * Create the Client Window.
	 */
	public ClientWindow(){
		this.setTitle("Group8 Lab3 Client");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(200,200);
		this.setBackground(Color.LIGHT_GRAY);
		this.setMinimumSize(new Dimension(1250, 720));
		
		this.clientPanel = new JPanel(new BorderLayout());
		this.clientPanel.setBackground(Color.LIGHT_GRAY);
		this.add(this.clientPanel);
		
		initializeMenuBar();
		initializeServerConnectionPanel();
		initializeTabbedPane();
	}

	/**
	 * Initialize the tabbed pane and configure the layout.
	 */
	public void initializeTabbedPane(){
		JPanel metricsValuesPanelArea = new JPanel(new BorderLayout());
		metricsValuesPanelArea.setPreferredSize(new Dimension(400, 550));
		metricsValuesPanelArea.setBorder(BorderFactory.createTitledBorder("Affective Values"));
		metricsValuesPanelArea.setBackground(Color.GRAY);
		
		JPanel metricsGraphPanelArea = new JPanel(new BorderLayout());
		metricsGraphPanelArea.setPreferredSize(new Dimension(800, 550));
		metricsGraphPanelArea.setBorder(BorderFactory.createTitledBorder("Affective Plot"));
		metricsGraphPanelArea.setBackground(Color.GRAY);
		
		JPanel metricsTab = new JPanel(new BorderLayout());
		metricsTab.setOpaque(false);
		
		JPanel facePanelArea = new JPanel(new BorderLayout());
		facePanelArea.setPreferredSize(new Dimension(500, 550));
		facePanelArea.setBorder(BorderFactory.createTitledBorder("Expression Avatar"));
		facePanelArea.setBackground(Color.GRAY);
		
		JPanel expressionGraphPanelArea = new JPanel(new BorderLayout());
		expressionGraphPanelArea.setPreferredSize(new Dimension(700, 550));
		expressionGraphPanelArea.setBorder(BorderFactory.createTitledBorder("Expression Plot"));
		expressionGraphPanelArea.setBackground(Color.GRAY);
	
		JPanel expressionsTab = new JPanel(new BorderLayout());
		expressionsTab.setOpaque(false);
		
		JTabbedPane clientTabbedPane = new JTabbedPane();
		clientTabbedPane.setOpaque(true);
		clientTabbedPane.setBackground(Color.LIGHT_GRAY);
	
		this.metricsValuesPanelArea = metricsValuesPanelArea;
		this.metricsGraphPanelArea = metricsGraphPanelArea;
		this.facePanelArea = facePanelArea;
		this.expressionGraphPanelArea = expressionGraphPanelArea;
		this.metricsTab = metricsTab;
		this.expressionsTab = expressionsTab;
		this.clientTabbedPane = clientTabbedPane;
		
		expressionsTab.add(this.facePanelArea, BorderLayout.WEST);
		expressionsTab.add(this.expressionGraphPanelArea, BorderLayout.CENTER);
		metricsTab.add(this.metricsValuesPanelArea, BorderLayout.WEST);
		metricsTab.add(this.metricsGraphPanelArea, BorderLayout.CENTER);
		clientTabbedPane.addTab("Expressions", this.expressionsTab);
		clientTabbedPane.addTab("Metrics", this.metricsTab);
		this.clientPanel.add(this.clientTabbedPane, BorderLayout.CENTER);
	}
	
	/**
	 * Sets the menu bar of the client.
	 *
	 */
	public void initializeMenuBar(){
		JMenu menu = new JMenu("Menu");
		
		JMenuItem openServer = new JMenuItem("Open Server");
		this.openServer = openServer;
		menu.add(this.openServer);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(menu);
		this.menuBar = menuBar;
		
		this.setJMenuBar(this.menuBar);
	}
	
	/**
	 * Sets the Servers Connection panel area.
	 */
	public void initializeServerConnectionPanel(){
		JPanel serverConnectionPanel = new JPanel(new BorderLayout());
		serverConnectionPanel.setBackground(Color.GRAY);
		serverConnectionPanel.setBorder(BorderFactory.createTitledBorder("Server Connection"));
		serverConnectionPanel.setPreferredSize(new Dimension(500, 60));
		
		this.serverConnectionPanel = serverConnectionPanel;
		this.clientPanel.add(this.serverConnectionPanel, BorderLayout.NORTH);
	}
	
	/**
	 * Add the metrics value panel to client.
	 * @param panel
	 */
	public void addMetricsValuesPanel(JPanel panel){

		this.metricsValuesPanelArea.add(panel, BorderLayout.CENTER);
	}
	
	/**
	 * Add the metrics graph panel to the client.
	 * @param panel
	 */
	public void addMetricsGraphPanel(JPanel panel){

		this.metricsGraphPanelArea.add(panel, BorderLayout.CENTER);
	}
	
	/**
	 * Add the face panel to the client.
	 * @param panel
	 */
	public void addFacePanel(JPanel panel){

		this.facePanelArea.add(panel, BorderLayout.CENTER);
	}
	
	/**
	 * Add the expressions graph panel to the client.
	 * @param panel
	 */
	public void addExpressionGraphPanel(JPanel panel){

		this.expressionGraphPanelArea.add(panel, BorderLayout.CENTER);
	}
	
	/**
	 * Add the Server Connection Panel to the client.
	 * @param panel
	 */
	public void addServerConnectionPanel(JPanel panel){

		this.serverConnectionPanel.add(panel, BorderLayout.CENTER);
	}
}