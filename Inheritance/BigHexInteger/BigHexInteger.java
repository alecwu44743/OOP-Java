package BigHexInteger;

import java.math.BigInteger;

public class BigHexInteger extends BigInteger {
    public BigHexInteger(String hex) {
        super(hex, 16);
    }

    public BigHexInteger add(BigHexInteger val) {
		return new BigHexInteger(super.add(val).toString(16));
	}
	
	public BigHexInteger add(BigInteger val) {
		return new BigHexInteger(super.add(val).toString(16));
	}
	
	public BigHexInteger subtract(BigHexInteger val) {
		return new BigHexInteger(super.subtract(val).toString(16));
	}
	
	public BigHexInteger subtract(BigInteger val) {
		return new BigHexInteger(super.subtract(val).toString(16));
	}

	public String toString() {
		return super.toString(16);
	}
}
