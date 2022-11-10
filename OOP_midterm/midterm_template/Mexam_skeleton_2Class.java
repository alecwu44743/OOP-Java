import java.util.Random;

public class Mexam_skeleton_2Class{
    private int n;
    public int[][] arr;
    private int r;
    private int s;

    public Mexam_skeleton_2Class(int n, int r, int s){
        this.n = n;
        this.r = r;
        this.s = s;
        this.arr = new int[n][n];

        for(int i=0; i<this.n; i++){
            for(int j=0; j<this.n; j++){
                this.arr[i][j] = 0;
            }
        }
    }

    public void init_value(){
        Random random = new Random();

        for(int i=0; i<this.n; i++){
            for(int j=0; j<this.n; j++){
                if(i-j <= this.r && i-j >= -this.s){
                    int val = 0;
					while(r == 0){
						r = random.nextInt(50 - (-50)) + (-50);
					}

                    this.arr[i][j] = val;
                }
            }
        }
    }

    // Minimum function.
	private static int min(int m, int n) {
		if (m <= n)
			return m;
		else
			return n;
	}

	// Maximum function.
	private static int max(int m, int n) {
		if (m <= n)
			return n;
		else
			return m;
	}

    public Mexam_skeleton_2Class matrix_product_banded(Mexam_skeleton_2Class B, int rb, int sb){
        Mexam_skeleton_2Class C = new Mexam_skeleton_2Class(this.n, this.r+rb, this.s+sb);

        for(int i=0; i<this.n; i++){
            for(int j=0; j<this.n; j++){
                for(int k=max(0, max(i-this.r, j-sb)); k<=min(this.n-1, min(i+this.r, j+rb)); k++){
                    C.arr[i][j] += this.arr[i][k] * B.arr[k][j];
                }
            }
        }

        return C;
    }

    // Print matrix values
	public void print_matrix() {
		for (int i = 0; i < this.n; i++) {
			for (int j = 0; j < this.n; j++) {
				if (this.arr[i][j] != 0)
					System.out.printf("%6d ", this.arr[i][j]);
				else
					System.out.printf("%6s ", " ");
			}
			System.out.println();
		}
	}
}