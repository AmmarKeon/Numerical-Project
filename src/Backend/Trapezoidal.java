package Backend;

import java.util.ArrayList;

public class Trapezoidal {

    public static String Trapezoidal(double a, double b, double n) {
        String mainLoop = "X    | ";
        ArrayList<Double> x = new ArrayList<>();
        ArrayList<Double> fx = new ArrayList<>();
        double count = a;
        double step = (b-a) / n;
        for (double i = a; i < 100; i++) {
            if (count <= b) {
                x.add(count);
                mainLoop += count + "\t\t\t\t";
                count += step;
            }
        }
        mainLoop += "\nF(x) | ";
        double temp;
        for (int i = 0; i < x.size(); i++) {
            temp = (1 / (9 + Math.pow(x.get(i), 2)));
            mainLoop += temp + "\t";
            fx.add(temp);
        }
        mainLoop += "\n";

        double answer;
        double inbetween = 0;
        String inbetweenString = " [ ";
        for (int i = 1; i < x.size()-1; i++) {
            if (i == (x.size() - 1) - 1) {
                inbetween += fx.get(i);
                break;
            }
            inbetween += fx.get(i);
            inbetweenString += fx.get(i) + " + ";
        }
        inbetweenString += fx.get((x.size() - 1)-1) + " ] ";
        answer = step/2 * (fx.get(0) + fx.get(x.size()-1) + 2 *(inbetween));
        mainLoop += step + "/2 * ( "+fx.get(0)+ " + " + fx.get(x.size()-1) + " + 2 *" + inbetweenString + ")";
        mainLoop += "\n = " + answer;

        return mainLoop;
    }
}
