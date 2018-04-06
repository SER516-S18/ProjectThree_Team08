package main.server.controller;

import main.model.EmotionMessageBean;
import main.server.view.ConsolePanel;
import main.server.view.DetectionPanel;
import main.server.view.InteractivePanel;

/**
 * Controller which acts as a interface between EndpointController and view(UI).
 * This class has to be created first when the main.server ui or main.client ui is on and should be the first one to be invoked
 * @author Balachandar Sampath, Rhythm Sharma
 * @version 1.0
 */
public class UIController {
    private ConsolePanel consolePanel;
    private static DetectionPanel detectionPanel;
    private static InteractivePanel interactivePanel;

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

    public static void setDetectionPanel(DetectionPanel detectionPanelObj) {
        detectionPanel = detectionPanelObj;
    }

    public static void setInteractivePanel(InteractivePanel interactivePanelObj) {
        interactivePanel = interactivePanelObj;
    }

    public void setConsolePanel(ConsolePanel consolePanel) {
        this.consolePanel = consolePanel;
    }

    // get the values from various parts of UI(spinner, text fields,..) and update in message bean
    public EmotionMessageBean updateMessageBeanFromUI() {
    	// TODO: @RHYTHM: Needs to update the logic here. 
    	// Set the values read from UI to messageBean 
    	return null;
    }

	public static void updateSendButtonText(boolean autoResetSelected) {
		String sendBtnText;
		if(autoResetSelected) {
			sendBtnText = "Start";
		} else {
			sendBtnText = "Send";
		}
		interactivePanel.updateSendBtnText(sendBtnText);
	}

	public static void updateSendButtonText() {
		if(interactivePanel.isAutoReset()) {
			interactivePanel.updateSendBtnText("Stop");
		}
	}

}
