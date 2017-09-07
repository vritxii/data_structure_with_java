package Poly;

/**
 * Created by vrit on 16-10-12.
 */
public class PolyNode {

    private double coef;//系数
    private int expn;//指数
    public PolyNode next;

    public PolyNode() {
        this(0, 0);
    }

    public PolyNode(double coef, int expn) {
        this.coef = coef;
        this.expn = expn;
    }

    public double getCoef() {
        return coef;
    }

    public void setCoef(double coef) {
        this.coef = coef;
    }

    public int getExpn() {
        return expn;
    }

    public void setExpn(int expn) {
        this.expn = expn;
    }
}
