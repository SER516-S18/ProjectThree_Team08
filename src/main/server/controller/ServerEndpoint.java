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

    @OnOpen
    public void onOpen(Session session) throws IOException {
        // Get session and WebSocket connection
        EndpointController endpointController = EndpointController.getInstance();
        System.out.println(String.format("%s connected with us", session.getId()));
        clients.add(session);
    }

    @OnMessage
    public void onMessage(EmotionMessageBean message, Session session) throws IOException, EncodeException {
        // Handle new messages
        String user = (String) session.getUserProperties().get("user");
        if (user == null) {
            session.getUserProperties().put("user", message.getSender());
        }
      /*  if ("stop".equalsIgnoreCase(message.getContent())) {
            session.close();
        }*/
        //get the data from
        // can call controller for other future activities as well
        System.out.println(String.format("[%s:%s]", session.getId(),message.toString()));
    }

    @OnClose
    public void onClose(Session session) throws IOException {
        // WebSocket connection closes
        System.out.println(String.format("%s disconnected the connection", session.getId()));
        clients.remove(session);
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        // Do error handling here
    }

}