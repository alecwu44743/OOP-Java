package RationalNumber;


public class RationalNumber{
    public String input;
    public int PN; // positive or negative
    public int numerator;
    public int denominator;

    public RationalNumber(String input){
        this.input = input;
        this.PN = (this.input.charAt(0) == '-') ? -1 : 1;
        this.numerator = 0;
        this.denominator = 0;


        setNume(getNume());
        setDeno(getDeno());
    }

    private void setNume(int _num){
        this.numerator = _num;
    }

    private void setDeno(int _deno){
        this.denominator = _deno;
    }

    private int getNume(){
        if(this.input.indexOf('/') == -1){
            return Math.abs(Integer.parseInt(this.input));
        }
        else if(this.PN == -1){
            return Integer.parseInt(this.input.substring(1, this.input.indexOf('/')));
        }
        else{
            return Integer.parseInt(this.input.substring(0, this.input.indexOf('/')));
        }
    }

    private int getDeno(){
        if(this.input.indexOf('/') == -1){
            return 1;
        }
        else{
            return Integer.parseInt(this.input.substring(this.input.indexOf('/') + 1));
        }
    }

    public void printRational(){
        if(this.denominator == 0){
            System.out.println("Error: denominator is 0");
        }
        else{
            if(this.numerator == 0){
                System.out.println("0");
            }
            else{
                int _gcd = GCD(this.numerator, this.denominator);
                this.numerator /= _gcd;
                this.denominator /= _gcd;

                System.out.printf("%s%s\n" , (this.PN * this.numerator), ((this.denominator == 1) ? "" : ("/" + this.denominator)));
            }
        }
    }

    private int GCD(int a, int b){
        // Euclidean algorithm by iterative
        a = Math.abs(a);
        b = Math.abs(b);

        int r = 0;
        while(b != 0){
            r = a % b;
            a = b;
            b = r;
        }

        return a;
    }

    // private void processAnswer(int _nume, int _deno){
    //     if(_deno == 0){
    //         System.out.println("Error: Denominator cannot be zero.");
    //     }
    //     else if(_nume == 0){
    //         System.out.println("0");
    //     }
    //     else{
    //         int gcd = GCD(_nume, _deno);
    //         _nume = _nume / gcd;
    //         _deno = _deno / gcd;

    //         System.out.printf("%s%s\n" , _nume , ((_deno == 1) ? "" : " / " + _deno));
    //     }
    // }

    public RationalNumber add(RationalNumber b){
        RationalNumber temp = new RationalNumber("0/1");
        int _nume = this.PN * this.numerator * b.denominator + b.PN * b.numerator * this.denominator;

        temp.PN = (_nume >= 0) ? 1 : -1;
        
        int _gcd = GCD(_nume, this.denominator * b.denominator);
        temp.numerator = Math.abs(_nume) / _gcd;
        temp.denominator = (this.denominator * b.denominator) / _gcd;

        return temp;
    }

    public RationalNumber subtract(RationalNumber b){
        RationalNumber temp = new RationalNumber("0/1");
        int _nume = this.PN * this.numerator * b.denominator - b.PN * b.numerator * this.denominator;

        temp.PN = (_nume >= 0) ? 1 : -1;

        int _gcd = GCD(_nume, this.denominator * b.denominator);
        temp.numerator = Math.abs(_nume) / _gcd;
        temp.denominator = (this.denominator * b.denominator) / _gcd;

        return temp;
    }

    public RationalNumber multiply(RationalNumber b){
        RationalNumber temp = new RationalNumber("0/1");
        int _nume = this.PN * this.numerator * b.PN * b.numerator;
        int _deno = this.denominator * b.denominator;

        temp.PN = (_nume * _deno >= 0) ? 1 : -1;

        int _gcd = GCD(_nume, _deno);
        temp.numerator = Math.abs(_nume) / _gcd;
        temp.denominator = Math.abs(this.denominator * b.denominator) / _gcd;

        return temp;
    }

    public RationalNumber divide(RationalNumber b){
        RationalNumber temp = new RationalNumber("0/1");
        int _nume = this.PN * this.numerator * b.denominator;
        int _deno = b.PN * b.numerator * this.denominator;

        temp.PN = (_nume * _deno >= 0) ? 1 : -1;

        int _gcd = GCD(_nume, _deno);
        temp.numerator = Math.abs(_nume) / _gcd;
        temp.denominator = Math.abs(_deno) / _gcd;

        return temp;
    }

    public RationalNumber Absolute(){
        RationalNumber temp = new RationalNumber("0/1");
        temp.PN = 1;

        int _gcd = GCD(this.numerator, this.denominator);
        temp.numerator = Math.abs(this.numerator) / _gcd;
        temp.denominator = this.denominator / _gcd;

        return temp;
    }

    // calculate the "(a× |d-b|)-(b+(c÷ a))× |(b× e)-(c÷ d)|"
    public RationalNumber complexArithmetic(RationalNumber a, RationalNumber b, RationalNumber c, RationalNumber d, RationalNumber e){
        RationalNumber temp1 = new RationalNumber("0/1");
        RationalNumber temp2 = new RationalNumber("0/1");
        RationalNumber temp3 = new RationalNumber("0/1");
        RationalNumber temp4 = new RationalNumber("0/1");
        RationalNumber temp5 = new RationalNumber("0/1");
        RationalNumber temp6 = new RationalNumber("0/1");
        RationalNumber temp7 = new RationalNumber("0/1");
        // RationalNumber temp8 = new RationalNumber("0/1");
        // RationalNumber temp9 = new RationalNumber("0/1");
        // RationalNumber temp10 = new RationalNumber("0/1");

        // a*|d-b|-(b+c/a)*|b*e-c/d| = -553/4
        temp1 = a.multiply(d.subtract(b).Absolute()); // a*|d-b|
        temp2 = b.add(c.divide(a)); // (b+c/a)
        temp3 = b.multiply(e); // b*e
        temp4 = c.divide(d); // c/d
        temp5 = temp3.subtract(temp4); // b*e-c/d
        temp6 = temp2.multiply(temp5.Absolute()); // (b+c/a)*|b*e-c/d|
        temp7 = temp1.subtract(temp6); // [a*|d-b|] - [(b+c/a)*|b*e-c/d|]
        // temp8 = temp7.multiply(temp7);
        // temp9 = temp8.multiply(temp8);
        // temp10 = temp9.multiply(temp9);

        return temp7;
    }

    public void printRational(RationalNumber b, RationalNumber c, RationalNumber d, RationalNumber e){
        System.out.println("a = " + this.PN * this.numerator + "/" + this.denominator);
        System.out.println("b = " + b.PN * b.numerator + "/" + b.denominator);
        System.out.println("c = " + c.PN * c.numerator + "/" + c.denominator);
        System.out.println("d = " + d.PN * d.numerator + "/" + d.denominator);
        System.out.println("e = " + e.PN * e.numerator + "/" + e.denominator);
    }
}