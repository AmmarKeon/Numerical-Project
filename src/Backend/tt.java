package Backend;

import java.util.Arrays;
import java.util.Scanner;

public class tt {
    public static void main(String[] args) {


        // modified more general
        System.out.println("System Of Linear Equation:\n");
        System.out.println("        5X1 - X2 + X3 = 10");
        System.out.println("        2X1 + 8X2 - X3 = 11");
        System.out.println("        -X1 + X2 + 4X3 = 3");
        System.out.println("Enter coefficients :");

        Scanner input = new Scanner(System.in);
        double a1 = input.nextDouble();
        double a2 = input.nextDouble();
        double a3 = input.nextDouble();
        double a4 = input.nextDouble();
        double b1 = input.nextDouble();
        double b2 = input.nextDouble();
        double b3 = input.nextDouble();
        double b4 = input.nextDouble();
        double c1 = input.nextDouble();
        double c2 = input.nextDouble();
        double c3 = input.nextDouble();
        double c4 = input.nextDouble();
        double [][] AR = {
                {a1, a2, a3,a4},
                {b1, b2, b3,b4},
                {c1, c2, c3,c4}
        };

        if (!isDiagonallyDominant(AR)){
            AR = makeDiagonallyDominant(AR);
        }
        print2DArray(AR);
         a1 = AR[0][0];
         a2 = AR[0][1];
         a3 = AR[0][2];
         a4 = AR[0][3];
         b1 = AR[1][0];
         b2 = AR[1][1];
         b3 = AR[1][2];
         b4 = AR[1][3];
         c1 = AR[2][0];
         c2 = AR[2][1];
         c3 = AR[2][2];
         c4 = AR[2][3];

        double X1_0 = 0, X2_0 = 0, X3_0 = 0; // Initial guess
        double A = X1_0, B = X2_0, C = X3_0; // Previous values

        double tolerance = 1e-14;
        Jacobi(a1,a2,a3,a4,b1,b2,b3,b4,c1,c2,c3,c4,X1_0,X2_0,X3_0, tolerance);
        System.out.println("if you want to modify system of linear equation by Gauss Seidle : y/n");
        char choice = input.next().charAt(0);
        if (choice == 'y') {Gauss_Seidle(a1,a2,a3,a4,b1,b2,b3,b4,c1,c2,c3,c4,X1_0,X2_0,X3_0,A,B,C,tolerance);}


    }
    public static boolean isDiagonallyDominant(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            double sum = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                if (i != j) {
                    sum += Math.abs(matrix[i][j]);
                }
            }
            if (Math.abs(matrix[i][i]) <= sum) {
                return false;
            }
        }
        return true;
    }
    public static double[][] makeDiagonallyDominant(double[][] matrix) {
        int n = matrix.length;
        double[][] newMatrix = new double[n][n];
        boolean[] used = new boolean[n];

        // Find the best pivot row for each position
        for (int col = 0; col < n; col++) {
            int bestRow = -1;
            double bestValue = -1;

            for (int row = 0; row < n; row++) {
                if (!used[row]) {
                    double diagonal = Math.abs(matrix[row][col]);
                    double sum = 0;

                    for (int j = 0; j < n; j++) {
                        if (j != col) {
                            sum += Math.abs(matrix[row][j]);
                        }
                    }

                    // Prefer rows where diagonal is much larger than sum
                    double dominanceRatio = diagonal - sum;
                    if (dominanceRatio > bestValue) {
                        bestValue = dominanceRatio;
                        bestRow = row;
                    }
                }
            }

            if (bestRow == -1) {
                throw new RuntimeException("Cannot make matrix diagonally dominant");
            }

            newMatrix[col] = matrix[bestRow];
            used[bestRow] = true;
        }

        return newMatrix;
    }
    public static void print2DArray(double[][] array) {
        // Determine the maximum width needed for each column
        int[] colWidths = new int[array[0].length];
        for (int j = 0; j < array[0].length; j++) {
            int maxWidth = 0;
            for (int i = 0; i < array.length; i++) {
                String s =""+array[i][j];
                if (s.length() > maxWidth) {
                    maxWidth = s.length();
                }
            }
            colWidths[j] = maxWidth;
        }

        // Print the array with aligned columns
        for (int i = 0; i < array.length; i++) {
            System.out.print("[ ");
            for (int j = 0; j < array[i].length; j++) {
                String formatted = ""+array[i][j];
                System.out.print(formatted);
                if (j < array[i].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println(" ]");
        }
    }
        public static String Jacobi(double a1 ,double a2,double a3,double a4,double b1,double b2,double b3,double b4,double c1 , double c2 ,double c3 ,double c4,double X1_0 ,double X2_0 ,double X3_0 , double tolerance) {
            String loop = "";
            double Ax, BY, CZ;
            int Iterations = 0;
            double A, B, C;

            do {
// Store previous values
                A = X1_0;
                B = X2_0;
                C = X3_0;

// Update new values using Jacobi iteration
                X1_0 = (1.0 / a1) * (a4 - (a2 * B) - (a3 * C));
                X2_0 = (1.0 / b2) * (b4 - (b1 * A) - (b3 * C));
                X3_0 = (1.0 / c3) * (c4 - (c1 * X1_0) - (c2 * B));

// Compute differences
                Ax = X1_0 - A;
                BY = X2_0 - B;
                CZ = X3_0 - C;

                Iterations++;
                loop += "Iteration " + Iterations + ":\n";
                loop += "X1 = " + X1_0 + "\n";
                loop += "X2 = " + X2_0 + "\n";
                loop += "X3 = " + X3_0 + "\n";
                loop += "--------------------------- \n";


            } while (Math.abs(Ax) > tolerance && Math.abs(BY) > tolerance && Math.abs(CZ) > tolerance);

            loop += "\nFinal Solution: \n";
            loop += "X1 = " + Math.floor(X1_0) + "\n";
            loop += "X2 = " + Math.floor(X2_0) + "\n";
            loop += "X3 = " + Math.ceil(X3_0) + "\n";
            loop += "Total Iterations: " + Iterations + "\n";

            return loop;
        }
    public static void Gauss_Seidle(double a1 ,double a2,double a3,double a4,double b1,double b2,double b3,double b4,double c1 , double c2 ,double c3 ,double c4,double X1_0 ,double X2_0 ,double X3_0 ,double A ,double B ,double C , double tolerance) {
        double Ax, BY, CZ;
        int Iterations = 0;

        System.out.println("System Of Linear Equation:\nGauss Seidle:");


        do {
// Store previous values
            A = X1_0;
            B = X2_0;
            C = X3_0;

// Update new values using Jacobi iteration
            X1_0 = (1.0 / a1) * (a4 - (a2 * B) - (a3 * C));
            X2_0 = (1.0 / b2) * (b4 - (b1 * X1_0) - (b3 * C));
            X3_0 = (1.0 / c3) * (c4 - (c1 * X1_0) - (c2 * X2_0));

// Compute differences
            Ax = X1_0 - A;
            BY = X2_0 - B;
            CZ = X3_0 - C;

            Iterations++;
            System.out.println("Iteration " + Iterations + ":");
            System.out.println("X1 = " + X1_0);
            System.out.println("X2 = " + X2_0);
            System.out.println("X3 = " + X3_0);
            System.out.println("------------------");


        } while (Math.abs(Ax) > tolerance && Math.abs(BY) > tolerance && Math.abs(CZ) > tolerance);

        System.out.println("\nFinal Solution:");
        System.out.println("X1 = " + Math.floor(X1_0));
        System.out.println("X2 = " + Math.floor(X2_0));
        System.out.println("X3 = " + Math.ceil(X3_0));
        System.out.println("Total Iterations: " + (Iterations-1));
    }
}
 ///////////////////////////////////////////////////////////////////////////


