package leetcode;

// https://leetcode.com/problems/majority-element/
public class MajorityElement {

	public static void main(String[] args) {
		int[] arr= {7,7,1,5,2,7,3,7,7,7,5,7,5};
		System.out.println(majorityElement(arr));
	}

	public static int majorityElement(int[] nums) {
		// it's OK to assume it's non-empty
		int occurrences = 1;
		int answer = nums[0];
		
		for (int i = 1; i < nums.length; i++) {
			int newcomer =  nums[i];
			if (newcomer == answer)
			{
				occurrences++;
			}
			else
			{
				occurrences--;
			}
			if(occurrences == 0)
			{
				answer =  newcomer;
				occurrences = 1;
			}
		}
		
		return answer;
	}
}