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
 * Class for creating controls for detection panel.
 *
 * @author Akash Sharma, Rhythm Sharma
 * @version 1.0
 */


public class DetectionPanel extends JPanel {

    private JTextField timeTxtField;
    private JComboBox<String> upperfaceComboBox;
    private JSpinner upperfaceSpinner;
    private JComboBox<String> lowerfaceComboBox;
    private JComboBox<String> eyeComboBox;
    private JCheckBox chckbxReset;
    private JButton btnActivate;
    private JComboBox<String> performanceMetricsComboBox;
    private JSpinner pfMetricSpinner;
    private String upperfaceSelectedItem;
    private double upperfaceSelectedValue;
    private String lowerfaceSelectedItem;
    private double lowerfaceSelectedValue;
    private String eyeStateSelectedItem;
    private boolean isResetChecked;
    private boolean isActivated;
    private String pfMetricSelectedItem;
    private double pfMetricSelectedValue;
    private double timeTxtFieldVal;

    /**
     * Constructor adding the DetectionPanel to the server UI
     */
    public DetectionPanel() {
        this.setBackground(Color.GRAY);
        this.setBorder(new TitledBorder(null, "Detection",
                TitledBorder.LEADING,
                TitledBorder.TOP, new Font("Tahoma",
                Font.BOLD, 12), null));
        this.setBounds(11, 130, 474, 267);
        this.setLayout(null);

        JLabel lblTime = new JLabel("Time:");
        lblTime.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblTime.setForeground(Color.WHITE);
        lblTime.setBounds(14, 24, 41, 33);
        this.add(lblTime);

        timeTxtField = new JTextField();
        timeTxtField.setForeground(Color.WHITE);
        timeTxtField.setBackground(Color.DARK_GRAY);
        timeTxtField.setEditable(false);
        timeTxtField.setText("0");
        timeTxtField.setBounds(53, 29, 50, 25);
        this.add(timeTxtField);
        timeTxtField.setColumns(10);

        JLabel lblSeconds = new JLabel("Seconds");
        lblSeconds.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblSeconds.setForeground(Color.WHITE);
        lblSeconds.setBounds(113, 24, 64, 33);
        this.add(lblSeconds);

        JLabel lblUpperface = new JLabel("Upperface:");
        lblUpperface.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblUpperface.setForeground(Color.WHITE);
        lblUpperface.setBounds(14, 68, 139, 33);
        this.add(lblUpperface);

        String[] upperfaceItems = new String[]{"Raise Brow", "Furrow Brow",
                "Look Left", "Look Right", "Look Up", "Look Down"};
        upperfaceComboBox = new JComboBox<>(upperfaceItems);
        upperfaceComboBox.setBounds(14, 98, 139, 25);
        setUpperfaceSelectedItem(upperfaceItems[0]);
        upperfaceComboBox.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox<String> changedObj = (JComboBox<String>) e.getSource();
                setUpperfaceSelectedItem(changedObj.getSelectedItem().toString());
                UIController.setDetectionPanel(getDetectionPanel());
            }

        });
        this.add(upperfaceComboBox);

        upperfaceSpinner = new JSpinner();
        upperfaceSpinner.setModel(new SpinnerNumberModel(0.00, 0.00,
                1.00, 0.1));
        upperfaceSpinner.setBackground(Color.WHITE);
        upperfaceSpinner.setBounds(161, 97, 55, 25);
        setUpperfaceSelectedValue(0.00);
        ChangeListener upperfaceSpinnerListener = new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                JSpinner changedObj = (JSpinner) e.getSource();
                setUpperfaceSelectedValue(Double.valueOf(changedObj.getValue().toString()));
                UIController.setDetectionPanel(getDetectionPanel());
            }
        };
        upperfaceSpinner.addChangeListener(upperfaceSpinnerListener);
        this.add(upperfaceSpinner);

        JLabel lblLowerface = new JLabel("Lowerface:");
        lblLowerface.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblLowerface.setForeground(Color.WHITE);
        lblLowerface.setBounds(250, 68, 139, 33);
        this.add(lblLowerface);

        String[] lowerfaceItems = new String[]{"Smile", "Clench"};
        lowerfaceComboBox = new JComboBox<>(lowerfaceItems);
        lowerfaceComboBox.setBounds(250, 98, 123, 25);
        setLowerfaceSelectedItem(lowerfaceItems[0]);
        lowerfaceComboBox.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox<String> changedObj = (JComboBox<String>) e.getSource();
                setLowerfaceSelectedItem(changedObj.getSelectedItem().toString());
                UIController.setDetectionPanel(getDetectionPanel());
            }
        });
        this.add(lowerfaceComboBox);

        JSpinner lowerfaceSpinner = new JSpinner();
        lowerfaceSpinner.setModel(new SpinnerNumberModel(0.00, 0.00,
                1.00, 0.1));
        lowerfaceSpinner.setForeground(Color.WHITE);
        lowerfaceSpinner.setBounds(383, 97, 52, 25);
        setLowerfaceSelectedValue(0.00);
        ChangeListener lowerfaceSpinnerListener = new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                JSpinner changedObj = (JSpinner) e.getSource();
                setLowerfaceSelectedValue(Double.valueOf(changedObj.getValue().toString()));
                UIController.setDetectionPanel(getDetectionPanel());
            }
        };
        lowerfaceSpinner.addChangeListener(lowerfaceSpinnerListener);
        this.add(lowerfaceSpinner);

        JLabel lblEye = new JLabel("Eye:");
        lblEye.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblEye.setForeground(Color.WHITE);
        lblEye.setBounds(14, 134, 115, 33);
        this.add(lblEye);

        String[] eyeItems = new String[]{"Blink", "Wink Left", "Wink Right"};
        eyeComboBox = new JComboBox<>(eyeItems);
        eyeComboBox.setBounds(14, 163, 139, 25);
        setEyeStateSelectedItem(eyeItems[0]);
        eyeComboBox.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox<String> changedObj = (JComboBox<String>) e.getSource();
                setEyeStateSelectedItem(changedObj.getSelectedItem().toString());
                UIController.setDetectionPanel(getDetectionPanel());
            }
        });
        this.add(eyeComboBox);

        btnActivate = new JButton("Activate");
        btnActivate.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnActivate.setContentAreaFilled(false);
        btnActivate.setOpaque(true);
        btnActivate.setBounds(185, 164, 95, 25);
        setActivated(false);
        btnActivate.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (isResetChecked && isActivated) {
                    setActivated(false);
                    btnActivate.setText("Activate");
                    chckbxReset.setEnabled(true);
                } else if (isResetChecked && !isActivated) {
                    setActivated(true);
                    btnActivate.setText("Deactivate");
                    chckbxReset.setEnabled(false);
                } else {
                    setActivated(true);
                }
                UIController.setDetectionPanel(getDetectionPanel());
            }
        });
        this.add(btnActivate);

        chckbxReset = new JCheckBox("Auto Reset");
        chckbxReset.setForeground(Color.WHITE);
        chckbxReset.setFont(new Font("Tahoma", Font.BOLD, 12));
        chckbxReset.setBackground(Color.GRAY);
        chckbxReset.setBounds(294, 164, 95, 25);
        setResetChecked(false);
        chckbxReset.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBox changedObj = (JCheckBox) e.getSource();
                setResetChecked(changedObj.isSelected());
                UIController.setDetectionPanel(getDetectionPanel());
            }
        });
        this.add(chckbxReset);

        JLabel lblPerformanceMetrics = new JLabel("Performance Metrics:");
        lblPerformanceMetrics.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblPerformanceMetrics.setForeground(Color.WHITE);
        lblPerformanceMetrics.setBounds(14, 199, 131, 33);
        this.add(lblPerformanceMetrics);

        String[] pfMetricItems = new String[]{"Interest", "Engagement",
                "Stress", "Excitement", "Relaxation", "Focus"};

        performanceMetricsComboBox = new JComboBox<>(pfMetricItems);
        performanceMetricsComboBox.setBounds(14, 229, 139, 25);
        setPfMetricSelectedItem(pfMetricItems[0]);
        performanceMetricsComboBox.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox<String> changedObj = (JComboBox<String>) e.getSource();
                setPfMetricSelectedItem(changedObj.getSelectedItem().toString());
                UIController.setDetectionPanel(getDetectionPanel());
            }
        });
        this.add(performanceMetricsComboBox);

        pfMetricSpinner = new JSpinner();
        pfMetricSpinner.setModel(new SpinnerNumberModel(0.00, 0.00,
                1.00, 0.1));
        pfMetricSpinner.setBounds(161, 229, 55, 25);
        setPfMetricSelectedValue(0.00);
        ChangeListener pfMetricChangeListener = new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                JSpinner changedObj = (JSpinner) e.getSource();
                setPfMetricSelectedValue(Double.valueOf(changedObj.
                        getValue().toString()));
                UIController.setDetectionPanel(getDetectionPanel());
            }
        };
        pfMetricSpinner.addChangeListener(pfMetricChangeListener);
        this.add(pfMetricSpinner);

    }

    /**
     * Getter/Setters for all the class properties
     */
    public String getUpperfaceSelectedItem() {
        return upperfaceSelectedItem;
    }

    public void setUpperfaceSelectedItem(String upperfaceSelectedItem) {
        this.upperfaceSelectedItem = upperfaceSelectedItem;
    }

    public double getUpperfaceSelectedValue() {
        return upperfaceSelectedValue;
    }

    public void setUpperfaceSelectedValue(double upperfaceSelectedValue) {
        this.upperfaceSelectedValue = upperfaceSelectedValue;
    }

    public String getLowerfaceSelectedItem() {
        return lowerfaceSelectedItem;
    }

    public void setLowerfaceSelectedItem(String lowerfaceSelectedItem) {
        this.lowerfaceSelectedItem = lowerfaceSelectedItem;
    }

    public double getLowerfaceSelectedValue() {
        return lowerfaceSelectedValue;
    }

    public void setLowerfaceSelectedValue(double lowerfaceSelectedValue) {
        this.lowerfaceSelectedValue = lowerfaceSelectedValue;
    }

    public String getEyeStateSelectedItem() {
        return eyeStateSelectedItem;
    }

    public void setEyeStateSelectedItem(String eyeStateSelectedItem) {
        this.eyeStateSelectedItem = eyeStateSelectedItem;
    }

    public boolean isResetChaecked() {
        return isResetChecked;
    }

    public void setResetChecked(boolean isResetChecked) {
        this.isResetChecked = isResetChecked;
    }

    public boolean isActivated() {
        return isActivated;
    }

    public void setActivated(boolean isActivated) {
        this.isActivated = isActivated;
    }

    public String getPfMetricSelectedItem() {
        return pfMetricSelectedItem;
    }

    public void setPfMetricSelectedItem(String pfMetricSelectedItem) {
        this.pfMetricSelectedItem = pfMetricSelectedItem;
    }

    public double getPfMetricSelectedValue() {
        return pfMetricSelectedValue;
    }

    public void setPfMetricSelectedValue(double pfMetricSelectedValue) {
        this.pfMetricSelectedValue = pfMetricSelectedValue;
    }

    public DetectionPanel getDetectionPanel() {
        return this;
    }

    public void setTimeTxtField(double clockTick) {
        this.timeTxtFieldVal = clockTick;
        timeTxtField.setText(Double.toString(this.timeTxtFieldVal));
    }

    public double getTimeTextField() {
        return timeTxtFieldVal;
    }

}
