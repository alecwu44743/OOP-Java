// Money currency
public abstract class Currency {
	public abstract void set(double c); // Set the currency amount.
	public abstract double get(); // Get the currency amount.
	public abstract void printc(); // Print the currency amount.
	
	protected double amount; // Amount of money currency.
}
