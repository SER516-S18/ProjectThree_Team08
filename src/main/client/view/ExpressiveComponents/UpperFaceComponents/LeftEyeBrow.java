package main.client.view.ExpressiveComponents.UpperFaceComponents;

/**
 * Class for left eye brow, inherits from EyeBrow
 * @author Ejaz Saifudeen
 * @version 1.1
 */
public class LeftEyeBrow extends EyeBrow {

    private static final int X = 175;
    private static final int Y = 163;
    private static final int START = 110;
    private static final int EXTENT = -50;

    /**
     * Constructor that calls super constructor with relevant
     * X, Y, Start and Extent values
     */
    public LeftEyeBrow(){
        super(X, Y, START, EXTENT);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void Reset(){
        setFrame(X, Y, WIDTH, HEIGHT);
    }
}
