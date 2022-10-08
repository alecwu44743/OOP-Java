import java.util.Scanner;


public class _1004_QuadraticEquation_guess{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        double a, b, c, x1, x2, delta;

        System.out.print("Enter a: ");
        a = sc.nextDouble();

        System.out.print("Enter b: ");
        b = sc.nextDouble();

        System.out.print("Enter c: ");
        c = sc.nextDouble();

        System.out.print("Enter the first root r1: ");
        x1 = sc.nextDouble();

        System.out.print("Enter the second root r2: ");
        x2 = sc.nextDouble();

        delta = b * b - 4 * a * c;
        if (delta < 0){
            System.out.printf("%.4f and %.4f are not the roots of equation %.4fx^2 + %.4fx + %.4f = 0\n", x1, x2, a, b, c);
            System.out.println("The equation has no real roots.");
        }
        else if (delta == 0){
            double ans = (-b) / (2 * a);
            if(x1 == ans && x2 == ans){
                System.out.printf("%.4f and %.4f are the roots of equation %.4fx^2 + %.4fx + %.4f = 0", x1, x2, a, b, c);
            }
            else{
                System.out.printf("%.4f and %.4f are not the roots of equation %.4fx^2 + %.4fx + %.4f = 0", x1, x2, a, b, c);
                System.out.println("The equation has one real root.");
                System.out.println("The equation has one root: " + ans);
            }
        }
        else{
            double ans1 = (-b + Math.sqrt(delta)) / (2 * a);
            double ans2 = (-b - Math.sqrt(delta)) / (2 * a);
            if((x1 == ans1 && x2 == ans2) || (x1 == ans2 && x2 == ans1)){
                System.out.printf("%.4f and %.4f are the roots of equation %.4fx^2 + %.4fx + %.4f = 0", x1, x2, a, b, c);
            }
            else{
                System.out.printf("%.4f and %.4f are not the roots of equation %.4fx^2 + %.4fx + %.4f = 0", x1, x2, a, b, c);
                System.out.println("The equation has two real roots.");
                System.out.println("The equation has two roots: " + ans1 + " and " + ans2);
            }
        }
    }
}