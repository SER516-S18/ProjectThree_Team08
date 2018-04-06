package main.server.controller;

import main.model.EmotionMessageBean;
import main.server.view.ConsolePanel;
import main.server.view.DetectionPanel;
import main.server.view.InteractivePanel;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Controller which acts as a interface between EndpointController and view(UI).
 * This class has to be created first when the main.server ui or main.client ui is on and should be the first one to be invoked
 * @author Balachandar Sampath, Rhythm Sharma, Aashita Priya
 * @version 1.0
 */
public class UIController {
    private ConsolePanel consolePanel;
    private static DetectionPanel detectionPanel;
    private static InteractivePanel interactivePanel;
    private static boolean run = true;

    private UIController() {}

    // Inner class SingletonHolder to support lazy initialisation of class
    private static class SingletonHolder {
        public static final UIController uiController = new UIController();
    }
    /**
     * Returns an instance of the class
     * @return UIController
     */
    public static UIController getInstance()
    {
        return SingletonHolder.uiController;
    }

    /**
     *
     * @param detectionPanelObj
     */
    public static void setDetectionPanel(DetectionPanel detectionPanelObj) {
        detectionPanel = detectionPanelObj;
    }

    /**
     *
     * @param interactivePanelObj
     */
    public static void setInteractivePanel(InteractivePanel interactivePanelObj) {
        interactivePanel = interactivePanelObj;
    }

    /**
     *
     * @param consolePanel
     */
    public void setConsolePanel(ConsolePanel consolePanel) {
        this.consolePanel = consolePanel;
    }

    // get the values from various parts of UI(spinner, text fields,..) and update in message bean
    public void updateMessageBeanFromUI() {
    	// TODO: @RHYTHM: Needs to update the logic here. 
    	// Set the values read from UI to messageBean
      //  Double time = emotionMessageBean.getClockTick (); //Append this time to message

        //From Bala : Can access eyewink data from this.detectionPanel and pls dont access the bean directly from here and use the below line to update the bean for low coupling and soc
        //EndpointController.getInstance().updateExpLeftWink();
    }

	public static void updateSendButtonText(boolean autoResetSelected) {
		String sendBtnText;
		if(autoResetSelected) {
			sendBtnText = "Start";
			System.out.println ("start");
		} else {
			sendBtnText = "Send";
			System.out.println ("send");
		}
		interactivePanel.updateSendBtnText(sendBtnText);
	}

	public static void updateSendButtonText(String presentText) {
		if(interactivePanel.isAutoReset()) {
		    if("start".equalsIgnoreCase (presentText)) {
                interactivePanel.updateSendBtnText("Stop");
            } else {
                interactivePanel.updateSendBtnText("Start");
            }

		}
	}

	public static void updateDetectionTime(double emoStateInterval) {

        if(!interactivePanel.isAutoReset()) {
            double detectionTime = detectionPanel.getTimeTextField ();
            detectionTime += emoStateInterval;
            detectionPanel.setTimeTxtField (detectionTime);

        } else {
            if("start".equalsIgnoreCase (interactivePanel.getBtnSendValue ())) {
                run = false;
            } else {
                run = true;
            }

            Timer timer = new Timer ();

            TimerTask timerTask = new TimerTask () {
                double detectionTime, newDetectionTime;
                @Override
                public void run() {
                    if(run) {
                        detectionTime = detectionPanel.getTimeTextField ();
                        newDetectionTime = detectionTime + emoStateInterval;
                        detectionPanel.setTimeTxtField (newDetectionTime);
                    } else {
                        timer.cancel();
                        timer.purge();
                    }
                }
            };

            long delay = 0;
            long intervalPeriod = (long) (emoStateInterval * 1000);
            timer.scheduleAtFixedRate (timerTask, delay, intervalPeriod);

        }

    }

}
