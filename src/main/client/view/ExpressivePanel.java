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
    public void affect(ExpressiveBean b){

        if(bean == null || !bean.equals(b)){
            for (IExpressive e : shapes)
                e.reset();

            bean = new ExpressiveBean(b);
            //Blink
            leftEye.blink(bean.isBlink());
            rightEye.blink(bean.isBlink());
            leftEyeLash.blink(bean.isBlink());
            rightEyeLash.blink(bean.isBlink());
            leftEyeBall.blink(bean.isBlink());
            rightEyeBall.blink(bean.isBlink());

            //Left wink
            leftEye.blink(bean.isLeftWink());
            leftEyeLash.blink(bean.isLeftWink());
            leftEyeBall.blink(bean.isLeftWink());

            //Right wink
            rightEye.blink(bean.isRightWink());
            rightEyeLash.blink(bean.isRightWink());
            rightEyeBall.blink(bean.isRightWink());

            //Look left
            leftEyeBall.lookLeft(bean.getLookingLeft());
            rightEyeBall.lookLeft(bean.getLookingLeft());

            //Look right
            leftEyeBall.lookRight(bean.getLookingRight());
            rightEyeBall.lookRight(bean.getLookingRight());

            //Look up
            leftEyeBall.lookUp(bean.getLookingUp());
            rightEyeBall.lookUp(bean.getLookingUp());

            //Look down
            leftEyeBall.lookDown(bean.getLookingDown());
            rightEyeBall.lookDown(bean.getLookingDown());

            //Eyebrow raise
            leftEyeBrow.raise(bean.getRaiseBrow());
            rightEyeBrow.raise(bean.getRaiseBrow());

            //Smile and Clench
            smile.set(bean.getSmile());
            clench.set(bean.getClench());
            mouth.set(bean.getSmile());
            mouth.set(bean.getClench());

            Graphics2D g2 =(Graphics2D)getGraphics();
            paintComponent(g2);
        }
    }
}
