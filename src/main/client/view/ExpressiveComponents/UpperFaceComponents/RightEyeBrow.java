package main.client.view.ExpressiveComponents.UpperFaceComponents;

/**
 * Class for right eye brow, inherits from EyeBrow
 * @author Ejaz Saifudeen
 * @version 1.1
 */
public class RightEyeBrow extends EyeBrow {

    private static final int X = 85;
    private static final int Y = 163;
    private static final int START = 70;
    private static final int EXTENT = 50;

    /**
     * Constructor that calls super constructor with relevant
     * X, Y, Start and Extent values
     */
    public RightEyeBrow(){
        super(X, Y, START, EXTENT);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void reset(){
        setFrame(X, Y, WIDTH, HEIGHT);
    }
}
