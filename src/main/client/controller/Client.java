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
 * @author Balachandar Sampath 
 * @version 1.0
 */

public class Client {

    public static final String SERVER = "ws://"+ ConnectionConstants.HOSTNAME+":"+ConnectionConstants.PORT+"/"+ConnectionConstants.ROOT_PATH+"/"+ConnectionConstants.ENDPOINT_PATH;
    private static Gson gson = new Gson();
    public static void main(String[] args) throws Exception {
        ClientInitUI.initialiseGUI();
       /* String message;
        // repeatedly read a message and send it to the main.server (until stop)
        do {
            message = scanner.nextLine();
            session.getBasicRemote().sendText(gson.toJson(new EmotionMessageBean()));
        } while (!message.equalsIgnoreCase("stop"));*/
    }

}



