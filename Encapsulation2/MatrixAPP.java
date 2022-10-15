import Matrix.*;


class MatrixApp{
    public static void main(String[] args){
        Matrix a = new Matrix(5, 4);
        Matrix b = new Matrix(5, 4);
        Matrix c = new Matrix(5, 4);
        Matrix d = new Matrix(4, 6);
        Matrix e = new Matrix(5, 6);

        System.out.println("Matrix A:"); a.init(); 
        System.out.println("\n-------------------------------------------");

        System.out.println("Matrix B:"); b.init();
        System.out.println("\n-------------------------------------------");

        System.out.println("Matrix C:"); c.init();
        System.out.println("\n-------------------------------------------");

        System.out.println("Matrix D:"); d.init();
        System.out.println("\n-------------------------------------------");

        System.out.println("Matrix E:"); e.init();
        System.out.println("\n-------------------------------------------");

        Matrix res;

        // A + B - C
        res = a.add(b).sub(c);
        System.out.println("\nResulting Matrix of A + B - C = "); res.print();
        System.out.println("\n-------------------------------------------");



        // B × D + E
        res = b.mul(d).add(e);
        System.out.println("\nResulting Matrix of B × D + E = "); res.print();
        System.out.println("\n-------------------------------------------");


        // E - A × D
        res = e.sub(a.mul(d));
        System.out.println("\nResulting Matrix of E - A × D = "); res.print();
        System.out.println("\n-------------------------------------------");
    }
}