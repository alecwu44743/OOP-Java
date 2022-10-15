import Matrix.*;


class MatrixApp{
    public static void main(String[] args){
        Matrix a = new Matrix(5, 4);
        Matrix b = new Matrix(5, 4);
        Matrix c = new Matrix(5, 4);
        Matrix d = new Matrix(4, 6);
        Matrix e = new Matrix(5, 6);

        System.out.println("Matrix a:"); a.init(); 
        System.out.println("Matrix b:"); b.init();
        System.out.println("Matrix c:"); c.init();
        System.out.println("Matrix d:"); d.init();
        System.out.println("Matrix e:"); e.init();

        Matrix res;

        // A + B - C
        res = a.add(b).sub(c);
        System.out.println("\nA + B - C = "); res.print();


        // B × D + E
        res = b.mul(d).add(e);
        System.out.println("\nB × D + E = "); res.print();


        // E - A × D
        res = e.sub(a.mul(d));
        System.out.println("\nE - A × D = "); res.print();
    }
}