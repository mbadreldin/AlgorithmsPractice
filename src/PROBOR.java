import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class PROBOR {
	static final int powersTwo []= {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 262144, 524288, 1048576, 2097152, 4194304, 8388608, 16777216, 33554432, 67108864, 134217728, 268435456, 536870912, 1073741824};
	static final String leadingZeros [] = { "", "0", "00", "000", "0000", "00000", "000000", "0000000", "00000000", "000000000", "0000000000", "00000000000", "000000000000", "0000000000000", "00000000000000", "000000000000000", "0000000000000000", "00000000000000000", "000000000000000000", "0000000000000000000", "00000000000000000000", "000000000000000000000", "0000000000000000000000", "00000000000000000000000", "000000000000000000000000", "0000000000000000000000000", "00000000000000000000000000", "000000000000000000000000000", "0000000000000000000000000000", "00000000000000000000000000000", "000000000000000000000000000000", "0000000000000000000000000000000" };
	static String [] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		double p=Double.parseDouble(st.nextToken());
		int n=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		int maxLength=0;
		arr = new String[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Long.toBinaryString(Integer.parseInt(st.nextToken()));
			maxLength= Math.max(maxLength, arr[i].length());
		}
		for(int i=0; i<n; i++){
			int leading=maxLength-arr[i].length();
			arr[i]= leadingZeros[leading]+arr[i];
		}
		//zero[i] = probability that bit i has the value 0
		double zero[] = new double [maxLength];
		//one[i] = probability that bit i has the value 0
		double one[] = new double [maxLength];
		for(int i=0; i< arr[0].length(); i++)
		{
			if(arr[0].charAt(i)=='0'){
				zero[i]=1;
			}
			else{
				one[i]=1;
			}
		}
		for(int x=1; x<n; x++){
			for (int i=0; i<arr[x].length(); i++){
				if(arr[x].charAt(i)=='0'){
					zero[i] = zero[i] + one[i]*p;
					one[i] =  one[i] * (1-p);
				}
				else{
					one[i] = one[i] + zero[i]*(1-p);
					zero[i] = zero[i] * p;
				}
			}
		}
		//expected value of the result = sum of expected values for each bit
		double ans=0;
		for(int i=0; i<maxLength; i++){
			ans += one[i]*powersTwo[maxLength-i-1];
		}
		System.out.printf("%.2f\n",ans);
	}
}
