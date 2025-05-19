package Backend;


import java.util.ArrayList;
import java.util.Scanner;


// ² √ ½ π ⁻ ¹
public class Backend {
    public static void main(String[] args) throws InterruptedException {
        int equationChoice;
        Scanner input = new Scanner(System.in);
        System.out.println("choose the method you want to test");
        System.out.println("1- Fixed Point" +
                "\n2- Bisection Method" +
                "\n3- Trapezoidal Integration Method" +
                "\n4- Newton Method" +
                "\n5- Lagradge Interpolation Method" +
                "\n6- Simpson Integration Method" +
                "\n7- Romberg Integration Method");
        int MethodChoice = input.nextInt();
        if (MethodChoice == 1) {
            System.out.println("\nchoose the equation you want to test");
            System.out.println("1- Cos(x) - x² = 0" +
                    "\n2- 2Sin⁻¹(2x-2π) = 0");
            equationChoice = input.nextInt();
            if (equationChoice == 1) {
                System.out.println("\n get X alone to solve the equation:" +
                        "\n- x² = cos(x)" +
                        "\n-> x = √cos(x)   - Xo = 1");
                double Xo = 1;
                FixedPoint1(Xo);

            } else if (equationChoice == 2) {
                System.out.println("\n get X alone to solve the equation:" +
                        "\n- x = 2Sin⁻¹(2x-2π)" +
                        "\n-> x/2 = Sin⁻¹(2x-2π)" +
                        "\n--> Sin(x/2) = 2x-2π" +
                        "\n---> 2x = 2π + Sin(x/2)" +
                        "\n----> X = π + ½ Sin(x/2)     - Xo = π");
                double Xo = Math.PI;
                Thread.sleep(2000);
                FixedPoint2(Xo);
            }
        }

        else if (MethodChoice == 2) {
            System.out.println("\nchoose the equation you want to test");
            System.out.println("1- X⁴ - X - 10 = 0" +
                    "\n2- ");
            equationChoice = input.nextInt();
            if (equationChoice == 1) {
                System.out.println("X⁴ - X - 10 = 0    - Over [1,2]");
                double a = 1;
                double b = 2;
                BisectionMethod1(a, b);
            }


        }

        else if (MethodChoice == 3) {
            System.out.println("\nchoose the equation you want to test");
            System.out.println("1- 1 / 9 + X²" +
                    "\n2- ");
            equationChoice = input.nextInt();
            if (equationChoice == 1) {
                System.out.println("₀|³ 1 / 9 + X² dx");
                double a = 0;
                double b = 3;
                double n = 6;
                System.out.println(Trapezoidal(a, b, n));
            }


        }

        else if (MethodChoice == 4) {}

        else if (MethodChoice == 5) {
            System.out.println("\nchoose number of elements in the table: ");
            int number = input.nextInt();
            ArrayList<Double> x = new ArrayList<>();
            ArrayList<Double> fx = new ArrayList<>();
            double targetX;
            for (int i = 0; i < number; i++) {
                System.out.print("\nenter X #" + (i + 1) + " value: ");
                x.add(input.nextDouble());
            }
            for (int i = 0; i < number; i++) {
                System.out.print("\nenter fx #" + (i + 1) + " value: ");
                fx.add(input.nextDouble());
            }

            System.out.println("enter the value of X you want to calculate: ");
            targetX = input.nextDouble();
            System.out.println(Largradge(x, fx, targetX));
        }

        else if (MethodChoice == 6) {
            System.out.println("\nchoose the equation you want to test");
            System.out.println("1 - ₀|³ 1 / 9 + X² dx" +
                    "\n2- ");
            equationChoice = input.nextInt();
            if (equationChoice == 1) {
                System.out.println("₀|³ 1 / 9 + X² dx");
                double a = 0;
                double b = 3;
                double n = 6;
                System.out.println(Simpson(a, b, n));
            }
        }

        else if (MethodChoice == 7) {
            System.out.println("\nchoose the equation you want to test");
            System.out.println("1 - ₀|⁸ X² dx" +
                    "\n2- ");
            equationChoice = input.nextInt();
            if (equationChoice == 1) {
                System.out.println("₀|⁸ X² dx");
                double a = 0.0;
                double b = 8.0;
                double n = 4.0;
                System.out.println("ANSWER TO ROMBERG IS : "+testRomberg(a, b, n));
            }
        }

    }

    // x = √cos(x)
    public static void FixedPoint1(double Xo) {
        double Xn;
        int i = 0;
        double epsilon = 1e-15;
        Xn = Math.sqrt(Math.cos(Xo));
        System.out.println("x"+i+" = " + Xn);
        while (Math.abs(Xo - Xn) > epsilon) {
            Xo = Xn;
            i++;
            Xn = Math.sqrt(Math.cos(Xn));
            System.out.println("x"+i+" = " + Xn);
            if (i > 20000) {
                System.out.println("Warning: Exceeded maximum iterations");
                break;
            }
        }
        System.out.println("converges after #"+i+" iterations to "+Xn);
    }



