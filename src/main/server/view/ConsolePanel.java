package main.server.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;

/**
 * Class for creating controls for console panel.
 * @author Akash Sharma
 * @version 1.0
 */

public class ConsolePanel extends JPanel{
    
    public ConsolePanel() {
        this.setBackground(Color.GRAY);
        this.setBorder(new TitledBorder(null, "EmoEngine Log", TitledBorder.LEADING, 
                        TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 12), Color.BLACK));
        this.setBounds(11, 408, 474, 152);
        this.setLayout(null);
        
        
        JButton btnClearLog = new JButton("Clear Log");
        btnClearLog.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	
            }
        });
        btnClearLog.setBounds(140, 119, 171, 25);
        btnClearLog.setForeground(Color.WHITE);
        btnClearLog.setBackground(Color.BLACK);
        btnClearLog.setContentAreaFilled(false);
        btnClearLog.setOpaque(true);
        this.add(btnClearLog);
        
        JTextPane consoleTextPane = new JTextPane();
        consoleTextPane.setEditable(false);
        consoleTextPane.setForeground(Color.WHITE);
        consoleTextPane.setText("Show Errors Here!");
        consoleTextPane.setBackground(Color.DARK_GRAY);
        consoleTextPane.setBounds(10, 26, 454, 86);
        this.add(consoleTextPane);
    }
}
