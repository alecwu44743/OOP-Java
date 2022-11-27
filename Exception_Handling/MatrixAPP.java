import java.util.Random;

interface MxInterface{
    public Matrix add(Matrix b);
    public Matrix subtract(Matrix b);
    public Matrix multiply(Matrix b);
    public Matrix transposition();
}


class Matrix implements MxInterface{
    public double [][] mx;
    public int r;
    public int c;

    public Matrix(int r, int c){
        this.r = r;
        this.c = c;
        mx = new double[r][c];

        init();
    }

    private void init(){
        Random rn = new Random();

        for(int i=0; i<this.r; i++){
            for(int j=0; j<this.c; j++){
                // double number range in 0 to 1
                mx[i][j] = rn.nextDouble() * 1;
            }
        }
    }

    public Matrix add(Matrix b){
        Matrix temp = new Matrix(this.r, this.c);
        boolean exceptionOccurred = false;

        try{
            if(this.r != b.r || this.c != b.c){
                System.out.println(">>>> Catch matrix operation exceptions.");
                MatrixException mEx = new MatrixException("Addition: mismatch matrix size." );
                throw mEx;
            }

            for(int i=0; i<this.r; i++){
                for(int j=0; j<this.c; j++){
                    temp.mx[i][j] = this.mx[i][j] + b.mx[i][j];
                }
            }
        }
        catch(MatrixException e){
            System.out.println(e.getMessage());
            exceptionOccurred = true;
        }

        finally{
            if(exceptionOccurred){
                System.out.println("******************************");
            }
        }

        return temp;
    }

    public Matrix subtract(Matrix b){
        Matrix temp = new Matrix(this.r, this.c);
        boolean exceptionOccurred = false;

        try{
            if(this.r != b.r || this.c != b.c){
                System.out.println(">>>> Catch matrix operation exceptions.");
                MatrixException mEx = new MatrixException("Subtraction: mismatch matrix size." );
                throw mEx;
            }

            for(int i=0; i<this.r; i++){
                for(int j=0; j<this.c; j++){
                    temp.mx[i][j] = this.mx[i][j] - b.mx[i][j];
                }
            }
        }
        catch(MatrixException e){
            System.out.println(e.getMessage());
            exceptionOccurred = true;
        }

        finally{
            if(exceptionOccurred){
                System.out.println("******************************");
            }
        }

        return temp;
    }

    public Matrix multiply(Matrix b){
        Matrix temp = new Matrix(this.r, b.c);
        boolean exceptionOccurred = false;

        try{
            if(this.c != b.r){
                System.out.println(">>>> Catch matrix operation exceptions.");
                MatrixException mEx = new MatrixException("Multiplication: mismatch matrix size." );
                throw mEx;
            }

            for(int i=0; i<this.r; i++){
                for(int j=0; j<b.c; j++){
                    for(int k=0; k<this.c; k++){
                        temp.mx[i][j] += this.mx[i][k] * b.mx[k][j];
                    }
                }
            }
        }
        catch(MatrixException e){
            System.out.println(e.getMessage());
            exceptionOccurred = true;
        }

        finally{
            if(exceptionOccurred){
                System.out.println("******************************");
            }
        }

        return temp;
    }

    public Matrix transposition(){
        Matrix temp = new Matrix(this.c, this.r);

        for(int i=0; i<this.r; i++){
            for(int j=0; j<this.c; j++){
                temp.mx[j][i] = this.mx[i][j];
            }
        }

        return temp;
    }


    public void print(){
        for(int i=0; i<this.r; i++){
            for(int j=0; j<this.c; j++){
                System.out.printf("%7.4f  ", this.mx[i][j]);
            }
            System.out.println();
        }

        System.out.println("======================");
    }

    public class MatrixException extends Exception{
        public MatrixException(){}
    
        public MatrixException(String message){
            super(message);
        }
    }

