package Backend;

import java.util.Scanner;

public class Newton {

    public static double f(double x) {
        return Math.pow(Math.E,x) - x - 1;
    }

    public static double fdash(double x) {
        return Math.pow(Math.E,x) - 1;
    }

    public static String newtonRaphson(double x0) {
        String loop = "Newton-Raphson Method for f(x) = e^X - X - 1\n\n";

        double xn = x0;
        double x = xn - f(xn) / fdash(xn);
        int i = 1;
        double tolerance = 1e-14;
        do {
            xn = x;
            x = xn - f(xn) / fdash(xn);
            loop += "x" + i + " = " + x +"\n";
            i++;
        } while (Math.abs(x - xn) > tolerance );
        return loop;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter X0 : ");
        double x0 = input.nextDouble();

        System.out.println(newtonRaphson(x0));
    }
}
