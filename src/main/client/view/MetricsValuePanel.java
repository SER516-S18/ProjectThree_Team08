package main.client.view;

import javax.swing.*;
import java.awt.*;

/**
 * Panel to display color for the graph plot representing effects in form of boxes. And display the time difference
 * between data received for the graph points.
 * @author Shaunak Shah
 * @version 1.0
 */
public class MetricsValuePanel extends JPanel {
    private ColorBox interest;
    private ColorBox engagement;
    private ColorBox stress;
    private ColorBox relaxation;
    private ColorBox excitement;
    private ColorBox focus;
    private JLabel displayLength;

    public MetricsValuePanel(){
        this.setLayout(null);

        interest = new ColorBox();
        interest.setBoxColor(0);
        interest.setEmotionName("Interest");
        interest.setBounds(35,15,150,150);
        this.add(interest);

        engagement = new ColorBox();
        engagement.setEmotionName("Engagement");
        engagement.setBoxColor(1);
        engagement.setBounds(190,15,150,150);
        this.add(engagement);

        stress = new ColorBox();
        stress.setEmotionName("Stress");
        stress.setBoxColor(2);
        stress.setBounds(35,170,150,150);
        this.add(stress);

        relaxation = new ColorBox();
        relaxation.setEmotionName("Relaxation");
        relaxation.setBoxColor(3);
        relaxation.setBounds(190,170,150,150);
        this.add(relaxation);

        excitement = new ColorBox();
        excitement.setEmotionName("Excitement");
        excitement.setBoxColor(4);
        excitement.setBounds(35,325,150,150);
        this.add(excitement);


        focus = new ColorBox();
        focus.setEmotionName("Focus");
        focus.setBoxColor(5);
        focus.setBounds(190,325,150,150);
        this.add(focus);

        JLabel title = new JLabel();
        title.setText("Display Length:");
        title.setBounds(70,495,140,30);
        this.add(title);

        displayLength = new JLabel("1", SwingConstants.CENTER);
        displayLength.setOpaque(true);
        displayLength.setBackground(Color.GRAY);
        displayLength.setBounds(165,495,50,30);
        this.add(displayLength);

        JLabel unit = new JLabel("Seconds", SwingConstants.CENTER);
        unit.setOpaque(true);
        unit.setBackground(Color.GRAY);
        unit.setBounds(230,495,70,30);
        this.add(unit);
    }

    /**
     * Public method to return the color selected by user for interest plot.
     */
    public Color getInterstColor(){
        return interest.getBoxColor();
    }

    /**
     * Public method to return the color selected by user for engagement plot.
     */
    public Color getEngagementColor(){
        return engagement.getBoxColor();
    }

    /**
     * Public method to return the color selected by user for stress plot.
     */
    public Color getStressColor(){
        return stress.getBoxColor();
    }

    /**
     * Public method to return the color selected by user for relaxation plot.
     */
    public Color getRelaxationColor(){
        return relaxation.getBoxColor();
    }

    /**
     * Public method to return the color selected by user for excitement plot.
     */
    public Color getExcitemetColor(){
        return excitement.getBoxColor();
    }

    /**
     * Public method to return the color selected by user for focus plot.
     */
    public Color getFocusColor(){
        return focus.getBoxColor();
    }

    /**
     * Public method to set the display length as per data received by the client.
     */
    public void setDisplayLength(int length){
        displayLength.setText(""+length);
    }
}
