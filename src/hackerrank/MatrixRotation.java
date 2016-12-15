package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MatrixRotation {

	// https://www.hackerrank.com/contests/cs1300-odd-2014/challenges/array-rotation/submissions
	private static void rotate90(int [][] arr)
	{
		int n = arr.length;
		int half = n/2 + n%2;
		for(int i=0; i<half; i++)
		{
			for(int j=i; j<n-i-1; j++)
			{
				int tmp = arr[i][j];
				arr[i][j] = arr[n-1-j][i];
				arr[n-1-j][i] = arr[n-1-i][n-1-j];
				arr[n-1-i][n-1-j] = arr[j][n-1-i];
				arr[j][n-1-i] = tmp;
			}
		}
	}
	
    public static void main(String[] args) throws IOException{
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = new Integer(br.readLine());
        int[][] arr = new int[n][n];
        for(int i=0; i<n; i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++)
                arr[i][j] = new Integer(st.nextToken());    
        }
        rotate90(arr);
		for(int i=0; i<arr.length; i++)
        {
            for(int j=0; j<arr.length-1; j++)
                System.out.print(arr[i][j]+" ");
            System.out.println(arr[i][n-1]);
        }
    }
}
