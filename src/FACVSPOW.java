import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FACVSPOW {

	//basically kept adjusting to figure out
	//what is a good value to allow finding answers
	//for values of a up till 10^6
	static final int MAX_N = 3000000;

	static boolean fVersusP(int a, int n){
		//see
		//http://mathworld.wolfram.com/StirlingsApproximation.html
		double ans = n*Math.log(n) - n + 0.5* Math.log(2*n*Math.PI);
		ans -= n*Math.log(a);
		return ans>0;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = new Integer(br.readLine());
		StringBuffer out = new StringBuffer();
		while(t-->0){
			int a  =  new Integer(br.readLine());
			int low = 2*a;
			int high = MAX_N;
			int ans  = Integer.MAX_VALUE;
			while(low <= high){
				int mid = low + (high-low)/2;
				if(fVersusP(a, mid)){
					ans = Math.min(ans, mid);
					high = mid-1;
				}
				else{
					low = mid+1;
				}
			}
			out.append(ans);
			out.append('\n');
		}
		System.out.print(out);
	}
}