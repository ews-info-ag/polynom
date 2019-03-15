package polynom;

import java.util.TreeSet;

/**
 * Polynom der Form f(x) = a*x^2+b*x+c
 */
public class QuadratischesPolynom implements Polynom {

    QuadratischesPolynom(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public double a, b, c;

    @Override
    public double f(double x) {
        return a * x * x + b * x + c;
    }

    @Override
    public Polynom Ableitung() {
        LinearesPolynom abl = new LinearesPolynom(2*a, b);
        return abl;
    }

    /**
     * Nullstelle: wenn a = 1 mit pq-formel wenn a = 0 mit linearem polynom
     * sonst: mit neuem quadratischem polynom, alle koeffizienten durch a
     * geteilt.
     * @return Liefert eine zufällige erste Nullstelle
     */
    @Override
    public double ersteNullstelle() {
        if (a == 1) {
            return -b / 2 - Math.sqrt((b / 2) * (b / 2) - c);
        } else if (a == 0) {
            LinearesPolynom lin = new LinearesPolynom(b, c);
            return lin.ersteNullstelle();
        } else {
            QuadratischesPolynom quad = new QuadratischesPolynom(1, b/a, c/a);
            return quad.ersteNullstelle();
        }
    }
    
    public double zweiteNullstelle() {
        if (a == 1) {
            return -b / 2 + Math.sqrt((b / 2) * (b / 2) - c);
        } else if (a == 0) {
            LinearesPolynom lin = new LinearesPolynom(b, c);
            return lin.ersteNullstelle();
        } else {
            QuadratischesPolynom quad = new QuadratischesPolynom(1, b/a, c/a);
            return quad.ersteNullstelle();
        }
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
    public int getDegree() {
        if (this.a != 0) {
            return 2;
        } else if (this.b != 0) {
            return 1;
        } else {
            return 0;
        }
    }
    
    @Override
    public TreeSet<Double> alleNullstellen() {
        TreeSet<Double> nullstellen = new TreeSet<Double>();
        if (this.getDegree() == 2) {
            nullstellen.add(this.ersteNullstelle());
            nullstellen.add(this.zweiteNullstelle());
            return nullstellen;
        } else if (this.getDegree() ==1 ){
            LinearesPolynom lin = new LinearesPolynom(b, c);
            return lin.alleNullstellen();
        } else {
            return nullstellen;
        }
    }

}
