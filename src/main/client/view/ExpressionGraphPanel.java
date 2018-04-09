package main.client.view;

import main.client.view.ExpressionLineGraph;

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
        this.setPreferredSize(new Dimension(700,550));
        GridBagConstraints c = new GridBagConstraints();
        exp.setBackground(Color.WHITE);
        this.add(exp);
        for (int i=0; i<11; i++)
        {
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
            c.ipadx=0;
            c.ipady=0;
            c.gridx = 0;
            c.gridy = i;
            ExpressionLineGraph graph=new ExpressionLineGraph(type);
            exp.add(graph, c);
            //JLabel label1=new JLabel(type);
            //exp.add(label1, c);
            c.ipadx=0;
            c.ipady=0;
            c.gridx = 1;
            c.gridy = i;


            JLabel label=new JLabel(type);
            exp.add(label, c);
        }

    }
}