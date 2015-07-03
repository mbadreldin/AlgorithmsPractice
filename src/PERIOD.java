import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PERIOD {

	static char p[];
	static int b[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = new Integer(br.readLine());
		StringBuffer out = new StringBuffer();
		for (int c = 1; c <= t; c++) {
			br.readLine();
			p = br.readLine().toCharArray();
			kmpPrepocess();
			out.append("Test case #");
			out.append(c);
			out.append('\n');
			for (int i = 1; i < b.length; i++) {
				int diff = i-b[i];
				if(b[i]>0 && i%diff == 0){
					out.append(i);
					out.append(' ');
					out.append(i/diff);
					out.append('\n');
				}
			}
		}
		System.out.print(out);

	}
	
	static void kmpPrepocess(){
		b = new int[p.length+1];
		int j=-1;
		b[0] = j;
		for (int i = 0; i < p.length; i++) {
			while(j>=0 && p[i]!= p[j]){
				j = b[j];
			}
			j++;
			b[i+1] = j;
		}
	}

}
