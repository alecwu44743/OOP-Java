import java.util.Scanner;

public class _0920_Arithmetic_Operations_GPA_Con{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        double per, con;
        System.out.print("Enter the percentage: ");
        per = sc.nextDouble();

        con = (per / 100) * 4;
        System.out.printf("The GPA is %4.2f\n", con);
    }
}