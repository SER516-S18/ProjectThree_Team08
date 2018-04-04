package main.client.view.ExpressiveComponents.EyeComponents;

public class RightEyeBall extends EyeBall {

    private static final int X = 102;
    private static final int Y = 181;

    public RightEyeBall() {
        super(X, Y);
    }

    public void LookLeft(double val){

        if(val <= 0 || val > 1)
            return;

        double newX = X + (5 * val);
        setFrame(newX, getY(), WIDTH, HEIGHT);
    }

    public void LookRight(double val){

        if(val <= 0 || val > 1)
            return;

        double newX = X - (5 * val);
        setFrame(newX, getY(), WIDTH, HEIGHT);
    }

    public void LookUp(double val){

        if(val <= 0 || val > 1)
            return;

        double newY = Y - (8 * val);
        setFrame(getX(), newY, WIDTH, HEIGHT);
    }

    public void LookDown(double val){

        if(val <= 0 || val > 1)
            return;

        double newY = Y + (6 * val);
        setFrame(getX(), newY, WIDTH, HEIGHT);
    }

    public void Reset(){
        setFrame(X, Y, WIDTH, HEIGHT);
        super.Reset();
    }

}
