package server.controller;

import model.MessageBean;
import model.MessageDecoder;
import model.MessageEncoder;
import utils.ConnectionConstants;

import javax.websocket.*;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@javax.websocket.server.ServerEndpoint(value = "/"+ ConnectionConstants.ENDPOINT_PATH, encoders = MessageEncoder.class, decoders = MessageDecoder.class)
public class ServerEndpoint {

    static Set<Session> clients = Collections.synchronizedSet(new HashSet<Session>());

    @OnOpen
    public void onOpen(Session session) throws IOException {
        // Get session and WebSocket connection
        System.out.println(String.format("%s connected with us", session.getId()));
        clients.add(session);
    }

    @OnMessage
    public void onMessage(MessageBean message, Session session) throws IOException, EncodeException {
        // Handle new messages
        String user = (String) session.getUserProperties().get("user");
        if (user == null) {
            session.getUserProperties().put("user", message.getSender());
        }
        if ("stop".equalsIgnoreCase(message.getContent())) {
            session.close();
        }

        System.out.println(String.format("[%s:%s] %s", session.getId(),message.getContent()));

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