package main.server.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import main.server.controller.UIController;

/**
 * Class for creating controls for interaction panel.
 * @author Akash Sharma, Rhythm Sharma, Aayushi Shah
 * @version 1.0
 */

public class InteractivePanel extends JPanel{
    
	private JComboBox<String> playerComboBox;
	private JCheckBox chckbxAutoReset;
	private JSpinner emoStateSpinner;
	private static JButton btnSend;
	private static int playerValue;
	private boolean isAutoReset = false;
	private static double emoStateTimeInterval;
	private String btnSendValue;
	
	/**
	 * Constructor is adding the interactivePanel to server UI 
	 * */
	public InteractivePanel() {
        
        this.setBackground(Color.GRAY);
        this.setBorder(new TitledBorder(null, "Interactive",
				TitledBorder.LEADING,
                        TitledBorder.TOP, new Font("Tahoma",
				Font.BOLD, 12), null));
        this.setBounds(11, 11, 474, 104);
        this.setLayout(null);
        
        
        String[] playerItems = new String[] {"0", "1", "2"};
        playerComboBox = new JComboBox<>(playerItems);
        playerComboBox.setBounds(85, 30, 55, 25);
        playerComboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox<String> changedObj = (JComboBox<String>) e.getSource();
				setPlayerValue(Integer.valueOf(changedObj.
						getSelectedItem().toString()));
			}
		});
        this.add(playerComboBox);
        
        JLabel playerLabel = new JLabel("Player");
        playerLabel.setForeground(Color.WHITE);
        playerLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        playerLabel.setBounds(14, 29, 55, 25);
        setPlayerValue (0);
        this.add(playerLabel);
        
        JLabel emoStateLabel = new JLabel("<html>EmoState Interval:</html>");
        emoStateLabel.setForeground(Color.WHITE);
        emoStateLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        emoStateLabel.setBounds(175, 29, 124, 25);
        this.add(emoStateLabel);
        
        chckbxAutoReset = new JCheckBox("Auto Reset");
        chckbxAutoReset.setForeground(Color.WHITE);
        chckbxAutoReset.setBackground(Color.GRAY);
        chckbxAutoReset.setFont(new Font("Tahoma", Font.BOLD, 12));
        chckbxAutoReset.setBounds(175, 61, 101, 25);
        chckbxAutoReset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JCheckBox changedObj = (JCheckBox) e.getSource();
				setAutoReset(changedObj.isSelected());
				UIController.updateSendButtonText(changedObj.isSelected());
			}
		});
        this.add(chckbxAutoReset);
        
        btnSend = new JButton("Send");
        btnSend.setForeground(Color.WHITE);
        btnSend.setBackground(Color.BLACK);
        btnSend.setContentAreaFilled(false);
        btnSend.setOpaque(true);
        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            	UIController.setInteractivePanel(getInteractivePanel());
            	UIController.updateDetectionTime(getEmoStateTimeInterval ());
            	UIController.sendMessageBean(btnSend.getText ());
		if(btnSend.getText().toLowerCase().equals("start"))
            		ConsolePanel.setMessage("Data is not being send");
            	else
            		ConsolePanel.setMessage("Data is now being send");
            }
        });
        btnSend.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnSend.setBounds(302, 61, 107, 25);
        this.add(btnSend);
        
        emoStateSpinner = new JSpinner();
        emoStateSpinner.setModel(new SpinnerNumberModel(0.25,
				0.25, 100.00, 0.50));
        emoStateSpinner.setBounds(324, 29, 55, 25);
        setEmoStateTimeInterval(0.25);

        ChangeListener emoStateChangeListener = new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				JSpinner changedObj = (JSpinner) e.getSource();
				setEmoStateTimeInterval(Double.valueOf(changedObj.
						getValue().toString()));
			}
		};
        emoStateSpinner.addChangeListener(emoStateChangeListener);
        this.add(emoStateSpinner);
    }

	/**
	 * Getter Setters for class properties
	 *
	 */
	
	public InteractivePanel getInteractivePanel() {
		return this;
	}

	public static int getPlayerValue() {
		return playerValue;
	}

	public void setPlayerValue(int playerValue) {
		this.playerValue = playerValue;
	}

	public boolean isAutoReset() {
		return isAutoReset;
	}

	public void setAutoReset(boolean isAutoReset) {
		this.isAutoReset = isAutoReset;
	}

	public static double getEmoStateTimeInterval() {
		return emoStateTimeInterval;
	}

	public void setEmoStateTimeInterval(double emoStateTimeInterval) {
		this.emoStateTimeInterval = emoStateTimeInterval;
	}
	
	public void updateSendBtnText(String sendBtnText) {
		this.btnSendValue = sendBtnText;
		btnSend.setText(sendBtnText);
	}

	public String getBtnSendValue() {
		return btnSendValue;
	}
}
