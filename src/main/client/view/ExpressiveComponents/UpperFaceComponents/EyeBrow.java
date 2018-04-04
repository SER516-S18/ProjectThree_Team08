package main.client.view.ExpressiveComponents.UpperFaceComponents;

import main.client.view.ExpressiveComponents.IExpressive;

import java.awt.*;
import java.awt.geom.Arc2D;

public abstract class EyeBrow extends Arc2D.Double implements IExpressive {

    protected static final int WIDTH = 50;
    protected static final int HEIGHT = 60;

    public EyeBrow(int x, int y, int st, int ex){
        super(x,y,WIDTH,HEIGHT,st,ex, Arc2D.OPEN);
    }

    public void Raise(double val){

        if(val <= 0 || val > 1)
            return;

        double newY = getY() - (val * 10);
        setFrame(getX(), newY, WIDTH, HEIGHT);
    }

    public void Reset(){
    }

    public boolean getFill(){
        return false;
    }

    public Color getColor(){
        return Color.BLACK;
    }
}
