package main.server.controller;

import main.model.EmotionMessageBean;
import javax.websocket.EncodeException;
import javax.websocket.Session;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;


/**
 * Controller which acts as a interface between server and UIController.
 * This class has to be created first when the main.server ui or main.client ui is on and should be the first one to be invoked
 * @author Balachandar Sampath
 * @version 1.0
 */
public class EndpointController {

    private static EmotionMessageBean emotionMessageBean = null;
    private Timer timer = new Timer("Timer");

    private EndpointController() { }

    //This will support lazy initialisation of endpointController
    private static class SingletonHolder {
        public static final EndpointController endpointController = new EndpointController();
    }

    /**
     * Returns an instance of the class
     *
     * @return EndpointController
     */
    public static EndpointController getInstance()
    {
        return SingletonHolder.endpointController;
    }


    public void updateExpBlink(boolean blink)
    {
            for (Session client : ServerEndpoint.clients)
            {
                EndpointController.getInstance().emotionMessageBean.getExpressive().setBlink(blink);
            }
    }

    public void updateExpRightWink(boolean rightWink)
    {
            for (Session client : ServerEndpoint.clients)
            {
                EndpointController.getInstance().emotionMessageBean.getExpressive().setRightWink(rightWink);
            }
    }

    public void updateExpLeftWink(boolean leftWink)
    {
            for (Session client : ServerEndpoint.clients)
            {
                EndpointController.getInstance().emotionMessageBean.getExpressive().setLeftWink(leftWink);
            }
    }

    public void updateExpLookingLeft(double lookingLeft)
    {
            for (Session client : ServerEndpoint.clients)
            {
                EndpointController.getInstance().emotionMessageBean.getExpressive().setLookingLeft(lookingLeft);
            }
    }

    public void updateExpLookingRight(double lookingRight)
    {
            for (Session client : ServerEndpoint.clients)
            {
                EndpointController.getInstance().emotionMessageBean.getExpressive().setLookingRight(lookingRight);
            }
    }


    public void updateEyeBrowRaise(double eyeBrowRaise)
    {
        for(Session client : ServerEndpoint.clients)
        {
            EndpointController.getInstance().emotionMessageBean.getExpressive().setRaiseBrow(eyeBrowRaise);
        }
    }

    public void updateEyesOpen(double eyesOpen)
    {
        for(Session client : ServerEndpoint.clients) {
            EndpointController.getInstance().emotionMessageBean.getExpressive().setEyesOpen(eyesOpen);
        }
    }

    public void updateSmile(double smile)
    {
        for(Session client : ServerEndpoint.clients) {
            EndpointController.getInstance().emotionMessageBean.getExpressive().setSmile(smile);
        }
    }

    public void updateClench(double clench) {
        for(Session client : ServerEndpoint.clients) {
            EndpointController.getInstance().emotionMessageBean.getExpressive().setClench(clench);
        }
    }

    public void updateLookingUp(double lookingUp) {
        for(Session client : ServerEndpoint.clients) {
            EndpointController.getInstance().emotionMessageBean.getExpressive().setLookingUp(lookingUp);
        }
    }

    public void updateLookingDown(double lookingDown) {
        for(Session client : ServerEndpoint.clients) {
            EndpointController.getInstance().emotionMessageBean.getExpressive().setLookingDown(lookingDown);
        }
    }

    public void updateInterest(double interest) {
        for(Session client : ServerEndpoint.clients) {
            EndpointController.getInstance().emotionMessageBean.getAffective().setInterest(interest);
        }
    }

    public void updateEngagement(double engagement) {
        for(Session client : ServerEndpoint.clients) {
            EndpointController.getInstance().emotionMessageBean.getAffective().setEngagement(engagement);
        }
    }

    public void updateStress(double stress) {
        for(Session client : ServerEndpoint.clients) {
            EndpointController.getInstance().emotionMessageBean.getAffective().setStress(stress);
        }
    }

    public void updateRelaxation(double relaxation) {
        for(Session client : ServerEndpoint.clients) {
            EndpointController.getInstance().emotionMessageBean.getAffective().setRelaxation(relaxation);
        }
    }


    public void updateExcitement(double excitement) {
        for(Session client : ServerEndpoint.clients) {
            EndpointController.getInstance().emotionMessageBean.getAffective().setExcitement(excitement);
        }
    }

    public void updateFocus(double focus) {
        for(Session client : ServerEndpoint.clients)
        {
            EndpointController.getInstance().emotionMessageBean.getAffective().setFocus(focus);
        }
    }

    /**
     * This method is to send the message only once
     */
    public void sendOnce()
    {
        sendEmotionMessage();
    }

    /**
     * This method is called to send message in certain given intervals of time
     * @param intervals This interval tells the value of intervals between sending messages to client from server
     */
    public void sendInIntervals(double intervals)
    {
        long period = (long)(intervals * 1000L);
        TimerTask toRepeatTask = new TimerTask() {
            @Override
            public void run() {
                sendEmotionMessage();
            }
        };
        timer = new Timer();
        timer.scheduleAtFixedRate(toRepeatTask, 0,period);
    }

    /**
     * This method is to stop the message sending
     */
    public void stop()
    {
        timer.cancel();
    }

    /**
     * This method is invoked to send emotion message
     */
    public void sendEmotionMessage()
    {
        emotionMessageBean = new EmotionMessageBean();
        emotionMessageBean = UIController.getInstance().updateMessageBeanFromUI();
        for (Session client : ServerEndpoint.clients) {
            // do not resend the message to its sender
            try {
                client.getBasicRemote().sendObject(emotionMessageBean);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (EncodeException e) {
                e.printStackTrace();
            }
        }
    }
}
