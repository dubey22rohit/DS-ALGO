
public class SpiralMatrix {
public static void printSpiral(int [][] mat) {
	int t = 0;
	int b = mat[0].length - 1;
	int l = 0;
	int r = mat.length - 1;
	int flag = 0;
	while(t <= b && l<=r) {
		if(flag == 0) {
			for(int i = l;i<=r;i++) {
				System.out.print(mat[t][i] + " ");
			}
			t++;
		}
		if(flag == 1) {
			for(int i = t;i<=b;i++) {
				System.out.print(mat[i][r] + " ");
			}
			r--;
		}
		if(flag == 2) {
			for(int i = r;i>=l;i--) {
				System.out.print(mat[b][i] + " ");
			}
			b--;
		}
		if(flag == 3) {
			for(int i = b;i>=t;i--) {
				System.out.print(mat[i][l] + " ");
			}
			l++;
		}
		flag = (flag+1)%4;
	}
	
	
}
	public static void main(String[] args) {
		int[][] ans = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		printSpiral(ans);
		

	}

}
