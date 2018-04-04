package main.client.view.ExpressiveComponents.EyeComponents;

public class RightEye extends Eye {

    private static final int X = 97;
    private static final int Y = 172;

    public RightEye(){
        super(X,Y);
    }

    public void Reset(){
        setFrame(X, Y, WIDTH, HEIGHT);
        super.Reset();
    }
}
