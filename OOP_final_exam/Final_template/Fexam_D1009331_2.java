import java.util.Random; // Package for random number generator.
import java.util.Scanner; // Package for reading data.

public class Fexam_D1009331_2 {
	static int board[][] = new int[3][3]; // For example, A 3 by 3 game board.
	static int win_lose_draw = 0; // Game status, draw: 0, computer win: 1, user win: 2.

	public static void main(String[] args) {
		Random random = new Random(); // Initial a random number seed.
		Scanner in = new Scanner(System.in); // Initial an input stream.
		int player; // The starting play, 1: computer(X), 2: user(O).
		int step = 0; // Step counter
		int inx; // Cell index between 1 and 9.
		int row, col; // Row and column index of a cell.

		do {
			System.out.print("Choose the starting player (1: computer, 2: user): ");
			player = in.nextInt();
		} while (player != 1 & player != 2);

		// Print the initial game board, the number denotes the cell index.
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				board[i][j] = 0;
			}
		}
		printBoard(step);
		System.out.println();


		// Repeat the following steps if the game is not draw and there are unfilled cells.
		// (1) Check whether it is a computer move or a user move.
		// (2) If it is a computer move, select an unfilled cell index randomly;
		//     otherwise, as the user to input an unfilled cell index.
		// (3) After cell selection is completed, change the player, 
		//     print the new game board, and check win-lose-draw.

		do{
			step++;
			if(player % 2 == 1){
				System.out.println("Computer's turn:");

				do{
					row = random.nextInt(9) % 3;
					col = random.nextInt(9) % 3;
				}while(board[row][col] != 0);
				board[row][col] = 1;

				System.out.println("Enter an unfilled cell index (row): " + row);
				System.out.println("Enter an unfilled cell index (col): " + col);
			}
			else{
				System.out.println("User's turn:");

				while(true){
					System.out.print("Enter an unfilled cell index (row): "); row = in.nextInt();
					System.out.print("Enter an unfilled cell index (col): "); col = in.nextInt();

					if(board[row][col] != 0){
						System.out.println("The cell is filled, please enter again.");
					}
					else{
						board[row][col] = 2;
						break;
					}
				}
			}

			printBoard(step);
			System.out.println();
			check_win_lose_draw();

			if(win_lose_draw != 0) break;
			
			player++;
		}while(step <= 9);
		
		// ***** Complete the program.
		
		// Output the result of the game.
		if (win_lose_draw == 0)	System.out.println("*****Game is draw!");
		else if (win_lose_draw == 1)	System.out.println("*****The winner is computer!");
		else if (win_lose_draw == 2)	System.out.println("*****The winner is user!");
		
		in.close();
	}

	// Print the game board.
	// If step==0, print the initial game board with cell indexes;
	// otherwise, print blank is the cell is marked 0 (unselected), 
	// print 'X' if the cell is marked 1 (computer), 
	// and print 'O' if the cell is marked 2 (user).
	private static void printBoard(int step) {
		if (step == 0) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					board[i][j] = 0;
				}
			}
		}

		System.out.println("Game board:");
		System.out.printf(" %s | %s | %s \n", getMark(board[0][0]), getMark(board[0][1]), getMark(board[0][2]));
		System.out.println("-----------");
		System.out.printf(" %s | %s | %s \n", getMark(board[1][0]), getMark(board[1][1]), getMark(board[1][2]));
		System.out.println("-----------");
		System.out.printf(" %s | %s | %s \n", getMark(board[2][0]), getMark(board[2][1]), getMark(board[2][2]));
		System.out.println();
	}

	// Check three rows, three columns, the diagonal, and the anti-diagonal.
	// If no matches, win_lose_draw is 0;
	// otherwise, set win_lose_draw to be the matching mark, 1 for computer and 2 for user.
	private static void check_win_lose_draw() {
		
		// check the board
		for(int i=0; i<3; i++){
			if(board[i][0] == board[i][1] && board[i][1] == board[i][2]){
				win_lose_draw = board[i][0];
				return;
			}
			else if(board[0][i] == board[1][i] && board[1][i] == board[2][i]){
				win_lose_draw = board[0][i];
				return;
			}
		}

		if(board[0][0] == board[1][1] && board[1][1] == board[2][2]){
			win_lose_draw = board[0][0];
			return;
		}
		else if(board[0][2] == board[1][1] && board[1][1] == board[2][0]){
			win_lose_draw = board[0][2];
			return;
		}

		win_lose_draw = 0;
	}

	private static String getMark(int mark) {
		if (mark == 0) return " ";
		else if (mark == 1) return "X";
		else return "O";
	}
}
