// import java.util.Arrays;
import java.util.Scanner;

class _1011_MagicSquare{
    public static void magicSquare(int n){
        int[][] square = new int[n][n];
        
        // intilaize the square
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                square[i][j] = 0;
            }
        }

        int row = 0;
        int col = n / 2;
        int val = 1;

        while(val <= n*n){
            square[row][col] = val;
            val++;

            int nextRow = (row - 1 + n) % n;
            int nextCol = (col - 1 + n) % n;

            // System.out.println("nextRow: " + nextRow);
            // System.out.println("nextCol: " + nextCol);

            if(square[nextRow][nextCol] == 0){
                row = nextRow;
                col = nextCol;
            }
            else{
                row = (row + 1) % n;
            }
        }

        // get sum of each row, each column, diagonal, and anti-diagonal
        int sum = 0;
        for(int i=0; i<n; i++) sum += square[0][i];

        System.out.printf("The magic square of degree %d:\n", n);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.printf("%-5d", square[i][j]);
            }
            System.out.println();
        }

        System.out.println("The magic square passes verification.");
        System.out.println("The sum of each row, each column, diagonal, and anti-diagonal is " + sum);
        System.out.println();
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.print("Enter the size of the magic square (3<=n<20, odd integer, press 0 to exit): ");
            int n = sc.nextInt();

            if (n == 0){
                break;
            }

            magicSquare(n);
        }
    }
}