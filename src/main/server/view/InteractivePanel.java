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

/**
 * Class for creating controls for interaction panel.
 * @author Akash Sharma
 * @version 1.0
 */

public class InteractivePanel extends JPanel{
    
	JComboBox playerComboBox;
	JCheckBox chckbxAutoReset;
	JSpinner emoStateSpinner;
	JButton btnSend;
	
	public InteractivePanel() {
        
        this.setBackground(Color.GRAY);
        this.setBorder(new TitledBorder(null, "Interactive", TitledBorder.LEADING, 
                        TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 12), null));
        this.setBounds(11, 11, 474, 104);
        this.setLayout(null);
        
        
        String[] playerItems = new String[] {"0", "1", "2"};
        playerComboBox = new JComboBox(playerItems);
        playerComboBox.setBounds(85, 30, 55, 25);
        this.add(playerComboBox);
        
        JLabel playerLabel = new JLabel("Player");
        playerLabel.setForeground(Color.WHITE);
        playerLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        playerLabel.setBounds(14, 29, 55, 25);
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
        this.add(chckbxAutoReset);
        
        btnSend = new JButton("Send");
        btnSend.setForeground(Color.WHITE);
        btnSend.setBackground(Color.BLACK);
        btnSend.setContentAreaFilled(false);
        btnSend.setOpaque(true);
        btnSend.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	
            }
        });
        btnSend.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnSend.setBounds(302, 61, 107, 25);
        this.add(btnSend);
        
        emoStateSpinner = new JSpinner();
        emoStateSpinner.setModel(new SpinnerNumberModel(0.25, 0.25, 100.00, 0.50));
        emoStateSpinner.setBounds(324, 29, 55, 25);
        this.add(emoStateSpinner);
    }
}
