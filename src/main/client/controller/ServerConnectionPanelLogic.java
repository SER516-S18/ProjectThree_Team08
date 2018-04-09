package main.client.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.websocket.Session;

import org.glassfish.tyrus.client.ClientManager;

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
	EmotionMessageBean emotionMessageBean;
	Session session = null;
	
	/**
	 * Constructor sets the fields that need to be updated and sets the reference to the observable.
	 * @param emotionMessageBean
	 * @param ipAddressTextField
	 * @param portTextField
	 * @param startStopButton
	 * @param timeStampValueLabel
	 */
	public ServerConnectionPanelLogic(EmotionMessageBean emotionMessageBean,
			JTextField ipAddressTextField, JTextField portTextField, JButton startStopButton, JLabel timeStampValueLabel){
		this.emotionMessageBean = emotionMessageBean;
		this.ipAddressTextField = ipAddressTextField;
		this.portTextField = portTextField;
		this.startStopButton = startStopButton;
		this.timeStampValueLabel = timeStampValueLabel;
		this.emotionMessageBean.addObserver(this);
	}
	
	/**
	 * Constructor sets the fields that need to be updated.
	 * @param ipAddressTextField
	 * @param portTextField
	 * @param startStopButton
	 */
	public ServerConnectionPanelLogic(
			JTextField ipAddressTextField, JTextField portTextField, JButton startStopButton, JLabel timeStampValueLabel){
		this.ipAddressTextField = ipAddressTextField;
		this.portTextField = portTextField;
		this.startStopButton = startStopButton;
		this.timeStampValueLabel = timeStampValueLabel;
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
						session = client.connectToServer(ClientEndpoint.class, new URI(sURI));
					}else{
						session.close();
						startStopButton.setText("Start");
					}
				}catch(Exception e) {
					// set the console if client is not connected
				}
				

				System.out.println("ip address: " + ipAddressTextField.getText());
				System.out.println("port: " + portTextField.getText());
			}
		};
	}

	/**
	 * update the fields in the SeverConnectionPanel.
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
