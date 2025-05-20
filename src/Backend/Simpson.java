package Backend;

import java.util.ArrayList;

public class Simpson {


    public static String Simpson(double a, double b, double n) {
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
        String inbetweenEvenString = " [ ";
        String inbetweenOddString = " [ ";
        double inbetweenEven = 0;
        double inbetweenOdd = 0;
        for (int i = 1; i < x.size()-1; i++) {
            if ((x.size()-1) % 2 == 0) {
                if (i == (x.size()-1) - 1) {
                    inbetweenOddString += fx.get(i) + " ] ";
                    inbetweenEvenString += "] ";

                    break;
                }
            } else {
                if (i == (x.size() - 1) - 1) {
                    inbetweenEvenString += fx.get(i) + " ] ";
                    inbetweenOddString += "] ";
                    break;
                }
            }


            if (i % 2 == 0) {
                inbetweenEven += fx.get(i);
                inbetweenEvenString += fx.get(i) + " + ";
            } else {
                inbetweenOdd += fx.get(i);
                inbetweenOddString += fx.get(i) + " + ";
            }
        }
        answer = step/3 * (fx.get(0) + fx.get(x.size()-1) + 4 * (inbetweenOdd) + 2 *(inbetweenEven));
        mainLoop += step + "/3 * ( "+fx.get(0)+ " + " + fx.get(x.size()-1) + " + 4 *" + inbetweenOddString + " + 2 *"+inbetweenEvenString+")";
        mainLoop += "\n = " + answer;

        return mainLoop;
    }

}
