import java.util.Scanner;

public class _0920_Arithmetic_Operations_BMI{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        double h, w, bmi;

        System.out.print("Enter your height (m): ");
        h = sc.nextDouble();

        System.out.print("Enter your weight (kg): ");
        w = sc.nextDouble();

        bmi = w / (h * h);
        System.out.printf("BMI: %4.1f\n", bmi);
    }
}