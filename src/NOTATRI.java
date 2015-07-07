import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NOTATRI {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer out = new StringBuffer();

		while(true){
			int n = new Integer(br.readLine());
			if(n==0)
				break;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int arr[] = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = new Integer(st.nextToken());
			}
			Arrays.sort(arr);
			long ans  = 0;
			for (int i = n-1; i >1; i--) {
				int c = arr[i];
				int low = 0;
				int high = i-1;
				while(low<high){
					int a = arr[low];
					int b = arr[high];
					if(a+b<c){
						//low, low+1, ..., high
						ans+= high-low;
						low++;
					}
					else{
						high--;
					}
				}
			}
			out.append(ans);
			out.append('\n');
		}
		System.out.print(out);

	}
}
//Binary search approach O(n^2*log(n)) TLE in Java but ACC C++
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuffer out = new StringBuffer();
//
//		while(true){
//			int n = new Integer(br.readLine());
//			if(n==0)
//				break;
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			int arr[] = new int[n];
//			for (int i = 0; i < n; i++) {
//				arr[i] = new Integer(st.nextToken());
//			}
//			Arrays.sort(arr);
//			long ans  = 0;
//			for (int i = 0; i < arr.length; i++) {
//				int a = arr[i];
//				for (int j = i+1; j < arr.length; j++) {
//					int b = arr[j];
//					int low = 0;
//					int high = n-1;
//					int index = n;
//					while(low<=high){
//						int mid  = low + (high-low)/2;
//						int c = arr[mid];
//						//<= because the problem statement says:
//						//degenerate triangles are allowed
//						if(c<=a+b){
//							low = mid+1;
//						}
//						else{
//							index = Math.min(index, mid);
//							high = mid - 1;
//						}
//					}
//					ans += (n-index);
//				}
//			}
//			out.append(ans);
//			out.append('\n');
//		}
//		System.out.print(out);
//	}

