import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RABBIT1 {
	static int n,m, mod;
	static long matrix[][]={{1,0},{0,1}};
	static final long mm[][]={{1,1},{1,0}};
	static void multiply(long [][]a, long [][]b){
		long tmp1=a[0][0]*b[0][0]+a[0][1]*b[1][0];
		long tmp2=a[0][0]*b[0][1]+a[0][1]*b[1][1];
		long tmp3=a[1][0]*b[0][0]+a[1][1]*b[1][0];
		long tmp4=a[1][0]*b[0][1]+a[1][1]*b[1][1];
		matrix[0][0]=tmp1%mod; matrix[0][1]=tmp2%mod; matrix[1][0]=tmp3%mod; matrix[1][1]=tmp4%mod;
	}
	static void f(int n){
		if(n>1){
			f(n/2);
			multiply(matrix, matrix);
		}
		if(n%2==1)
			multiply(matrix, mm);
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int cases=Integer.parseInt(br.readLine());
		StringBuffer out=new StringBuffer();
		while(cases-- >0){
			StringTokenizer st=new StringTokenizer(br.readLine());
			n=Integer.parseInt(st.nextToken());
			m=Integer.parseInt(st.nextToken());
			mod=1<<m;
			matrix[0][0]=1; matrix[0][1]=0;
			matrix[1][0]=0; matrix[1][1]=1;
			f(n);
			out.append(matrix[0][0]+"\n");
		}
		System.out.print(out);
	}
}
