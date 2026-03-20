package Backend;

import java.util.ArrayList;


public class differential {

    public static double f(double Xn, ArrayList<Double> x, ArrayList<Double> fx) {

        for (int i = 0; i < x.size(); i++) {

            if (Math.abs(x.get(i) - Xn) < 1e-14) {
                return fx.get(i);
            }
        }
        throw new IllegalArgumentException("x=" + Xn + "x not found");
    }


    public static String diff(ArrayList<Double> x, ArrayList<Double> fx, double Xn, int choose) {
        String loop = "";
        double h = x.get(2)-x.get(1);

        if (choose == 1) {
            double forward = 0;
            double backward = 0;
            int s = x.indexOf(Xn);

            if (s == x.size() - 1) {
                backward = (f(Xn, x, fx) - f((Xn - h), x, fx)) / h;
                loop += "backward Difference  at x = " + Xn + " is " + backward + "\n";
            } else {
                forward = (f((Xn + h), x, fx) - f(Xn, x, fx)) / h;
                loop += "Forward Difference  at x = " + Xn + " is " + forward + "\n";

            }


        } else if (choose == 2) {
            double forward3point = 0;
            double backward3point = 0;
            double central = 0;
            int s = x.indexOf(Xn);
            if (s == x.size() - 1) {
                backward3point = ((3 * f(Xn, x, fx)) - (4 * f((Xn - h), x, fx)) + f((Xn - (2 * h)), x, fx) / (2 * h));
                loop += "Backward 3-Point at x = " + Xn + " is " + backward3point + "\n";
            } else if (s == 0) {
                forward3point = ((-3 * f(Xn, x, fx)) + (4 * f((Xn + h), x, fx)) - f((Xn + (2 * h)), x, fx) / (2 * h));
                loop += "Forward 3-Point at x = " + Xn + " is " + forward3point + "\n";
            } else {
                central = ((f((Xn + h), x, fx) - f((Xn - h), x, fx)) / (2 * h));
                loop += "Central Difference  at x = " + Xn + " is " + central + "\n";
            }
        }
        return loop;
    }
}


