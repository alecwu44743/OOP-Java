import java.util.Scanner;
import RationalNumber.*;


public class cal_RN{
    public static void print_Rational(RationalNumber a, RationalNumber b, RationalNumber c, RationalNumber d, RationalNumber e){
        System.out.println("a = " + a.PN * a.numerator + "/" + a.denominator);
        System.out.println("b = " + b.PN * b.numerator + "/" + b.denominator);
        System.out.println("c = " + c.PN * c.numerator + "/" + c.denominator);
        System.out.println("d = " + d.PN * d.numerator + "/" + d.denominator);
        System.out.println("e = " + e.PN * e.numerator + "/" + e.denominator);
        System.out.println("");
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        String str;

        System.out.print("a = ");
        str = sc.nextLine();
        RationalNumber a = new RationalNumber(str);

        System.out.print("b = ");
        str = sc.nextLine();
        RationalNumber b = new RationalNumber(str);

        System.out.print("c = ");
        str = sc.nextLine();
        RationalNumber c = new RationalNumber(str);

        System.out.print("d = ");
        str = sc.nextLine();
        RationalNumber d = new RationalNumber(str);

        System.out.print("e = ");
        str = sc.nextLine();
        RationalNumber e = new RationalNumber(str);
        

        System.out.println("\n----------------------------------------------\n");

        // System.out.print("Print by method of cal_RN.java: \n");
        // print_Rational(a, b, c, d, e);
        
        // System.out.print("Print by method of class of RationalNumber: \n");
        // System.out.print("a = "); a.printRational();
        // System.out.print("b = "); b.printRational();
        // System.out.print("c = "); c.printRational();
        // System.out.print("d = "); d.printRational();

        // System.out.println("\n----------------------------------------------\n");

        // System.out.print("a + b = "); a.add(b);
        // System.out.print("c - d = "); c.subtract(d);
        // System.out.print("a * b = "); a.multiply(b);
        // System.out.print("c / d = "); c.divide(d);
        // System.out.print("|e| = "); e.ratAbsolute();
        RationalNumber res = new RationalNumber("0/1");
        System.out.print("a + b = "); res = a.add(b); res.printRational();
        System.out.print("c - d = "); res = c.subtract(d); res.printRational();
        System.out.print("a * b = "); res = a.multiply(b); res.printRational();
        System.out.print("c / d = "); res = c.divide(d); res.printRational();
        System.out.print("|e| = "); res = e.Absolute(); res.printRational();
        System.out.print("a*|d-b|-(b+c/a)*|b*e-c/d| = "); res = res.complexArithmetic(a, b, c, d, e); res.printRational();
    }
}