package Client.controller;

import java.net.URI;
import java.util.Scanner;
import javax.websocket.Session;

import utils.JsonUtil;
import org.glassfish.tyrus.client.ClientManager;

public class Client {

    public static final String SERVER = "ws://localhost:8025/ws/connect";

    public static void main(String[] args) throws Exception {
        ClientManager client = ClientManager.createClient();
        String message;

        // connect to server
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Client");
        System.out.println("What's your client name?");
        String user = scanner.nextLine();
        Session session = client.connectToServer(ClientEndpoint.class, new URI(SERVER));
        System.out.println("You are connected to the server as client: " + user);

        // repeatedly read a message and send it to the server (until quit)
        do {
            message = scanner.nextLine();
            session.getBasicRemote().sendText(JsonUtil.formatMessage(message, user));
        } while (!message.equalsIgnoreCase("quit"));
    }

}
