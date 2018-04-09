package main.client.view.ExpressiveComponents.UpperFaceComponents;

/**
 * Class for left eye ball, inherits from EyeBall
 * @author Ejaz Saifudeen
 * @version 1.1
 */
public class LeftEyeBall extends EyeBall {

    private static final int X = 195;
    private static final int Y = 181;

    /**
     * Constructor that calls super constructor with relevant
     * X, Y
     */
    public LeftEyeBall(){
        super(X,Y);
    }

    /**
     * Modifies X position based on received val to position
     * eyeball to the left
     * @param val double 0-1
     */
    public void lookLeft(double val){

        if(val <= 0 || val > 1)
            return;

        double newX = X + (5 * val);
        setFrame(newX, getY(), WIDTH, HEIGHT);
    }

    /**
     * Modifies X position based on received val to position
     * eyeball to the right
     * @param val double 0-1
     */
    public void lookRight(double val){

        if(val <= 0 || val > 1)
            return;

        double newX = X - (5 * val);
        setFrame(newX, getY(), WIDTH, HEIGHT);
    }

    /**
     * Modifies Y position based on received val to position
     * eyeball to the top
     * @param val double 0-1
     */
    public void lookUp(double val){

        if(val <= 0 || val > 1)
            return;

        double newY = Y - (8 * val);
        setFrame(getX(), newY, WIDTH, HEIGHT);
    }

    /**
     * Modifies Y position based on received val to position
     * eyeball to the bottom
     * @param val double 0-1
     */
    public void lookDown(double val){

        if(val <= 0 || val > 1)
            return;

        double newY = Y + (6 * val);
        setFrame(getX(), newY, WIDTH, HEIGHT);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void reset(){
        setFrame(X, Y, WIDTH, HEIGHT);
        super.reset();
    }
}
