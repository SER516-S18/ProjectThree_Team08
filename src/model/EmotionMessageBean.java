package model;

public class EmotionMessageBean {
    private ExpressiveBean expressive;

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


}
