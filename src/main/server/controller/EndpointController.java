package main.server.controller;

import main.model.EmotionMessageBean;
import main.server.view.ConsolePanel;

import javax.websocket.EncodeException;
import javax.websocket.Session;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

//This class has to be created first when the main.server ui or main.client ui is on and should be the first one to be invoked
/**
 * Controller which acts as a interface between server and UIController.
 * @author Balachandar Sampath
 * @version 1.0
 */
public class EndpointController {

    private static EndpointController endpointController = null;
    private static EmotionMessageBean emotionMessageBean = null;
    private Timer timer = new Timer("Timer");
    /**
     * Returns an instance of the class
     *
     * @return EndpointController
     */
    public static EndpointController getInstance() {
        if(endpointController == null)
        {
            endpointController = new EndpointController();
        }
        return endpointController;
    }
    //private boolean blink;
    public void updateExpBlink(boolean blink)
    {
            for (Session client : ServerEndpoint.clients)
            {
                EndpointController.getInstance().emotionMessageBean.getExpressive().setBlink(blink);
            }
    }
    //    private boolean rightWink;
    public void updateExpRightWink(boolean rightWink)
    {
            for (Session client : ServerEndpoint.clients)
            {
                EndpointController.getInstance().emotionMessageBean.getExpressive().setRightWink(rightWink);
            }
    }
    //private boolean leftWink;
    public void updateExpLeftWink(boolean leftWink)
    {
            for (Session client : ServerEndpoint.clients)
            {
                EndpointController.getInstance().emotionMessageBean.getExpressive().setLeftWink(leftWink);
            }
    }
//    private boolean lookingLeft;
    public void updateExpLookingLeft(boolean lookingLeft)
    {
            for (Session client : ServerEndpoint.clients)
            {
                EndpointController.getInstance().emotionMessageBean.getExpressive().setLookingLeft(lookingLeft);
            }
    }
    //private boolean lookingRight;
    public void updateExpLookingRight(boolean lookingRight)
    {
            for (Session client : ServerEndpoint.clients)
            {
                EndpointController.getInstance().emotionMessageBean.getExpressive().setRightWink(lookingRight);
            }
    }

    //private double eyeBrowRaise;
    public void updateEyeBrowRaise(double eyeBrowRaise)
    {
        for(Session client : ServerEndpoint.clients)
        {
            EndpointController.getInstance().emotionMessageBean.getExpressive().setRaiseBrow(eyeBrowRaise);
        }
    }
    //private double eyesOpen;
    public void updateEyesOpen(double eyesOpen)
    {
        for(Session client : ServerEndpoint.clients) {
            EndpointController.getInstance().emotionMessageBean.getExpressive().setEyesOpen(eyesOpen);
        }
    }
    //private double smile;
    public void updateSmile(double smile)
    {
        for(Session client : ServerEndpoint.clients) {
            EndpointController.getInstance().emotionMessageBean.getExpressive().setSmile(smile);
        }
    }
    //private double clench;
    public void updateClench(double clench) {
        for(Session client : ServerEndpoint.clients) {
            EndpointController.getInstance().emotionMessageBean.getExpressive().setClench(clench);
        }
    }
    //private double lookingUp;
    public void updateLookingUp(double lookingUp) {
        for(Session client : ServerEndpoint.clients) {
            EndpointController.getInstance().emotionMessageBean.getExpressive().setLookingUp(lookingUp);
        }
    }
    //private double lookingDown;
    public void updateLookingDown(double lookingDown) {
        for(Session client : ServerEndpoint.clients) {
            EndpointController.getInstance().emotionMessageBean.getExpressive().setLookingDown(lookingDown);
        }
    }

    //Affective
    //private double interest;
    public void updateInterest(double interest) {
        for(Session client : ServerEndpoint.clients) {
            EndpointController.getInstance().emotionMessageBean.getAffective().setInterest(interest);
        }
    }

    //private double engagement;
    public void updateEngagement(double engagement) {
        for(Session client : ServerEndpoint.clients) {
            EndpointController.getInstance().emotionMessageBean.getAffective().setEngagement(engagement);
        }
    }

    //private double stress;
    public void updateStress(double stress) {
        for(Session client : ServerEndpoint.clients) {
            EndpointController.getInstance().emotionMessageBean.getAffective().setStress(stress);
        }
    }
//    private double relaxation;
    public void updateRelaxation(double relaxation) {
        for(Session client : ServerEndpoint.clients) {
            EndpointController.getInstance().emotionMessageBean.getAffective().setRelaxation(relaxation);
        }
    }

    //private double excitement;
    public void updateExcitement(double excitement) {
        for(Session client : ServerEndpoint.clients) {
            EndpointController.getInstance().emotionMessageBean.getAffective().setExcitement(excitement);
        }
    }

    //private double focus;
    public void updateFocus(double focus) {
        for(Session client : ServerEndpoint.clients)
        {
            EndpointController.getInstance().emotionMessageBean.getAffective().setFocus(focus);
        }
    }
    // This method is to send the message only once
    public void sendOnce()
    {
        sendEmotionMessage();
    }

    // This method is to send the message in period of certain interval
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

    public void stop()
    {
        timer.cancel();
    }

    //This method is invoked to send emotion message to main.client.
    //Prerequiste : First update the message that you want to send and then call this method
    public void sendEmotionMessage()
    {
        emotionMessageBean = new EmotionMessageBean();
        UIController.getInstance().updateMessageBeanFromUI(emotionMessageBean);
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
