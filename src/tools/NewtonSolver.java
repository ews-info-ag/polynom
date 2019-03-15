/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.util.Vector;
import polynom.Polynom;

/**
 *
 * @author r.luedecke
 */
public class NewtonSolver {

    public Vector<Double> solve(Polynom pol, double value) {
        Vector<Double> solutions = new Vector<Double>();
        int maxSolutions = pol.getDegree();
        
        //lineare Abtastung
        //quadratische Abtastung
        //exponentielle Abtastung
        for (int i = 0; i < 1000; i++) {
            double position = 
            int solution = 
        }
        
        return solutions;
    }

    public Vector<Double> solveToZero(Polynom pol) {
        return solve(pol, 0);
    }

    private double solve(Polynom pol, double value, double position, double precision) throws NotConvergingInTimeException {
        precision = Math.pow(10, -precision);
        double lastPosition = position + precision;
        for (int i = 0; Math.abs(lastPosition - position) >= precision; i++) {
            if (i >= 100000) {
                throw new NotConvergingInTimeException().setNumberOfIterations(i);
            }
            lastPosition = position;
            position = position - pol.f(position) / pol.fStrich(position);
        }
        return position;
    }
    
}
