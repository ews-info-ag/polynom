/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.util.TreeSet;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import polynom.Polynom;

/**
 *
 * @author r.luedecke
 */
public class NewtonSolver {
    
    Scanner scanner = new Scanner();

    public TreeSet<Double> solve(Polynom pol, double value) {
        TreeSet<Double> solutions = new TreeSet<Double>();
        int maxSolutions = pol.getDegree();
        
        
        //lineare Abtastung
        for (int i = 0; i < 1000; i++) {
            double position = scanner.getLinearScan(i);
            try {
                double solution = solve(pol, value, position, 3);
                solutions.add(solution);
            } catch (NotConvergingInTimeException ex) {
                Logger.getLogger(NewtonSolver.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (solutions.size() >= maxSolutions) {
                return solutions;
            }
        }
        //quadratische Abtastung
        for (int i = 0; i < 1000; i++) {
            double position = scanner.getSquareScan(i);
            try {
                double solution = solve(pol, value, position, 3);
                solutions.add(solution);
            } catch (NotConvergingInTimeException ex) {
                Logger.getLogger(NewtonSolver.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (solutions.size() >= maxSolutions) {
                return solutions;
            }
        }
        //exponentielle Abtastung
        for (int i = 0; i < 1000; i++) {
            double position = scanner.getExponentialScan(i);
            try {
                double solution = solve(pol, value, position, 3);
                solutions.add(solution);
            } catch (NotConvergingInTimeException ex) {
                Logger.getLogger(NewtonSolver.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (solutions.size() >= maxSolutions) {
                return solutions;
            }
        }
        return solutions; 
    }

    public TreeSet<Double> solveToZero(Polynom pol) {
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
