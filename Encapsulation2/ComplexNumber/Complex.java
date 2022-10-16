package ComplexNumber;

public class Complex{
    private double r;
    private double s;

    public Complex(int r, int s){
        setRe(r);
        setIm(s);
    }

    public Complex(int r){
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
