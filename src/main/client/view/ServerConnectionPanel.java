package main.client.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Panel displaying connect/disconnect and the time stamp.
 * @author Jason Rice
 * @version 1.0
 */
public class ServerConnectionPanel extends JPanel{
	private JLabel ipAddressLabel;
	private JLabel portLabel;
	private JLabel timeStampLabel;
	public JLabel timeStampValueLabel;
	public JTextField ipAddressTextField;
	public JTextField portTextField;
	public JButton startStopButton;
	
	/**
	 * Connection panel constructor
	 */
	public ServerConnectionPanel(){
		JPanel outterPanelLeft = new JPanel(new BorderLayout());
		JPanel outterPanelRight = new JPanel(new BorderLayout());
		JPanel innerPanelLeft = new JPanel(new BorderLayout());
		JPanel innerPanelCenter = new JPanel(new BorderLayout());
		
		startStopButton = new JButton("Start");
		ipAddressLabel = new JLabel("IP Address:");
		portLabel = new JLabel("Port:");
		timeStampLabel = new JLabel("Time Step:");
		timeStampValueLabel = new JLabel("0.00");
		ipAddressTextField = new JTextField("localhost");
		portTextField = new JTextField("8025");
		
		innerPanelLeft.add(ipAddressLabel, BorderLayout.WEST);
		innerPanelLeft.add(ipAddressTextField, BorderLayout.CENTER);
		innerPanelLeft.setPreferredSize(new Dimension(200, 50));
		
		innerPanelCenter.add(portLabel, BorderLayout.WEST);
		innerPanelCenter.add(portTextField, BorderLayout.CENTER);
		innerPanelCenter.add(startStopButton, BorderLayout.EAST);
		innerPanelCenter.setPreferredSize(new Dimension(150, 50));
		
		outterPanelRight.add(timeStampLabel, BorderLayout.WEST);
		outterPanelRight.add(timeStampValueLabel, BorderLayout.CENTER);
		outterPanelRight.setPreferredSize(new Dimension(100, 50));
		
		outterPanelLeft.add(innerPanelLeft, BorderLayout.WEST);
		outterPanelLeft.add(innerPanelCenter, BorderLayout.CENTER);
		
		this.setLayout(new BorderLayout());
		this.add(outterPanelLeft, BorderLayout.WEST);
		this.add(outterPanelRight, BorderLayout.EAST);
	}
}
