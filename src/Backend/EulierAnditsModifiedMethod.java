import java.util.Scanner;

public class EulierAnditsModifiedMethod {
    public static void main(String[] args) {
//        System.out.println("1st order :");
//        System.out.println("dy/dx = x+y");
//        Scanner input = new Scanner(System.in);
//        System.out.println("Find value of y when x = ?");
//        double x_end = input.nextDouble();
//        System.out.println("Given that y(x) ? x:y");
//        double x_start = input.nextDouble();
//        double y_start = input.nextDouble();
//        System.out.println("h ?");
//        float h = input.nextFloat();
//        System.out.printf("y(%.1f) = %f\n",x_start,y_start);
//
//        int iterations =0;
//        do{
//            y_start = y_start + h*(x_start+y_start);
//            x_start = x_start + h;
//
//            System.out.printf("y(%.1f) = ",x_start);
//            System.out.print(y_start+"\n");
//
//            iterations++;
//        }while (x_start <= x_end);

        System.out.println("4th order :");
        System.out.println("dy/dx = x+y^2");
        Scanner input = new Scanner(System.in);
        System.out.println("Find value of y when x = ?");
        double x_end = input.nextDouble();
        System.out.println("Given that y(x) ? x:y");
        double x_start = input.nextDouble();
        double y_start = input.nextDouble();
        System.out.println("h ?");
        float h = input.nextFloat();
        System.out.printf("y(%.1f) = %f\n",x_start,y_start);
        double k0,k1,k2,k3;

        int iterations =0;
        do{
            k0 = h*(x_start +(y_start*y_start));
            k1 = h*(x_start+(0.5*h)+Math.pow((y_start+(0.5*k0)),2));
            k2 = h*(x_start+(0.5*h)+Math.pow((y_start+(0.5*k1)),2));
            k3 = h*(x_start+h+Math.pow((y_start+(k2)),2));
            y_start = y_start +(1/6.0) * (k0+(2*k1)+(2*k2)+k3);
            x_start = x_start + h;

            System.out.printf("y(%.1f) = ",x_start);
            System.out.print(y_start+"\n");

            iterations++;
        }while (x_start <= x_end);

    }
}
