package client.controller;


import model.MessageBean;
import model.MessageDecoder;
import model.MessageEncoder;

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
    public void onMessage(MessageBean message) {
        System.out.println(String.format("In client From the server:[%s] %s"+message.getSender() + message.getContent()));
    }

}
