import java.util.Scanner;

public class Mexam_skeleton_1 {

	public static void main(String[] args) {
		int[][] square; // Two dimensional square matrix.
		Scanner in = new Scanner(System.in); // Initial an input stream.
		int n = 3; // Scale of the magic square, an odd number such that 3<=n<20.
		int start = 0; // Starting cell, at the center of 0: top row, 1: right-most column, 2: bottom row, 3: left-most column.		
		int move = 0; // Move step, 0: upper-left, 1: upper-right, 2: lower-right, 3: lower-left.
		int value = 1; // The first value to be filled to the magic square is 1.
		int row = 0, col = 0; // Row and column indexes. Initial to be the cell on the top-left corner.
		int total; // Total value, (1+n^2)n/2, of each row, each column, the diagonal, and the anti-diagonal.
		int sum; // To compute sum of rows, columns, the diagonal, and the anti-diagonal.
		int i, j; // Loop variables. 

		int r_offset = 0, c_offset = 0; // Row and column offsets.

		//TODO: Add some code here for input data
		do {
			System.out.print("Enter the size of the magic square (3<=n<20, odd integer): ");
			n = in.nextInt();
		} while (n<3 | n >20 | n%2==0); // 3<=n<20 and n is odd; otherwise, repeat the input.

		// Set the starting cell, at the center of 0: top row, 1: right-most column, 2: bottom row, 3: left-most column.
		do {
			System.out.println("Enter position of the starting cell at the center of");
			System.out.print("  0: top row, 1: right-most column, 2: bottom row, 3: left-most column: ");
			start = in.nextInt();
		} while (start<0 | start>3); // If start is invalid, repeat the input.

		// Set the move step, 0: upper-left, 1: upper-right, 2: lower-right, 3: lower-left.
		do {
			System.out.print("Set move step (0: upper-left, 1: upper-right, 2: lower-right, 3: lower-left): ");
			move = in.nextInt();
		} while (move<0 | move >3); // If move is invalid, repeat the input.
		
		//TODO: Add some code here & complete the program.
		if(start == 0) {
			row = 0;
			col = n/2;
		}
		else if(start == 1) {
			row = n/2;
			col = n-1;
		}
		else if(start == 2) {
			row = n-1;
			col = n/2;
		}
		else if(start == 3) {
			row = n/2;
			col = 0;
		}

		if(move == 0) {
			r_offset = -1;
			c_offset = -1;
		}
		else if(move == 1) {
			r_offset = -1;
			c_offset = 1;
		}
		else if(move == 2) {
			r_offset = 1;
			c_offset = 1;
		}
		else if(move == 3) {
			r_offset = 1;
			c_offset = -1;
		}

		square = new int[n][n];
		for(int ii=0; ii<n; ii++) {
			for(int jj=0; jj<n; jj++) {
				square[ii][jj] = 0;
			}
		}

		while(value <= n*n){
			square[row][col] = value;
			value++;
			
			int nextRow = (row + r_offset + n) % n;
			int nextCol = (col + c_offset + n) % n;

			if(square[nextRow][nextCol] == 0) {
				row = nextRow;
				col = nextCol;
			}
			else {
				row = (row - r_offset + n) % n;
			}
		}
		
		// ToDo: Print the magic square.
		System.out.printf("The magic square of degree %d:\n", n); // Heading message.
		for (i=0; i<n; i++) { // Output n rows.
	        System.out.print("      "); // Leave 6 blanks on the left-hand-side.
			for (j=0; j<n; j++) { // output n columns.
				System.out.printf("%4d", square[i][j]); // Print the value of a cell, 4-digit format.			
			}
			System.out.print("\n");
		}
		
		// ToDo: Start to verify magic square.
		// Verify all rows.
		total = (1+n*n)*n/2; // Total value of each row, each column, the diagonal, and the anti-diagonal.
		for (i=0; i<n; i++) { // For each row.
			sum = 0; // Reset sum to 0.
			for (j=0; j<n; j++) { // For each column.
				sum += square[i][j]; // Add the value of the cell to sum.
			}
			if (sum != total) { // If sum is not equal to total, the magic square is invalid.
				System.out.printf("The magic square is invalid: sum of row %d is %d, not %d.\n", i, sum, total);
				return; // Exit the program.
			}
		}

		boolean rowValid = false;
		boolean colValid = false;
		boolean diagValid = false;
		boolean antiDiagValid = false;


		// Verify all columns.	
		for (j=0; j<n; j++) { // For each column.
			sum = 0; // Reset sum to 0.
			for (i=0; i<n; i++) { // For each row.
				sum += square[i][j]; // Add the value of the cell to sum.
			}
			if (sum != total) { // If sum is not equal to total, the magic square is invalid.
				System.out.printf("The magic square is invalid: sum of column %d is %d, not %d.\n", j, sum, total);
				// return; // Exit the program.
			}
		}
		colValid = true;

		// Verify all rows.
		for (i=0; i<n; i++) { // For each row.
			sum = 0; // Reset sum to 0.
			for (j=0; j<n; j++) { // For each column.
				sum += square[i][j]; // Add the value of the cell to sum.
			}
			if (sum != total) { // If sum is not equal to total, the magic square is invalid.
				System.out.printf("The magic square is invalid: sum of row %d is %d, not %d.\n", i, sum, total);
				// return; // Exit the program.
			}
		}
		rowValid = true;

		// Verify diagonals. 
		sum = 0; // Reset sum to 0.
		for (i=0; i<n; i++) { // For each row.
			sum += square[i][i]; // Add the value of the cell to sum.
		}
		if (sum != total) { // If sum is not equal to total, the magic square is invalid.
			System.out.printf("The magic square is invalid: sum of diagonal is %d, not %d.\n", sum, total);
			// return; // Exit the program.
		}
		else{
			diagValid = true;
		}

		// Verify anti-diagonals.	
		sum = 0; // Reset sum to 0.
		for (i=0; i<n; i++) { // For each row.
			sum += square[i][n-1-i]; // Add the value of the cell to sum.
		}
		if (sum != total) { // If sum is not equal to total, the magic square is invalid.
			System.out.printf("The magic square is invalid: sum of anti-diagonal is %d, not %d.\n", sum, total);
			// return; // Exit the program.
		}
		else{
			antiDiagValid = true;
		}

		// If all verification pass.
		// System.out.println("\nThe magic square passes verification.");
		// System.out.printf("The sum of each row and each column is %d.\n", total);
		// System.out.printf("The sum of at least one diaginal is %d.\n", total);
		// System.out.printf("The sum of at least one anti-diaginal is %d.\n", total);

		if(rowValid && colValid && diagValid && antiDiagValid) {
			System.out.println("\nThe magic square passes verification.");
		}
		else {
			System.out.println("\nThe magic square does not pass verification.");
		}

		if(rowValid && colValid) {
			System.out.printf("The sum of each row and each column is %d.\n", total);
		}
		else {
			if(rowValid) {
				System.out.printf("The sum of each row is %d.\n", total);
				// System.out.printf("The sum of each column is not %d.\n", total);
			}
			else{
				// System.out.printf("The sum of each row is not %d.\n", total);
				System.out.printf("The sum of each column is %d.\n", total);
			}
		}

		if(diagValid) {
			System.out.printf("The sum of at least one diaginal is %d.\n", total);
		}

		if(antiDiagValid) {
			System.out.printf("The sum of at least one anti-diaginal is %d.\n", total);
		}
		
		in.close();
	}
}
