import java.util.Scanner;

public class _0920_Arithmetic_Operations_F2C{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        double f, c;

        System.out.print("Enter the temperature in Fahrenheit: ");
        f = sc.nextDouble();

        c = (f - 32) * 5 / 9;
        System.out.printf("The temperature in Celsius is %6.2f\n", c);
    }
}