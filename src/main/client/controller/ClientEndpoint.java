package main.client.controller;

import main.model.EmotionMessageBean;
import main.model.MessageDecoder;
import main.model.MessageEncoder;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

/**
 * ClientEndpoint
 * @author
 * @version 1.1
 */
@javax.websocket.ClientEndpoint(encoders = MessageEncoder.class, decoders = MessageDecoder.class)
public class ClientEndpoint {
	EmotionMessageBean emotionMessageBean;
	
	public ClientEndpoint(EmotionMessageBean emotionMessageBean){
		this.emotionMessageBean = emotionMessageBean;
	}
	
    /**
     *
     * @param session
     */
    @OnOpen
    public void onOpen(Session session) {
        System.out.println(String.format("Connection established. session id: %s", session.getId()));
    }

    /**
     * 
     * @param message
     */
    @OnMessage
    public void onMessage(EmotionMessageBean message) {
    	if(message.getAffective() != null){
    		this.emotionMessageBean.setAffective(message.getAffective());
    	}
    	if(message.getExpressive() != null){
    		this.emotionMessageBean.setExpressive(message.getExpressive());
    	}
    	if(emotionMessageBean.getClockTick() != 0.0){
    		emotionMessageBean.setTick(message.getClockTick());
    	}
    	if(emotionMessageBean.hasChanged()){
    		System.out.println("Observers Notified: "+ emotionMessageBean.countObservers());
    		this.emotionMessageBean.notifyObservers();
    	}
        System.out.println("Message received from client"+message);
    }

}
