package polynom;

public interface Polynom {
	public double f(double x);
        public double fStrich(double x);
        public double fStrichStrich(double x);
	public Polynom Ableitung();
	public double ersteNullstelle();
        public int getDegree();
}