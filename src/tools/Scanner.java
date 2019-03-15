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
public class Scanner {
    
    public double getLinearScan(int i) {
        if (i % 2 == 0) {
            return i / 2;
        } else {
            return - (i + 1)/2;
        }
    }
    
    public double getSquareScan(int i) {
        if (i % 2 == 0) {
            return (i / 2)*(i / 2);
        } else {
            i++;
            return - (i/2)*(i/2);
        }
    }
    
    public double getExponentialScan(int i) {
        if (i % 2 == 0) {
            return (i / 2)*(i / 2);
        } else {
            i++;
            return - (i/2)*(i/2);
        }
    }
    
}
