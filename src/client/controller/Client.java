package client.controller;

import java.net.URI;
import java.util.Scanner;
import javax.websocket.Session;

import com.google.gson.Gson;
import model.MessageBean;
import org.glassfish.tyrus.client.ClientManager;
import utils.ConnectionConstants;

public class Client {

    public static final String SERVER = "ws://"+ ConnectionConstants.HOSTNAME+":"+ConnectionConstants.PORT+"/"+ConnectionConstants.ROOT_PATH+"/"+ConnectionConstants.ENDPOINT_PATH;
    private static Gson gson = new Gson();
    public static void main(String[] args) throws Exception {
        ClientManager client = ClientManager.createClient();
        String message;

        // connect to server
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to client");
        System.out.println("What's your client name?");
        String user = scanner.nextLine();
        Session session = client.connectToServer(ClientEndpoint.class, new URI(SERVER));
        System.out.println("You are connected to the server as client: " + user);

        // repeatedly read a message and send it to the server (until stop)
        do {
            message = scanner.nextLine();
            session.getBasicRemote().sendText(gson.toJson(new MessageBean(message, user)));
        } while (!message.equalsIgnoreCase("stop"));
    }

}



