import java.util.Scanner;

public class _1004_QuadraticEquation_cal{
    static void cal(double a, double b, double c){
        double minB = -b;
        double _sqrt = b*b - 4*a*c;
        double twoA = 2*a;

        if(_sqrt < 0){
            _sqrt = Math.sqrt(Math.abs(_sqrt));
            System.out.printf("The equation of %.4fx^2 + %.4fx + %.4f has two complex roots: %.4f + %.4fi and %.4f - %.4fi\n", a, b, c, minB/(twoA), _sqrt/(twoA), minB/(twoA), _sqrt/(twoA));
            
        }
        else if(_sqrt == 0){
            System.out.printf("The equation of %.4fx^2 + %.4fx + %.4f has one root: %.4f\n", a, b, c, minB/(twoA));
        }
        else{
            _sqrt = Math.sqrt(_sqrt);
            System.out.printf("The equation of %.4fx^2 + %.4fx + %.4f has two real roots: %.4f and %.4f\n", a, b, c, (minB+_sqrt)/(twoA), (minB-_sqrt)/(twoA));
        }
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print(" Enter coefficient a: ");
        double a = sc.nextDouble();

        System.out.print(" Enter coefficient b: ");
        double b = sc.nextDouble();

        System.out.print(" Enter coefficient c: ");
        double c = sc.nextDouble();

        // System.out.print("Enter the first root r1: ");
        // double r1 = sc.nextDouble();

        // System.out.print("Enter the second root r2: ");
        // double r2 = sc.nextDouble();

        cal(a, b, c);
    }
}