    public double determinant(){
        double det = 0;
        boolean exceptionOccurred = false;

        try{
            if(this.r != this.c){
                System.out.println(">>>> Catch matrix operation exceptions.");
                MatrixException mEx = new MatrixException("Determinant: not a square matrix." );
                throw mEx;
            }

            if(this.r == 1){
                det = this.mx[0][0];
            }
            else if(this.r == 2){
                det = this.mx[0][0] * this.mx[1][1] - this.mx[0][1] * this.mx[1][0];
            }
            else{
                for(int i=0; i<this.r; i++){
                    Matrix temp = new Matrix(this.r-1, this.c-1);
                    for(int j=0; j<this.r-1; j++){
                        for(int k=0; k<this.c-1; k++){
                            if(k < i){
                                temp.mx[j][k] = this.mx[j+1][k];
                            }
                            else{
                                temp.mx[j][k] = this.mx[j+1][k+1];
                            }
                        }
                    }

                    det += Math.pow(-1, i) * this.mx[0][i] * temp.determinant();
                }
            }
        }
        catch(MatrixException e){
            System.out.println(e.getMessage());
            exceptionOccurred = true;
        }

        finally{
            if(exceptionOccurred){
                System.out.println("******************************");
            }
        }

        return det;
    }
}


class VectorRow extends Matrix{
    public VectorRow(int c){
        super(1, c);
    }

    public void getVector(Matrix mx, int index){
        boolean exceptionOccurred = false;

        try{
            if(index >= mx.r){
                System.out.println(">>>> Catch row vector exceptions.");
                MatrixException mEx = new MatrixException("Row " + index + " does not exist." );
                throw mEx;
            }

            // System.out.printf("Row %d of Matrix %s: \n", index, name);
            for(int i=0; i<mx.c; i++){
                this.mx[0][i] = mx.mx[index][i];
                System.out.printf("%7.4f  ", this.mx[0][i]);
            }
            System.out.printf("\n======================");
        }
        catch(MatrixException e){
            System.out.println(e.getMessage());
            exceptionOccurred = true;
        }

        finally{
            if(exceptionOccurred){
                System.out.println("******************************");
            }
        }
    }

    public double innerProduct(VectorRow b){
        double temp = 0;
        boolean exceptionOccurred = false;

        try{
            if(this.c != b.c){
                System.out.println(">>>> Catch inner product row vector length mismatch exception.");
                MatrixException mEx = new MatrixException("The two row vectors are not of the same length." );
                throw mEx;
            }

            for(int i=0; i<this.c; i++){
                temp += this.mx[0][i] * b.mx[0][i];
            }
        }
        catch(MatrixException e){
            System.out.println(e.getMessage());
            exceptionOccurred = true;
        }

        finally{
            if(exceptionOccurred){
                System.out.println("******************************");
            }
        }

        return temp;
    }
}


class VectorCol extends Matrix{
    public VectorCol(int r){
        super(r, 1);
    }

    public void getVector(Matrix mx, int index){
        boolean exceptionOccurred = false;

        try{
            if(index >= mx.c){
                System.out.println(">>>> Catch column vector exceptions.");
                MatrixException mEx = new MatrixException("Column " + index + " does not exist." );
                throw mEx;
            }

            // System.out.printf("Column %d of Matrix %s: \n", index, name);
            for(int i=0; i<mx.r; i++){
                this.mx[i][0] = mx.mx[i][index];
                System.out.printf("%7.4f  \n", this.mx[i][0]);
            }
            System.out.printf("======================");
        }
        catch(MatrixException e){
            System.out.println(e.getMessage());
            exceptionOccurred = true;
        }

        finally{
            if(exceptionOccurred){
                System.out.println("******************************");
            }
        }
    }

    public double innerProduct(VectorCol b){
        double temp = 0;
        boolean exceptionOccurred = false;

        try{
            if(this.r != b.r){
                System.out.println(">>>> Catch inner product column vector length mismatch exception.");
                MatrixException mEx = new MatrixException("The two column vectors are not of the same length." );
                throw mEx;
            }

            for(int i=0; i<this.r; i++){
                temp += this.mx[i][0] * b.mx[i][0];
            }
        }
        catch(MatrixException e){
            System.out.println(e.getMessage());
            exceptionOccurred = true;
        }

        finally{
            if(exceptionOccurred){
                System.out.println("******************************");
            }
        }

        return temp;
    }
}


