package main.server.view;

import java.awt.EventQueue;

/**
 * Server main to initialize Server GUI.
 * @author Akash Sharma
 * @version 1.0
 */

public class ServerMain {

    public static void initializeGUI() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ServerUI window = new ServerUI();
                    window.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
    
    public static void main(String[] args) {
        initializeGUI();
    }
}
