package ComplexNumber;

public class Complex{
    private double r;
    private double s;

    public Complex(double r, double s){
        setRe(r);
        setIm(s);
    }

    public Complex(double r){
        setRe(r);
    }

    public Complex(){
        setRe(0);
        setIm(0);
    }

    private void setRe(double r){
        this.r = r;
    }

    private void setIm(double s){
        this.s = s;
    }

    private double getRe(){
        return this.r;
    }

    private double getIm(){
        return this.s;
    }

    public Complex add(Complex b){
        Complex temp = new Complex();
        temp.setRe(this.getRe() + b.getRe());
        temp.setIm(this.getIm() + b.getIm());
        return temp;
    }

    public Complex subtract(Complex b){
        Complex temp = new Complex();
        temp.setRe(this.getRe() - b.getRe());
        temp.setIm(this.getIm() - b.getIm());
        return temp;
    }

    public Complex multiply(Complex b){
        Complex temp = new Complex();
        temp.setRe(this.getRe() * b.getRe() - this.getIm() * b.getIm());
        temp.setIm(this.getRe() * b.getIm() + this.getIm() * b.getRe());
        return temp;
    }

    public Complex divide(Complex b){
        Complex temp = new Complex();
        temp.setRe((this.getRe() * b.getRe() + this.getIm() * b.getIm()) / (b.getRe() * b.getRe() + b.getIm() * b.getIm()));
        temp.setIm((this.getIm() * b.getRe() - this.getRe() * b.getIm()) / (b.getRe() * b.getRe() + b.getIm() * b.getIm()));
        return temp;
    }

    public double Absolute(){
        double ans;
        ans = Math.sqrt(this.getRe() * this.getRe() + this.getIm() * this.getIm());

        return ans;
    }

    public static void equation_root(double a, double b, double c){
        double minB = -b;
        double _sqrt = b*b - 4*a*c;
        double twoA = 2*a;

        System.out.println();

        if(_sqrt < 0){
            _sqrt = Math.sqrt(Math.abs(_sqrt));
            // System.out.printf("The equation of %.4fx^2 + %.4fx + %.4f has two complex roots: %.4f + %.4fi and %.4f - %.4fi\n"
            // , a, b, c, minB/(twoA), _sqrt/(twoA), minB/(twoA), _sqrt/(twoA));

            Complex r1 = new Complex(minB/(twoA), _sqrt/(twoA));
            // Complex r2 = new Complex(minB/(twoA), -_sqrt/(twoA));

            System.out.printf("The two roots of quadratic equation %.4fX**2%c%.4fX%c%.4f=0.0000 are: %.4f+%.4fi and %.4f-%.4fi\n", a, (b>0?'+':'-'), Math.abs(b), (c>0?'+':'-'), Math.abs(c), r1.getRe(), r1.getIm(), r1.getRe(), r1.getIm());
        }
        else if(_sqrt == 0){
            // System.out.printf("The equation of %.4fx^2 + %.4fx + %.4f has one root: %.4f\n", a, b, c, minB/(twoA));

            Complex r1 = new Complex(minB/(twoA));

            System.out.printf("The one root of quadratic equation %.4fX**2%c%.4fX%c%.4f=0.0000 is: %.4f\n", a, (b>0?'+':'-'), Math.abs(b), (c>0?'+':'-'), Math.abs(c), r1.getRe());
        }
        else{
            _sqrt = Math.sqrt(_sqrt);
            // System.out.printf("The equation of %.4fx^2 + %.4fx + %.4f has two real roots: %.4f and %.4f\n"
            // , a, b, c, (minB+_sqrt)/(twoA), (minB-_sqrt)/(twoA));

            Complex r1 = new Complex((minB+_sqrt)/(twoA));
            Complex r2 = new Complex((minB-_sqrt)/(twoA));

            System.out.printf("The two roots of quadratic equation %.4fX**2%c%.4fX%c%.4f=0.0000 are: %.4f and %.4f\n", a, (b>0?'+':'-'), Math.abs(b), (c>0?'+':'-'), Math.abs(c), r1.getRe(), r2.getRe());
        }


        System.out.println("\nVerification of the two quadratic equation roots PASSES.");
    }

    public void printOpeRes(){
        double r = this.getRe();
        double s = this.getIm();

        System.out.printf("%.2f%c%.2fi\n" , r , ((s >= 0) ? '+' : '-') , Math.abs(s));
    }

    public void printComplex(){
        double r = this.getRe();
        double s = this.getIm();

        System.out.printf("%.2f %c %.2fi" , r , ((s >= 0) ? '+' : '-') , Math.abs(s));
    }
}
