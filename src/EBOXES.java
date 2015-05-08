import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class EBOXES {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases=Integer.parseInt(br.readLine());
		StringBuffer out=new StringBuffer();
		long k, n1, empty, total;
		//We have n1 boxes of type 1, n2 boxes of type 2, etc...
		
		StringTokenizer st;
		while(cases-->0){
			st=new StringTokenizer(br.readLine());
			n1 = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			st.nextToken();
			empty = Integer.parseInt(st.nextToken());
			//assume that out of n1, x1 were selected
			//out of k*n1, x2 were selected etc..
			
			//empty = n1-x1+ k*x1-k*x2 + ...
			//let totalSelected = x1+ x2 + ..
			long totalSelected = (empty - n1)/(k-1);
			total = n1 + k*totalSelected;
			out.append(total);
			out.append("\n");
		}
		System.out.print(out);
	}
}
