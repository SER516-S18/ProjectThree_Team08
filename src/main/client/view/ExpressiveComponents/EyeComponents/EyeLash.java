package main.client.view.ExpressiveComponents.EyeComponents;

import main.client.view.ExpressiveComponents.IExpressive;

import java.awt.*;
import java.awt.geom.Arc2D;

public class EyeLash extends Arc2D.Double implements IExpressive {

    protected static final int WIDTH = 23;
    protected static final int HEIGHT = 30;
    private static final int START = 90;
    private static final int EXTENT = -360;

    public EyeLash(int x, int y){
        super(x,y,WIDTH,HEIGHT,START,EXTENT, Arc2D.OPEN);
    }

    public void Blink(boolean b){

        if(!b)
            return;

        //double newStart = START - ((val/2) * 180);
        //double newExtent = EXTENT + ((val/2) * 360);
        double newStart = 0;
        double newExtent = -180;
        setAngleStart(newStart);
        setAngleExtent(newExtent);
    }

    public void Reset(){
        setAngleStart(START);
        setAngleExtent(EXTENT);
    }

    public boolean getFill(){
        return false;
    }

    public Color getColor(){
        return Color.BLACK;
    }

}
