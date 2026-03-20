package Backend;

import java.util.Scanner;

public class GaussQuadrature {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String FX = "(2(X)+(3/(X)))^2";
        System.out.println("F(X)= "+FX);
        System.out.println("Enter the intial and the end points in the quadrature: X: [intial,end] ");
        int x0 = input.nextInt();
        int x1 = input.nextInt();
        double a , b ;
        a = (x0+x1)/2.0;
        b = (x1-x0)/2.0;
        System.out.println("X="+a+"+("+b+")X" +
                "d");
        String x =a+"+("+b+")Xd";
        String FXX = FX.replace("X",x);
        System.out.println("FXd= "+FXX+"(0.5)");
        double w0 , w1 , w2;
        double x0Value;
        double x1Value;
        double x2Value;
        double GaussResult;
        int c = input.nextInt();
        switch (c){
            case 1:
                GaussResult = 2*f(0);
                System.out.println("I = 2 F(0) = "+GaussResult);
                break;
            case 2:
                w0 =1;
                w1 = 1;
                x0Value= -(1/Math.sqrt(3));
                x1Value= (1/Math.sqrt(3));
                GaussResult = w0*f(x0Value)+w1*f(x1Value);
                System.out.println("I = W0 F(X0)+ W1 F(X1)) = "+GaussResult);
                break;
            case 3:
                w0 = 5/9.0;
                w1 = 8/9.0;
                w2 = 5/9.0;
                x0Value= -Math.sqrt(3/5.0);
                x1Value= 0;
                x2Value= Math.sqrt(3/5.0);
                GaussResult = w0*f(x0Value)+w1*f(x1Value)+w2*f(x2Value);
                System.out.println("I = W0 F(X0)+ W1 F(X1)+ W2 F(X2) = "+GaussResult);
                break;

                default:
                    System.out.println("Invalid input");
                    break;

        }

    }
    public static double f(double x) {
        double result = Math.pow(2*(1.5+0.5*x)+(3/(1.5+0.5*x)),2)*0.5;
        return result;
    }



    public static String GaussQuadrature(double x0, double x1, double c) {
        String FX = "F(x) = (2(X)+(3/(X)))^2\n";
        double a , b ;
        a = (x0+x1)/2.0;
        b = (x1-x0)/2.0;
        String mainLoop = "";
        mainLoop += +a+"+("+b+")X" +
                "d";
        String x =a+"+("+b+")Xd";
        String FXX = FX.replace("X",x);
        mainLoop += "FXd= "+FXX+"(0.5)\n";
        double w0 , w1 , w2;
        double x0Value;
        double x1Value;
        double x2Value;
        double GaussResult;
        switch ((int)c){
            case 1:
                GaussResult = 2*f(0);
                mainLoop += "I = 2 F(0) = "+GaussResult+"\n";
                break;
            case 2:
                w0 =1;
                w1 = 1;
                x0Value= -(1/Math.sqrt(3));
                x1Value= (1/Math.sqrt(3));
                GaussResult = w0*f(x0Value)+w1*f(x1Value);
                mainLoop += "I = W0 F(X0)+ W1 F(X1)) = "+GaussResult+"\n";
                mainLoop += w0 +" * " +f(x0Value)+ " + "+w1+" * " + f(x1Value)+"\n";
                break;
            case 3:
                w0 = 5/9.0;
                w1 = 8/9.0;
                w2 = 5/9.0;
                x0Value= -Math.sqrt(3/5.0);
                x1Value= 0;
                x2Value= Math.sqrt(3/5.0);
                GaussResult = w0*f(x0Value)+w1*f(x1Value)+w2*f(x2Value);
                mainLoop += "I = W0 F(X0)+ W1 F(X1)+ W2 F(X2) = "+GaussResult+"\n";
                mainLoop += w0 +" * "+f(x0Value)+" + "+w1+ " * " + f(x1Value)+ " + "+w2+" * " +f(x2Value)+ "\n";
                break;

            default:
                mainLoop += "Invalid input";
                break;

        }
        return mainLoop;
    }



}
