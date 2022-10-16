import java.util.Scanner;
import ComplexNumber.*;

class HW2APP_D1009331{
    public static void main(String[] args){
        Complex res = new Complex();
        Complex first = new Complex();
        Complex second = new Complex();

        int a, b;
        int c, d;
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the first complex number a + bi = ");
        a = sc.nextInt();
        b = sc.nextInt();

        System.out.print("Enter the second complex number c + di = ");
        c = sc.nextInt();
        d = sc.nextInt();

        if(b == 0){
            first = new Complex(a);
        }else{
            first = new Complex(a, b);
        }

        if(d == 0){
            second = new Complex(c);
        }else{
            second = new Complex(c, d);
        }

        System.out.print("The complex numbers are ");
        first.printComplex(); System.out.print(" and "); second.printComplex();
        System.out.println();
        
        System.out.println("\nAfter complex number arithmetic operations:");
        System.out.println("===================================");

        res = first.add(second);
        System.out.print("Complex addition: "); res.printOpeRes(); System.out.println();

        res = first.subtract(second);
        System.out.print("Complex subtraction: "); res.printOpeRes(); System.out.println();

        res = first.multiply(second);
        System.out.print("Complex multiplication: "); res.printOpeRes(); System.out.println();

        res = first.divide(second);
        System.out.print("Complex division: "); res.printOpeRes(); System.out.println();

        double abs1 = first.Absolute();
        System.out.printf("Absolute value of the first complex number: %.2f\n", abs1);
        System.out.println();

        double abs2 = second.Absolute();
        System.out.printf("Absolute value of the second complex number: %.2f\n", abs2);
    }
}