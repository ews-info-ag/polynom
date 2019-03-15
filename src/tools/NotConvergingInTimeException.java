/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

/**
 *
 * @author r.luedecke
 */
public class NotConvergingInTimeException extends Exception {
    
    private int numberOfIterations;

    /**
     * @return the numberOfIterations
     */
    public int getNumberOfIterations() {
        return numberOfIterations;
    }

    /**
     * @param numberOfIterations the numberOfIterations to set
     */
    public NotConvergingInTimeException setNumberOfIterations(int numberOfIterations) {
        this.numberOfIterations = numberOfIterations;
        return this;
    }
    
    
    
}
