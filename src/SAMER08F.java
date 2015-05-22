import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
 
public class SAMER08F{
 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuffer out=new StringBuffer();
		int arr[]=new int[101];
		for(int i=1; i<arr.length; i++)
			arr[i]=arr[i-1]+i*i;
		int n=Integer.parseInt(br.readLine());
		while(n>0)
		{
			out.append(arr[n]+"\n");
			n=Integer.parseInt(br.readLine());
		}
		System.out.print(out);
	}
 
}