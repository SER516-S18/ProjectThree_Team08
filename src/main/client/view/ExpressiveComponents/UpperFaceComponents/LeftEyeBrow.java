package main.client.view.ExpressiveComponents.UpperFaceComponents;

public class LeftEyeBrow extends EyeBrow {

    private static final int X = 175;
    private static final int Y = 163;
    private static final int START = 110;
    private static final int EXTENT = -50;

    public LeftEyeBrow(){
        super(X, Y, START, EXTENT);
    }

    public void Reset(){
        setFrame(X, Y, WIDTH, HEIGHT);
    }
}
