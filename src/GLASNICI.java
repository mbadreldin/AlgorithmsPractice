import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class GLASNICI {

	static int n;
	static double k, location[], newLocation[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = new Integer(br.readLine());
	
		while(t-->0){
			StringTokenizer st = new StringTokenizer(br.readLine());
			k = Double.parseDouble(st.nextToken());
			n = Integer.parseInt(st.nextToken());
		
			location = new double[n];

			for (int i = 0; i < n; i++) {
				location[i] =  Double.parseDouble(br.readLine());
			}

			double low = 0;
			double high = (location[n-1] - location[0])/2;
			double ans = high;
	
			while(low<=high) {
				double mid = low + (high-low)/2;
				if(doable(mid)){
					ans = Math.min(ans, mid);
					high = mid-0.001;
				}
				else{
					low = mid+0.001;
				}
			}
			System.out.printf("%.3f\n",ans);
		}
	}

	static boolean doable(double goal){
		newLocation = new double[n];
		for (int i = 0; i < location.length; i++) {
			newLocation[i] = location[i];
		}
		//moves towards the left
		newLocation[0] += goal;
		for (int i = 1; i < n; i++) {
			if(newLocation[i]<= newLocation[i-1])
			{
				newLocation[i] = Math.min(newLocation[i-1]+k, newLocation[i]+goal);
			}
			else{
				double whereIShouldBe = newLocation[i-1]+k;
				if(newLocation[i]- whereIShouldBe>goal)
					return false;
				double whereICanGo = newLocation[i]+goal;
				newLocation[i] = Math.min(whereIShouldBe, whereICanGo);
			}
		}
		return true;
	}
}
