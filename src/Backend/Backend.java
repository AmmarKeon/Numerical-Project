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
                "\n3- Trapezoidal Method" +
                "\n4- Newton Method" +
                "\n5- Lagradge Interpolation Method" +
                "\n6- Secant Method");
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
                Thread.sleep(2000);
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
        } else if (MethodChoice == 2) {
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


        } else if (MethodChoice == 3) {
            System.out.println("\nchoose the equation you want to test");
            System.out.println("1- 1 / 9 + X²" +
                    "\n2- ");
            equationChoice = input.nextInt();
            if (equationChoice == 1) {
                System.out.println("₀|³ 1 / 9 + X² dx");
                double a = 0;
                double b = 3;
                System.out.println(Trapezoidal(a, b));
            }


        } else if (MethodChoice == 4) {

        } else if (MethodChoice == 5) {
            System.out.println("\nchoose number of elements in the table: ");
            int number = input.nextInt();
            ArrayList<Double> x = new ArrayList<>();
            ArrayList<Double> fx = new ArrayList<>();
            double targetX;
            for (int i = 0; i < number; i++) {
                System.out.print("\nenter X #"+(i+1)+" value: ");
                x.add(input.nextDouble());
            }
            for (int i = 0; i < number; i++) {
                System.out.print("\nenter fx #"+(i+1)+" value: ");
                fx.add(input.nextDouble());
            }

            System.out.println("enter the value of X you want to calculate: ");
            targetX = input.nextDouble();
            System.out.println(Largradge(x,fx,targetX));
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
        double c = (a+b)/2;
        System.out.println("a"+i+" - b"+i+" - c"+i+
                "\n"+a+" - "+b+" - "+c);
        double epsilon = 1e-15;
        while (Math.abs(c - a) > epsilon && Math.abs(c - b) > epsilon) {
            if (c < 0) {
                a = c;
            } else if (c > 0) {
                b = c;
            }
        }

    }

    public static void BisectionMethod2(double a, double b) {}

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

    public static String Trapezoidal(double a, double b) {
        String mainLoop = "";
        ArrayList<Double> x = new ArrayList<>();
        ArrayList<Double> fx = new ArrayList<>();
        double count = a;
        double h = 0.5;
        for (double i = a; i < 100; i++) {
            if (count <= b) {
                x.add(count);
                count += h;
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
        answer = h/2 * (fx.get(0) + fx.get(x.size()-1) + 2 *(inbetween));

        return mainLoop + answer;
    }




}
