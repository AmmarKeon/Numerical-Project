import java.util.Scanner;

public class Newton {

    public static double f(double x) {
        return Math.pow(Math.E,x) - x - 1;
    }

    public static double fdash(double x) {
        return Math.pow(Math.E,x) - 1;
    }

    public static void newtonRaphson(double x0) {
        System.out.println("Newton-Raphson Method for f(x) = e^X - X - 1");
        double x = x0;
        int i = 1;
        double tolerance = 1e-6;
            do{
                x = x - f(x) / fdash(x);
                System.out.printf("x%d = ", i);
                System.out.print(x+"\n");
                i++;
            }
            while (Math.abs(x - x0) > tolerance&&i!=21); {

            }


    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter X0 : ");
        double x0 = input.nextDouble();

        newtonRaphson(x0);
    }
}
