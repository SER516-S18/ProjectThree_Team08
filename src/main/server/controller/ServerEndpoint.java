package main.server.controller;

import main.model.EmotionMessageBean;
import main.model.MessageDecoder;
import main.model.MessageEncoder;
import main.utils.ConnectionConstants;

import javax.websocket.*;

import java.io.IOException;
import java.util.*;

/**
 * Web Socket Endpoint which handles the various lifecycle of connections with client.
 * @author Balachandar Sampath
 * @version 1.0
 */
@javax.websocket.server.ServerEndpoint(value = "/"+ ConnectionConstants.ENDPOINT_PATH, encoders = MessageEncoder.class, decoders = MessageDecoder.class)
public class ServerEndpoint {

    public static Set<Session> clients = Collections.synchronizedSet(new HashSet<Session>());

    /**
     * This method is called when connection opens
     * @param session This is the first parameter to onOpen method and holds client session
     */
    @OnOpen
    public void onOpen(Session session) throws IOException {
        // Get session and WebSocket connection
        EndpointController endpointController = EndpointController.getInstance();
        System.out.println(String.format("%s connected with us", session.getId()));
        clients.add(session);
    }

    /**
     * This method is called when connection opens
     * @param message This is the first parameter to onMessage method and holds the message object received
     * @param session This is the second parameter to onMessage method and holds client session
     */
    @OnMessage
    public void onMessage(EmotionMessageBean message, Session session) throws IOException, EncodeException {
        // Handle new messages
        String user = (String) session.getUserProperties().get("user");
        if (user == null) {
            session.getUserProperties().put("user", message.getSender());
        }
        System.out.println(String.format("[%s:%s]", session.getId(),message.toString()));
    }
    /**
     * This method is called when connection closes
     * @param session This is the first parameter to onClose method and holds client session
     */
    @OnClose
    public void onClose(Session session) throws IOException {
        // WebSocket connection closes
        System.out.println(String.format("%s disconnected the connection", session.getId()));
        clients.remove(session);
    }
    /**
     * This method is called when there is connection error
     * @param session This is the first parameter to onError method and holds client session
     * @param throwable
     */
    @OnError
    public void onError(Session session, Throwable throwable) {
        // Do error handling here
    }

}