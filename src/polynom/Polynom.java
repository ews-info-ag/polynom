package polynom;

import java.util.Set;

public interface Polynom {
	public double f(double x);
        public double fStrich(double x);
        public double fStrichStrich(double x);
	public Polynom Ableitung();
	public double ersteNullstelle();
        public Set alleNullstellen();
        public int getDegree();
}