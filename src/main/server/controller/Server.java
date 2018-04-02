package main.server.controller;

import main.server.view.ServerMain;
import main.utils.ConnectionConstants;

import javax.websocket.DeploymentException;

import java.util.Scanner;

public class Server {

    public static void main(String[] args) {

        // Initilaise the gui
        ServerMain serverMain = new ServerMain();
        serverMain.initializeGUI();

        // Initialise the server
        EndpointController endpointController = EndpointController.getInstance();
        UIController uiController = UIController.getInstance();
        org.glassfish.tyrus.server.Server server = new org.glassfish.tyrus.server.Server(ConnectionConstants.HOSTNAME, ConnectionConstants.PORT, "/"+ConnectionConstants.ROOT_PATH, ServerEndpoint.class);
        try {
            server.start();
            System.out.println("Press any key to stop the main.server..");
            new Scanner(System.in).nextLine();
        } catch (DeploymentException e) {
            throw new RuntimeException(e);
        } finally {
            server.stop();
        }
    }
}
