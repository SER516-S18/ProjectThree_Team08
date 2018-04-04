package main.client.view.ExpressiveComponents.EyeComponents;

public class LeftEyeLash extends EyeLash {

    private static final int X = 190;
    private static final int Y = 172;

    public LeftEyeLash(){
        super(X,Y);
    }

    public void Reset(){
        setFrame(X, Y, WIDTH, HEIGHT);
        super.Reset();
    }
}
