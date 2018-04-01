package main.model;

/**
 * Bean which stores the emotion message to be sent to client.
 * @author Balachandar Sampath
 * @version 1.0
 */
public class ExpressiveBean {
    private boolean blink;
    private boolean rightWink;
    private boolean leftWink;
    private boolean lookingLeft;
    private boolean lookingRight;

    private double raiseBrow;
    private double furrowBrow;
    private double smile;
    private double clench;
    private double leftSmirk;
    private double rightSmirk;

    public boolean isBlink() {
        return blink;
    }

    public void setBlink(boolean blink) {
        this.blink = blink;
    }

    public boolean isRightWink() {
        return rightWink;
    }

    public void setRightWink(boolean rightWink) {
        this.rightWink = rightWink;
    }

    public boolean isLeftWink() {
        return leftWink;
    }

    public void setLeftWink(boolean leftWink) {
        this.leftWink = leftWink;
    }

    public boolean isLookingLeft() {
        return lookingLeft;
    }

    public void setLookingLeft(boolean lookingLeft) {
        this.lookingLeft = lookingLeft;
    }

    public boolean isLookingRight() {
        return lookingRight;
    }

    public void setLookingRight(boolean lookingRight) {
        this.lookingRight = lookingRight;
    }

    public double getRaiseBrow() {
        return raiseBrow;
    }

    public void setRaiseBrow(double raiseBrow) {
        this.raiseBrow = raiseBrow;
    }

    public double getFurrowBrow() {
        return furrowBrow;
    }

    public void setFurrowBrow(double furrowBrow) {
        this.furrowBrow = furrowBrow;
    }

    public double getSmile() {
        return smile;
    }

    public void setSmile(double smile) {
        this.smile = smile;
    }

    public double getClench() {
        return clench;
    }

    public void setClench(double clench) {
        this.clench = clench;
    }

    public double getLeftSmirk() {
        return leftSmirk;
    }

    public void setLeftSmirk(double leftSmirk) {
        this.leftSmirk = leftSmirk;
    }

    public double getRightSmirk() {
        return rightSmirk;
    }

    public void setRightSmirk(double rightSmirk) {
        this.rightSmirk = rightSmirk;
    }

    @Override
    public String toString() {
        return "ExpressiveBean{" +
                "blink=" + blink +
                ", rightWink=" + rightWink +
                ", leftWink=" + leftWink +
                ", lookingLeft=" + lookingLeft +
                ", lookingRight=" + lookingRight +
                ", raiseBrow=" + raiseBrow +
                ", furrowBrow=" + furrowBrow +
                ", smile=" + smile +
                ", clench=" + clench +
                ", leftSmirk=" + leftSmirk +
                ", rightSmirk=" + rightSmirk +
                '}';
    }
}
