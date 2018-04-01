package main.server.controller;

import main.model.EmotionMessageBean;

import javax.websocket.EncodeException;
import javax.websocket.Session;
import java.io.IOException;

//This class has to be created first when the main.server ui or main.client ui is on and should be the first one to be invoked
public class EndpointController {

    private static EndpointController endpointController = null;

    public static EndpointController getInstance() {
        if(endpointController == null)
        {
            endpointController = new EndpointController();
        }
        return endpointController;
    }
    public void updateExpBlink(boolean blink)
    {
            for (Session client : ServerEndpoint.clients)
            {
                ServerEndpoint.clientMessageMap.get(client.getId()).getExpressive().setBlink(blink);
            }

    }
    public void updateExpRightWink(boolean rightWink)
    {
            for (Session client : ServerEndpoint.clients)
            {
                ServerEndpoint.clientMessageMap.get(client.getId()).getExpressive().setRightWink(rightWink);
            }
    }

    public void updateExpLeftWink(boolean leftWink)
    {
            for (Session client : ServerEndpoint.clients)
            {
                ServerEndpoint.clientMessageMap.get(client.getId()).getExpressive().setLeftWink(leftWink);
            }
    }

    public void updateExpLookingLeft(boolean lookingLeft)
    {
            for (Session client : ServerEndpoint.clients)
            {
                ServerEndpoint.clientMessageMap.get(client.getId()).getExpressive().setLookingLeft(lookingLeft);
            }
    }

    public void updateExpLookingRight(boolean lookingRight)
    {
            for (Session client : ServerEndpoint.clients)
            {
                ServerEndpoint.clientMessageMap.get(client.getId()).getExpressive().setRightWink(lookingRight);
            }
    }

    //This method is invoked to send emotion message to main.client.
    //Prerequiste : First update the message that you want to send and then call this method
    public void sendEmotionMessage()
    {
        for (Session client : ServerEndpoint.clients) {
            // do not resend the message to its sender
            try {
                client.getBasicRemote().sendObject(ServerEndpoint.clientMessageMap.get(client.getId()));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (EncodeException e) {
                e.printStackTrace();
            }
        }
    }
}
