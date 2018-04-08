package main.server.controller;

import main.server.view.ServerInitUI;
import main.utils.ConnectionConstants;

import javax.websocket.DeploymentException;

import java.util.Scanner;

public class Server {

    public static void main(String[] args) {

        // Initialise the server
        EndpointController endpointController = EndpointController.getInstance();
        UIController uiController = UIController.getInstance();

        // Initilaise the gui
        ServerInitUI.initializeGUI();


        org.glassfish.tyrus.server.Server server = new
                org.glassfish.tyrus.server.Server(ConnectionConstants.HOSTNAME,
                ConnectionConstants.PORT, "/"+ConnectionConstants.ROOT_PATH, ServerEndpoint.class);
        try {
            server.start();
            System.out.println("Press 1 to sendOnce, \n 2 to sendInIntervals " +
                    "\n 3 to stop \n 4 to exit from server ");
            int input = Integer.parseInt(new Scanner(System.in).nextLine());
            while(input!=4) {
                switch (input)
                {
                    case 1:
                        EndpointController.getInstance().sendOnce();
                        break;
                    case 2:
                        EndpointController.getInstance().sendInIntervals(1.5);
                        break;
                    case 3:
                        EndpointController.getInstance().stop();
                        break;
                }
                System.out.println("Press 1 to sendOnce, \n 2 to sendInIntervals " +
                        "\n 3 to stop \n 4 to exit from server ");
                input = Integer.parseInt(new Scanner(System.in).nextLine());
            }
        } catch (DeploymentException e) {
            throw new RuntimeException(e);
        } finally {
            server.stop();
        }
    }
}
