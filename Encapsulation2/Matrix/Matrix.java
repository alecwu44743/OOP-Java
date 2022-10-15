package Matrix;

import java.util.Scanner;


public class Matrix{
    private int matrix[][];
    private int row;
    private int col;

    public Matrix(int _row, int _col){
        this.row = _row;
        this.col = _col;
        this.matrix = new int[this.row][this.col];
    }

    public void init(){
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < this.row; i++){
            for(int j = 0; j < this.col; j++){
                this.matrix[i][j] = sc.nextInt();
            }
        }
    }

    public Matrix add(Matrix m){
        Matrix res = new Matrix(this.row, this.col);

        if(this.row != m.row || this.col != m.col){
            System.out.println("The two matrices are not the same size.");
            return res;
        }

        for(int i = 0; i < this.row; i++){
            for(int j = 0; j < this.col; j++){
                res.matrix[i][j] = this.matrix[i][j] + m.matrix[i][j];
            }
        }

        return res;
    }

    public Matrix sub(Matrix m){
        Matrix res = new Matrix(this.row, this.col);

        if(this.row != m.row || this.col != m.col){
            System.out.println("The two matrices are not the same size.");
            return res;
        }

        for(int i = 0; i < this.row; i++){
            for(int j = 0; j < this.col; j++){
                res.matrix[i][j] = this.matrix[i][j] - m.matrix[i][j];
            }
        }

        return res;
    }

    public Matrix mul(Matrix m){
        Matrix res = new Matrix(this.row, m.col);

        if(this.col != m.row){
            System.out.println("The two matrices are not the same size.");
            return res;
        }

        for(int i = 0; i < this.row; i++){
            for(int j = 0; j < m.col; j++){
                for(int k = 0; k < this.col; k++){
                    res.matrix[i][j] += this.matrix[i][k] * m.matrix[k][j];
                }
            }
        }

        return res;
    }

    public void print(){
        for(int i = 0; i < this.row; i++){
            for(int j = 0; j < this.col; j++){
                System.out.print(this.matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}