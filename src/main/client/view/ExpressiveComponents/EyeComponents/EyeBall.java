package main.client.view.ExpressiveComponents.EyeComponents;

import main.client.view.ExpressiveComponents.IExpressive;

import java.awt.*;
import java.awt.geom.Arc2D;

public class EyeBall extends Arc2D.Double implements IExpressive {

    protected static final int WIDTH = 12;
    protected static final int HEIGHT = 15;
    private static final int START = 90;
    private static final int EXTENT = -360;

    public EyeBall(int x, int y){
        super(x,y,WIDTH,HEIGHT,START,EXTENT, Arc2D.CHORD);
    }

    public void Blink(boolean b){

        if(!b)
            return;

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
        return Color.BLACK;
    }
}
