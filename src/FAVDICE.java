import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class FAVDICE {
	static int n;
	static final int MAX_EXPECTED_N= 1001;
	static double h[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		h = new double [MAX_EXPECTED_N];
		h[1] = 1;
		for (int i = 2; i < h.length; i++) {
			h[i] = h[i-1]+1.0/i;
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = new Integer(br.readLine());
		StringBuffer sb = new StringBuffer();
		while(t-- > 0){
			n = new Integer(br.readLine());
			double ans = n*h[n];
			BigDecimal b = new BigDecimal(ans).setScale(2, BigDecimal.ROUND_UP);
			sb.append(b);
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
