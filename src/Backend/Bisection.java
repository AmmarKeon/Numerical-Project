package Backend;

public class Bisection {

    public static String BisectionMethod1(double a, double b) { // NOT DONE
        String loop = "";
        int i = 0;
        int max = 100;
        double c = 0;
        double fa = Math.pow(a, 4) + a + 9;
        double fb = Math.pow(b, 4) + b + 9;
        loop += "Solving X⁴ + X + 9 = 0 using Bisection Method\n";
        loop += "Iteration\t a\t b\t c\t f(c)\n";
        loop += "----------------------------------------------------------------------------------------\n";
        double epsilon = 1e-14;
        while (i < max) {
            c = (a+b)/2;
            double fc = Math.pow(c, 4.0) + c + 9.0; // f(c) = c⁴ + c + 9

            loop += i + "\t" +a+ "\t\t" +b+ "\t\t" +c+ "\t\t" +fc+"\n";
            // Check for convergence
            if (Math.abs(fa - fc) < epsilon) {
                loop += "\nRoot found: "+c+"\n";
                return loop;
            }

            if (fa * fc < 0) {
                b = c;
                fb = fc;
            } else {
                a = c;
                fa = fc;
            }

            i++;

        }
        return loop;
    }
}
