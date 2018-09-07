package mushroom;

// https://www.geeksforgeeks.org/rotate-matrix-90-degree-without-using-extra-space-set-2/

public class MatrixRotate {
	// Rotate a square clockwise
	public void rotate(int[][]a) {
		int n = a.length;
		// Transpose
		for (int i=0; i < n; i++) {
			for (int j=i; j < n; j++ ) {
				int temp = a[i][j];
				a[i][j] = a[j][i];
				a[j][i] = temp;						
			}
		}
		System.out.println("After Transposing");
		print(a);
		// reverse rows
		for (int i=0; i < n; i++) {
			for (int j=0; j < n/2; j++ ) {
				int temp = a[i][j];
				a[i][j] = a[i][n-1-j];
				a[i][n-1-j] = temp;						
			}
		}
	}
	
	public void print(int[][]a) {
		int n = a.length;
		for (int i=0; i < n; i++) {
			for (int j=0; j < n; j++ ) {
				System.out.print(a[i][j] + ", ");
			}
			System.out.println("");
		}
		System.out.println("");
	}
	public static void main(String[] args) {
		var m = new MatrixRotate();
		var a = new int [][] {
			{1,2,3,4},
			{5,6,7,8},
			{9,10,11,12},
			{13,14,15,16}
			
		};
		m.print(a);
		m.rotate(a);
		m.print(a);		
	}
}
