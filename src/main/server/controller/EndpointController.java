package main.server.controller;

import main.model.EmotionMessageBean;
import javax.websocket.EncodeException;
import javax.websocket.Session;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Controller which acts as a interface between server and UIController. This
 * class has to be created first when the main.server ui or main.client ui is on
 * and should be the first one to be invoked
 * 
 * @author Balachandar Sampath, Rhythm Sharma
 * @version 1.0
 */
public class EndpointController {

	private EmotionMessageBean emotionMessageBean = null;
	private Timer timer = new Timer("Timer");

	private EndpointController() {
	}

	// This will support lazy initialisation of endpointController
	private static class SingletonHolder {
		public static final EndpointController endpointController = new EndpointController();
	}

	/**
	 * Returns an instance of the class
	 *
	 * @return EndpointController
	 */
	public static EndpointController getInstance() {
		return SingletonHolder.endpointController;
	}

	/**
	 *
	 * @param blink
	 */
	public void updateExpBlink(boolean blink) {
		EndpointController.getInstance().emotionMessageBean.getExpressive().setBlink(blink);
	}

	/**
	 *
	 * @param rightWink
	 */
	public void updateExpRightWink(boolean rightWink) {
		EndpointController.getInstance().emotionMessageBean.getExpressive().setRightWink(rightWink);
	}

	/**
	 *
	 * @param leftWink
	 */
	public void updateExpLeftWink(boolean leftWink) {
		EndpointController.getInstance().emotionMessageBean.getExpressive().setLeftWink(leftWink);
	}

	/**
	 *
	 * @param lookingLeft
	 */
	public void updateExpLookingLeft(double lookingLeft) {
		EndpointController.getInstance().emotionMessageBean.getExpressive().setLookingLeft(lookingLeft);
	}

	/**
	 *
	 * @param lookingRight
	 */
	public void updateExpLookingRight(double lookingRight) {
		EndpointController.getInstance().emotionMessageBean.getExpressive().setLookingRight(lookingRight);
	}

	/**
	 *
	 * @param eyeBrowRaise
	 */
	public void updateEyeBrowRaise(double eyeBrowRaise) {
		EndpointController.getInstance().emotionMessageBean.getExpressive().setRaiseBrow(eyeBrowRaise);
	}

	/**
	 *
	 * @param eyesOpen
	 */
	public void updateEyesOpen(double eyesOpen) {
		EndpointController.getInstance().emotionMessageBean.getExpressive().setEyesOpen(eyesOpen);
	}

	/**
	 *
	 * @param smile
	 */
	public void updateSmile(double smile) {
		EndpointController.getInstance().emotionMessageBean.getExpressive().setSmile(smile);
	}

	/**
	 *
	 * @param clench
	 */
	public void updateClench(double clench) {
		EndpointController.getInstance().emotionMessageBean.getExpressive().setClench(clench);
	}

	/**
	 *
	 * @param lookingUp
	 */
	public void updateLookingUp(double lookingUp) {
		EndpointController.getInstance().emotionMessageBean.getExpressive().setLookingUp(lookingUp);
	}

	/**
	 *
	 * @param lookingDown
	 */
	public void updateLookingDown(double lookingDown) {
		EndpointController.getInstance().emotionMessageBean.getExpressive().setLookingDown(lookingDown);
	}

	/**
	 *
	 * @param interest
	 */
	public void updateInterest(double interest) {
		EndpointController.getInstance().emotionMessageBean.getAffective().setInterest(interest);
	}

	/**
	 *
	 * @param engagement
	 */
	public void updateEngagement(double engagement) {
		EndpointController.getInstance().emotionMessageBean.getAffective().setEngagement(engagement);
	}

	/**
	 *
	 * @param stress
	 */
	public void updateStress(double stress) {
		EndpointController.getInstance().emotionMessageBean.getAffective().setStress(stress);
	}

	/**
	 *
	 * @param relaxation
	 */
	public void updateRelaxation(double relaxation) {
		EndpointController.getInstance().emotionMessageBean.getAffective().setRelaxation(relaxation);
	}

	/**
	 *
	 * @param excitement
	 */
	public void updateExcitement(double excitement) {
		EndpointController.getInstance().emotionMessageBean.getAffective().setExcitement(excitement);
	}

	/**
	 *
	 * @param focus
	 */
	public void updateFocus(double focus) {
		EndpointController.getInstance().emotionMessageBean.getAffective().setFocus(focus);
	}

	/**
	 * This method is to send the message only once
	 */
	public void sendOnce() {
		sendEmotionMessage();
	}

	/**
	 * This method is called to send message in certain given intervals of time
	 * 
	 * @param intervals
	 *            This interval tells the value of intervals between sending
	 *            messages to client from server
	 */
	public void sendInIntervals(double intervals) {
		long period = (long) (intervals * 1000L);
		TimerTask toRepeatTask = new TimerTask() {
			@Override
			public void run() {
				sendEmotionMessage();
			}
		};
		timer = new Timer();
		timer.scheduleAtFixedRate(toRepeatTask, 0, period);
	}

	/**
	 * This method is to stop the message sending
	 */
	public void stop() {
		timer.cancel();
	}

	/**
	 * This method is invoked to send emotion message
	 */
	public void sendEmotionMessage() {
		// Reintialisation emotion for resetting data
		this.emotionMessageBean = new EmotionMessageBean();

		UIController.getInstance().updateMessageBeanFromUI();
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
