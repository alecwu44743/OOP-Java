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

		System.out.println("exp1Integer = " + exp1Integer);
		System.out.println("exp1HexInteger = " + exp1HexInteger);
		
		//TODO: Add some code here for expression b-c+d+e-f+a & output the restult
		BigInteger exp2Integer = new BigInteger("0");		  
		Mexam_skeleton_3Class exp2HexInteger = new Mexam_skeleton_3Class("0");	
		exp2Integer = exp2Integer.add(bi[1]).subtract(bi[2]).add(bi[3]).add(bi[4]).subtract(bi[5]).add(bi[0]);
		exp2HexInteger = exp2HexInteger.add(bi[1]).subtract(bi[2]).add(bi[3]).add(bi[4]).subtract(bi[5]).add(bi[0]);


		System.out.println("exp2Integer = " + exp2Integer.toString(10));
		System.out.println("exp2HexInteger = " + exp2HexInteger);
	}
}