import java.util.Scanner;
import ComplexNumber.*;

public class HW2APP_D1009331_equa{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter coefficient a: ");
        double a = sc.nextDouble();

        System.out.print("Enter coefficient b: ");
        double b = sc.nextDouble();

        System.out.print("Enter coefficient c: ");
        double c = sc.nextDouble();

        // System.out.print("Enter the first root r1: ");
        // double r1 = sc.nextDouble();

        // System.out.print("Enter the second root r2: ");
        // double r2 = sc.nextDouble();


        ComplexNumber.Complex.equation_root(a, b, c);
    }
}