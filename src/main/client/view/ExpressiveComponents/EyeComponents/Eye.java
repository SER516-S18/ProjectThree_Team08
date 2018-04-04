package main.client.view.ExpressiveComponents.EyeComponents;

import main.client.view.ExpressiveComponents.IExpressive;

import java.awt.*;
import java.awt.geom.Arc2D;

public abstract class Eye extends Arc2D.Double implements IExpressive {

    protected static final int WIDTH = 23;
    protected static final int HEIGHT = 30;
    private static final int START = 90;
    private static final int EXTENT = -360;

    public Eye(int x, int y){
        super(x,y,WIDTH,HEIGHT,START,EXTENT, Arc2D.CHORD);
    }

    public void Blink(boolean b){

        if(!b)
            return;

        //double newStart = START - (val * 180);
        //double newExtent = EXTENT + (val * 360);
        setAngleExtent(0);
    }

    public void Reset(){
        setAngleStart(START);
        setAngleExtent(EXTENT);
    }

    public boolean getFill(){
        return true;
    }

    public Color getColor(){
        return Color.WHITE;
    }
}
