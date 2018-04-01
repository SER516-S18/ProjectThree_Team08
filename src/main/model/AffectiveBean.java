package main.model;

/**
 * Bean which stores the emotion message to be sent to client.
 * @author Balachandar Sampath
 * @version 1.0
 */
public class AffectiveBean {


    private double interest;
    private double engagement;
    private double stress;
    private double relaxation;
    private double excitement;
    private double focus;

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public double getEngagement() {
        return engagement;
    }

    public void setEngagement(double engagement) {
        this.engagement = engagement;
    }

    public double getStress() {
        return stress;
    }

    public void setStress(double stress) {
        this.stress = stress;
    }

    public double getRelaxation() {
        return relaxation;
    }

    public void setRelaxation(double relaxation) {
        this.relaxation = relaxation;
    }

    public double getExcitement() {
        return excitement;
    }

    public void setExcitement(double excitement) {
        this.excitement = excitement;
    }

    public double getFocus() {
        return focus;
    }

    public void setFocus(double focus) {
        this.focus = focus;
    }

    @Override
    public String toString() {
        return "AffectiveBean{" +
                "interest=" + interest +
                ", engagement=" + engagement +
                ", stress=" + stress +
                ", relaxation=" + relaxation +
                ", excitement=" + excitement +
                ", focus=" + focus +
                '}';
    }
}
