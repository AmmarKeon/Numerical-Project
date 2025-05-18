import java.util.ArrayList;
import java.util.Scanner;

public class NewtonDividedDifference{
    static ArrayList<Double> xval = new ArrayList<>();
    static ArrayList<Double> fxval = new ArrayList<>();

    public static double f(double x) {
        for (int i = 0; i < xval.size(); i++) {
            if (Math.abs(xval.get(i) - x) < 1e-6) {
                return fxval.get(i);
            }
        }
        throw new IllegalArgumentException("x=" + x + " not found in data points");
    }

    public static double[][] dividedDifferenceTable(int n) {
        double[][] table = new double[n+1][n+1];


        for (int i = 0; i <= n; i++) {
            table[i][0] = fxval.get(i);
        }

        // Calc divided
        for (int j = 1; j <= n; j++) {
            for (int i = 0; i <= n - j; i++) {
                table[i][j] = (table[i+1][j-1] - table[i][j-1]) / (xval.get(i+j) - xval.get(i));
            }
        }

        return table;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //  numpoints
        System.out.print("Enter number of data points (n): ");
        int n = input.nextInt();

        //  x
        System.out.println("\nEnter x values:");
        for (int i = 0; i < n; i++) {
            System.out.print("x" + i + ": ");
            xval.add(input.nextDouble());
        }

        // f(x) values
        System.out.println("\nEnter f(x) values:");
        for (int i = 0; i < n; i++) {
            System.out.print("f(x" + i + "): ");
            fxval.add(input.nextDouble());
        }

        // D.input
        System.out.println("\nInput Data:");
        System.out.println("-------------------------");
        System.out.printf("%-6s | %-10s\n", "x", "f(x)");
        System.out.println("-------------------------");
        for (int i = 0; i < n; i++) {
            System.out.printf("%-6.2f | %-10.4f\n", xval.get(i), fxval.get(i));
        }

        // Calc divided
        int polynomialDegree = n - 1;
        double[][] ddTable = dividedDifferenceTable(polynomialDegree);

        System.out.println("\nDivided Difference Table:");
        System.out.println("--------------------------------------------------");
        for (int i = 0; i < n; i++) {
            System.out.printf("%-6.2f | ", xval.get(i));
            for (int j = 0; j < n - i; j++) {
                System.out.printf("%-10.4f ", ddTable[i][j]);
            }
            System.out.println();
        }

        System.out.println("\nNewton's Divided Difference Polynomial:");
        StringBuilder polynomial = new StringBuilder();
        polynomial.append("P").append(polynomialDegree).append("(x) = ");
        polynomial.append(String.format("%.4f", ddTable[0][0]));

        for (int i = 1; i <= polynomialDegree; i++) {
            polynomial.append(" + ").append(String.format("%.4f", ddTable[0][i]));
            for (int j = 0; j < i; j++) {
                polynomial.append("(x - ").append(String.format("%.2f", xval.get(j))).append(")");
            }
        }
        System.out.println(polynomial.toString());

        System.out.print("\nWould you like to see the simplified polynomial? (y/n): ");
        if (input.next().equalsIgnoreCase("y")) {
            System.out.println("\nSimplified Polynomial:");
            System.out.println("(Note: This requires manual calculation based on the divided differences)");
            System.out.println("Example format: 2x³ - 5x² + 3x - 4");
        }
    }
}