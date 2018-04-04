package main.client.view.ExpressiveComponents.LowerFaceComponents;

import main.client.view.ExpressiveComponents.IExpressive;

import java.awt.*;
import java.awt.geom.Arc2D;

public class Smile extends Arc2D.Double implements IExpressive {

    private static final int X = 106;
    private static final int Y = 105;
    private static final int WIDTH = 100;
    private static final int HEIGHT = 140;
    private static final int START = 250;
    private static final int EXTENT = 40;

    public Smile(){
        super(X,Y,WIDTH,HEIGHT,0,0, Arc2D.CHORD);
    }

    public void Set(double val){

        if(val <= 0 || val > 1)
            return;

        double newY = Y + (20*val);
        double NewStart = START - (30 * val);
        double NewExtent = EXTENT + (60 * val);
        setFrame(X, newY, WIDTH, HEIGHT);
        setAngleStart(NewStart);
        setAngleExtent(NewExtent);
    }

    public void Reset(){
        setAngleStart(0);
        setAngleExtent(0);
    }

    public boolean getFill(){
        return true;
    }

    public Color getColor(){
        return Color.BLACK;
    }
}
