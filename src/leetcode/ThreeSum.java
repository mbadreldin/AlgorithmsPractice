package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {
	
	public static void main(String[] args) {
		int arr[]= {2,0,-3,-2,3,-1,-3,0,1,0,3,4,-5,2};
		List<List<Integer>> l = new ThreeSum().threeSum(arr);
		System.out.println(l);
	}
	
	//https://leetcode.com/problems/3sum/
	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);

		List<List<Integer>> ans = new LinkedList<List<Integer>>();
		HashSet<List<Integer>> uniqueTriples = new HashSet<List<Integer>>();

		for(int i=0; i < nums.length; i++)
		{
			int smallIndex = i+1;
			int largeIndex = nums.length - 1;
			int complement = 0 - nums[i];

			while(smallIndex < largeIndex)
			{
				int currentSum = nums[smallIndex] + nums[largeIndex];
				if(currentSum ==  complement)
				{
					List<Integer> triple = new LinkedList<Integer>();
					triple.add(nums[i]);
					triple.add(nums[smallIndex]);
					triple.add(nums[largeIndex]);
					if(!uniqueTriples.contains(triple))
					{
						ans.add(triple);
						uniqueTriples.add(triple);
					}
					smallIndex++;
					largeIndex--;
				}
				else if(currentSum < complement)
				{
					smallIndex++;
				}
				else
				{
					largeIndex--;
				}
			}
		}

		return ans;
	}
}
