/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polynom;

/**
 *
 * @author r.luedecke
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Program starting up!");

        QuadratischesPolynom pol = new QuadratischesPolynom(4, 1, -5);
        double fvon3 = pol.f(3);
        System.out.println("Funktionswert bei x=3: " + fvon3);
        System.out.println("Steigung bei x=3: " + pol.fStrich(3));
        System.out.println("Krümmung bei x=3: " + pol.fStrichStrich(3));
        System.out.println("Nullstelle: " + pol.ersteNullstelle());
    }

}
