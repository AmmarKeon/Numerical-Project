package Backend;

public class FixedPoint {

    public static String FixedPoint1(double Xo) {
        String loop = "";
        double Xn;
        int i = 0;
        double epsilon = 1e-15;
        Xn = Math.sqrt(Math.cos(Xo));
        loop += "x"+i+" = " + Xn + "\n";
        while (Math.abs(Xo - Xn) > epsilon) {
            Xo = Xn;
            i++;
            Xn = Math.sqrt(Math.cos(Xn));
            loop += "x"+i+" = " + Xn + "\n";
            if (i > 20000) {
                loop += "Warning: Exceeded maximum iterations \n";
                break;
            }
        }
        loop += "converges after #"+i+" iterations to "+Xn;
        return loop;
    }

    public static String FixedPoint2(double Xo) {
        String loop = "";
        double Xn;
        int i = 0;
        double epsilon = 1e-15;
        Xn = Math.PI + (1.0/2.0) * Math.sin(Xo/2);
        loop += "x"+i+" = " + Xn+ "\n";
        while (Math.abs(Xo - Xn) > epsilon) {
            Xo = Xn;
            i++;
            Xn = Math.PI + (1.0/2.0) * Math.sin(Xn/2);
            loop += "x"+i+" = " + Xn+ "\n";
            if (i > 20000) {
                loop += "Warning: Exceeded maximum iterations \n";
                break;
            }
        }
        loop += "\nconverges after #"+i+" iterations to "+Xn;
        return loop;
    }
}
