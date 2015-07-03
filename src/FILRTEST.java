import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class FILRTEST {

	static char p[];
	static int b[], k;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer out = new StringBuffer();
		StringTokenizer st;
		while(true){
			st = new StringTokenizer(br.readLine());
			k = new Integer(st.nextToken());
			if(k==-1)
				break;
			p = st.nextToken().toCharArray();
			if(k<p.length){
				out.append("0\n");
			}
			else if(k == p.length){
				out.append("1\n");
			}
			else{
				kmpPrepocess();
				int diff = p.length- b[p.length];
				int ans = 1+ (k-p.length)/diff;
				out.append(ans);
				out.append('\n');
			}
		}
		System.out.print(out);
	}

	static void kmpPrepocess(){
		b = new int[p.length+1];
		int j= -1;
		int i=0;
		b[i] =j;
		while(i<p.length){
			while(j>=0 && p[i] != p[j]){
				j = b[j];
			}
			i++;
			j++;
			b[i] = j;
		}
	}
}
