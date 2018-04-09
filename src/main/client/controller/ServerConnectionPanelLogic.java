package main.client.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.websocket.Session;

import org.glassfish.tyrus.client.ClientManager;

import main.client.view.ClientWindow;
import main.model.EmotionMessageBean;
import main.utils.ConnectionConstants;

/**
 * Server conection panel logic
 * @author Jason Rice
 * @version 1.0
 */
public class ServerConnectionPanelLogic implements Observer{
	JTextField ipAddressTextField;
	JTextField portTextField;
	JButton startStopButton;
	JLabel timeStampValueLabel;
	ClientEndpoint clientEndPoint;
	Session session = null;
	EmotionMessageBean emotionMessageBean;
	
	/**
	 * Constructor sets the fields that need to be updated and sets the reference to the observable and end point.
	 * @param clientEndPoint
	 * @param emotionMessageBean
	 * @param ipAddressTextField
	 * @param portTextField
	 * @param startStopButton
	 * @param timeStampValueLabel
	 */
	public ServerConnectionPanelLogic(ClientEndpoint clientEndPoint, EmotionMessageBean emotionMessageBean,
			JTextField ipAddressTextField, JTextField portTextField, JButton startStopButton, JLabel timeStampValueLabel){
		this.clientEndPoint = clientEndPoint;
		this.ipAddressTextField = ipAddressTextField;
		this.portTextField = portTextField;
		this.startStopButton = startStopButton;
		this.timeStampValueLabel = timeStampValueLabel;
		this.emotionMessageBean = emotionMessageBean;
	}
	
	/**
	 * Handles the Start connection logic.
	 */
	public ActionListener generateStartServerConnectionActionListener(){
		final String sURI = "ws://"+ this.ipAddressTextField.getText() + ":" + this.portTextField.getText()
							+ "/" + ConnectionConstants.ROOT_PATH + "/" + ConnectionConstants.ENDPOINT_PATH;
		return new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event) {
				try {
					ClientManager client = ClientManager.createClient();
					
					if(startStopButton.getText().equals("Start")){
						startStopButton.setText("Stop");
						session = client.connectToServer(clientEndPoint, new URI(sURI));
						
						if(!session.isOpen()){
							String message = "The Connection was not established.";
							JOptionPane.showMessageDialog(
									timeStampValueLabel.getRootPane(), message, 
									"Connection Status", JOptionPane.WARNING_MESSAGE);
						}
					}else{
						session.close();
						startStopButton.setText("Start");
					}
				}catch(Exception e) {
					String message = "Connection error has ocurred.";
					JOptionPane.showMessageDialog(
							timeStampValueLabel.getRootPane(), message, 
							"Connection Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		};
	}

	/**
	 * update the time stamp.
	 * @param observable
	 * @param arg
	 */
	@Override
	public void update(Observable observable, Object arg) {
		if(this.emotionMessageBean == observable){
			this.timeStampValueLabel.setText(""+this.emotionMessageBean.getClockTick());
		}
	}
}
