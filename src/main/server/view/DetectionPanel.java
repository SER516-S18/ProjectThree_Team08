package main.server.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.TitledBorder;

/**
 * Class for creating controls for detection panel.
 * @author Akash Sharma
 * @version 1.0
 */


public class DetectionPanel extends JPanel{
    
    public DetectionPanel() {
        this.setBackground(Color.GRAY);
        this.setBorder(new TitledBorder(null, "Detection", TitledBorder.LEADING, 
                        TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 12), null));
        this.setBounds(11, 130, 474, 267);
        this.setLayout(null);
        
        JLabel lblTime = new JLabel("Time:");
        lblTime.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblTime.setForeground(Color.WHITE);
        lblTime.setBounds(14, 24, 41, 33);
        this.add(lblTime);
        
        JTextField timeTxtField = new JTextField();
        timeTxtField.setForeground(Color.WHITE);
        timeTxtField.setBackground(Color.DARK_GRAY);
        timeTxtField.setEditable(false);
        timeTxtField.setText("29.25");
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
        
        String[] upperfaceItems = new String[] {"Raise Brow", "Furrow Brow"};
        JComboBox upperfaceComboBox = new JComboBox(upperfaceItems);
        upperfaceComboBox.setBounds(14, 98, 139, 25);
        this.add(upperfaceComboBox);
        
        JSpinner upperfaceSpinner = new JSpinner();
        upperfaceSpinner.setModel(new SpinnerNumberModel(0.00, 0.00, 1.00, 0.1));
        upperfaceSpinner.setBackground(Color.WHITE);
        upperfaceSpinner.setBounds(161, 97, 55, 25);
        this.add(upperfaceSpinner);
        
        JLabel lblLowerface = new JLabel("Lowerface:");
        lblLowerface.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblLowerface.setForeground(Color.WHITE);
        lblLowerface.setBounds(250, 68, 139, 33);
        this.add(lblLowerface);
        
        String[] lowerfaceItems = new String[] {"Smile", "Clench","Smirk Left",
                                                "Smirk Right","Laugh"};
        JComboBox lowerfaceComboBox = new JComboBox(lowerfaceItems);
        lowerfaceComboBox.setBounds(250, 98, 123, 25);
        this.add(lowerfaceComboBox);
        
        JLabel lblEye = new JLabel("Eye:");
        lblEye.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblEye.setForeground(Color.WHITE);
        lblEye.setBounds(14, 134, 115, 33);
        this.add(lblEye);
        
        JSpinner lowerfaceSpinner = new JSpinner();
        lowerfaceSpinner.setModel(new SpinnerNumberModel(0.00, 0.00, 1.00, 0.1));
        lowerfaceSpinner.setForeground(Color.WHITE);
        lowerfaceSpinner.setBounds(383, 97, 52, 25);
        this.add(lowerfaceSpinner);
        
        String[] eyeItems = new String[] {"Blink", "Wink Left", 
                                            "Wink Right","Look Left","Look Right"};
        JComboBox eyeComboBox = new JComboBox(eyeItems);
        eyeComboBox.setBounds(14, 163, 139, 25);
        this.add(eyeComboBox);
        
        JCheckBox chckbxAcitvate = new JCheckBox("Auto Reset");
        chckbxAcitvate.setForeground(Color.WHITE);
        chckbxAcitvate.setFont(new Font("Tahoma", Font.BOLD, 12));
        chckbxAcitvate.setBackground(Color.GRAY);
        chckbxAcitvate.setBounds(294, 164, 95, 25);
        this.add(chckbxAcitvate);
        
        JLabel lblPerformanceMetrics = new JLabel("Performance Metrics:");
        lblPerformanceMetrics.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblPerformanceMetrics.setForeground(Color.WHITE);
        lblPerformanceMetrics.setBounds(14, 199, 131, 33);
        this.add(lblPerformanceMetrics);
        
        String[] pfMetricItems = new String[] {"Meditation", "EngagementBoredom", 
                                                "ExcitementShortTerm","Frustration","ExcitementLongTerm"};
        JComboBox performanceMetricsComboBox = new JComboBox(pfMetricItems);
        performanceMetricsComboBox.setBounds(14, 229, 139, 25);
        this.add(performanceMetricsComboBox);
        
        JSpinner pfMetricSpinner = new JSpinner();
        pfMetricSpinner.setModel(new SpinnerNumberModel(0.00, 0.00, 1.00, 0.1));
        pfMetricSpinner.setBounds(161, 229, 55, 25);
        this.add(pfMetricSpinner);
        
        JCheckBox chckbxActivate = new JCheckBox("Activate");
        chckbxActivate.setFont(new Font("Tahoma", Font.BOLD, 12));
        chckbxActivate.setBackground(Color.GRAY);
        chckbxActivate.setForeground(Color.WHITE);
        chckbxActivate.setBounds(185, 164, 95, 25);
        this.add(chckbxActivate);
    }
}
