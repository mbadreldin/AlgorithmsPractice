import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class IITKWPCN {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = new Integer(br.readLine());
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		while(t-->0){
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			int b = new Integer(st.nextToken());
			if((b&1) == 0) //even
				sb.append("0.000000\n");
			else
				sb.append("1.000000\n");
		}
		System.out.print(sb.toString());
	}
}
