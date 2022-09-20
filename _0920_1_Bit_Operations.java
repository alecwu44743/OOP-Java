import java.util.Scanner;

public class _0920_1_Bit_Operations{

    private static void printBinary(int a) {
        for (int i=0; i<32; i++) { System.out.print((a>>(31-i))&1);
        if (i>0 & (i+1)%4==0) System.out.print(" ");
        } System.out.println();
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int a, b;

        System.out.print("Enter two integers (saparated by space): ");
        a = sc.nextInt();
        b = sc.nextInt();

        // a disjuction b
        System.out.print("a | b  =  ");
        printBinary(a|b);

        // a conjunction b
        System.out.print("a & b  =  ");
        printBinary(a&b);

        // a exclusive b
        System.out.print("a ^ b  =  ");
        printBinary(a^b);


        // right shift three bits of the first input integer
        System.out.print("a >> 3 =  ");
        printBinary(a>>3);


        // left shift three bits of the second input integer
        System.out.print("b << 3 =  ");
        printBinary(b<<3);

    }
}