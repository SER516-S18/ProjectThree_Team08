package main.client.controller;

import java.net.URI;
import java.util.Scanner;
import javax.websocket.Session;

import com.google.gson.Gson;
import main.model.EmotionMessageBean;
import org.glassfish.tyrus.client.ClientManager;
import main.utils.ConnectionConstants;

/**
 * Client
 * @author Jason Rice
 * @version 1.0
 */

public class Client {

    public static final String SERVER = "ws://"+ ConnectionConstants.HOSTNAME+":"+ConnectionConstants.PORT+"/"+ConnectionConstants.ROOT_PATH+"/"+ConnectionConstants.ENDPOINT_PATH;
    private static Gson gson = new Gson();
    public static void main(String[] args) throws Exception {
        ClientManager client = ClientManager.createClient();
        ClientInitUI.initialiseGUI();
        String message;

        // connect to main.server
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to main.client");
        System.out.println("What's your main.client name?");
        String user = scanner.nextLine();
        Session session = client.connectToServer(ClientEndpoint.class, new URI(SERVER));
        System.out.println("You are connected to the main.server as main.client: " + user);

        // repeatedly read a message and send it to the main.server (until stop)
        do {
            message = scanner.nextLine();
            session.getBasicRemote().sendText(gson.toJson(new EmotionMessageBean()));
        } while (!message.equalsIgnoreCase("stop"));
    }

}



