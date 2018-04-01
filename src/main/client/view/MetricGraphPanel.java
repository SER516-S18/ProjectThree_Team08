package main.client.view;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;

/**
 * Graph Panel to display chart in graph tab
 * @author Shaunak Shah
 * @version 1.0
 */

public class MetricGraphPanel extends JPanel {

    private XYSeries[] metricValues;
    private ChartPanel chartPanel;
    private JFreeChart chart;
    private Color colorList[] = new Color[] { Color.RED, Color.GREEN, Color.YELLOW,
            Color.BLUE, Color.PINK };
    private int channelNumber;

    public MetricGraphPanel(){
        XYSeriesCollection dataSet = new XYSeriesCollection();
        chart = createChart(dataSet);
        chartPanel = new ChartPanel(chart);
        chartPanel.setMouseZoomable(true , false);
        chartPanel.setPreferredSize(new Dimension(520, 520));
        this.setLayout(new BorderLayout());
        this.add(chartPanel, BorderLayout.CENTER);
        this.setVisible(true);
    }

    /**
     * Public method to continuously update the values for the channels in graph
     */
    public void updateMetric(double[] xCoordinate, double[] yCoordinate){
        for(int i=0; i<channelNumber;i++){
            metricValues[i].add(xCoordinate[i],yCoordinate[i]);
        }
    }

    /**
     * Public method used to update the number of channels in a graph. Creates new chart panel.
     * And it to the panel.
     */
    public void updateChannelNumber(int n){
        channelNumber = n;
        XYDataset dataSet = createDataSet(channelNumber);
        remove(chartPanel);
        chart = createChart(dataSet);
        chartPanel = new ChartPanel(chart);
        chartPanel.setMouseZoomable(true , false);
        chartPanel.setPreferredSize(new Dimension(520, 520));
        this.setLayout(new BorderLayout());
        this.add(chartPanel, BorderLayout.CENTER);
        this.setVisible(true);
    }

    /**
     * Public method to change the color of a specific channel.
     */
    public void updateColor(int key, Color color){
        XYPlot plot = chart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(key,color);
        plot.setRenderer(renderer);

    }

    /**
     * Private method to create data chart based on the data set provided. Used when panel is initialized or channel
     * count is changed.
     */
    private JFreeChart createChart(XYDataset dataSet){
        JFreeChart chart = ChartFactory.createXYLineChart("InitialMetric", "X",
                "Y", dataSet,
                PlotOrientation.VERTICAL, true, false, false);
        chart.removeLegend();
        final XYPlot plot = chart.getXYPlot();

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        for (int i = 0; i < dataSet.getSeriesCount(); i++) {
            renderer.setSeriesPaint(i, colorList[i]);
//            renderer.setSeriesStroke(i, new BasicStroke(1.0f));
        }
        plot.setRenderer(renderer);
        plot.setBackgroundPaint(Color.GRAY);
        plot.setRangeGridlinesVisible(false);
        plot.setDomainGridlinesVisible(false);
        return chart;
    }

    /**
     * Private method to initialize new data set based on the number of channels provided. Used when channel number is
     * addded or updated by the method 'update channel number'.
     */
    private XYDataset createDataSet(int channelNumber) {
        final XYSeriesCollection dataset = new XYSeriesCollection();
        metricValues = new XYSeries[channelNumber];
        for (int i = 0; i < channelNumber; i++) {
            metricValues[i] = new XYSeries("Channel " + (i + 1));
        }

        for (int i = 0; i < channelNumber; i++) {
            dataset.addSeries(metricValues[i]);
        }
        return dataset;
    }
}