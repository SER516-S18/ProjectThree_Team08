package main.server.view;

import main.server.controller.UIController;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class for creating controls for interaction panel.
 *
 * @author Akash Sharma, Rhythm Sharma, Aayushi Shah
 * @version 1.0
 */

public class InteractivePanel extends JPanel {

    private static JButton btnSend;
    private static int playerValue;
    private static double emoStateTimeInterval;
    private JComboBox<String> playerComboBox;
    private JCheckBox chckbxAutoReset;
    private JSpinner emoStateSpinner;
    private boolean isAutoReset = false;
    private String btnSendValue;

    /**
     * Constructor is adding the interactivePanel to server UI
     */
    public InteractivePanel() {

        this.setBackground(Color.GRAY);
        this.setBorder(new TitledBorder(null, "Interactive",
                TitledBorder.LEADING,
                TitledBorder.TOP, new Font("Tahoma",
                Font.BOLD, 12), null));
        this.setLayout(null);
        this.setPreferredSize(new Dimension(200, 120));

        JLabel emoStateLabel = new JLabel("<html>EmoState Interval:</html>");
        emoStateLabel.setForeground(Color.WHITE);
        emoStateLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        emoStateLabel.setBounds(14, 29, 124, 25);
        this.add(emoStateLabel);

        chckbxAutoReset = new JCheckBox("Auto Reset");
        chckbxAutoReset.setForeground(Color.WHITE);
        chckbxAutoReset.setBackground(Color.GRAY);
        chckbxAutoReset.setFont(new Font("Tahoma", Font.BOLD, 12));
        chckbxAutoReset.setBounds(10, 61, 101, 25);
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
        btnSend.setContentAreaFilled(false);
        btnSend.setOpaque(true);
        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                UIController.setInteractivePanel(getInteractivePanel());
                UIController.updateDetectionTime(getEmoStateTimeInterval());
                UIController.sendMessageBean(btnSend.getText());
                if (btnSend.getText().toLowerCase().equals("start"))
                    ConsolePanel.setMessage("Data transmission ended.");
                else if (isAutoReset)
                    ConsolePanel.setMessage("Data transmission started.");
                else
                    ConsolePanel.setMessage("Data transmitted.");
            }
        });
        btnSend.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnSend.setBounds(121, 61, 107, 25);
        this.add(btnSend);

        emoStateSpinner = new JSpinner();
        emoStateSpinner.setModel(new SpinnerNumberModel(0.25,
                0.25, 100.00, 0.50));
        emoStateSpinner.setBounds(173, 29, 55, 25);
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

    public static int getPlayerValue() {
        return playerValue;
    }

    public void setPlayerValue(int playerValue) {
        this.playerValue = playerValue;
    }

    public static double getEmoStateTimeInterval() {
        return emoStateTimeInterval;
    }

    public void setEmoStateTimeInterval(double emoStateTimeInterval) {
        this.emoStateTimeInterval = emoStateTimeInterval;
    }

    /**
     * Getter Setters for class properties
     */

    public InteractivePanel getInteractivePanel() {
        return this;
    }

    public boolean isAutoReset() {
        return isAutoReset;
    }

    public void setAutoReset(boolean isAutoReset) {
        this.isAutoReset = isAutoReset;
    }

    public void updateSendBtnText(String sendBtnText) {
        this.btnSendValue = sendBtnText;
        btnSend.setText(sendBtnText);
    }

    public String getBtnSendValue() {
        return btnSendValue;
    }
}
