import java.util.Random; // Package for random number generator.
import java.util.Scanner; // Package for input stream.

public class Mexam_skeleton_2 {

	public static void main(String[] args) {
		int[][] A; // Matrix A.
		int[][] B; // Matrix B.
		int[][] C; // Matrix C.
		int n; // Row size and Column size of square matrices A, b, and C.
		int ra, sa; // Lower bandwidth and upper bandwidth of matrix A.
		int rb, sb; // Lower bandwidth and upper bandwidth of matrix B.
		// Lower bandwidth and upper bandwidth of matrix C are ra+rb and sa+sb,
		// respectively.
		Scanner in = new Scanner(System.in); // Initial an input stream.
		Random random = new Random(); // Initial a random number seed.
		int i, j; // Loop variables.

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

		//	TODO: Add some code here & Complete the program.
		A = new int[n][n];
		B = new int[n][n];
		C = new int[n][n];

		for(i = 0; i < n; i++) {
			for(j = 0; j < n; j++) {
				A[i][j] = 0;
				B[i][j] = 0;
				C[i][j] = 0;
			}
		}

		matrix_product_banded(A, B, C, n, ra, sa, rb, sb);

		in.close();
	}

	// Minimum function.
	private static int min(int m, int n) {
		if (m <= n)
			return m;
		else
			return n;
	}

	// Maximum function.
	private static int max(int m, int n) {
		if (m <= n)
			return n;
		else
			return m;
	}

	// Print matrix values
	private static void print_matrix(int[][] A, int n) {
		int i, j;
		for (i = 0; i < n; i++) {
			for (j = 0; j < n; j++) {
				if (A[i][j] != 0)
					System.out.printf("%6d ", A[i][j]);
				else
					System.out.printf("%6s ", " ");
			}
			System.out.println();
		}
	}

	// A: pointer to nxn banded matrix, 
	// B: pointer to nxn banded matrix, 
	// C: pointer to nxn banded matrix, 
	// ra: the lower bandwidth of matrix A, 
	// rb: the upper bandwidth of matrix A, 
	// sa: the lower bandwidth of matrix B, 
	// sb: the upper bandwidth of matrix B, 
	// ra+rb: the lower bandwidth of matrix C, 
	// sa+sb: the upper bandwidth of matrix C. 
	// Compute C=AxB using banded matrix multiplication algorithm.
	private static void matrix_product_banded(int[][] A, int[][] B, int[][] C, int n, int ra, int sa, int rb, int sb) {
		// ***** Complete this function.
		Random random = new Random();
		// int number = random.nextInt(max - min) + min;
		// random.nextInt(30 + 10) - 10;
		// max = 30; min = -10;
		
		// set A, B random values
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(i-j <= ra && i-j >= -sa) {
					int r = 0;
					while(r == 0){
						r = random.nextInt(50 - (-50)) + (-50);
					}

					A[i][j] = r;
				}
				if(i-j <= rb && i-j >= -sb) {
					int r = 0;
					while(r == 0){
						r = random.nextInt(50 - (-50)) + (-50);
					}

					B[i][j] = r;
				}
			}
		}

		// C = A*B
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				for(int k=max(0, max(i-ra, j-sb)); k<=min(n-1, min(i+sa, j+rb)); k++) {
					C[i][j] += A[i][k] * B[k][j];
				}
			}
		}

		System.out.println("Matrix A:");
		print_matrix(A, n);

		System.out.println("Matrix B:");
		print_matrix(B, n);

		System.out.println("Matrix C:");
		print_matrix(C, n);
	}

}