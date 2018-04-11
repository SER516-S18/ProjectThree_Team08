package main.server.view;

import main.server.controller.UIController;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

/**
 * ServerUI represent the main Emotiv JFrame.
 * Consists of 3 panels Interactive, Detection and Console Panel.
 * @author Akash Sharma
 * @version 1.0
 */

public class ServerUI extends JFrame{
    
    public ServerUI() {
        this.setTitle("Server");
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        this.setResizable(true);
        this.setMinimumSize(new Dimension(492,600));
        this.setBounds(100, 100, 492, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout(0, 0));
        
        InteractivePanel intPanel = new InteractivePanel();
        this.getContentPane().add(intPanel, BorderLayout.NORTH);
        UIController.getInstance().setInteractivePanel(intPanel);
        
        DetectionPanel detPanel = new DetectionPanel();
        this.getContentPane().add(detPanel, BorderLayout.CENTER);
        UIController.getInstance().setDetectionPanel(detPanel);
        
        ConsolePanel conPanel = new ConsolePanel();
        this.getContentPane().add(conPanel, BorderLayout.SOUTH);
        UIController.getInstance().setConsolePanel(conPanel);
    }
}
