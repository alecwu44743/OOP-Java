public class Fexam_D1009331_1 {
	public static void main(String[] args) {
		  NTD n; // Concrete object of NTD.
		  USD u1, u2; // Concrete object of USD.
		  JPY j; // Concrete object of JPY. 
  
  	/*
    	  The foreign exchange policy in Taiwan requires that any foreign currency 
	  exchange buying or selling must be via New Taiwan Dollar. 
        Suppose a person is going to buy US Dollar using 300,000 Japanese Yen. 
        Write a main function to compute his/her exchange gain/loss, 
        if he/she could directly buy US Dollar using Japanese Yen.
  	*/
		// buy US Dollar using 300,000 Japanese Yen, via New Taiwan Dollar.
		System.out.println("Buy US Dollar using 300,000 Japanese Yen, via New Taiwan Dollar.");
		j = new JPY(300000);
		n = new NTD(j);
		u1 = new USD(n);
		u1.printc();

		System.out.println();

		// buy US Dollar using 300,000 Japanese Yen, directly.
		System.out.println("Buy US Dollar using 300,000 Japanese Yen, directly.");
		j = new JPY(300000);
		u2 = new USD(j);
		u2.printc();

		System.out.println();

		// Compute the exchange gain/loss.
		System.out.println("Exchange gain/loss: " + (u2.get() - u1.get()) + " USD. " +(u2.get() > u1.get() ? " (gain)" : " (loss)"));

	}
}
