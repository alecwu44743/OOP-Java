import java.util.Scanner;

public class Mexam_skeleton_2APP{
    public static void main(String[] args){
        int n; // Row size and Column size of square matrices A, b, and C.
        int ra, sa; // Lower bandwidth and upper bandwidth of matrix A.
        int rb, sb; // Lower bandwidth and upper bandwidth of matrix B.
        // Lower bandwidth and upper bandwidth of matrix C are ra+rb and sa+sb, respectively.
        Scanner in = new Scanner(System.in); // Initial an input stream.

        //TODO: Add some code here for input data
        do {
            System.out.print("Enter integers n for square matrix size: ");
            n = in.nextInt(); // Row and column size of square matrices.
            System.out.print("Enter lower bandwidth and upper bandwidth of matrix A: ");
            ra = in.nextInt(); // Lower bandwidth matrix A.
            sa = in.nextInt(); // Upper bandwidth matrix A.
            System.out.print("Enter lower bandwidth and upper bandwidth of matrix B: ");
            rb = in.nextInt(); // Lower bandwidth matrix B.
            sb = in.nextInt(); // Upper bandwidth matrix B.
        } while (n <= 0 | ra < 0 | sa < 0 & rb < 0 | sb < 0 | ra >= n | sa >= n | rb >= n | sb >= n);

        Mexam_skeleton_2Class a = new Mexam_skeleton_2Class(n, ra, sa);
        a.init_value();
        a.print_matrix();

        Mexam_skeleton_2Class b = new Mexam_skeleton_2Class(n, rb, sb);
        b.init_value();

        Mexam_skeleton_2Class c = a.matrix_product_banded(b, rb, sb);

        System.out.println("Matrix A:");
        a.print_matrix();

        System.out.println("Matrix B:");
        b.print_matrix();

        System.out.println("Matrix C:");
        c.print_matrix();
    }

}