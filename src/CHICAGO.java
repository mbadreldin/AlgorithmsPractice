import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class CHICAGO{

	static int n,m, adj[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while(true){
			st = new StringTokenizer(br.readLine());
			n=new Integer(st.nextToken());
			if(n==0)break;
			m=new Integer(st.nextToken());
			adj=new int[n][n];
			for(int i=0; i<m; i++){
				st = new StringTokenizer(br.readLine());
				int a=new Integer(st.nextToken())-1;
				int b=new Integer(st.nextToken())-1;
				int c=new Integer(st.nextToken());
				adj[a][b]=c;
				adj[b][a]=c;
			}
			double ans=100*f();
			System.out.printf("%.6f percent\n", ans);
		}
	}
	public static double f(){
		double ans=0;
		boolean visisted[]=new boolean[n];
		PriorityQueue<Intersection> q=new PriorityQueue<Intersection>();
		q.add(new Intersection(0,1));
		while(!q.isEmpty()){
			Intersection current=q.poll();
			if(visisted[current.name])continue;
			visisted[current.name]=true;
			if(current.name==n-1)return current.p;
			for(int i=0; i<n; i++)
				if(!visisted[i] && adj[current.name][i]>0)
					q.add(new Intersection(i, current.p*adj[current.name][i]/100));
		}
		return ans;
	}
}
class Intersection implements Comparable<Intersection>{
	int name;
	double p;
	public Intersection(int x, double z){
		name=x;
		p=z;
	}
	@Override
	public int compareTo(Intersection s) {
		if(this.p>s.p)return -1;
		if(this.p<s.p)return 1;
		return 0;
	}
}

