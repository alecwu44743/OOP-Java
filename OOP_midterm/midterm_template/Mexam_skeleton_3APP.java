import java.math.BigInteger;

public class Mexam_skeleton_3APP {
	static public void main(String[] args) {
		
		//TODO: Add some code here for input testing data
		BigInteger[] bi = new BigInteger[6];
		bi[0] = new BigInteger("121");     	// a
		bi[1] = new Mexam_skeleton_3Class("FF");	// b
		bi[2] = new BigInteger("-28");		// c
		bi[3] = new Mexam_skeleton_3Class("-1C");	// d
		bi[4] = new BigInteger("83");		// e
		bi[5] = new Mexam_skeleton_3Class("2B");	// f
		
		//TODO: Add some code here for expression a+b+c+d+e+f & output the restult
		BigInteger exp1Integer = new BigInteger("0");		  
		Mexam_skeleton_3Class exp1HexInteger = new Mexam_skeleton_3Class("0");	
		for(int i = 0; i < bi.length; i++) {
			exp1Integer = exp1Integer.add(bi[i]);
			exp1HexInteger = exp1HexInteger.add(bi[i]);
		}

		// System.out.println("exp1Integer = " + exp1Integer);
		// System.out.println("exp1HexInteger = " + exp1HexInteger);
		
		//TODO: Add some code here for expression b-c+d+e-f+a & output the restult
		BigInteger exp2Integer = new BigInteger("0");		  
		Mexam_skeleton_3Class exp2HexInteger = new Mexam_skeleton_3Class("0");	
		exp2Integer = exp2Integer.add(bi[1]).subtract(bi[2]).add(bi[3]).add(bi[4]).subtract(bi[5]).add(bi[0]);
		exp2HexInteger = exp2HexInteger.add(bi[1]).subtract(bi[2]).add(bi[3]).add(bi[4]).subtract(bi[5]).add(bi[0]);

		System.out.println("The testing data as follows:");
		System.out.println("================================");
		System.out.println("a = 121 (BigInteger)");
		System.out.println("b = FF (BigHexInteger)");
		System.out.println("c = -28 (BigInteger)");
		System.out.println("d = -1C (BigHexInteger)");
		System.out.println("e = 83 (BigInteger)");
		System.out.println("f = 2B (BigHexInteger)");

		System.out.println();


		System.out.println("The output data as follows:");
		System.out.println("================================");

		// print a+b+c+d+e+f = 446(BigInteger) 1BE(BigHexInteger)
		System.out.println("a+b+c+d+e+f = " + exp1Integer.toString(10).toUpperCase() + "(BigInteger) " + exp1HexInteger.toString().toUpperCase() + "(BigHexInteger)");

		// print b-c+d+e-f+a = 446(BigInteger) 1BE(BigHexInteger)
		System.out.println("b-c+d+e-f+a = " + exp2Integer.toString(10).toUpperCase() + "(BigInteger) " + exp2HexInteger.toString().toUpperCase() + "(BigHexInteger)");
	}
}