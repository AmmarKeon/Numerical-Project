package Backend;

import java.util.Scanner;

public class Secant {
    public static void main(String[] args) {
        String FX = "3x^2 - e^x ";
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer X0 and X1: ");
        double X0 = input.nextDouble();
        double X1= input.nextDouble();
        System.out.println("X0: "+X0+"\nX1: "+X1);
        double FX0 = (3*X0*X0)-Math.pow(Math.E,X0);
        double FX1 = (3*X1*X1)-Math.pow(Math.E,X1);
        double X2 = X1 - (((X1-X0)*FX1)/(FX1-FX0));
        System.out.println("X2: "+X2);
        int Iterations =0;
        double tolerance = 1e-16 ;
        int i = 3;

            while (Math.abs(X1 - X2) > tolerance) {
                X0 = X1;
                FX0 = (3 * X0 * X0) - Math.pow(Math.E, X0);
                X1 = X2;
                FX1 = (3 * X1 * X1) - Math.pow(Math.E, X1);
                X2 = X1 - (((X1 - X0) * FX1) / (FX1 - FX0));
                Iterations++;
                System.out.println("X"+i+": "+X2);
                i++;
            }

        System.out.println("Total number of iterations: " + Iterations);








    }
}
