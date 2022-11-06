import java.util.Scanner;

import java.math.BigInteger;
import BigHexInteger.BigHexInteger;


public class BiHexInteger_APP {

    public static void main(String[] args) {
        // Create a string Array
        // String[] bi = new String[6];
        // bi[0] = "121"; // BigInteger
        // bi[1] = "-12"; // BigHexInteger
        // bi[2] = "-23"; // BigInteger
        // bi[3] = "FF"; // BigHexInteger
        // bi[4] = "45"; // BigInteger
        // bi[5] = "3A"; // BigHexInteger

        BigInteger[] bi = new BigInteger[6];
        bi[0] = new BigInteger("121");      // a
        bi[1] = new BigHexInteger("-12");    // b
        bi[2] = new BigInteger("-23");      // c
        bi[3] = new BigHexInteger("FF");   // d
        bi[4] = new BigInteger("45");       // e
        bi[5] = new BigHexInteger("3A");    // f


        // sum of bi
        BigHexInteger ans_bhi = new BigHexInteger("0");
        BigInteger ans_bi = new BigInteger("0");
        for (int i = 0; i < bi.length; i++) { 
            ans_bhi = ans_bhi.add(bi[i]);
            ans_bi = ans_bi.add(bi[i]);
        }

        System.out.println("bi[0] =121 (BigInteger)");
        System.out.println("bi[1] =-12 (BigHexInteger)");
        System.out.println("bi[2] =-23 (BigInteger)");
        System.out.println("bi[3] =FF (BigHexInteger)");
        System.out.println("bi[4] =45 (BigInteger)");
        System.out.println("bi[5] =3A (BigHexInteger)");

        System.out.println();

        System.out.println("Sum of BigInteger = " + ans_bi.toString().toUpperCase());
        System.out.println("Sum of BigHexInteger = " + ans_bhi.toString().toUpperCase());
    }
}