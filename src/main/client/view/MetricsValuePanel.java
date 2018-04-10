package main.client.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Panel to display color for the graph plot representing effects in form of boxes. And display the time difference
 * between data received for the graph points.
 * @author Shaunak Shah
 * @author Ayan Shah
 * @version 1.0
 */
public class MetricsValuePanel extends JPanel {
    private ColorBox interest;
    private ColorBox engagement;
    private ColorBox stress;
    private ColorBox relaxation;
    private ColorBox excitement;
    private ColorBox focus;
    private JFormattedTextField displayLength;
    private JButton setLength;
    private MetricGraphPanel metricGraphPanel;
    private Color colors[] = new Color[] {Color.RED.darker(), Color.GREEN.darker(), Color.YELLOW.darker(),
            Color.BLUE.darker(), Color.PINK.darker(), Color.ORANGE.darker()};

    public MetricsValuePanel(MetricGraphPanel metricGraphPanel1){
        this.setLayout(null);
        this.metricGraphPanel = metricGraphPanel1;
        interest = new ColorBox();
        interest.setBoxColor(0);
        interest.setEmotionName("Interest");
        interest.setBounds(35,15,150,150);
        interest.getDropdown().addItemListener(
                new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        if(e.getStateChange() == ItemEvent.SELECTED){
                            interest.setBackground(colors[interest.getDropdown().getSelectedIndex()]);
                            metricGraphPanel.updateColor(0, colors[interest.getDropdown().getSelectedIndex()]);
                        }
                    }
                }
        );

        this.add(interest);

        engagement = new ColorBox();
        engagement.setEmotionName("Engagement");
        engagement.setBoxColor(1);
        engagement.setBounds(190,15,150,150);
        engagement.getDropdown().addItemListener(
                new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        if(e.getStateChange() == ItemEvent.SELECTED){
                            engagement.setBackground(colors[engagement.getDropdown().getSelectedIndex()]);
                            metricGraphPanel.updateColor(1, colors[engagement.getDropdown().getSelectedIndex()]);
                        }
                    }
                }
        );
        this.add(engagement);

        stress = new ColorBox();
        stress.setEmotionName("Stress");
        stress.setBoxColor(2);
        stress.setBounds(35,170,150,150);
        stress.getDropdown().addItemListener(
                new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        if(e.getStateChange() == ItemEvent.SELECTED){
                            stress.setBackground(colors[stress.getDropdown().getSelectedIndex()]);
                            metricGraphPanel.updateColor(2, colors[stress.getDropdown().getSelectedIndex()]);
                        }
                    }
                }
        );
        this.add(stress);

        relaxation = new ColorBox();
        relaxation.setEmotionName("Relaxation");
        relaxation.setBoxColor(3);
        relaxation.setBounds(190,170,150,150);
        relaxation.getDropdown().addItemListener(
                new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        if(e.getStateChange() == ItemEvent.SELECTED){
                            relaxation.setBackground(colors[relaxation.getDropdown().getSelectedIndex()]);
                            metricGraphPanel.updateColor(3, colors[relaxation.getDropdown().getSelectedIndex()]);
                        }
                    }
                }
        );
        this.add(relaxation);

        excitement = new ColorBox();
        excitement.setEmotionName("Excitement");
        excitement.setBoxColor(4);
        excitement.setBounds(35,325,150,150);
        excitement.getDropdown().addItemListener(
                new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        if(e.getStateChange() == ItemEvent.SELECTED){
                            excitement.setBackground(colors[excitement.getDropdown().getSelectedIndex()]);
                            metricGraphPanel.updateColor(4, colors[excitement.getDropdown().getSelectedIndex()]);
                        }
                    }
                }
        );
        this.add(excitement);


        focus = new ColorBox();
        focus.setEmotionName("Focus");
        focus.setBoxColor(5);
        focus.setBounds(190,325,150,150);
        focus.getDropdown().addItemListener(
                new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        if(e.getStateChange() == ItemEvent.SELECTED){
                            focus.setBackground(colors[focus.getDropdown().getSelectedIndex()]);
                            metricGraphPanel.updateColor(5, colors[focus.getDropdown().getSelectedIndex()]);
                        }
                    }
                }
        );
        this.add(focus);

        JLabel title = new JLabel();
        title.setText("Display Length:");
        title.setBounds(50,495,140,30);
        this.add(title);

        displayLength = new JFormattedTextField();
        displayLength.setValue(new Double(1));
        displayLength.setOpaque(true);
        displayLength.setBackground(Color.GRAY);
        displayLength.setBounds(145,495,50,30);
        this.add(displayLength);

        setLength = new JButton();
        setLength.setText("Seconds");
        setLength.setOpaque(true);
        setLength.setBackground(Color.GRAY);
        setLength.setBounds(210,495,100,30);
        setLength.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                metricGraphPanel.updateDisplayLength(getDisplayLength());
            }
        });
        this.add(setLength);
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
     * Public method to get the display length as per data entered by the user. Default is set to 1.
     */
    public double getDisplayLength(){
        return (double) displayLength.getValue();
    }
}
