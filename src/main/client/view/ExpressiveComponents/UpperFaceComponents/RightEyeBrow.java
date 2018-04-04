package main.client.view.ExpressiveComponents.UpperFaceComponents;

public class RightEyeBrow extends EyeBrow {

    private static final int X = 85;
    private static final int Y = 163;
    private static final int START = 70;
    private static final int EXTENT = 50;

    public RightEyeBrow(){
        super(X, Y, START, EXTENT);
    }

    public void Reset(){
        setFrame(X, Y, WIDTH, HEIGHT);
    }
}
