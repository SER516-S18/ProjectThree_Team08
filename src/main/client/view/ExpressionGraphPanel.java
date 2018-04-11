package main.client.view;

import main.model.EmotionMessageBean;
import main.model.ExpressiveBean;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.TimeSeries;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;


public class ExpressionGraphPanel extends JPanel implements Observer{

    private EmotionMessageBean emotionMessageBean;
    //private TimeSeries[] series;
    //private Double[] clenchVal;
    private TimeSeries blinkVal = new TimeSeries("Blink");
    private TimeSeries rightWinkVal = new TimeSeries("Right Wink");
    private TimeSeries leftWinkVal = new TimeSeries("Left Wink");
    private TimeSeries lookingRightVal = new TimeSeries("Looking Right");
    private TimeSeries lookingLeftVal = new TimeSeries("Looking Left");
    private TimeSeries eyeBrowRaiseVal = new TimeSeries("Eyebrow Raise");
    private TimeSeries eyeBrowFurrowVal = new TimeSeries("Eyebrow Furrow ");
    private TimeSeries smileVal = new TimeSeries("Smile");
    private TimeSeries clenchVal = new TimeSeries("Clench");
    private TimeSeries lookingUpVal = new TimeSeries("Looking Up");
    private TimeSeries lookingDownVal = new TimeSeries("Looking Down");

    public ExpressionGraphPanel(EmotionMessageBean emotionMessageBean){
        this.emotionMessageBean=emotionMessageBean;
        this.setLayout(new BorderLayout());
        JPanel subPanel = new JPanel();
        subPanel.setLayout(new GridBagLayout());
        GridBagConstraints constraints=new GridBagConstraints();
        subPanel.setBackground(Color.WHITE);
        this.add(subPanel, BorderLayout.CENTER);
        subPanel.setPreferredSize(new Dimension(700,550));
        for(int i=0; i<11; i++){
            constraints.ipadx=0;
            constraints.ipady=0;
            constraints.gridx=0;
            constraints.gridy=i;
            subPanel.add(createChartPanel(i), constraints);

            constraints.ipadx=0;
            constraints.ipady=0;
            constraints.gridx=1;
            constraints.gridy=i;
            JLabel label=new JLabel(createLabel(i));
            subPanel.add(label, constraints);
        }

    }

    private JPanel createChartPanel(int type){
        XYDataset dataSet = createDataSet(type);
        JFreeChart graph = createChart(dataSet);
        ChartPanel chart = new ChartPanel(graph);
        JPanel chartPanelHolder = new JPanel();

        chart.setMouseZoomable(true,true);
        chartPanelHolder.setPreferredSize(new Dimension(550,40));
        chartPanelHolder.setLayout(new BorderLayout());
        chartPanelHolder.add(chart, BorderLayout.CENTER);
        return chartPanelHolder;
    }

    private XYDataset createDataSet(int type){
        switch(type){
            case 0: return new TimeSeriesCollection(blinkVal);
            case 1: return new TimeSeriesCollection(rightWinkVal);
            case 2: return new TimeSeriesCollection(leftWinkVal);
            case 3: return new TimeSeriesCollection(lookingRightVal);
            case 4: return new TimeSeriesCollection(lookingLeftVal);
            case 5: return new TimeSeriesCollection(eyeBrowRaiseVal);
            case 6: return new TimeSeriesCollection(eyeBrowFurrowVal);
            case 7: return new TimeSeriesCollection(smileVal);
            case 8: return new TimeSeriesCollection(clenchVal);
            case 9: return new TimeSeriesCollection(lookingUpVal);
            case 10: return new TimeSeriesCollection(lookingDownVal);
        }

        return new TimeSeriesCollection();
    }

    private JFreeChart createChart(final XYDataset dataSet){
        JFreeChart chart= ChartFactory.createTimeSeriesChart(
                "",
                "Seconds",
                "Value",
                dataSet,
                false,
                false,
                false);
        XYPlot plot = chart.getXYPlot();
        plot.setDomainGridlinesVisible(false);
        plot.setRangeGridlinesVisible(false);
        org.jfree.chart.axis.ValueAxis xaxis = plot.getDomainAxis();
        xaxis.setAutoRange(true);

        xaxis.setFixedAutoRange(60000.0);  // 60 seconds
        xaxis.setVerticalTickLabels(false);

        xaxis.setAutoTickUnitSelection(true);
        xaxis.setVisible(false);

        org.jfree.chart.axis.ValueAxis yaxis = plot.getRangeAxis();
        yaxis.setRange(0.0, 1.1);
        yaxis.setVisible(false);

        return chart;
    }

    private String createLabel(int type){
        String expression="";
        switch(type){
            case 0: expression="Blink";
                break;
            case 1: expression="Right Wink";
                break;
            case 2: expression="Left wink";
                break;
            case 3: expression="Looking Right";
                break;
            case 4: expression="Looking Left";
                break;
            case 5: expression="Eye Brow Raise";
                break;
            case 6: expression="Eye Brow Furrow";
                break;
            case 7: expression="Smile";
                break;
            case 8: expression="Clench";
                break;
            case 9: expression="Looking Up";
                break;
            case 10 : expression="Looking Down";
                break;
        }
        return expression;
    }

    private void updateValue(ExpressiveBean expressiveBean){
        Double val;
        final Millisecond current= new Millisecond();
        if(expressiveBean.isBlink())
            val=1.00;
        else
            val=0.00;
        blinkVal.add(current,val);
        if(expressiveBean.isRightWink())
            val=1.00;
        else
            val=0.00;
        rightWinkVal.add(current,val);
        if(expressiveBean.isLeftWink())
            val=1.00;
        else
            val=0.00;
        leftWinkVal.add(current,val);
        lookingRightVal.add(current, expressiveBean.getLookingRight());
        lookingLeftVal.add(current, expressiveBean.getLookingLeft());
        eyeBrowRaiseVal.add(current, expressiveBean.getRaiseBrow());
        eyeBrowFurrowVal.add(current, expressiveBean.getFurrowBrow());
        smileVal.add(current, expressiveBean.getSmile());
        clenchVal.add(current, expressiveBean.getClench());
        lookingUpVal.add(current, expressiveBean.getLookingUp());
        lookingDownVal.add(current, expressiveBean.getLookingDown());
    }
    @Override
    public void update(Observable o, Object arg) {
        if(this.emotionMessageBean == o){
            updateValue(emotionMessageBean.getExpressive());
        }
    }
}
