package main.model;

public class EmotionMessageBean {

    private ExpressiveBean expressive;
    private String sender;
    private AffectiveBean affective;

    public EmotionMessageBean()
    {
        expressive = new ExpressiveBean();
        affective = new AffectiveBean();
    }

    public ExpressiveBean getExpressive() {
        return expressive;
    }

    public void setExpressive(ExpressiveBean expressive) {
        this.expressive = expressive;
    }

    public AffectiveBean getAffective() {
        return affective;
    }

    public void setAffective(AffectiveBean affective) {
        this.affective = affective;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    @Override
    public String toString() {
        return "EmotionMessageBean{" +
                "expressive=" + expressive +
                ", sender='" + sender + '\'' +
                ", affective=" + affective +
                '}';
    }
}
