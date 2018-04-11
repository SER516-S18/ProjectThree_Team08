package main.client.controller;

import main.model.EmotionMessageBean;
import main.utils.ConnectionConstants;
import org.glassfish.tyrus.client.ClientManager;

import javax.swing.*;
import javax.websocket.Session;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.util.Observable;
import java.util.Observer;

/**
 * Server connection panel logic
 *
 * @author Jason Rice
 * @version 1.0
 */
public class ServerConnectionPanelLogic implements Observer {
    JTextField ipAddressTextField;
    JTextField portTextField;
    JButton startStopButton;
    JLabel timeStampValueLabel;
    ClientEndpoint clientEndPoint;
    Session session = null;
    EmotionMessageBean emotionMessageBean;

    /**
     * Constructor sets the references to the fields, end point, and the message bean.
     *
     * @param clientEndPoint
     * @param emotionMessageBean
     * @param ipAddressTextField
     * @param portTextField
     * @param startStopButton
     * @param timeStampValueLabel
     */
    public ServerConnectionPanelLogic(
            ClientEndpoint clientEndPoint,
            EmotionMessageBean emotionMessageBean,
            JTextField ipAddressTextField,
            JTextField portTextField,
            JButton startStopButton,
            JLabel timeStampValueLabel) {

        this.clientEndPoint = clientEndPoint;
        this.ipAddressTextField = ipAddressTextField;
        this.portTextField = portTextField;
        this.timeStampValueLabel = timeStampValueLabel;
        this.emotionMessageBean = emotionMessageBean;
        startStopButton.addActionListener(generateStartServerConnectionActionListener());
        this.startStopButton = startStopButton;
    }

    /**
     * ActionListener for the connection logic.
     */
    public ActionListener generateStartServerConnectionActionListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                try {
                    String sURI = "ws://" + ipAddressTextField.getText() + ":" + portTextField.getText()
                            + "/" + ConnectionConstants.ROOT_PATH + "/" + ConnectionConstants.ENDPOINT_PATH;
                    ClientManager client = ClientManager.createClient();

                    if (startStopButton.getText().equals("Connect")) {
                        startStopButton.setText("Disconnect");
                        session = client.connectToServer(clientEndPoint, new URI(sURI));
                    } else {
                        session.close();
                        startStopButton.setText("Connect");
                    }
                } catch (Exception e) {
                    String message = "Connection could not be established.";
                    JOptionPane.showMessageDialog(
                            timeStampValueLabel.getRootPane(), message,
                            "Connection Error", JOptionPane.ERROR_MESSAGE);
                    startStopButton.setText("Connect");
                }
            }
        };
    }

    /**
     * update the time stamp.
     *
     * @param observable
     * @param arg
     */
    @Override
    public void update(Observable observable, Object arg) {
        if (this.emotionMessageBean == observable) {
            this.timeStampValueLabel.setText("" + this.emotionMessageBean.getClockTick());
        }
    }
}
