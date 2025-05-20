package Backend;

import java.util.ArrayList;

public class Romberg {



    public static String testRomberg(double a, double b, double n) {
        String mainLoop = "X    | ";
        ArrayList<Double> x = new ArrayList<>();
        ArrayList<Double> fx = new ArrayList<>();
        ArrayList<ArrayList<Double>> points = new ArrayList<>();
        points.add(new ArrayList<>());
        x.add(a);
        mainLoop += a+"\t";
        x.add(b);
        mainLoop += b+"\t";
        points.get(0).add( (a + b) / 2.0 );        // get(0)(0), '4'
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                x.add(points.get(i).get(i));
                mainLoop += points.get(i).get(i)+"\t";
            } else if (i == 1) {
                points.add(new ArrayList<>());
                points.get(1).add((a + points.get(0).get(0)) /2.0); // get(1)(0), '2'
                points.get(1).add((b + points.get(0).get(0)) /2.0); // get(1)(1), '6'
            } else if (i == 2) {
                points.add(new ArrayList<>());
                for (int j = 0; j < points.size(); j++) {
                    if (j == 0) {
                        points.get(2).add((a + points.get(1).get(j)) / 2.0);                    // get(2)(0), '1'
                        points.get(2).add((points.get(0).get(0) + points.get(1).get(j)) / 2.0); // get(2)(1), '3'
                    } else if (j == 1) {
                        points.get(2).add((points.get(0).get(0) + points.get(1).get(j)) / 2.0); // get(2)(2) '5'
                        points.get(2).add((b + points.get(1).get(j)) / 2.0);                   // get(2)(3), '7'

                    }

                }
            }
            else if (i == 3) {
                points.add(new ArrayList<>());
                for (int j = 0; j < points.size(); j++) {
                    if (j == 0) {
                        points.get(3).add((a + points.get(2).get(j)) / 2.0);
                        points.get(3).add((points.get(2).get(j) + points.get(1).get(j)) / 2.0);

                    } else if (j == 1) {
                        points.get(3).add( (points.get(2).get(j) + points.get(1).get(j-1)) / 2.0);
                        points.get(3).add( (points.get(2).get(j) + points.get(0).get(0))  / 2.0);
                    } else if (j == 2) {
                        points.get(3).add( (points.get(2).get(j) + points.get(0).get(0))  / 2.0 );
                        points.get(3).add( (points.get(2).get(j) + points.get(1).get(j-1)) / 2.0);
                    } else if (j == 3) {
                        points.get(3).add( (points.get(2).get(j) + points.get(1).get(j-2))  / 2.0);
                        points.get(3).add( (points.get(2).get(j) + b)  / 2.0);
                    }
                }
            }
        }
        for (int i = 1; i < points.size(); i++) {
            for (int j = 0; j < points.get(i).size(); j++) {
                x.add(points.get(i).get(j));
                mainLoop += points.get(i).get(j)+"\t";
            }
        }


        double temp;
        mainLoop += "\nF(x) | ";
        for (int i = 0; i < x.size(); i++) {
            temp = Math.pow(x.get(i), 2.0);
            fx.add(temp);
            mainLoop += temp+"\t";
        }
        mainLoop += "\n\n";



        double step = 4;
        double[][] array = new double[2][(int)n]; // [0] is for inbetween calculations and [1] is for I calculation
        double answer;
        double inbetween = 0;
        mainLoop += "I00 = ";
        inbetween += fx.get(2);
        String inbetweenString = "[ "+fx.get(2)+" ] ";
        array[0][0] = (fx.get(0) + fx.get(1) + (2.0 *(inbetween)));
        String tempString = fx.get(0) +" + "+fx.get(1)+" (2 * "+inbetweenString+")";
        answer = step/2 * array[0][0];
        mainLoop += step+ "/2 * "+tempString+"\n\n";
        array[1][0] = answer;




        for (int i = 0; i < n-1; i++) {
            step = step/2;
            double[][] temp1 = Trapezoidal(array[0][i], step, fx);
            mainLoop += "I0"+(i+1)+" = " +extraTrapezoidal(array[0][i], step, fx) + "\n\n";
            array[0][i+1] = temp1[0][0];
            array[1][i+1] = temp1[1][0];

        }

        double[][] iterations = new double[(int)n][(int)n]; //[n][m], [n] is for iteration count, [m] is I elements calculated in that
        // iteration

        for (int i = 0; i < n; i++) {
            iterations[0][i] = array[1][i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = i; j < iterations[i].length; j++) {
                iterations[i][j] = iterations[i-1][j] + ((1.0/((Math.pow(4.0, (j+1)-1)) - 1.0)) * (iterations[i-1][j] - iterations[i-1][j-1]));
                mainLoop += "I"+i+""+j+" = "+iterations[i-1][j]+ " + (1 / (4^"+(j+1)+"-1)) * "+iterations[i-1][j]+" - " + iterations[i-1][j-1]+" = "+ iterations[i][j]+"\n";

            }
            mainLoop += "\n";
        }
        mainLoop += " = " +iterations[((int)n-1)][((int)n-1)];

        return mainLoop;


    }



    // MODIFIED TRAPEZOIDAL METHOD FOR ROMBERG ITERATIONS
    public static double[][] Trapezoidal(double a, double step, ArrayList<Double> fx) {
        double[][] answer = new double[2][1];
        double inbetween = 0;
        double answerNum;
        if (step == 2) {
            for (int i = 3; i <= 4 ; i++) {
                inbetween += fx.get(i);
            }
        } else if (step == 1) {
            for (int i = 5; i <= 8 ; i++) {
                inbetween += fx.get(i);
            }
        } else if (step == 0.5) {
            for (int i = 9; i < fx.size(); i++) {
                inbetween += fx.get(i);
            }
        }
        answer[0][0] = (a + 2 *(inbetween));
        answerNum = step/2 * answer[0][0];
        answer[1][0] = answerNum;


        return answer;
    }

    public static String extraTrapezoidal(double a, double step, ArrayList<Double> fx) {
        String mainLoop = "";


        double[][] answer = new double[2][1];
        double inbetween = 0;
        String inbetweenString = "[ ";
        double answerNum;
        if (step == 2) {
            for (int i = 3; i <= 4 ; i++) {
                if (i == 4) {
                    inbetweenString += fx.get(i) +" ]";
                    break;
                }
                inbetweenString += fx.get(i) +" + ";
            }
        } else if (step == 1) {
            for (int i = 5; i <= 8 ; i++) {
                if (i == 8) {
                    inbetweenString += fx.get(i) +" ]";
                    break;
                }
                inbetweenString += fx.get(i) +" + ";
            }
        } else if (step == 0.5) {
            for (int i = 9; i < fx.size(); i++) {
                if (i == fx.size()-1) {
                    inbetweenString += fx.get(i) +" ]";
                    break;
                }
                inbetweenString += fx.get(i) +" + ";
            }
        }
        answer[0][0] = (a + 2 *(inbetween));
        String tempString = a +" + 2 * "+inbetweenString;
        answerNum = step/2 * answer[0][0];
        mainLoop += step+ "/2 * "+tempString;
        answer[1][0] = answerNum;



        return mainLoop;
    }


}
