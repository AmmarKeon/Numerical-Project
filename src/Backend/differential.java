package Backend;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class differential {

    static ArrayList<Double> xval = new ArrayList<>();
    static ArrayList<Double> fxval = new ArrayList<>();

    public static double f(double x) {

        for (int i = 0; i < xval.size(); i++) {

            if (Math.abs(xval.get(i) - x) < 1e-6) {
                return fxval.get(i);
            }
        }
        throw new IllegalArgumentException("x=" + x + "x not found");
    }

    public static void main(String[] args) {

        System.out.println("Enter x: ");
        do {
            Scanner sc = new Scanner(System.in);
            xval.add(sc.nextDouble());
        }
        while (xval.get(xval.size() - 1) != -1000);
        {
            System.out.println("done ");
            xval.remove(xval.size() - 1);
        }

        System.out.println("Enter Fx: ");
        do {
            Scanner sc = new Scanner(System.in);
            fxval.add(sc.nextDouble());
        }
        while (fxval.get(fxval.size() - 1) != -1000);
        {
            System.out.println("done ");
            fxval.remove(fxval.size() - 1);
        }
        // table
        System.out.println("Table of x and f(x):");
        System.out.printf("%-10s | %-10s\n", "x", "f(x)");
        System.out.println("---------------------------");
        for (int i = 0; i < xval.size(); i++) {
            System.out.printf("%.1f        |  %f\n", xval.get(i), fxval.get(i));
        }
        System.out.println();

        Scanner input = new Scanner(System.in);
        double h = xval.get(xval.size() - 1) - xval.get(fxval.size() - 2);
        double x ;
        System.out.println("1- Two points \n2- Three Points ");
        int choose = input.nextInt();
        if (choose == 1) {
            do {
                System.out.println("Get derivative at X= ?/ (-1000) Exit");
                x = input.nextDouble();
                double forward = 0;
                double backward =0;
                int s = xval.indexOf(x);

                if (s == xval.size()-1) {
                    backward =  (f(x) - f(x - h)) / h;
                    System.out.printf("backward Difference  at x = %f: %f\n", x, backward);
                }
                else if (x==-1000) {
                    System.out.println("Exit");
                    break;
                }
                else {
                    forward = (f(x + h) - f(x)) / h;
                    System.out.printf("Forward Difference  at x = %f: %f\n", x, forward);
                }

            }
            while (x != -1000);


        } else if (choose == 2) {
            do {
                System.out.println("Get derivative at X= ? / (-1000) Exit");
                x = input.nextDouble();
                double forward3point = 0;
                double backward3point = 0;
                double central = 0;
                int s = xval.indexOf(x);
                if (s == xval.size()-1) {
                    backward3point = ((3 * f(x)) - (4 * f(x-h)) + f(x-(2*h)) ) / (2 * h);
                    System.out.printf("Backward 3-Point at x = %f: %f\n", x, backward3point);
                } else if (s == 0) {
                    forward3point = ((-3 * f(x)) + (4 * f(x+h) )- f(x+(2*h))) / (2 * h);
                    System.out.printf("Forward 3-Point at x = %f: %f\n", x, forward3point);
                }
                else if (x==-1000) {
                    System.out.println("Exit");
                    break;
                } else {
                central = (f(x+h) - f(x-h)) / (2 * h);
                System.out.printf("Central Difference  at x = %f: %f\n", x, central);
            }
            }
            while (x != -1000);

        }
    }
}


