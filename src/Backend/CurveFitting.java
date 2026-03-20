package Backend;

public class CurveFitting {

    //Curvefitting
    public static void curveFittingExample() {

    System.out.println("=== Curve Fitting Example (Linear Regression) ===");

        double[] x = {1, 3, 4, 6, 8, 9, 11, 14};
        double[] y = {1, 2, 4, 4, 5, 7, 8, 9};
        int n = x.length;

        double sumX = 0, sumY = 0, sumXY = 0, sumX2 = 0;

        for (int i = 0; i < n; i++) {
            sumX += x[i];
            sumY += y[i];
            sumXY += x[i] * y[i];
            sumX2 += x[i] * x[i];
        }

        double a = (n * sumXY - sumX * sumY) / (n * sumX2 - sumX * sumX);
        double b = (sumY - a * sumX) / n;

        System.out.printf("Best fit line: y = %.4fx + %.4f%n", a, b);

        double xVal = 2;
        double yVal = a * xVal + b;
        System.out.printf("Estimated y at x = %.2f: y = %.4f%n", xVal, yVal);
        System.out.println();
    }

}
