package polynom;

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

}
