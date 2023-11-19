// Japanese Yen
public class JPY extends Currency {
	// Complete the implementation of the constructors.
	public JPY(double a) {
		this.amount = a;
	}
	public JPY(USD d) {
		this.amount = d.get() * 133.52;
	}
	public JPY(NTD d) {
		this.amount = d.get() * 4.34;
	}
	
	public double get() {return amount;}
	public void set(double a) {amount = a;}
	// Complete the implementation of function printc().
	public void printc() {
		System.out.println("JPY: " + amount);
	}

}
