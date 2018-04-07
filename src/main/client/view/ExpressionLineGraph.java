package main.client.view;

import main.model.ExpressiveBean;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.*;
import org.jfree.data.xy.XYDataset;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import main.model.ExpressiveBean;

/**
 * Graph Panel to display line graph in graph tab
 * @author Nishiti Sawant
 * @version 1.0
 */

public class ExpressionLineGraph extends JPanel{
    private TimeSeries[] metricValues;
    private ChartPanel chartPanel;
    private JFreeChart chart;
    private int frequency = 1;
    public ExpressionLineGraph(int type) {


        XYDataset dataSet = createDataSet(type);
        chart = createChart(dataSet);
        chartPanel = new ChartPanel(chart);
        chartPanel.addComponentListener(new ChartSizeListener());
        chartPanel.setMouseZoomable(true , true);
        chartPanel.setPreferredSize(new Dimension(580, 45));
        this.setLayout(new BorderLayout());
        this.add(chartPanel, BorderLayout.CENTER);
    }

    /**
     * Public method to continuously update the values for the channels in graph
     */
    public void updateMetric(ExpressiveBean bean){
        Millisecond current = new Millisecond();
        //metricValues[0].addOrUpdate(current,bean.isBlink());
        //metricValues[1].addOrUpdate(current,bean.isRightWink());
        //metricValues[2].addOrUpdate(current,bean.isLeftWink());
        metricValues[3].addOrUpdate(current,bean.getLookingLeft());
        metricValues[4].addOrUpdate(current,bean.getLookingRight());
        metricValues[5].addOrUpdate(current,bean.getRaiseBrow());
        metricValues[6].addOrUpdate(current,bean.getEyesOpen());
        metricValues[7].addOrUpdate(current,bean.getSmile());
        metricValues[8].addOrUpdate(current,bean.getClench());
        metricValues[9].addOrUpdate(current,bean.getLookingUp());
        metricValues[10].addOrUpdate(current,bean.getLookingDown());
        NumberAxis n = (NumberAxis) chart.getXYPlot().getDomainAxis();
//        n.pan(0.01);
    }


    /**
     * Private method to create data chart based on the data set provided. Used when panel is initialized or channel
     * count is changed.
     */
    private JFreeChart createChart(XYDataset dataSet){
        JFreeChart chart = ChartFactory.createXYLineChart("", "",
                "Amount", dataSet,
                PlotOrientation.VERTICAL, true, false, false);
        chart.removeLegend();
        final XYPlot plot = chart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        for (int i = 0; i < dataSet.getSeriesCount()-1; i++) {
            renderer.setSeriesPaint(i,Color.orange);
        }

        NumberAxis domain = (NumberAxis) plot.getDomainAxis();
        domain.setVerticalTickLabels(false);
        domain.setVisible(false);
        domain.setAutoTickUnitSelection(true);

        NumberAxis range = (NumberAxis) plot.getRangeAxis();
        range.setRange(0.00, 1.00);
        range.setVisible(false);
        range.setTickUnit(new NumberTickUnit(0.1));

        plot.setRenderer(renderer);
        plot.setBackgroundPaint(Color.LIGHT_GRAY);
        plot.setRangeGridlinesVisible(false);
        plot.setDomainGridlinesVisible(false);
        return chart;
    }

    /**
     * Private method to initialize new data set based on the number of channels provided. Used when channel number is
     * addded or updated by the method 'update channel number'.
     */
    private XYDataset createDataSet(int channelNumber) {
        final TimeSeriesCollection dataSet = new TimeSeriesCollection();
        metricValues = new TimeSeries[channelNumber];
        for (int i = 0; i < channelNumber; i++) {
            metricValues[i] = new TimeSeries("Channel " + (i + 1));
            dataSet.addSeries(metricValues[i]);
        }
        return dataSet;
    }

    private void setMaximumPlots(int maxPlots){

        int maxItemAge = (1000/frequency)*maxPlots;

        for(int i = 0; i < channelNumber; i++){
            metricValues[i].setMaximumItemAge(maxItemAge);
        }
    }

    private class ChartSizeListener extends ComponentAdapter  {

        public void componentResized(ComponentEvent ev) {

            int maxPlots = chartPanel.getWidth()/15;
            setMaximumPlots(maxPlots);
        }
    }

}
