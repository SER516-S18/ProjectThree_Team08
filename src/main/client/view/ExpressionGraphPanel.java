package main.client.view;

import javax.swing.*;
import java.awt.*;

/**
 * Graph Panel to display chart in graph tab
 * @author Nishiti Sawant
 * @version 1.0
 */

public class ExpressionGraphPanel extends JPanel {

    private String type;


    public ExpressionGraphPanel() {
        JPanel exp = new JPanel(new GridBagLayout());
        this.setLayout(new BorderLayout());
        GridBagConstraints c = new GridBagConstraints();
        exp.setBackground(Color.LIGHT_GRAY);
        this.add(exp);
        for (int i=0; i<11; i++)
        {
            c.ipadx=0;
            c.ipady=0;
            c.weightx=0.5;
            c.weighty=0.0;
            c.fill = GridBagConstraints.CENTER;
            c.gridx = 0;
            c.gridy = i;
            ExpressionLineGraph graph=new ExpressionLineGraph(i);
            exp.add(graph, c);
            c.ipadx=0;
            c.ipady=0;
            c.weightx=0.5;
            c.weighty=0.0;
            c.fill = GridBagConstraints.CENTER;
            c.gridx = 1;
            c.gridy = i;
            switch(i){
                case 0: type="Blink";
                        break;
                case 1: type="Right Wink";
                        break;
                case 2: type="Left Wink";
                        break;
                case 3: type="Looking Right";
                        break;
                case 4: type="Looking Left";
                        break;
                case 5: type="Raise Brow";
                        break;
                case 6: type="Eyes Open";
                        break;
                case 7: type="Smile";
                        break;
                case 8: type="Clench";
                        break;
                case 9: type="Looking Up";
                        break;
                case 10: type="Looking Down";
                        break;

            }

            JLabel label=new JLabel(type);
            exp.add(label, c);
        }

    }
}