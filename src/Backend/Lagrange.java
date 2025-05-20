package Backend;

import java.util.ArrayList;

public class Lagrange {

    public static String Largrange(ArrayList<Double> x, ArrayList<Double> fx, double targetX) {
        String mainLoop = "Table : \nX    |\t";
        double product = 0;
        double mult;
        for (int i = 0; i < x.size(); i++) {
            mainLoop += x.get(i) + "\t";
        }
        mainLoop += "\nF(x) |\t";
        for (int i = 0; i < x.size(); i++) {
            mainLoop += fx.get(i) + "\t";
        }
        mainLoop += "\n\n";

        for (int i = 0; i < x.size(); i++) {
            mult = 1;
            mainLoop += "[ ";
            for (int j = 0; j < x.size(); j++) {
                if (i != j) {
                    mult *= ((targetX - x.get(j)) / (x.get(i) - x.get(j)));
                    mainLoop +=
                            "((" + targetX + " - " + x.get(j) + ") / (" + x.get(i) + " - " + x.get(j) + ")) * ";
                }
            }
            mainLoop += " ] * ";
            mainLoop += fx.get(i) + "\n";
            mult *= fx.get(i);
            product += mult;
            if (i == x.size() - 1) {
                break;
            }
            mainLoop += " + \n";
        }
        mainLoop += " = " + product;
        return mainLoop;
    }

}
