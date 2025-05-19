package Backend;

import java.util.Scanner;

public class Secant {

    public static String Secant(double X0, double X1) {
        String loop = "3x^2 - e^x = 0\n";
        double FX0 = (3*X0*X0)-Math.pow(Math.E,X0);
        double FX1 = (3*X1*X1)-Math.pow(Math.E,X1);
        double X2 = X1 - (((X1-X0)*FX1)/(FX1-FX0));
        loop += "X2: "+X2+"\n";
        int Iterations = 1;
        double tolerance = 1e-13 ;
        int i = 3;

        while (Math.abs(X1 - X2) > tolerance) {
            X0 = X1;
            FX0 = (3 * X0 * X0) - Math.pow(Math.E, X0);
            X1 = X2;
            FX1 = (3 * X1 * X1) - Math.pow(Math.E, X1);
            X2 = X1 - (((X1 - X0) * FX1) / (FX1 - FX0));
            Iterations++;
            loop += "X"+(i)+": "+X2+"\n";
            i++;
        }

        loop += "\nTotal number of iterations: " + Iterations +"\n";
        return loop;

    }








}