public class MatrixAPP{
    public static void main(String[] args){
        Matrix A = new Matrix(6, 4);
        Matrix B = new Matrix(6, 4);
        Matrix C = new Matrix(4, 6);

        System.out.println();
        System.out.println("Matrix A:");
        A.print();

        System.out.println();
        System.out.println("Matrix B:");
        B.print();

        System.out.println();
        System.out.println("Matrix C:");
        C.print();

        System.out.println();
        System.out.println("Matrix A+B:");
        A.add(B).print();
        
        System.out.println();
        System.out.println("Matrix A-B:");
        A.subtract(B).print();

        System.out.println();
        System.out.println("Matrix A*C:");
        A.multiply(C).print();

        System.out.println();
        System.out.println("Matrix C*A:");
        C.multiply(B).print();

        System.out.println();
        System.out.println("Matrix (B-A)^T:");
        B.subtract(A).transposition().print();

        System.out.println();
        System.out.println("Matrix C-A:");
        C.subtract(A).print();

        System.out.println();
        for(int i=0; i<=6; i++){
            VectorRow v = new VectorRow(A.c);
            System.out.printf("Row %d of Matrix A: \n", i);
            v.getVector(A, i);
            System.out.println();
        }

        System.out.println();
        for(int i=0; i<=4; i++){
            VectorCol v = new VectorCol(A.r);
            System.out.printf("Column %d of Matrix A: \n", i);
            v.getVector(A, i);

            System.out.println();
        }

        System.out.println();
        System.out.println("Row A[0][*]:");
        VectorRow v1 = new VectorRow(A.c);
        v1.getVector(A, 0);

        System.out.println();
        System.out.println("Row B[*][0]:");
        VectorRow v2 = new VectorRow(B.c);
        v2.getVector(B, 0);

        System.out.println();
        System.out.print("Inner product of A[0][*] and B[0][*]: ");
        System.out.printf("%.4f\n", v1.innerProduct(v2));

        System.out.println();
        System.out.println("Column C[*][0]:");
        VectorCol v3 = new VectorCol(C.r);
        v3.getVector(C, 0);
        System.out.println();
        Matrix ans = new Matrix(1, 1);
        ans = v1.multiply(v3);
        System.out.println("\nA[0][*]*C[*][0]:");
        ans.print();

        System.out.println();
        System.out.println("Row A[1][*]:");
        VectorRow A1_ = new VectorRow(A.c);
        A1_.getVector(A, 1);

        System.out.println();
        System.out.println("Row C[1][*]:");
        VectorRow C1_ = new VectorRow(C.c);
        C1_.getVector(C, 1);

        System.out.println();
        System.out.print("Inner product of A[1][*] and C[1][*]: ");
        System.out.printf("%.4f\n", A1_.innerProduct(C1_));

        System.out.println();
        System.out.println("Column A[*][0]");
        VectorCol A_0 = new VectorCol(A.r);
        A_0.getVector(A, 0);

        System.out.println();
        System.out.println("Column B[*][0]:");
        VectorCol B_0 = new VectorCol(B.r);
        B_0.getVector(B, 0);

        System.out.println();
        System.out.print("Inner product of A[*][0] and B[*][0]: ");
        System.out.printf("%.4f\n", A_0.innerProduct(B_0));

        System.out.println();
        System.out.println("Row C[0][*]:");
        VectorRow C0_ = new VectorRow(C.c);
        C0_.getVector(C, 0);

        System.out.println();
        System.out.println("\nA[*][0]*C[0][*]:");
        A_0.multiply(C0_).print();

        System.out.println();
        System.out.println("Column A[*][1]:");
        VectorCol A_1 = new VectorCol(A.r);
        A_1.getVector(A, 1);

        System.out.println();
        System.out.println("Column C[*][1]:");
        VectorCol C_1 = new VectorCol(C.r);
        C_1.getVector(C, 1);

        System.out.println();
        System.out.print("Inner product of A[*][1] and C[*][1]: ");
        System.out.printf("%.4f\n", A_1.innerProduct(C_1));

        System.out.println();
        System.out.println("Matrix S:");
        Matrix s = new Matrix(5, 5);
        s.print();
        System.out.println("The determinant of square matrix S: " + s.determinant());

        System.out.println();
        System.out.println("Matrix B*C:");
        B.multiply(C).print();
        System.out.println("The determinant of square matrix B*C: " + B.multiply(C).determinant());

        System.out.println();
        System.out.println("Matrix A:");
        A.print();
        System.out.println("The determinant of square matrix A: " + A.determinant());
    }
}