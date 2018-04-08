package main.client.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import main.model.EmotionMessageBean;

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
		return new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event) {
				if(startStopButton.getText().equals("Start")){
					startStopButton.setText("Stop");
				}else{
					startStopButton.setText("Start");
				}

				System.out.println("ip address: " + ipAddressTextField.getText());
				System.out.println("port: " + portTextField.getText());
			}
		};
	}

	/**
	 * update the fields in the SeverConnectionPanel.
	 */
	@Override
	public void update(Observable observable, Object arg) {
		if(this.emotionMessageBean == observable){
			this.timeStampValueLabel.setText(""+this.emotionMessageBean.getClockTick());
		}
	}
}
