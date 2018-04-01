package main.client.controller;


import main.model.EmotionMessageBean;
import main.model.MessageDecoder;
import main.model.MessageEncoder;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

@javax.websocket.ClientEndpoint(encoders = MessageEncoder.class, decoders = MessageDecoder.class)
public class ClientEndpoint {

    @OnOpen
    public void onOpen(Session session) {
        System.out.println(String.format("Connection established. session id: %s", session.getId()));
    }

    @OnMessage
    public void onMessage(EmotionMessageBean message) {
        System.out.println("Message received from client"+message);
    }

}
