import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class GNYR09F{
	static int n,k;
	static long dp[][][];
	
	public static long f(int x, int p, int sofar){
		if(sofar>k)return 0;
		if(x==n)return (sofar==k?1:0);
		if(dp[x][p][sofar]!=-1) return dp[x][p][sofar];
		long ans=0;
		ans+=f(x+1,0,sofar);
		ans+=f(x+1,1, sofar+p);
		return dp[x][p][sofar]=ans;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuffer out=new StringBuffer();
		int cases=Integer.parseInt(br.readLine());
		for(int c=1; c<=cases; c++){
			StringTokenizer st=new StringTokenizer(br.readLine());
			st.nextToken();
			n=Integer.parseInt(st.nextToken());
			k=Integer.parseInt(st.nextToken());
			dp=new long[n][2][k+1];
			for(int i=0; i<n; i++)for(int j=0; j<2; j++)for(int kk=0; kk<=k; kk++)dp[i][j][kk]=-1;
			long ans=f(1,0,0)+f(1,1,0);
			out.append(c+" "+ans+"\n");
		}
		System.out.print(out);
	}
}