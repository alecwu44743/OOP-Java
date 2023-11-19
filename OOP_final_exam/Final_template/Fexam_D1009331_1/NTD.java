// New Taiwan Dollar
public class NTD extends Currency {
	// Complete the implementation of the constructors.
	public NTD(double a) {
		this.amount = a;
	}
	public NTD(USD d) {
		this.amount = d.get() * 30.78;
	}
	public NTD(JPY d) {
		this.amount = d.get() * 0.23;
	}
	
	public double get() {return amount;}
	public void set(double a) {amount = a;}
	// Complete the implementation of function printc().
	public void printc() {
		System.out.println("NTD: " + amount);
	}

}
