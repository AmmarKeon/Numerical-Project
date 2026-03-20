package Backend;

import java.util.Arrays;

public class SYSTEM_OF_NON_LINEAR_EQUATION {

    public static String print2DArray(double[][] array) {
        // Determine the maximum width needed for each column
        String loop ="";
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
            loop+="[ ";
            for (int j = 0; j < array[i].length; j++) {
                loop+= ""+array[i][j];

                if (j < array[i].length - 1) {
                    loop+=", ";
                }
                loop+=" ]\n";
            }
        }
        return loop ;
    }
    /// /////////////////////////////////////////////////
    public static double[] gaussianElimination3x3(double[][] A, double[] b) {

        // Create augmented matrix
        double[][] augmented = new double[3][4];
        for (int i = 0; i < 3; i++) {
            System.arraycopy(A[i], 0, augmented[i], 0, 3);
            augmented[i][3] = b[i];
        }

        // Forward elimination
        for (int p = 0; p < 3; p++) {
            // Partial pivoting
            int max = p;
            for (int i = p + 1; i < 3; i++) {
                if (Math.abs(augmented[i][p]) > Math.abs(augmented[max][p])) {
                    max = i;
                }
            }
            double[] temp = augmented[p];
            augmented[p] = augmented[max];
            augmented[max] = temp;

            // Elimination
            for (int i = p + 1; i < 3; i++) {
                double factor = augmented[i][p]/augmented[p][p];
                for (int j = p; j < 4; j++) {
                    augmented[i][j] -= factor * augmented[p][j];
                }
            }
        }

        // Back substitution
        double[] solution = new double[3];
        for (int i = 2; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < 3; j++) {
                sum += augmented[i][j] * solution[j];
            }
            solution[i] = (augmented[i][3] - sum)/augmented[i][i];
        }

        return solution;
    }
    public static String SystemofnonLinear () {
        String loop = "";
        double [][] X = new double[3][1];
        double AX ;
        double AY ;
        double AZ ;
        int iterations = 0;
        double tolerance = 1e-16;
        do{

            double x = X[0][0];
            double y = X[1][0];
            double z = X[2][0];

            double [][] F_x = {
                    {(3 * x)- Math.cos(y*z) - 0.5} ,
                    {4*(x*x) - 625*(y*y) + (2*y) - 1},
                    {Math.pow(Math.E,-(x*y)) + (20*z) + ((10*Math.PI)- 3)/3}
            };
            double [][] DFX = {
                    { 3 , z*Math.sin(y*z) , y*Math.sin(y*z) },
                    { 8*x , -1250*y +2 , 0},
                    { -y*Math.pow(Math.E,-(x*y)) , -x*Math.pow(Math.E,-(x*y)) , 20}
            };



            double [] tem = new double[3];
            for (int i = 0; i < 3; i++) {
                tem [i] = - F_x[i][0];
            }


            double [] ζ = gaussianElimination3x3(DFX, tem);

            double [][]X1 = new double[3][1];
            for (int i = 0; i < 3; i++) {
                X1[i][0] = ζ[i]+X[i][0];
            }
            loop+="X"+iterations+":\n" ;
            loop+=print2DArray(X);
            iterations++;
            //defference of the new and old elements
            AX = X1[0][0]-X[0][0];
            AY = X1[1][0]-X[1][0];
            AZ = X1[2][0]-X[2][0];
            X = X1;

            loop+="\n";
        }
        while (Math.abs(AX) > tolerance && Math.abs(AY) > tolerance && Math.abs(AZ) > tolerance);
        loop+="\ntotal iterations: " + (iterations-1);
        return loop;
    }
}
