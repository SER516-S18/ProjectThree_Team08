package main.client.view.ExpressiveComponents.EyeComponents;

/**
 * Class for right eye, inherits from Eye
 * @author Ejaz Saifudeen
 * @version 1.1
 */
public class RightEye extends Eye {

    private static final int X = 97;
    private static final int Y = 172;

    /**
     * Constructor that calls super constructor with relevant
     * X, Y
     */
    public RightEye(){
        super(X,Y);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void Reset(){
        setFrame(X, Y, WIDTH, HEIGHT);
        super.Reset();
    }
}
