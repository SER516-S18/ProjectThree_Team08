package main.client.view.ExpressiveComponents.LowerFaceComponents;

import main.client.view.ExpressiveComponents.IExpressive;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Mouth extends Rectangle2D.Double implements IExpressive {

    private static final int X = 140;
    private static final int Y = 240;
    private static final int WIDTH = 30;
    private static final int HEIGHT = 3;

    public Mouth(){
        super(X, Y, WIDTH, HEIGHT);
    }

    public void Set(double val){
        if(val > 0 && val <= 1)
            setFrame(X,Y,0,0);
    }

    public void Reset(){
        setFrame(X,Y,WIDTH,HEIGHT);
    }

    public boolean getFill(){
        return true;
    }

    public Color getColor(){
        return Color.BLACK;
    }
}
