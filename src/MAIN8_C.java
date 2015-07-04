import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MAIN8_C {
	static int candyBoxes[], kStudents, n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = new Integer(br.readLine());
		StringBuffer out = new StringBuffer();
		StringTokenizer st;
		while(t-->0){
			st = new StringTokenizer(br.readLine());
			n = new Integer(st.nextToken());
			kStudents = new Integer(st.nextToken());
			candyBoxes = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				candyBoxes[i]= new Integer(st.nextToken());
			}
			Arrays.sort(candyBoxes);
			int ans = 0;
			int low = 1;
			int high = candyBoxes[n-1];
			while(low<= high){
				int mid=  low + (high-low)/2;
				int total = 0;
				for (int i = n-1; i >=0; i--) {
					total+= candyBoxes[i]/mid;
					if(total>=kStudents)
						break;
				}
				if(total<kStudents){
					high = mid-1;
				}
				else{
					ans = Math.max(ans, mid);
					low = mid+1;
				}
			}
			out.append(ans);
			out.append('\n');
		}
		System.out.print(out);
	}
}
