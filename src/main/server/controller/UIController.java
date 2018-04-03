package main.server.controller;

import main.model.EmotionMessageBean;
import main.server.view.ConsolePanel;
import main.server.view.DetectionPanel;
import main.server.view.InteractivePanel;

/**
 * Controller which acts as a interface between EndpointController and view(UI).
 * This class has to be created first when the main.server ui or main.client ui is on and should be the first one to be invoked
 * @author Balachandar Sampath
 * @version 1.0
 */
public class UIController {
    private ConsolePanel consolePanel;
    private DetectionPanel detectionPanel;
    private InteractivePanel interactivePanel;

    private UIController() {}

    private static class SingletonHolder {
        public static final UIController uiController = new UIController();
    }
    public static UIController getInstance()
    {
        return SingletonHolder.uiController;
    }

    public void setDetectionPanel(DetectionPanel detectionPanel) {
        this.detectionPanel = detectionPanel;
    }

    public void setInteractivePanel(InteractivePanel interactivePanel) {
        this.interactivePanel = interactivePanel;
    }

    public void setConsolePanel(ConsolePanel consolePanel) {
        this.consolePanel = consolePanel;
    }

    // get the values from various parts of UI(spinner, text fields,..) and update in message bean
    public void updateMessageBeanFromUI(EmotionMessageBean emotionMessageBean) {

    }

}
