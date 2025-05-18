package Backend;

public class FalsePosition {

    // False Position
    public static double f(double x) {
        return (x * x * x*x )- x -10;  // Example: f(x) = x³ - x - 2
    }

    //False Position
    public static String FalsePosition(double a, double b) {
        String loop = "=== False Position Method with Tolerance ===\n";

        double tolerance = 1e-5;
        double c = a;
        double prevC;
        int iteration = 0;

        if (f(a) * f(b) >= 0) {
            loop += "Invalid initial interval: f(a) and f(b) must have opposite signs.\n";
            return loop;
        }

        do {
            prevC = c;
            c = b - (b - a) * f(b) / (f(b) - f(a));
            double fc = f(c);

            loop += "Iteration \t" + (iteration + 1) +
                    ":\t a=" + a +
                    ",\t b=" + b +
                    ",\t c=" + c +
                    ",\t f(c)=" + fc +"\n";

            if (f(a) * fc < 0) {
                b = c;
            } else {
                a = c;
            }

            iteration++;
        } while (Math.abs(c - prevC) > tolerance);

        loop += "Approximate root after " + iteration +
                " iterations: x ≈ " + c;
        return loop;
    }

}
