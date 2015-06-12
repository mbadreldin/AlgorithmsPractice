
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class INUMBER {
	static int n;
	static boolean visited[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t= new Integer(br.readLine());
		StringBuffer out = new StringBuffer();
		while(t-->0){
			n = new Integer(br.readLine());
			out.append(f());
			out.append('\n');
		}
		System.out.print(out);
	}
 
	static String f(){
		LinkedList<NumNode> q = new LinkedList<NumNode>();
		visited = new boolean[n+1][n];
		//making sure we start with a digit [1-9] in order
		//to avoid leading zeros
		for (int i = 1; i <10; i++) {
			if(i<=n){
				q.add(new NumNode(i%n, i, i+""));
				visited[i][i%n]= true;
			}
		}
		while(true){
			NumNode cur = q.remove();
			if(cur.sum == n && cur.rem == 0)
				return cur.val;
			for (int i = 0; i <10; i++) {
				int newSum = cur.sum+i;
				if(newSum<=n){
					int newRem = (cur.rem*10%n+i%n)%n;
					if(visited[newSum][newRem])
						continue;
					q.add(new NumNode(newRem, newSum, cur.val+i));
					visited[newSum][newRem]= true;
				}
			}
		}
	}

}
class NumNode{
	int rem, sum;
	String val;

	public NumNode(int r, int s, String v){
		rem = r;
		sum = s;
		val = v;
	}
}