package main.client.view.ExpressiveComponents.EyeComponents;

public class RightEyeLash extends EyeLash {

    private static final int X = 97;
    private static final int Y = 172;

    public RightEyeLash(){
        super(X,Y);
    }

    public void Reset(){
        setFrame(X, Y, WIDTH, HEIGHT);
        super.Reset();
    }
}
