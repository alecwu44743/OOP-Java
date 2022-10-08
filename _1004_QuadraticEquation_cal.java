import java.util.Scanner;

public class _1004_QuadraticEquation_cal{
    static void cal(double a, double b, double c){
        double minB = -b;
        double _sqrt = b*b - 4*a*c;
        double twoA = 2*a;

        if(_sqrt < 0){
            _sqrt = Math.sqrt(Math.abs(_sqrt));
            System.out.printf("The equation of %.2fx^2 + %.2fx + %.2f has two complex roots: %.2f + %.2fi and %.2f - %.2fi\n", a, b, c, minB/(twoA), _sqrt/(twoA), minB/(twoA), _sqrt/(twoA));
            
        }
        else if(_sqrt == 0){
            System.out.printf("The equation of %.2fx^2 + %.2fx + %.2f has one root: %.2f\n", a, b, c, minB/(twoA));
        }
        else{
            _sqrt = Math.sqrt(_sqrt);
            System.out.printf("The equation of %.2fx^2 + %.2fx + %.2f has two real roots: %.2f and %.2f\n", a, b, c, (minB+_sqrt)/(twoA), (minB-_sqrt)/(twoA));
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