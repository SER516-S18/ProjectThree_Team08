package main.client.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;
import javax.swing.JPanel;

import main.model.ExpressiveBean;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

//import main.model.ExpressiveBean.*;

/**
 * An example to show how we can create a dynamic chart.
 */
public class ExpressionLineGraph extends JPanel{

    /** The time series data. */
    private TimeSeries series;

    private String expressionType;

    /** The most recent value added. */
    private double value;

    /** Timer to refresh graph after every 1/4th of a second */
    //private Timer timer = new Timer(250, this);

    /**
     * Constructs a new dynamic chart application.
     *
     * @param title  the frame title.
     */
    public ExpressionLineGraph(final String title) {

        super();
        expressionType=title;
        this.series = new TimeSeries("", Millisecond.class);

        final TimeSeriesCollection dataset = new TimeSeriesCollection(this.series);
        final JFreeChart chart = createChart(dataset);

        //timer.setInitialDelay(1000);

        //Sets background color of chart
        chart.setBackgroundPaint(Color.WHITE);

        //Created JPanel to show graph on screen
        //final JPanel content = new JPanel(new BorderLayout());

        //Created Chartpanel for chart area
        final ChartPanel chartPanel = new ChartPanel(chart);

        //Added chartpanel to main panel
        //content.add(chartPanel);

        //Sets the size of whole window (JPanel)
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new java.awt.Dimension(580, 45));
        this.add(chartPanel, BorderLayout.CENTER);
        //Puts the whole content on a Frame
        //setContentPane(content);
        //timer.start();

    }

    /**
     * Creates a sample chart.
     *
     * @param dataset  the dataset.
     *
     * @return A sample chart.
     */
    private JFreeChart createChart(final XYDataset dataset) {
        final JFreeChart result = ChartFactory.createTimeSeriesChart(
                "",
                "Time",
                "Value",
                dataset,
                false,
                true,
                false
        );

        final XYPlot plot = result.getXYPlot();
        plot.setBackgroundPaint(Color.LIGHT_GRAY);
        plot.setDomainGridlinesVisible(false);
        plot.setRangeGridlinesVisible(false);

        ValueAxis xaxis = plot.getDomainAxis();
        xaxis.setAutoRange(true);

        //Domain axis would show data of 60 seconds for a time
        xaxis.setFixedAutoRange(60000.0);  // 60 seconds
        xaxis.setVerticalTickLabels(false);
        xaxis.setVisible(false);

        ValueAxis yaxis = plot.getRangeAxis();
        yaxis.setRange(0.0, 1.0);
        yaxis.setVisible(false);

        return result;
    }
    /**
     * Generates an random entry for a particular call made by time for every 1/4th of a second.
     *
     * @param e  the action event.
     */
    public void update(ExpressiveBean expressionBean) {

        ExpressiveBean bean = expressionBean;
        switch(expressionType){
            case("Blink"):if(bean.isBlink()) this.value = 1.0;
            else this.value=0.0;
                break;
            case("Right Wink"):if(bean.isRightWink()) this.value = 1.0;
            else this.value=0.0;
                break;
            case("Left Wink"):if(bean.isLeftWink()) this.value = 1.0;
            else this.value=0.0;
                break;
            case("Looking Right"):this.value = bean.getLookingRight();
                break;
            case("Looking Left"):this.value = bean.getLookingLeft();
                break;
            case("Raise Brow"):this.value = bean.getRaiseBrow();
                break;
            case("Furrow Brow"):this.value = bean.getFurrowBrow();
                break;
            case("Smile"):this.value = bean.getSmile();
                break;
            case("Clench"):this.value = bean.getClench();
                break;
            case("Looking Up"):this.value = bean.getLookingUp();
                break;
            case("Looking Down"):this.value = bean.getLookingDown();
                break;
        }

        final Millisecond now = new Millisecond();
        this.series.add(new Millisecond(), this.value);
    }

}
