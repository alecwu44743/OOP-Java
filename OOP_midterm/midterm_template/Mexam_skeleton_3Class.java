import java.math.BigInteger;

public class Mexam_skeleton_3Class extends BigInteger{

	public Mexam_skeleton_3Class(String val) {
		super(val, 16);
	}
	
	public Mexam_skeleton_3Class add(Mexam_skeleton_3Class val) {
		return new Mexam_skeleton_3Class(super.add(val).toString(16));
	}
	
	public Mexam_skeleton_3Class add(BigInteger val) {
		return new Mexam_skeleton_3Class(super.add(val).toString(16));
	}
	
	public Mexam_skeleton_3Class subtract(Mexam_skeleton_3Class val) {
		return new Mexam_skeleton_3Class(super.subtract(val).toString(16));
	}
	
	public Mexam_skeleton_3Class subtract(BigInteger val) {
		return new Mexam_skeleton_3Class(super.subtract(val).toString(16));
	}

	public String toString() {
		return super.toString(16);
	}
}
