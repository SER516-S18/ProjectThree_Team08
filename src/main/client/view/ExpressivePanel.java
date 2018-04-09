package main.client.view;

import main.client.view.ExpressiveComponents.EyeComponents.*;
import main.client.view.ExpressiveComponents.LowerFaceComponents.*;
import main.client.view.ExpressiveComponents.UpperFaceComponents.*;
import main.client.view.ExpressiveComponents.*;
import main.model.ExpressiveBean;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This panel displays the face and handles facial expressions
 * @author Ejaz Saifudeen
 * @version 1.1
 */
public class ExpressivePanel extends JPanel {

    private static final String faceLayoutPath = "faceLayout.png";
    private List<IExpressive> shapes = new ArrayList<>();
    private LeftEye leftEye = new LeftEye();
    private RightEye rightEye = new RightEye();
    private LeftEyeLash leftEyeLash = new LeftEyeLash();
    private RightEyeLash rightEyeLash = new RightEyeLash();
    private LeftEyeBall leftEyeBall = new LeftEyeBall();
    private RightEyeBall rightEyeBall = new RightEyeBall();
    private LeftEyeBrow leftEyeBrow = new LeftEyeBrow();
    private RightEyeBrow rightEyeBrow = new RightEyeBrow();
    private Mouth mouth = new Mouth();
    private Smile smile = new Smile();
    private Clench clench = new Clench();
    BufferedImage img = null;
    ExpressiveBean bean = null;

    /**
     * Constructor adds all shapes to a list and reads the facelayout image
     * to a buffered image
     */
    public ExpressivePanel(){
        shapes.add(leftEye);
        shapes.add(rightEye);
        shapes.add(leftEyeLash);
        shapes.add(rightEyeLash);
        shapes.add(leftEyeBall);
        shapes.add(rightEyeBall);
        shapes.add(leftEyeBrow);
        shapes.add(rightEyeBrow);
        shapes.add(mouth);
        shapes.add(smile);
        shapes.add(clench);

        try {
            img = ImageIO.read(getClass().getClassLoader().getResource(faceLayoutPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is responsible for drawing all the shapes
     * @param g Graphics object
     */
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        setBackground(Color.WHITE);
        g2.drawImage(img, 0,0,null);

        for (IExpressive e : shapes){
            g2.setColor(e.getColor());
            if(e.getFill()) {
                g2.fill(e);
            } else {
                g2.setStroke(new BasicStroke(3));
                g2.draw(e);
            }
        }
    }

    /**
     * Affects facial features based on the received bean
     * @param b ExpressiveBean object
     */
    public void Affect(ExpressiveBean b){

        if(bean == null || !bean.equals(b)){
            for (IExpressive e : shapes)
                e.Reset();

            bean = new ExpressiveBean(b);
            //Blink
            leftEye.Blink(bean.isBlink());
            rightEye.Blink(bean.isBlink());
            leftEyeLash.Blink(bean.isBlink());
            rightEyeLash.Blink(bean.isBlink());
            leftEyeBall.Blink(bean.isBlink());
            rightEyeBall.Blink(bean.isBlink());

            //Left wink
            leftEye.Blink(bean.isLeftWink());
            leftEyeLash.Blink(bean.isLeftWink());
            leftEyeBall.Blink(bean.isLeftWink());

            //Right wink
            rightEye.Blink(bean.isRightWink());
            rightEyeLash.Blink(bean.isRightWink());
            rightEyeBall.Blink(bean.isRightWink());

            //Look left
            leftEyeBall.LookLeft(bean.getLookingLeft());
            rightEyeBall.LookLeft(bean.getLookingLeft());

            //Look right
            leftEyeBall.LookRight(bean.getLookingRight());
            rightEyeBall.LookRight(bean.getLookingRight());

            //Look up
            leftEyeBall.LookUp(bean.getLookingUp());
            rightEyeBall.LookUp(bean.getLookingUp());

            //Look down
            leftEyeBall.LookDown(bean.getLookingDown());
            rightEyeBall.LookDown(bean.getLookingDown());

            //Eyebrow raise
            leftEyeBrow.Raise(bean.getRaiseBrow());
            rightEyeBrow.Raise(bean.getRaiseBrow());

            //Smile and Clench
            smile.Set(bean.getSmile());
            clench.Set(bean.getClench());
            mouth.Set(bean.getSmile());
            mouth.Set(bean.getClench());

            Graphics2D g2 =(Graphics2D)getGraphics();
            paintComponent(g2);
        }
    }
}