    // X = π + ½ Sin(x/2)
    public static void FixedPoint2(double Xo) {
        double Xn;
        int i = 0;
        double epsilon = 1e-15;
        Xn = Math.PI + (1.0/2.0) * Math.sin(Xo/2);
        System.out.println("x"+i+" = " + Xn);
        while (Math.abs(Xo - Xn) > epsilon) {
            Xo = Xn;
            i++;
            Xn = Math.PI + (1.0/2.0) * Math.sin(Xn/2);
            System.out.println("x"+i+" = " + Xn);
            if (i > 20000) {
                System.out.println("Warning: Exceeded maximum iterations");
                break;
            }
        }
        System.out.println("converges after #"+i+" iterations to "+Xn);
    }

    public static void BisectionMethod1(double a, double b) { // NOT DONE

        int i = 0;
        int max = 100;
        double c = 0;
        double fa = Math.pow(a, 4) + a + 9;
        double fb = Math.pow(b, 4) + b + 9;
        System.out.println("Solving X⁴ + X + 9 = 0 using Bisection Method");
        System.out.println("Iteration\t\t\t a\t\t\t b\t\t\t c\t\t\t f(c)");
        System.out.println("-------------------------------------------------------");
        double epsilon = 1e-14;
        while (i < max) {
            c = (a+b)/2;
            double fc = Math.pow(c, 4.0) + c + 9.0; // f(c) = c⁴ + c + 9

            System.out.println(i + "\t\t\t" +a+ "\t\t\t" +b+ "\t\t\t" +c+ "\t\t\t" +fc);
            // Check for convergence
            if (Math.abs(fa - fc) < epsilon) {
                System.out.println("\nRoot found: "+c+"\n");
                return;
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

    }


    public static String Largradge(ArrayList<Double> x, ArrayList<Double> fx, double targetX) {
        String mainLoop = "";
        double product = 0;
        double mult;
        for (int i = 0; i < x.size(); i++) {
            mult = 1;
            for (int j = 0; j < x.size(); j++) {
                if (i != j) {
                    mult *= ((targetX - x.get(j)) / (x.get(i) - x.get(j)));
                    mainLoop +=
                            "((" + targetX + " - " + x.get(j) + ") / (" + x.get(i) + " - " + x.get(j) + ")) * ";
                }
            }
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

    public static String Trapezoidal(double a, double b, double n) {
        String mainLoop = "";
        ArrayList<Double> x = new ArrayList<>();
        ArrayList<Double> fx = new ArrayList<>();
        double count = a;
        double step = (b-a) / n;
        for (double i = a; i < 100; i++) {
            if (count <= b) {
                x.add(count);
                count += step;
            }
        }
        double temp;
        for (int i = 0; i < x.size(); i++) {
            temp = (1 / (9 + Math.pow(x.get(i), 2)));
            fx.add(temp);
        }

        double answer;
        double inbetween = 0;
        for (int i = 1; i < x.size()-1; i++) {
            inbetween += fx.get(i);
        }
        answer = step/2 * (fx.get(0) + fx.get(x.size()-1) + 2 *(inbetween));

        return mainLoop + answer;
    }


    public static String Simpson(double a, double b, double n) {
        String mainLoop = "";
        ArrayList<Double> x = new ArrayList<>();
        ArrayList<Double> fx = new ArrayList<>();
        double count = a;
        double step = (b-a) / n;
        for (double i = a; i < 100; i++) {
            if (count <= b) {
                x.add(count);
                count += step;
            }
        }
        double temp;
        for (int i = 0; i < x.size(); i++) {
            temp = (1 / (9 + Math.pow(x.get(i), 2)));
            fx.add(temp);
        }

        double answer;
        double inbetweenEven = 0;
        double inbetweenOdd = 0;
        for (int i = 1; i < x.size()-1; i++) {
            if (i % 2 == 0) {
                inbetweenEven += fx.get(i);
            } else {
                inbetweenOdd += fx.get(i);
            }
        }
        answer = step/3 * (fx.get(0) + fx.get(x.size()-1) + 4 * (inbetweenOdd) + 2 *(inbetweenEven));

        return mainLoop + answer;
    }


    // MODIFIED TRAPEZOIDAL METHOD FOR ROMBERG ITERATIONS
    public static double[][] extraTrapezoidal(double a, double step, ArrayList<Double> x, ArrayList<Double> fx) {
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




    public static double testRomberg(double a, double b, double n) {

        ArrayList<Double> x = new ArrayList<>();
        ArrayList<Double> fx = new ArrayList<>();
        ArrayList<ArrayList<Double>> points = new ArrayList<>();
        points.add(new ArrayList<>());
        x.add(a);
        x.add(b);
        points.get(0).add( (a + b) / 2.0 );        // get(0)(0), '4'
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                x.add(points.get(i).get(i));
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
            }
        }


        double temp;
        for (int i = 0; i < x.size(); i++) {
            temp = Math.pow(x.get(i), 2.0);
            fx.add(temp);
        }



        double step = 4;
        double[][] array = new double[2][(int)n]; // [0] is for inbetween calculations and [1] is for I calculation
        double answer;
        double inbetween = 0;
        inbetween += fx.get(2);
        array[0][0] = (fx.get(0) + fx.get(1) + (2.0 *(inbetween)));
        answer = step/2 * array[0][0];
        array[1][0] = answer;




        for (int i = 0; i < n-1; i++) {
            step = step/2;
            double[][] temp1 = extraTrapezoidal(array[0][i], step, x, fx);
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
            }
        }

        return iterations[((int)n-1)][((int)n-1)];


    }




}
