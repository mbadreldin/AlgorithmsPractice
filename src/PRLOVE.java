import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class PRLOVE {
	static int n,p[][],t[][];
	static double l[][], u[][], y[], x[], b[];

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases= new Integer(br.readLine());
		while(cases-->0){
			n= new Integer(br.readLine());
			p = new int[n][n];
			t=new int [n][n];
			StringTokenizer st;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					p[i][j] = new Integer(st.nextToken());
				}
			}
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					t[i][j] = new Integer(st.nextToken());
				}
			}
			double [][]a= new double[n-1][n-1];
			//start a as an identity matrix
			for (int i = 0; i < a.length; i++) {
				a[i][i]=1;
			}
			b = new double[n-1];
			for (int i = 0; i < b.length; i++) {
				for (int j = 0; j < b.length; j++) {
					a[i][j]= a[i][j]- p[i][j]/100.0;
				}
				for (int j = 0; j < p.length; j++) {
					b[i] = b[i]+ t[i][j]* p[i][j]/100.0;
				}
			}
			LUDecompose(a);
			solve();
			System.out.println(new BigDecimal(x[0]).setScale(6, BigDecimal.ROUND_UP));
		}
	}

	static void LUDecompose(double [][]a){
		int len = a.length;
		l = new double[len][len];
		u= new double[len][len];
	
		//initialize l with 1s on the diagonal
		for (int i = 0; i < l.length; i++) {
			l[i][i] = 1;
		}
		for(int k=0; k<len; k++){
			u[k][k]= a[k][k];
			for(int i=k+1; i<len; i++){
				l[i][k]= a[i][k]/a[k][k];
				u[k][i] = a[k][i];
			}
			for (int i = k+1; i < len; i++) {
				for (int j = k+1; j < len; j++) {
					a[i][j] = a[i][j]- l[i][k]*u[k][j];
				}
			}
		}
	}

	static void solve(){
		int len = l.length;
		y= new double[len];
		x = new double[len];
		//Ax=b and LU = A
		//therefore LUx=b
		//first solve Ly=b to get y
		for (int i = 0; i < len; i++) {
			y[i] = b[i];
			for (int j = 0; j < i; j++) {
				y[i] = y[i]- l[i][j]*y[j];
			}
		}
		//then solve  Ux = y to get x
		for (int i = len-1; i >=0; i--) {
			x[i] = y[i];
			for (int j = len-1; j > i; j--) {
				x[i] =x[i]- u[i][j]*x[j];
			}
			x[i]= x[i]/u[i][i];
		}
	}
}