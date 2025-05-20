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

        String loop = "Enter x: \n";
        System.out.print(loop);
        Ent_X();

        loop = "Enter Fx: ";
        System.out.print(loop);
        Ent_Fx();

        // table
        loop = "Table of x and f(x):\n";
        loop += ("X          |  f(x)\n");
        loop += "---------------------------\n";
        for (int i = 0; i < xval.size(); i++) {
            loop += "" + xval.get(i) + "        |  " + fxval.get(i) + "\n";
        }
        loop += "\n";
        System.out.print(loop);
        Scanner input = new Scanner(System.in);
        System.out.println("1- Two points \n2- Three Points ");;
        int choose = input.nextInt();
        System.out.println(diff(choose));


    }

    public static String Ent_X() {
        String loop = "";
        do {
            Scanner sc = new Scanner(System.in);
            xval.add(sc.nextDouble());
        }
        while (xval.get(xval.size() - 1) != -1000);
        {
            loop += "done";
            xval.remove(xval.size() - 1);
        }
        return loop;
    }

    public static String Ent_Fx() {
        String loop = "";
        do {
            Scanner sc = new Scanner(System.in);
            fxval.add(sc.nextDouble());
        }
        while (fxval.get(fxval.size() - 1) != -1000);
        {
            System.out.println("done ");
            fxval.remove(fxval.size() - 1);
        }
        return loop;
    }

    public static String diff(int choose) {
        String loop = "";
        Scanner input = new Scanner(System.in);
        double h = xval.get(xval.size() - 1) - xval.get(fxval.size() - 2);
        double x;

        if (choose == 1) {
            do {
                loop="Get derivative at X= ?/ (-1000) Exit";
                System.out.println(loop);
                x = input.nextDouble();
                double forward = 0;
                double backward = 0;
                int s = xval.indexOf(x);

                if (s == xval.size() - 1) {
                    backward = (f(x) - f(x - h)) / h;
                    loop=("backward Difference  at x = "+x+": "+backward+"\n");
                    System.out.println(loop);
                } else if (x == -1000) {
                    loop=("Exit");

                    break;
                } else {
                    forward = (f(x + h) - f(x)) / h;
                    loop=("Forward Difference  at x = "+x+": "+forward+"\n");
                    System.out.println(loop);
                }

            }
            while (x != -1000);


        } else if (choose == 2) {
            do {
                loop="Get derivative at X= ?/ (-1000) Exit";
                System.out.println(loop);
                x = input.nextDouble();
                double forward3point = 0;
                double backward3point = 0;
                double central = 0;
                int s = xval.indexOf(x);
                if (s == xval.size() - 1) {
                    backward3point = ((3 * f(x)) - (4 * f(x - h)) + f(x - (2 * h))) / (2 * h);
                    loop=("Backward 3-Point at x = "+x+": "+backward3point+"\n");
                    System.out.println(loop);
                } else if (s == 0) {
                    forward3point = ((-3 * f(x)) + (4 * f(x + h)) - f(x + (2 * h))) / (2 * h);
                    loop=("Forward 3-Point at x = "+x+": "+forward3point+"\n");
                    System.out.println(loop);
                } else if (x == -1000) {
                    loop="Exit";
                    break;
                } else {
                    central = (f(x + h) - f(x - h)) / (2 * h);
                    loop=("Central Difference  at x = "+x+": "+central+"\n");
                    System.out.println(loop);
                }
            }
            while (x != -1000);
        }
        return loop;
    }
}


