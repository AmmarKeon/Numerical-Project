package Backend;

public class Hally {

    public static double f(double x) {
        return Math.exp(x) - x - 1;
    }

    public static double fdash(double x) {
        return Math.exp(x) - 1;
    }

    public static double fDoubledash(double x) {
        return Math.exp(x);
    }

    public static double halleysMethod(double initialGuess, double tolerance) {
        double x = initialGuess;
        int iteration = 0;

        System.out.println("Halley's Method for f(x) = e^x - x - 1");
        System.out.printf("Initial guess: x0 = %.15f%n", x);


        while (true) {
            iteration++;
            double fx = f(x);
            double fp = fdash(x);
            double fpp = fDoubledash(x);

            double numerator = 2 * fx * fp;
            double denominator = 2 * fp * fp - fx * fpp;

            if (Math.abs(denominator) < 1e-100) {
                System.out.println("Warning: Denominator too small, possible division by zero");
                break;
            }

            double delta = numerator / denominator;
            double xNew = x - delta;

            System.out.printf("x%d = %.15f (Δ = %.3e)%n", iteration, xNew, delta);

            if (Math.abs(delta) < tolerance) {
                System.out.printf("Converged after %d iterations%n", iteration);
                return xNew;
            }

            x = xNew;
        }

        return x;
    }

    public static void main(String[] args) {
        double x0 = 1.0;
        double tolerance = 1e-16;

        double root = halleysMethod(x0, tolerance);
        System.out.printf("Final root approximation: %.15f%n", root);
        System.out.println("Note: The exact root is x = 0.0");
    }
}

