package polynom;

import java.util.TreeSet;

/**
 * Polynom der Form f(x) = m*x+b
 */
public class LinearesPolynom implements Polynom {

    LinearesPolynom(double m, double b) {
        this.m = m;
        this.b = b;
    }

    public double m, b;

    @Override
    public double f(double x) {
        return m * x + b;
    }

    @Override
    public double fStrich(double x) {
        Polynom abl = this.Ableitung();
        return abl.f(x);
    }

    @Override
    public double fStrichStrich(double x) {
        Polynom zweiteAbl = this.Ableitung().Ableitung();
        return zweiteAbl.f(x);
    }

    @Override
    public Polynom Ableitung() {
        LinearesPolynom abl = new LinearesPolynom(0, m);
        return abl;
    }

    /**
     * Nullstelle: 0 = m*x + b m*x = -b x = -b/a
     */
    @Override
    public double ersteNullstelle() {
        return -b / m;
    }

    @Override
    public int getDegree() {
        if (this.m != 0) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public TreeSet<Double> alleNullstellen() {
        TreeSet<Double> nullstellen = new TreeSet<Double>();
        if (this.getDegree() == 1) {
            nullstellen.add(this.ersteNullstelle());
        }
        return nullstellen;
    }

}
