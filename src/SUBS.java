import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class SUBS {

	static char x[] , y[];
	
	static boolean isSubsequence(int m){
		int j= 0;
		for (int i = 0; i < x.length; i++) {
			int toMatch  = m;
			while(toMatch>0){
				if(j>= y.length)
					return false;
				if(x[i] == y[j])
					toMatch--;
				j++;
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int t = new Integer(br.readLine());
		StringBuffer out = new StringBuffer();
		while(t-->0){
			x = br.readLine().toCharArray();
			y = br.readLine().toCharArray();
			int low = 0;
			int high = y.length/x.length;
			int ans = 0;
			while(low<= high){
				int mid  = low + (high-low)/2;
				if(isSubsequence(mid)){
					ans = Math.max(ans, mid);
					low = mid+1;
				}
				else{
					high = mid-1;
				}
			}
			out.append(ans);
			out.append('\n');
		}
		System.out.print(out);
	}

}
